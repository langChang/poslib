package com.nhsoft.poslib.utils;

import android.text.TextUtils;

import com.nhsoft.poslib.entity.nongmao.Stall;
import com.nhsoft.poslib.entity.nongmao.StallPromotion;
import com.nhsoft.poslib.entity.nongmao.StallPromotionDetail;
import com.nhsoft.poslib.entity.order.PosOrderDetail;
import com.nhsoft.poslib.libconfig.LibConfig;
import com.nhsoft.poslib.service.PosItemService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Iverson on 2019/1/4 9:28 AM
 * 此类用于：用于计算商品促销价和会员价
 */
public class PriceStallPromotionCalUtils {

    public static StallPromotion getPolicypromotionPrice(PosOrderDetail posOrderDetail, List<StallPromotion> stallPromotions) {
        if (!PosItemService.getInstance().goodsCanDiscount(posOrderDetail.getItemNum(), posOrderDetail.getItemGradeNum()))
            return null;

        for (StallPromotion stallPromotion : stallPromotions) {
            //会员只能使用一次
            if(stallPromotion.getPolicy_promotion_card_once() && LibConfig.activeVipMember != null){
                if(LibConfig.sVipEnjoyStallPromotion.size() > 0){
                    String promotionId = LibConfig.sVipEnjoyStallPromotion.get(LibConfig.activeVipMember.getCard_user_num());
                    if(promotionId != null && promotionId.equals(stallPromotion.getPolicy_promotion_no()) ){
                        continue;
                    }
                }
            }
            if(stallPromotion.getStalls() != null && stallPromotion.getStalls().size() > 0){
                boolean isContain = false;
                for (Stall stall : stallPromotion.getStalls()){
                    if(LibConfig.activePosMachine.getStall_num() == stall.getStall_num()){
                        isContain = true;
                        break;
                    }
                }
                if(!isContain)continue;
            }

            if (!currentTimeContain(stallPromotion)) continue;  //具体时间
            if (!currentDateContain(stallPromotion)) continue;//具体日期

            if (stallPromotion.getPolicy_promotion_card_only()) {
                if (LibConfig.activeVipMember == null) continue;
                if (!TextUtils.isEmpty(stallPromotion.getPolicy_promotion_card_type())) {
                    if (("<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                            "<消费卡类型列表/>").equals(stallPromotion.getPolicy_promotion_card_type())) {
                    } else {
                        if (!stallPromotion.getPolicy_promotion_card_type().contains(">" + LibConfig.activeVipMember.getCard_user_type_name() + "<"))
                            continue;
                    }
                }
            }
            List<StallPromotionDetail> stallPromotionDetails = stallPromotion.getDetails();
            //全场折扣
            if (stallPromotion.isStall_promotion_all()) {
                if (!TextUtils.isEmpty(stallPromotion.getPolicy_promotion_except_item()) && stallPromotion.getPolicy_promotion_except_item().contains("Key=\"" + posOrderDetail.getItemNum())) {
                    continue;
                }
                return stallPromotion;
            } else if (!TextUtils.isEmpty(stallPromotion.getPolicy_promotion_category())) {

                if (!TextUtils.isEmpty(stallPromotion.getPolicy_promotion_except_item()) && stallPromotion.getPolicy_promotion_except_item().contains("Key=\"" + posOrderDetail.getItemNum())) {
                    continue;
                }
                //类别折扣
                if (posOrderDetail.getPosItem() == null) return null;
                String item_category_code = posOrderDetail.getPosItem().getItem_category_code();
                String[] splitCategory = stallPromotion.getPolicy_promotion_category().split(",");
                boolean inUsable = false;
                for (String string : splitCategory) {
                    if (item_category_code.equals(string)) {
                        inUsable = true;
                        break;
                    }
                }
                if (!inUsable) continue;
                return stallPromotion;
            } else {
                if (stallPromotionDetails != null && stallPromotionDetails.size() > 0) {
                    for (StallPromotionDetail promotionDetail : stallPromotionDetails) {
                        if (posOrderDetail.getItemNum() == promotionDetail.getItem_num() && posOrderDetail.getItemGradeNum() == promotionDetail.getItem_grade_num()) {
                            if (stallPromotion.getPolicy_promotion_discount() > 0 && stallPromotion.getPolicy_promotion_discount() < 1) {
                                promotionDetail.setPolicy_promotion_detail_special_price(posOrderDetail.getOrderDetailStdPrice() * stallPromotion.getPolicy_promotion_discount());
                            }
                            stallPromotion.setStallPromotionDetail(promotionDetail);
                            return stallPromotion;
                        }
                    }
                }
            }
        }
        return null;
    }



    private static boolean currentTimeContain(StallPromotion stallPromotion) {

        String startTime = stallPromotion.getPolicy_promotion_time_from();
        String endTime = stallPromotion.getPolicy_promotion_time_to();
        String nowTime = TimeUtil.getInstance().stampToDate(System.currentTimeMillis());

        String format = "HH:mm:ss";
        try {
            String nowString = nowTime.substring(nowTime.length() - 8, nowTime.length());
            String startString = startTime.substring(startTime.length() - 8, startTime.length());
            String endString = endTime.substring(endTime.length() - 8, endTime.length());

            Date nowDate = new SimpleDateFormat(format).parse(nowString);
            Date starDate = new SimpleDateFormat(format).parse(startString);
            Date endDate = new SimpleDateFormat(format).parse(endString);
            if (isEffectiveTime(nowDate, starDate, endDate)) {
                return true;
            } else {
                return false;
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean currentDateContain(StallPromotion stallPromotion) {

        String startTime = stallPromotion.getPolicy_promotion_date_from();
        String endTime = stallPromotion.getPolicy_promotion_date_to();
        String nowTime = TimeUtil.getInstance().stampToDate(System.currentTimeMillis());

        String format = "yyyy-MM-dd";
        try {
            String nowString = nowTime.substring(0, nowTime.length() - 8);
            String startString = startTime.substring(0, startTime.length() - 8);
            String endString = endTime.substring(0, endTime.length() - 8);

            Date nowDate = new SimpleDateFormat(format).parse(nowString);
            Date starDate = new SimpleDateFormat(format).parse(startString);
            Date endDate = new SimpleDateFormat(format).parse(endString);
            int replayType  = 0;
            if (isEffectiveDate(nowDate, starDate, endDate, replayType)) {
                return true;
            } else {
                return false;
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime    当前时间
     * @param startTime  开始时间
     * @param endTime    结束时间
     * @param replayType 0 代表不重复  1 代表每个月重复 2 代表每年重复
     * @returnre
     */
    private static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime, int replayType) {
        Calendar nowdate = Calendar.getInstance();
        nowdate.setTime(nowTime);
        int nowMonth = nowdate.get(Calendar.MONTH);
        int nowDay = nowdate.get(Calendar.DAY_OF_MONTH);

        Calendar begindate = Calendar.getInstance();
        begindate.setTime(startTime);
        int beginMonth = begindate.get(Calendar.MONTH);
        int beginDay = begindate.get(Calendar.DAY_OF_MONTH);

        Calendar enddate = Calendar.getInstance();
        enddate.setTime(endTime);
        int endMonth = enddate.get(Calendar.MONTH);
        int endDay = enddate.get(Calendar.DAY_OF_MONTH);

        int isSpanMonth = endMonth - beginMonth;//是否跨月

        //每个月重复
        if (replayType == 1) {
            if (isSpanMonth == 1) {
                if (endDay >= beginDay) return true; //大过一个月

                int monthHavaDays = getMonthHavaDays(enddate.get(Calendar.YEAR), enddate.get(Calendar.MONTH));
                int beginmonthHavaDays = getMonthHavaDays(begindate.get(Calendar.YEAR), begindate.get(Calendar.MONTH));
                //开始日期是最后一天
                if (beginmonthHavaDays == beginDay) {
                    int nowHavadays = getMonthHavaDays(nowdate.get(Calendar.YEAR), nowdate.get(Calendar.MONTH));
                    if (nowDay == nowHavadays) return true; //今天也是最后一天
                    if (monthHavaDays == endDay) return true;//最后一天也是最后一天
                    if (nowDay <= endDay) return true;//今天小于等于结束日期
                    return false;
                } else {
                    if (nowDay >= beginDay) return true;
                    if (monthHavaDays == endDay) return true;//最后一天也是最后一天
                    if (nowDay <= endDay) return true;
                    return false;
                }

            } else if (isSpanMonth > 1) {
                return true;
            } else {
                int monthHavaDays = getMonthHavaDays(enddate.get(Calendar.YEAR), enddate.get(Calendar.MONTH));
                if (monthHavaDays == endDay) {
                    //代表是月末最后一天
                    if (nowDay >= beginDay) return true;
                    return false;
                } else {
                    if (nowDay >= beginDay || nowDay <= endDay) return true;
                    return false;
                }
            }
        } else if (replayType == 2) {
            if (nowMonth < beginMonth || nowMonth > endMonth) return false;
            if (nowMonth > beginMonth && nowMonth < endMonth) return true;
            if (isSpanMonth >= 1) {
                int beginmonthHavaDays = getMonthHavaDays(begindate.get(Calendar.YEAR), begindate.get(Calendar.MONTH));
                int nowHavadays = getMonthHavaDays(nowdate.get(Calendar.YEAR), nowdate.get(Calendar.MONTH));
                int monthHavaDays = getMonthHavaDays(enddate.get(Calendar.YEAR), enddate.get(Calendar.MONTH));

                if (nowMonth == beginMonth) {
                    if (beginmonthHavaDays == beginDay) {
                        if (nowDay == nowHavadays) return true; //今天也是最后一天
                        return false;
                    } else {
                        if (nowDay >= beginDay) return true;
                        return false;
                    }
                } else if (nowMonth == endMonth) {
                    if (monthHavaDays != endDay) {
                        if (nowDay <= endDay) return true;
                        return false;
                    } else {
                        if (nowDay == nowHavadays) return true; //今天也是最后一天
                    }
                }

                if (endDay >= beginDay) return true; //大过一个月
                //开始日期是最后一天
                if (beginmonthHavaDays == beginDay) {
                    if (nowDay == nowHavadays) return true; //今天也是最后一天
                    if (monthHavaDays == endDay) return true;//最后一天也是最后一天
                    if (nowDay <= endDay) return true;//今天小于等于结束日期
                    return false;
                } else {
                    if (nowDay >= beginDay) return true;
                    if (monthHavaDays == endDay) return true;//最后一天也是最后一天
                    if (nowDay <= endDay) return true;
                    return false;
                }
            } else {
                int monthHavaDays = getMonthHavaDays(enddate.get(Calendar.YEAR), enddate.get(Calendar.MONTH));
                if (monthHavaDays == endDay) {
                    //代表是月末最后一天
                    if (nowDay >= beginDay) return true;
                    return false;
                } else {
                    if (nowDay >= beginDay || nowDay <= endDay) return true;
                    return false;
                }
            }

        } else {
            if (nowTime.getTime() == startTime.getTime()
                    || nowTime.getTime() == endTime.getTime()) {
                return true;
            }

            if (nowdate.after(begindate) && nowdate.before(enddate)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static int getMonthHavaDays(int year, int month) {
        Calendar instance = Calendar.getInstance();
        instance.set(year, month, 0);
        return instance.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @author jqlin
     */
    private static boolean isEffectiveTime(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
