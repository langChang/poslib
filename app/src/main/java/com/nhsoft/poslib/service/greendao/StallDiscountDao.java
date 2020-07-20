package com.nhsoft.poslib.service.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.nhsoft.poslib.entity.nongmao.StallDiscount;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STALL_DISCOUNT".
*/
public class StallDiscountDao extends AbstractDao<StallDiscount, String> {

    public static final String TABLENAME = "STALL_DISCOUNT";

    /**
     * Properties of entity StallDiscount.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Policy_discount_no = new Property(0, String.class, "policy_discount_no", true, "POLICY_DISCOUNT_NO");
        public final static Property Branch_num = new Property(1, int.class, "branch_num", false, "BRANCH_NUM");
        public final static Property Policy_discount_audit_time = new Property(2, String.class, "policy_discount_audit_time", false, "POLICY_DISCOUNT_AUDIT_TIME");
        public final static Property Policy_discount_auditor = new Property(3, String.class, "policy_discount_auditor", false, "POLICY_DISCOUNT_AUDITOR");
        public final static Property Policy_discount_bill_money = new Property(4, int.class, "policy_discount_bill_money", false, "POLICY_DISCOUNT_BILL_MONEY");
        public final static Property Policy_discount_cancel_operator = new Property(5, String.class, "policy_discount_cancel_operator", false, "POLICY_DISCOUNT_CANCEL_OPERATOR");
        public final static Property Policy_discount_cancel_time = new Property(6, String.class, "policy_discount_cancel_time", false, "POLICY_DISCOUNT_CANCEL_TIME");
        public final static Property Policy_discount_card_only = new Property(7, boolean.class, "policy_discount_card_only", false, "POLICY_DISCOUNT_CARD_ONLY");
        public final static Property Policy_discount_card_type = new Property(8, String.class, "policy_discount_card_type", false, "POLICY_DISCOUNT_CARD_TYPE");
        public final static Property Policy_discount_create_time = new Property(9, String.class, "policy_discount_create_time", false, "POLICY_DISCOUNT_CREATE_TIME");
        public final static Property Policy_discount_creator = new Property(10, String.class, "policy_discount_creator", false, "POLICY_DISCOUNT_CREATOR");
        public final static Property Policy_discount_date_from = new Property(11, String.class, "policy_discount_date_from", false, "POLICY_DISCOUNT_DATE_FROM");
        public final static Property Policy_discount_date_to = new Property(12, String.class, "policy_discount_date_to", false, "POLICY_DISCOUNT_DATE_TO");
        public final static Property Policy_discount_discount = new Property(13, int.class, "policy_discount_discount", false, "POLICY_DISCOUNT_DISCOUNT");
        public final static Property Policy_discount_discount_money = new Property(14, int.class, "policy_discount_discount_money", false, "POLICY_DISCOUNT_DISCOUNT_MONEY");
        public final static Property Policy_discount_friday_actived = new Property(15, boolean.class, "policy_discount_friday_actived", false, "POLICY_DISCOUNT_FRIDAY_ACTIVED");
        public final static Property Policy_discount_last_edit_time = new Property(16, String.class, "policy_discount_last_edit_time", false, "POLICY_DISCOUNT_LAST_EDIT_TIME");
        public final static Property Policy_discount_memo = new Property(17, String.class, "policy_discount_memo", false, "POLICY_DISCOUNT_MEMO");
        public final static Property Policy_discount_mon_actived = new Property(18, boolean.class, "policy_discount_mon_actived", false, "POLICY_DISCOUNT_MON_ACTIVED");
        public final static Property Policy_discount_sat_actived = new Property(19, boolean.class, "policy_discount_sat_actived", false, "POLICY_DISCOUNT_SAT_ACTIVED");
        public final static Property Policy_discount_sun_actived = new Property(20, boolean.class, "policy_discount_sun_actived", false, "POLICY_DISCOUNT_SUN_ACTIVED");
        public final static Property Policy_discount_thurs_actived = new Property(21, boolean.class, "policy_discount_thurs_actived", false, "POLICY_DISCOUNT_THURS_ACTIVED");
        public final static Property Policy_discount_time_from = new Property(22, String.class, "policy_discount_time_from", false, "POLICY_DISCOUNT_TIME_FROM");
        public final static Property Policy_discount_time_to = new Property(23, String.class, "policy_discount_time_to", false, "POLICY_DISCOUNT_TIME_TO");
        public final static Property Policy_discount_total_discount = new Property(24, int.class, "policy_discount_total_discount", false, "POLICY_DISCOUNT_TOTAL_DISCOUNT");
        public final static Property Policy_discount_tues_actived = new Property(25, boolean.class, "policy_discount_tues_actived", false, "POLICY_DISCOUNT_TUES_ACTIVED");
        public final static Property Policy_discount_wed_actived = new Property(26, boolean.class, "policy_discount_wed_actived", false, "POLICY_DISCOUNT_WED_ACTIVED");
        public final static Property State_code = new Property(27, int.class, "state_code", false, "STATE_CODE");
        public final static Property State_name = new Property(28, String.class, "state_name", false, "STATE_NAME");
        public final static Property System_book_code = new Property(29, String.class, "system_book_code", false, "SYSTEM_BOOK_CODE");
        public final static Property StallList = new Property(30, String.class, "stallList", false, "STALL_LIST");
    }

    private DaoSession daoSession;


    public StallDiscountDao(DaoConfig config) {
        super(config);
    }
    
    public StallDiscountDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STALL_DISCOUNT\" (" + //
                "\"POLICY_DISCOUNT_NO\" TEXT PRIMARY KEY NOT NULL ," + // 0: policy_discount_no
                "\"BRANCH_NUM\" INTEGER NOT NULL ," + // 1: branch_num
                "\"POLICY_DISCOUNT_AUDIT_TIME\" TEXT," + // 2: policy_discount_audit_time
                "\"POLICY_DISCOUNT_AUDITOR\" TEXT," + // 3: policy_discount_auditor
                "\"POLICY_DISCOUNT_BILL_MONEY\" INTEGER NOT NULL ," + // 4: policy_discount_bill_money
                "\"POLICY_DISCOUNT_CANCEL_OPERATOR\" TEXT," + // 5: policy_discount_cancel_operator
                "\"POLICY_DISCOUNT_CANCEL_TIME\" TEXT," + // 6: policy_discount_cancel_time
                "\"POLICY_DISCOUNT_CARD_ONLY\" INTEGER NOT NULL ," + // 7: policy_discount_card_only
                "\"POLICY_DISCOUNT_CARD_TYPE\" TEXT," + // 8: policy_discount_card_type
                "\"POLICY_DISCOUNT_CREATE_TIME\" TEXT," + // 9: policy_discount_create_time
                "\"POLICY_DISCOUNT_CREATOR\" TEXT," + // 10: policy_discount_creator
                "\"POLICY_DISCOUNT_DATE_FROM\" TEXT," + // 11: policy_discount_date_from
                "\"POLICY_DISCOUNT_DATE_TO\" TEXT," + // 12: policy_discount_date_to
                "\"POLICY_DISCOUNT_DISCOUNT\" INTEGER NOT NULL ," + // 13: policy_discount_discount
                "\"POLICY_DISCOUNT_DISCOUNT_MONEY\" INTEGER NOT NULL ," + // 14: policy_discount_discount_money
                "\"POLICY_DISCOUNT_FRIDAY_ACTIVED\" INTEGER NOT NULL ," + // 15: policy_discount_friday_actived
                "\"POLICY_DISCOUNT_LAST_EDIT_TIME\" TEXT," + // 16: policy_discount_last_edit_time
                "\"POLICY_DISCOUNT_MEMO\" TEXT," + // 17: policy_discount_memo
                "\"POLICY_DISCOUNT_MON_ACTIVED\" INTEGER NOT NULL ," + // 18: policy_discount_mon_actived
                "\"POLICY_DISCOUNT_SAT_ACTIVED\" INTEGER NOT NULL ," + // 19: policy_discount_sat_actived
                "\"POLICY_DISCOUNT_SUN_ACTIVED\" INTEGER NOT NULL ," + // 20: policy_discount_sun_actived
                "\"POLICY_DISCOUNT_THURS_ACTIVED\" INTEGER NOT NULL ," + // 21: policy_discount_thurs_actived
                "\"POLICY_DISCOUNT_TIME_FROM\" TEXT," + // 22: policy_discount_time_from
                "\"POLICY_DISCOUNT_TIME_TO\" TEXT," + // 23: policy_discount_time_to
                "\"POLICY_DISCOUNT_TOTAL_DISCOUNT\" INTEGER NOT NULL ," + // 24: policy_discount_total_discount
                "\"POLICY_DISCOUNT_TUES_ACTIVED\" INTEGER NOT NULL ," + // 25: policy_discount_tues_actived
                "\"POLICY_DISCOUNT_WED_ACTIVED\" INTEGER NOT NULL ," + // 26: policy_discount_wed_actived
                "\"STATE_CODE\" INTEGER NOT NULL ," + // 27: state_code
                "\"STATE_NAME\" TEXT," + // 28: state_name
                "\"SYSTEM_BOOK_CODE\" TEXT," + // 29: system_book_code
                "\"STALL_LIST\" TEXT);"); // 30: stallList
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STALL_DISCOUNT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StallDiscount entity) {
        stmt.clearBindings();
 
        String policy_discount_no = entity.getPolicy_discount_no();
        if (policy_discount_no != null) {
            stmt.bindString(1, policy_discount_no);
        }
        stmt.bindLong(2, entity.getBranch_num());
 
        String policy_discount_audit_time = entity.getPolicy_discount_audit_time();
        if (policy_discount_audit_time != null) {
            stmt.bindString(3, policy_discount_audit_time);
        }
 
        String policy_discount_auditor = entity.getPolicy_discount_auditor();
        if (policy_discount_auditor != null) {
            stmt.bindString(4, policy_discount_auditor);
        }
        stmt.bindLong(5, entity.getPolicy_discount_bill_money());
 
        String policy_discount_cancel_operator = entity.getPolicy_discount_cancel_operator();
        if (policy_discount_cancel_operator != null) {
            stmt.bindString(6, policy_discount_cancel_operator);
        }
 
        String policy_discount_cancel_time = entity.getPolicy_discount_cancel_time();
        if (policy_discount_cancel_time != null) {
            stmt.bindString(7, policy_discount_cancel_time);
        }
        stmt.bindLong(8, entity.getPolicy_discount_card_only() ? 1L: 0L);
 
        String policy_discount_card_type = entity.getPolicy_discount_card_type();
        if (policy_discount_card_type != null) {
            stmt.bindString(9, policy_discount_card_type);
        }
 
        String policy_discount_create_time = entity.getPolicy_discount_create_time();
        if (policy_discount_create_time != null) {
            stmt.bindString(10, policy_discount_create_time);
        }
 
        String policy_discount_creator = entity.getPolicy_discount_creator();
        if (policy_discount_creator != null) {
            stmt.bindString(11, policy_discount_creator);
        }
 
        String policy_discount_date_from = entity.getPolicy_discount_date_from();
        if (policy_discount_date_from != null) {
            stmt.bindString(12, policy_discount_date_from);
        }
 
        String policy_discount_date_to = entity.getPolicy_discount_date_to();
        if (policy_discount_date_to != null) {
            stmt.bindString(13, policy_discount_date_to);
        }
        stmt.bindLong(14, entity.getPolicy_discount_discount());
        stmt.bindLong(15, entity.getPolicy_discount_discount_money());
        stmt.bindLong(16, entity.getPolicy_discount_friday_actived() ? 1L: 0L);
 
        String policy_discount_last_edit_time = entity.getPolicy_discount_last_edit_time();
        if (policy_discount_last_edit_time != null) {
            stmt.bindString(17, policy_discount_last_edit_time);
        }
 
        String policy_discount_memo = entity.getPolicy_discount_memo();
        if (policy_discount_memo != null) {
            stmt.bindString(18, policy_discount_memo);
        }
        stmt.bindLong(19, entity.getPolicy_discount_mon_actived() ? 1L: 0L);
        stmt.bindLong(20, entity.getPolicy_discount_sat_actived() ? 1L: 0L);
        stmt.bindLong(21, entity.getPolicy_discount_sun_actived() ? 1L: 0L);
        stmt.bindLong(22, entity.getPolicy_discount_thurs_actived() ? 1L: 0L);
 
        String policy_discount_time_from = entity.getPolicy_discount_time_from();
        if (policy_discount_time_from != null) {
            stmt.bindString(23, policy_discount_time_from);
        }
 
        String policy_discount_time_to = entity.getPolicy_discount_time_to();
        if (policy_discount_time_to != null) {
            stmt.bindString(24, policy_discount_time_to);
        }
        stmt.bindLong(25, entity.getPolicy_discount_total_discount());
        stmt.bindLong(26, entity.getPolicy_discount_tues_actived() ? 1L: 0L);
        stmt.bindLong(27, entity.getPolicy_discount_wed_actived() ? 1L: 0L);
        stmt.bindLong(28, entity.getState_code());
 
        String state_name = entity.getState_name();
        if (state_name != null) {
            stmt.bindString(29, state_name);
        }
 
        String system_book_code = entity.getSystem_book_code();
        if (system_book_code != null) {
            stmt.bindString(30, system_book_code);
        }
 
        String stallList = entity.getStallList();
        if (stallList != null) {
            stmt.bindString(31, stallList);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StallDiscount entity) {
        stmt.clearBindings();
 
        String policy_discount_no = entity.getPolicy_discount_no();
        if (policy_discount_no != null) {
            stmt.bindString(1, policy_discount_no);
        }
        stmt.bindLong(2, entity.getBranch_num());
 
        String policy_discount_audit_time = entity.getPolicy_discount_audit_time();
        if (policy_discount_audit_time != null) {
            stmt.bindString(3, policy_discount_audit_time);
        }
 
        String policy_discount_auditor = entity.getPolicy_discount_auditor();
        if (policy_discount_auditor != null) {
            stmt.bindString(4, policy_discount_auditor);
        }
        stmt.bindLong(5, entity.getPolicy_discount_bill_money());
 
        String policy_discount_cancel_operator = entity.getPolicy_discount_cancel_operator();
        if (policy_discount_cancel_operator != null) {
            stmt.bindString(6, policy_discount_cancel_operator);
        }
 
        String policy_discount_cancel_time = entity.getPolicy_discount_cancel_time();
        if (policy_discount_cancel_time != null) {
            stmt.bindString(7, policy_discount_cancel_time);
        }
        stmt.bindLong(8, entity.getPolicy_discount_card_only() ? 1L: 0L);
 
        String policy_discount_card_type = entity.getPolicy_discount_card_type();
        if (policy_discount_card_type != null) {
            stmt.bindString(9, policy_discount_card_type);
        }
 
        String policy_discount_create_time = entity.getPolicy_discount_create_time();
        if (policy_discount_create_time != null) {
            stmt.bindString(10, policy_discount_create_time);
        }
 
        String policy_discount_creator = entity.getPolicy_discount_creator();
        if (policy_discount_creator != null) {
            stmt.bindString(11, policy_discount_creator);
        }
 
        String policy_discount_date_from = entity.getPolicy_discount_date_from();
        if (policy_discount_date_from != null) {
            stmt.bindString(12, policy_discount_date_from);
        }
 
        String policy_discount_date_to = entity.getPolicy_discount_date_to();
        if (policy_discount_date_to != null) {
            stmt.bindString(13, policy_discount_date_to);
        }
        stmt.bindLong(14, entity.getPolicy_discount_discount());
        stmt.bindLong(15, entity.getPolicy_discount_discount_money());
        stmt.bindLong(16, entity.getPolicy_discount_friday_actived() ? 1L: 0L);
 
        String policy_discount_last_edit_time = entity.getPolicy_discount_last_edit_time();
        if (policy_discount_last_edit_time != null) {
            stmt.bindString(17, policy_discount_last_edit_time);
        }
 
        String policy_discount_memo = entity.getPolicy_discount_memo();
        if (policy_discount_memo != null) {
            stmt.bindString(18, policy_discount_memo);
        }
        stmt.bindLong(19, entity.getPolicy_discount_mon_actived() ? 1L: 0L);
        stmt.bindLong(20, entity.getPolicy_discount_sat_actived() ? 1L: 0L);
        stmt.bindLong(21, entity.getPolicy_discount_sun_actived() ? 1L: 0L);
        stmt.bindLong(22, entity.getPolicy_discount_thurs_actived() ? 1L: 0L);
 
        String policy_discount_time_from = entity.getPolicy_discount_time_from();
        if (policy_discount_time_from != null) {
            stmt.bindString(23, policy_discount_time_from);
        }
 
        String policy_discount_time_to = entity.getPolicy_discount_time_to();
        if (policy_discount_time_to != null) {
            stmt.bindString(24, policy_discount_time_to);
        }
        stmt.bindLong(25, entity.getPolicy_discount_total_discount());
        stmt.bindLong(26, entity.getPolicy_discount_tues_actived() ? 1L: 0L);
        stmt.bindLong(27, entity.getPolicy_discount_wed_actived() ? 1L: 0L);
        stmt.bindLong(28, entity.getState_code());
 
        String state_name = entity.getState_name();
        if (state_name != null) {
            stmt.bindString(29, state_name);
        }
 
        String system_book_code = entity.getSystem_book_code();
        if (system_book_code != null) {
            stmt.bindString(30, system_book_code);
        }
 
        String stallList = entity.getStallList();
        if (stallList != null) {
            stmt.bindString(31, stallList);
        }
    }

    @Override
    protected final void attachEntity(StallDiscount entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public StallDiscount readEntity(Cursor cursor, int offset) {
        StallDiscount entity = new StallDiscount( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // policy_discount_no
            cursor.getInt(offset + 1), // branch_num
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // policy_discount_audit_time
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // policy_discount_auditor
            cursor.getInt(offset + 4), // policy_discount_bill_money
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // policy_discount_cancel_operator
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // policy_discount_cancel_time
            cursor.getShort(offset + 7) != 0, // policy_discount_card_only
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // policy_discount_card_type
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // policy_discount_create_time
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // policy_discount_creator
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // policy_discount_date_from
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // policy_discount_date_to
            cursor.getInt(offset + 13), // policy_discount_discount
            cursor.getInt(offset + 14), // policy_discount_discount_money
            cursor.getShort(offset + 15) != 0, // policy_discount_friday_actived
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // policy_discount_last_edit_time
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // policy_discount_memo
            cursor.getShort(offset + 18) != 0, // policy_discount_mon_actived
            cursor.getShort(offset + 19) != 0, // policy_discount_sat_actived
            cursor.getShort(offset + 20) != 0, // policy_discount_sun_actived
            cursor.getShort(offset + 21) != 0, // policy_discount_thurs_actived
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // policy_discount_time_from
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // policy_discount_time_to
            cursor.getInt(offset + 24), // policy_discount_total_discount
            cursor.getShort(offset + 25) != 0, // policy_discount_tues_actived
            cursor.getShort(offset + 26) != 0, // policy_discount_wed_actived
            cursor.getInt(offset + 27), // state_code
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // state_name
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // system_book_code
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30) // stallList
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StallDiscount entity, int offset) {
        entity.setPolicy_discount_no(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setBranch_num(cursor.getInt(offset + 1));
        entity.setPolicy_discount_audit_time(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPolicy_discount_auditor(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPolicy_discount_bill_money(cursor.getInt(offset + 4));
        entity.setPolicy_discount_cancel_operator(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPolicy_discount_cancel_time(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPolicy_discount_card_only(cursor.getShort(offset + 7) != 0);
        entity.setPolicy_discount_card_type(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPolicy_discount_create_time(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPolicy_discount_creator(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPolicy_discount_date_from(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPolicy_discount_date_to(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPolicy_discount_discount(cursor.getInt(offset + 13));
        entity.setPolicy_discount_discount_money(cursor.getInt(offset + 14));
        entity.setPolicy_discount_friday_actived(cursor.getShort(offset + 15) != 0);
        entity.setPolicy_discount_last_edit_time(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPolicy_discount_memo(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setPolicy_discount_mon_actived(cursor.getShort(offset + 18) != 0);
        entity.setPolicy_discount_sat_actived(cursor.getShort(offset + 19) != 0);
        entity.setPolicy_discount_sun_actived(cursor.getShort(offset + 20) != 0);
        entity.setPolicy_discount_thurs_actived(cursor.getShort(offset + 21) != 0);
        entity.setPolicy_discount_time_from(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setPolicy_discount_time_to(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setPolicy_discount_total_discount(cursor.getInt(offset + 24));
        entity.setPolicy_discount_tues_actived(cursor.getShort(offset + 25) != 0);
        entity.setPolicy_discount_wed_actived(cursor.getShort(offset + 26) != 0);
        entity.setState_code(cursor.getInt(offset + 27));
        entity.setState_name(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setSystem_book_code(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setStallList(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
     }
    
    @Override
    protected final String updateKeyAfterInsert(StallDiscount entity, long rowId) {
        return entity.getPolicy_discount_no();
    }
    
    @Override
    public String getKey(StallDiscount entity) {
        if(entity != null) {
            return entity.getPolicy_discount_no();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StallDiscount entity) {
        return entity.getPolicy_discount_no() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
