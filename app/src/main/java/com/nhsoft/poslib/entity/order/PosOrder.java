package com.nhsoft.poslib.entity.order;


import android.text.TextUtils;

import com.nhsoft.poslib.entity.ClientPoint;
import com.nhsoft.poslib.entity.KeyGeneratorBizday;
import com.nhsoft.poslib.entity.TicketSendDetail;
import com.nhsoft.poslib.entity.VipUserInfo;
import com.nhsoft.poslib.libconfig.LibConfig;
import com.nhsoft.poslib.model.CouponsBean;
import com.nhsoft.poslib.model.RedisBean;
import com.nhsoft.poslib.service.KeyGeneratorBizdayService;
import com.nhsoft.poslib.service.greendao.DaoSession;
import com.nhsoft.poslib.service.greendao.PaymentDao;
import com.nhsoft.poslib.service.greendao.PosOrderDao;
import com.nhsoft.poslib.service.greendao.PosOrderDetailDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * PosOrder generated by hbm2java
 */
@Entity
public class PosOrder implements Cloneable {

    @Id
    @Property(nameInDb = "ORDER_NO")
    private String  orderNo;
    private String  layawayOrderNo;
    private String  clientFid;
    private int     storehouseNum;
    private String  systemBookCode;//
    private int     branchNum;//
    private int     shiftTableNum;//
    private String  shiftTableBizday;//
    private String  orderDate;
    private String  orderSoldBy;
    private String  orderOperator;
    private String  orderOperateTime;
    private Boolean orderFlag = false;
    private String  orderPrintedNum;
    private String  orderCardUser;
    private String  orderCardTypeDesc;
    private float   orderDiscountMoney;
    private float   orderCommission;
    private float   orderTotalMoney;//用了多少钱
    private float   orderPaymentMoney;// 总面值多少钱
    private float   orderRound;
    private float   orderBalance;
    private float   orderTotalInvoice;
    private float   orderChange;
    private String  orderTime;
    private String  orderMachine;
    private String  orderChangeAuditor;
    private String  orderChangeTime;
    private String  orderPayee;
    private int     orderStateCode;//5
    private String  orderStateName;
    private String  orderMemo = "";
    private String  orderRefBillno;
    private float   orderPoint;
    private float   orderGrossProfit;
    private float   orderMgrDiscountMoney;
    private float   orderCouponTotalMoney;
    private float   orderCouponPaymentMoney;
    private int     orderCardUserNum;
    private int     orderCardType;
    private String  orderSource;
    private float   orderPostFee;
    private float   orderPromotionDiscountMoney;
    private String  orderExternalNo;
    private int     orderDetailItemCount;
    private String  orderTimeChar;
    private Boolean orderStockFlag;
    private String  orderCardPhone;
    private float   orderCardChange;
    private float   orderTaxMoney;
    private String  orderTmallMemo;
    private String  orderUserGroup;
    private float   orderOnlineDiscount;
    private int     merchantNum;
    private int     stallNum;
    private float   orderCostMoney;
    private String  orderPayNo;
    private boolean orderUploadState;//是否已经上传成功 标记 默认false(没上传)
    private boolean orderRemortInsertBean;//是否远程查询插入本地的
    private String openId;
    private String alipayUserId;
    private String customerId;
    @Transient
    private RedisBean redisBean;
    @Transient
    private RedisBean couponsRedisBean;


    public RedisBean getCouponsRedisBean() {
        return couponsRedisBean;
    }

    public void setCouponsRedisBean(RedisBean couponsRedisBean) {
        this.couponsRedisBean = couponsRedisBean;
    }




    public RedisBean getRedisBean() {
        return redisBean;
    }

