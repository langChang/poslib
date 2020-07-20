package com.nhsoft.poslib.service.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.nhsoft.poslib.entity.AppUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "APP_USER".
*/
public class AppUserDao extends AbstractDao<AppUser, Long> {

    public static final String TABLENAME = "APP_USER";

    /**
     * Properties of entity AppUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property App_user_num = new Property(0, Long.class, "app_user_num", true, "app_user_num");
        public final static Property System_book_code = new Property(1, String.class, "system_book_code", false, "SYSTEM_BOOK_CODE");
        public final static Property App_user_code = new Property(2, String.class, "app_user_code", false, "APP_USER_CODE");
        public final static Property App_user_name = new Property(3, String.class, "app_user_name", false, "APP_USER_NAME");
        public final static Property App_user_password = new Property(4, String.class, "app_user_password", false, "APP_USER_PASSWORD");
        public final static Property App_user_state_code = new Property(5, int.class, "app_user_state_code", false, "APP_USER_STATE_CODE");
        public final static Property App_user_phone = new Property(6, String.class, "app_user_phone", false, "APP_USER_PHONE");
        public final static Property App_user_email = new Property(7, String.class, "app_user_email", false, "APP_USER_EMAIL");
        public final static Property App_user_pw_key = new Property(8, String.class, "app_user_pw_key", false, "APP_USER_PW_KEY");
        public final static Property Touch_pos_user = new Property(9, boolean.class, "touch_pos_user", false, "TOUCH_POS_USER");
        public final static Property User_max_discount = new Property(10, float.class, "user_max_discount", false, "USER_MAX_DISCOUNT");
        public final static Property User_max_discount_rate = new Property(11, float.class, "user_max_discount_rate", false, "USER_MAX_DISCOUNT_RATE");
        public final static Property User_max_order_number = new Property(12, Integer.class, "user_max_order_number", false, "USER_MAX_ORDER_NUMBER");
        public final static Property Merchant_num = new Property(13, Integer.class, "merchant_num", false, "MERCHANT_NUM");
    }

    private DaoSession daoSession;


    public AppUserDao(DaoConfig config) {
        super(config);
    }
    
    public AppUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"APP_USER\" (" + //
                "\"app_user_num\" INTEGER PRIMARY KEY ," + // 0: app_user_num
                "\"SYSTEM_BOOK_CODE\" TEXT," + // 1: system_book_code
                "\"APP_USER_CODE\" TEXT," + // 2: app_user_code
                "\"APP_USER_NAME\" TEXT," + // 3: app_user_name
                "\"APP_USER_PASSWORD\" TEXT," + // 4: app_user_password
                "\"APP_USER_STATE_CODE\" INTEGER NOT NULL ," + // 5: app_user_state_code
                "\"APP_USER_PHONE\" TEXT," + // 6: app_user_phone
                "\"APP_USER_EMAIL\" TEXT," + // 7: app_user_email
                "\"APP_USER_PW_KEY\" TEXT," + // 8: app_user_pw_key
                "\"TOUCH_POS_USER\" INTEGER NOT NULL ," + // 9: touch_pos_user
                "\"USER_MAX_DISCOUNT\" REAL NOT NULL ," + // 10: user_max_discount
                "\"USER_MAX_DISCOUNT_RATE\" REAL NOT NULL ," + // 11: user_max_discount_rate
                "\"USER_MAX_ORDER_NUMBER\" INTEGER," + // 12: user_max_order_number
                "\"MERCHANT_NUM\" INTEGER);"); // 13: merchant_num
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"APP_USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AppUser entity) {
        stmt.clearBindings();
 
        Long app_user_num = entity.getApp_user_num();
        if (app_user_num != null) {
            stmt.bindLong(1, app_user_num);
        }
 
        String system_book_code = entity.getSystem_book_code();
        if (system_book_code != null) {
            stmt.bindString(2, system_book_code);
        }
 
        String app_user_code = entity.getApp_user_code();
        if (app_user_code != null) {
            stmt.bindString(3, app_user_code);
        }
 
        String app_user_name = entity.getApp_user_name();
        if (app_user_name != null) {
            stmt.bindString(4, app_user_name);
        }
 
        String app_user_password = entity.getApp_user_password();
        if (app_user_password != null) {
            stmt.bindString(5, app_user_password);
        }
        stmt.bindLong(6, entity.getApp_user_state_code());
 
        String app_user_phone = entity.getApp_user_phone();
        if (app_user_phone != null) {
            stmt.bindString(7, app_user_phone);
        }
 
        String app_user_email = entity.getApp_user_email();
        if (app_user_email != null) {
            stmt.bindString(8, app_user_email);
        }
 
        String app_user_pw_key = entity.getApp_user_pw_key();
        if (app_user_pw_key != null) {
            stmt.bindString(9, app_user_pw_key);
        }
        stmt.bindLong(10, entity.getTouch_pos_user() ? 1L: 0L);
        stmt.bindDouble(11, entity.getUser_max_discount());
        stmt.bindDouble(12, entity.getUser_max_discount_rate());
 
        Integer user_max_order_number = entity.getUser_max_order_number();
        if (user_max_order_number != null) {
            stmt.bindLong(13, user_max_order_number);
        }
 
        Integer merchant_num = entity.getMerchant_num();
        if (merchant_num != null) {
            stmt.bindLong(14, merchant_num);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AppUser entity) {
        stmt.clearBindings();
 
        Long app_user_num = entity.getApp_user_num();
        if (app_user_num != null) {
            stmt.bindLong(1, app_user_num);
        }
 
        String system_book_code = entity.getSystem_book_code();
        if (system_book_code != null) {
            stmt.bindString(2, system_book_code);
        }
 
        String app_user_code = entity.getApp_user_code();
        if (app_user_code != null) {
            stmt.bindString(3, app_user_code);
        }
 
        String app_user_name = entity.getApp_user_name();
        if (app_user_name != null) {
            stmt.bindString(4, app_user_name);
        }
 
        String app_user_password = entity.getApp_user_password();
        if (app_user_password != null) {
            stmt.bindString(5, app_user_password);
        }
        stmt.bindLong(6, entity.getApp_user_state_code());
 
        String app_user_phone = entity.getApp_user_phone();
        if (app_user_phone != null) {
            stmt.bindString(7, app_user_phone);
        }
 
        String app_user_email = entity.getApp_user_email();
        if (app_user_email != null) {
            stmt.bindString(8, app_user_email);
        }
 
        String app_user_pw_key = entity.getApp_user_pw_key();
        if (app_user_pw_key != null) {
            stmt.bindString(9, app_user_pw_key);
        }
        stmt.bindLong(10, entity.getTouch_pos_user() ? 1L: 0L);
        stmt.bindDouble(11, entity.getUser_max_discount());
        stmt.bindDouble(12, entity.getUser_max_discount_rate());
 
        Integer user_max_order_number = entity.getUser_max_order_number();
        if (user_max_order_number != null) {
            stmt.bindLong(13, user_max_order_number);
        }
 
        Integer merchant_num = entity.getMerchant_num();
        if (merchant_num != null) {
            stmt.bindLong(14, merchant_num);
        }
    }

    @Override
    protected final void attachEntity(AppUser entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AppUser readEntity(Cursor cursor, int offset) {
        AppUser entity = new AppUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // app_user_num
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // system_book_code
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // app_user_code
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // app_user_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // app_user_password
            cursor.getInt(offset + 5), // app_user_state_code
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // app_user_phone
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // app_user_email
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // app_user_pw_key
            cursor.getShort(offset + 9) != 0, // touch_pos_user
            cursor.getFloat(offset + 10), // user_max_discount
            cursor.getFloat(offset + 11), // user_max_discount_rate
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // user_max_order_number
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13) // merchant_num
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AppUser entity, int offset) {
        entity.setApp_user_num(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSystem_book_code(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setApp_user_code(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setApp_user_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setApp_user_password(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setApp_user_state_code(cursor.getInt(offset + 5));
        entity.setApp_user_phone(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setApp_user_email(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setApp_user_pw_key(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setTouch_pos_user(cursor.getShort(offset + 9) != 0);
        entity.setUser_max_discount(cursor.getFloat(offset + 10));
        entity.setUser_max_discount_rate(cursor.getFloat(offset + 11));
        entity.setUser_max_order_number(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setMerchant_num(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AppUser entity, long rowId) {
        entity.setApp_user_num(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AppUser entity) {
        if(entity != null) {
            return entity.getApp_user_num();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AppUser entity) {
        return entity.getApp_user_num() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