    public void setRedisBean(RedisBean redisBean) {
        this.redisBean = redisBean;
    }




    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }



    @Transient
    private VipUserInfo            vipUserInfo;
    @Transient
    private ClientPoint            clientPoint;
    @Transient
    private List<TicketSendDetail> ticketSendDetails;
    @Transient
    private boolean                isRoundPayment;
    @Transient
    private float                  quickZeroMoney;

    public float getQuickZeroMoney() {
        return quickZeroMoney;
    }

    public void setQuickZeroMoney(float quickZeroMoney) {
        this.quickZeroMoney = quickZeroMoney;
    }

    public VipUserInfo getVipUserInfo() {
        return vipUserInfo;
    }

    public void setVipUserInfo(VipUserInfo vipUserInfo) {
        this.vipUserInfo = vipUserInfo;
    }

    public ClientPoint getClientPoint() {
        return clientPoint;
    }

    public void setClientPoint(ClientPoint clientPoint) {
        this.clientPoint = clientPoint;
    }


    public List<TicketSendDetail> getTicketSendDetails() {
        return ticketSendDetails;
    }

    public void setTicketSendDetails(List<TicketSendDetail> ticketSendDetails) {
        this.ticketSendDetails = ticketSendDetails;
    }

    public boolean isRoundPayment() {
        return isRoundPayment;
    }

    public void setRoundPayment(boolean roundPayment) {
        isRoundPayment = roundPayment;
    }

    @Transient
    private KeyGeneratorBizday keyGeneratorBizday;

    @ToMany(referencedJoinProperty = "orderNo")
    private           List<PosOrderDetail> posOrderDetails = new ArrayList<PosOrderDetail>(0);
    @ToMany(referencedJoinProperty = "orderNo")
    private           List<Payment>        payments        = new ArrayList<Payment>(0);
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession           daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1730114913)
    private transient PosOrderDao          myDao;

    @Transient
    private List<CouponsBean> useConponsList = new ArrayList<>();

    @Transient
    private List<CouponsBean> mercuryConponsList = new ArrayList<>();

    public List<CouponsBean> getUseConponsList() {
        return useConponsList;
    }

    public void setUseConponsList(List<CouponsBean> userConponsList) {
        this.useConponsList = userConponsList;
    }

    public List<CouponsBean> getMercuryConponsList() {
        return mercuryConponsList;
    }

    public void setMercuryConponsList(List<CouponsBean> mercuryConponsList) {
        this.mercuryConponsList = mercuryConponsList;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Generated(hash = 1763251636)
    public PosOrder() {
    }


    @Generated(hash = 376681)
    public PosOrder(String orderNo, String layawayOrderNo, String clientFid, int storehouseNum, String systemBookCode, int branchNum, int shiftTableNum, String shiftTableBizday, String orderDate, String orderSoldBy, String orderOperator,
            String orderOperateTime, Boolean orderFlag, String orderPrintedNum, String orderCardUser, String orderCardTypeDesc, float orderDiscountMoney, float orderCommission, float orderTotalMoney, float orderPaymentMoney, float orderRound,
            float orderBalance, float orderTotalInvoice, float orderChange, String orderTime, String orderMachine, String orderChangeAuditor, String orderChangeTime, String orderPayee, int orderStateCode, String orderStateName,
            String orderMemo, String orderRefBillno, float orderPoint, float orderGrossProfit, float orderMgrDiscountMoney, float orderCouponTotalMoney, float orderCouponPaymentMoney, int orderCardUserNum, int orderCardType, String orderSource,
            float orderPostFee, float orderPromotionDiscountMoney, String orderExternalNo, int orderDetailItemCount, String orderTimeChar, Boolean orderStockFlag, String orderCardPhone, float orderCardChange, float orderTaxMoney,
            String orderTmallMemo, String orderUserGroup, float orderOnlineDiscount, int merchantNum, int stallNum, float orderCostMoney, String orderPayNo, boolean orderUploadState, boolean orderRemortInsertBean, String openId,
            String alipayUserId, String customerId) {
        this.orderNo = orderNo;
        this.layawayOrderNo = layawayOrderNo;
        this.clientFid = clientFid;
        this.storehouseNum = storehouseNum;
        this.systemBookCode = systemBookCode;
        this.branchNum = branchNum;
        this.shiftTableNum = shiftTableNum;
        this.shiftTableBizday = shiftTableBizday;
        this.orderDate = orderDate;
        this.orderSoldBy = orderSoldBy;
        this.orderOperator = orderOperator;
        this.orderOperateTime = orderOperateTime;
        this.orderFlag = orderFlag;
        this.orderPrintedNum = orderPrintedNum;
        this.orderCardUser = orderCardUser;
        this.orderCardTypeDesc = orderCardTypeDesc;
        this.orderDiscountMoney = orderDiscountMoney;
        this.orderCommission = orderCommission;
        this.orderTotalMoney = orderTotalMoney;
        this.orderPaymentMoney = orderPaymentMoney;
        this.orderRound = orderRound;
        this.orderBalance = orderBalance;
        this.orderTotalInvoice = orderTotalInvoice;
        this.orderChange = orderChange;
        this.orderTime = orderTime;
        this.orderMachine = orderMachine;
        this.orderChangeAuditor = orderChangeAuditor;
        this.orderChangeTime = orderChangeTime;
        this.orderPayee = orderPayee;
        this.orderStateCode = orderStateCode;
        this.orderStateName = orderStateName;
        this.orderMemo = orderMemo;
        this.orderRefBillno = orderRefBillno;
        this.orderPoint = orderPoint;
        this.orderGrossProfit = orderGrossProfit;
        this.orderMgrDiscountMoney = orderMgrDiscountMoney;
        this.orderCouponTotalMoney = orderCouponTotalMoney;
        this.orderCouponPaymentMoney = orderCouponPaymentMoney;
        this.orderCardUserNum = orderCardUserNum;
        this.orderCardType = orderCardType;
        this.orderSource = orderSource;
        this.orderPostFee = orderPostFee;
        this.orderPromotionDiscountMoney = orderPromotionDiscountMoney;
        this.orderExternalNo = orderExternalNo;
        this.orderDetailItemCount = orderDetailItemCount;
        this.orderTimeChar = orderTimeChar;
        this.orderStockFlag = orderStockFlag;
        this.orderCardPhone = orderCardPhone;
        this.orderCardChange = orderCardChange;
        this.orderTaxMoney = orderTaxMoney;
        this.orderTmallMemo = orderTmallMemo;
        this.orderUserGroup = orderUserGroup;
        this.orderOnlineDiscount = orderOnlineDiscount;
        this.merchantNum = merchantNum;
        this.stallNum = stallNum;
        this.orderCostMoney = orderCostMoney;
        this.orderPayNo = orderPayNo;
        this.orderUploadState = orderUploadState;
        this.orderRemortInsertBean = orderRemortInsertBean;
        this.openId = openId;
        this.alipayUserId = alipayUserId;
        this.customerId = customerId;
    }

    public boolean isOrderUploadState() {
        return orderUploadState;
    }

    public void setOrderUploadState(boolean orderUploadState) {
        this.orderUploadState = orderUploadState;
    }

    public void setPosOrderDetails(List<PosOrderDetail> details) {
        this.posOrderDetails = details;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        if (TextUtils.isEmpty(getOrderExternalNo())) {
            setOrderExternalNo(KeyGeneratorBizdayService.getInstance().createOutPosOrderNo(LibConfig.activeShiftTable.getBranchNum(), LibConfig.activeShiftTable.getShiftTableBizday(), LibConfig.activePosMachine.getPos_machine_sequence()));
        }
    }

    public String getLayawayOrderNo() {
        return this.layawayOrderNo;
    }

    public void setLayawayOrderNo(String layawayOrderNo) {
        this.layawayOrderNo = layawayOrderNo;
    }

    public String getClientFid() {
        return this.clientFid;
    }

    public void setClientFid(String clientFid) {
        this.clientFid = clientFid;
    }

    public int getStorehouseNum() {
        return this.storehouseNum;
    }

    public void setStorehouseNum(int storehouseNum) {
        this.storehouseNum = storehouseNum;
    }

    public String getSystemBookCode() {
        return this.systemBookCode;
    }

    public void setSystemBookCode(String systemBookCode) {
        this.systemBookCode = systemBookCode;
    }

    public int getBranchNum() {
        return this.branchNum;
    }

    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

    public int getShiftTableNum() {
        return this.shiftTableNum;
    }

    public void setShiftTableNum(int shiftTableNum) {
        this.shiftTableNum = shiftTableNum;
    }

    public String getShiftTableBizday() {
        return this.shiftTableBizday;
    }

    public void setShiftTableBizday(String shiftTableBizday) {
        this.shiftTableBizday = shiftTableBizday;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderSoldBy() {
        return this.orderSoldBy;
    }

    public void setOrderSoldBy(String orderSoldBy) {
        this.orderSoldBy = orderSoldBy;
    }

    public String getOrderOperator() {
        return this.orderOperator;
    }

    public void setOrderOperator(String orderOperator) {
        this.orderOperator = orderOperator;
    }

    public String getOrderOperateTime() {
        return this.orderOperateTime;
    }

    public void setOrderOperateTime(String orderOperateTime) {
        this.orderOperateTime = orderOperateTime;
    }

    public Boolean getOrderFlag() {
        return this.orderFlag;
    }

    public void setOrderFlag(Boolean orderFlag) {
        this.orderFlag = orderFlag;
    }

    public String getOrderPrintedNum() {
        return this.orderPrintedNum;
    }

    public void setOrderPrintedNum(String orderPrintedNum) {
        this.orderPrintedNum = orderPrintedNum;
    }

    public String getOrderCardUser() {
        return this.orderCardUser;
    }

    public void setOrderCardUser(String orderCardUser) {
        this.orderCardUser = orderCardUser;
    }

    public String getOrderCardTypeDesc() {
        return this.orderCardTypeDesc;
    }

    public void setOrderCardTypeDesc(String orderCardTypeDesc) {
        this.orderCardTypeDesc = orderCardTypeDesc;
    }

    public float getOrderDiscountMoney() {
        return this.orderDiscountMoney;
    }

    public void setOrderDiscountMoney(float orderDiscountMoney) {
        this.orderDiscountMoney = orderDiscountMoney;
    }

    public float getOrderCommission() {
        return this.orderCommission;
    }

    public void setOrderCommission(float orderCommission) {
        this.orderCommission = orderCommission;
    }

    public float getOrderTotalMoney() {
        return this.orderTotalMoney;
    }

    public void setOrderTotalMoney(float orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }

    public float getOrderPaymentMoney() {
        return this.orderPaymentMoney;
    }

    public void setOrderPaymentMoney(float orderPaymentMoney) {
        this.orderPaymentMoney = orderPaymentMoney;
    }

    public float getOrderRound() {
        return this.orderRound;
    }

    public void setOrderRound(float orderRound) {
        this.orderRound = orderRound;
    }

    public float getOrderBalance() {
        return this.orderBalance;
    }

    public void setOrderBalance(float orderBalance) {
        this.orderBalance = orderBalance;
    }

    public float getOrderTotalInvoice() {
        return this.orderTotalInvoice;
    }

    public void setOrderTotalInvoice(float orderTotalInvoice) {
        this.orderTotalInvoice = orderTotalInvoice;
    }

    public float getOrderChange() {
        return this.orderChange;
    }

    public void setOrderChange(float orderChange) {
        this.orderChange = orderChange;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    public String getOrderChangeAuditor() {
        return this.orderChangeAuditor;
    }

    public void setOrderChangeAuditor(String orderChangeAuditor) {
        this.orderChangeAuditor = orderChangeAuditor;
    }

    public String getOrderChangeTime() {
        return this.orderChangeTime;
    }

    public void setOrderChangeTime(String orderChangeTime) {
        this.orderChangeTime = orderChangeTime;
    }

    public String getOrderPayee() {
        return this.orderPayee;
    }

    public void setOrderPayee(String orderPayee) {
        this.orderPayee = orderPayee;
    }

    public int getOrderStateCode() {
        return this.orderStateCode;
    }

    public void setOrderStateCode(int orderStateCode) {
        this.orderStateCode = orderStateCode;
    }

    public String getOrderStateName() {
        return this.orderStateName;
    }

    public void setOrderStateName(String orderStateName) {
        this.orderStateName = orderStateName;
    }

    public String getOrderMemo() {
        return this.orderMemo;
    }

    public void setOrderMemo(String orderMemo) {
        this.orderMemo = orderMemo;
    }

    public String getOrderRefBillno() {
        return this.orderRefBillno;
    }

    public void setOrderRefBillno(String orderRefBillno) {
        this.orderRefBillno = orderRefBillno;
    }

    public float getOrderPoint() {
        return this.orderPoint;
    }

    public void setOrderPoint(float orderPoint) {
        this.orderPoint = orderPoint;
    }

    public float getOrderGrossProfit() {
        return this.orderGrossProfit;
    }

    public void setOrderGrossProfit(float orderGrossProfit) {
        this.orderGrossProfit = orderGrossProfit;
    }

    public float getOrderMgrDiscountMoney() {
        return this.orderMgrDiscountMoney;
    }

    public void setOrderMgrDiscountMoney(float orderMgrDiscountMoney) {
        this.orderMgrDiscountMoney = orderMgrDiscountMoney;
    }

    public float getOrderCouponTotalMoney() {
        return this.orderCouponTotalMoney;
    }

    public void setOrderCouponTotalMoney(float orderCouponTotalMoney) {
        this.orderCouponTotalMoney = orderCouponTotalMoney;
    }

    public float getOrderCouponPaymentMoney() {
        return this.orderCouponPaymentMoney;
    }

    public void setOrderCouponPaymentMoney(float orderCouponPaymentMoney) {
        this.orderCouponPaymentMoney = orderCouponPaymentMoney;
    }

    public int getOrderCardUserNum() {
        return this.orderCardUserNum;
    }

    public void setOrderCardUserNum(int orderCardUserNum) {
        this.orderCardUserNum = orderCardUserNum;
    }

    public int getOrderCardType() {
        return this.orderCardType;
    }

    public void setOrderCardType(int orderCardType) {
        this.orderCardType = orderCardType;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public float getOrderPostFee() {
        return this.orderPostFee;
    }

    public void setOrderPostFee(float orderPostFee) {
        this.orderPostFee = orderPostFee;
    }

    public float getOrderPromotionDiscountMoney() {
        return this.orderPromotionDiscountMoney;
    }

    public void setOrderPromotionDiscountMoney(float orderPromotionDiscountMoney) {
        this.orderPromotionDiscountMoney = orderPromotionDiscountMoney;
    }

    public String getOrderExternalNo() {
        return this.orderExternalNo;
    }

    public void setOrderExternalNo(String orderExternalNo) {
        this.orderExternalNo = orderExternalNo;
    }

    public int getOrderDetailItemCount() {
        return this.orderDetailItemCount;
    }

    public void setOrderDetailItemCount(int orderDetailItemCount) {
        this.orderDetailItemCount = orderDetailItemCount;
    }

    public String getOrderTimeChar() {
        return this.orderTimeChar;
    }

    public void setOrderTimeChar(String orderTimeChar) {
        this.orderTimeChar = orderTimeChar;
    }

    public Boolean getOrderStockFlag() {
        return this.orderStockFlag;
    }

    public void setOrderStockFlag(Boolean orderStockFlag) {
        this.orderStockFlag = orderStockFlag;
    }

    public String getOrderCardPhone() {
        return this.orderCardPhone;
    }

    public void setOrderCardPhone(String orderCardPhone) {
        this.orderCardPhone = orderCardPhone;
    }

    public float getOrderCardChange() {
        return this.orderCardChange;
    }

    public void setOrderCardChange(float orderCardChange) {
        this.orderCardChange = orderCardChange;
    }

    public float getOrderTaxMoney() {
        return this.orderTaxMoney;
    }

    public void setOrderTaxMoney(float orderTaxMoney) {
        this.orderTaxMoney = orderTaxMoney;
    }

    public String getOrderTmallMemo() {
        return this.orderTmallMemo;
    }

    public void setOrderTmallMemo(String orderTmallMemo) {
        this.orderTmallMemo = orderTmallMemo;
    }

    public String getOrderUserGroup() {
        return this.orderUserGroup;
    }

    public void setOrderUserGroup(String orderUserGroup) {
        this.orderUserGroup = orderUserGroup;
    }

    public float getOrderOnlineDiscount() {
        return this.orderOnlineDiscount;
    }

    public void setOrderOnlineDiscount(float orderOnlineDiscount) {
        this.orderOnlineDiscount = orderOnlineDiscount;
    }

    public int getMerchantNum() {
        return this.merchantNum;
    }

    public void setMerchantNum(int merchantNum) {
        this.merchantNum = merchantNum;
    }

    public int getStallNum() {
        return this.stallNum;
    }

    public void setStallNum(int stallNum) {
        this.stallNum = stallNum;
    }

    public float getOrderCostMoney() {
        return this.orderCostMoney;
    }

    public void setOrderCostMoney(float orderCostMoney) {
        this.orderCostMoney = orderCostMoney;
    }

    public String getOrderPayNo() {
        return this.orderPayNo;
    }

    public void setOrderPayNo(String orderPayNo) {
        this.orderPayNo = orderPayNo;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 423547649)
    public List<PosOrderDetail> getPosOrderDetails() {
        if (posOrderDetails == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PosOrderDetailDao targetDao = daoSession.getPosOrderDetailDao();
            List<PosOrderDetail> posOrderDetailsNew = targetDao
                    ._queryPosOrder_PosOrderDetails(orderNo);
            synchronized (this) {
                if (posOrderDetails == null) {
                    posOrderDetails = posOrderDetailsNew;
                }
            }
        }
        return posOrderDetails;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 458317267)
    public synchronized void resetPosOrderDetails() {
        posOrderDetails = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1757645081)
    public List<Payment> getPayments() {
        if (payments == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PaymentDao targetDao = daoSession.getPaymentDao();
            List<Payment> paymentsNew = targetDao._queryPosOrder_Payments(orderNo);
            synchronized (this) {
                if (payments == null) {
                    payments = paymentsNew;
                }
            }
        }
        return payments;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1083720232)
    public synchronized void resetPayments() {
        payments = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public boolean getOrderUploadState() {
        return this.orderUploadState;
    }


    public String getOrderMachine() {
        return this.orderMachine;
    }


    public void setOrderMachine(String orderMachine) {
        this.orderMachine = orderMachine;
    }

    public boolean getOrderRemortInsertBean() {
        return this.orderRemortInsertBean;
    }

    public void setOrderRemortInsertBean(boolean orderRemortInsertBean) {
        this.orderRemortInsertBean = orderRemortInsertBean;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1520547251)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPosOrderDao() : null;
    }


}
