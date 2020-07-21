package com.nhsoft.poslib.service.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.nhsoft.poslib.entity.VipStrangeSuccessSendMoney;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VIP_STRANGE_SUCCESS_SEND_MONEY".
*/
public class VipStrangeSuccessSendMoneyDao extends AbstractDao<VipStrangeSuccessSendMoney, Long> {

    public static final String TABLENAME = "VIP_STRANGE_SUCCESS_SEND_MONEY";

    /**
     * Properties of entity VipStrangeSuccessSendMoney.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property SystemBookCode = new Property(1, String.class, "systemBookCode", false, "SYSTEM_BOOK_CODE");
        public final static Property BranchNum = new Property(2, int.class, "branchNum", false, "BRANCH_NUM");
        public final static Property ShiftTableNum = new Property(3, String.class, "shiftTableNum", false, "SHIFT_TABLE_NUM");
        public final static Property Bizday = new Property(4, String.class, "bizday", false, "BIZDAY");
        public final static Property Money = new Property(5, float.class, "money", false, "MONEY");
    }


    public VipStrangeSuccessSendMoneyDao(DaoConfig config) {
        super(config);
    }
    
    public VipStrangeSuccessSendMoneyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VIP_STRANGE_SUCCESS_SEND_MONEY\" (" + //
                "\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"SYSTEM_BOOK_CODE\" TEXT," + // 1: systemBookCode
                "\"BRANCH_NUM\" INTEGER NOT NULL ," + // 2: branchNum
                "\"SHIFT_TABLE_NUM\" TEXT," + // 3: shiftTableNum
                "\"BIZDAY\" TEXT," + // 4: bizday
                "\"MONEY\" REAL NOT NULL );"); // 5: money
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VIP_STRANGE_SUCCESS_SEND_MONEY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, VipStrangeSuccessSendMoney entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String systemBookCode = entity.getSystemBookCode();
        if (systemBookCode != null) {
            stmt.bindString(2, systemBookCode);
        }
        stmt.bindLong(3, entity.getBranchNum());
 
        String shiftTableNum = entity.getShiftTableNum();
        if (shiftTableNum != null) {
            stmt.bindString(4, shiftTableNum);
        }
 
        String bizday = entity.getBizday();
        if (bizday != null) {
            stmt.bindString(5, bizday);
        }
        stmt.bindDouble(6, entity.getMoney());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, VipStrangeSuccessSendMoney entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String systemBookCode = entity.getSystemBookCode();
        if (systemBookCode != null) {
            stmt.bindString(2, systemBookCode);
        }
        stmt.bindLong(3, entity.getBranchNum());
 
        String shiftTableNum = entity.getShiftTableNum();
        if (shiftTableNum != null) {
            stmt.bindString(4, shiftTableNum);
        }
 
        String bizday = entity.getBizday();
        if (bizday != null) {
            stmt.bindString(5, bizday);
        }
        stmt.bindDouble(6, entity.getMoney());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public VipStrangeSuccessSendMoney readEntity(Cursor cursor, int offset) {
        VipStrangeSuccessSendMoney entity = new VipStrangeSuccessSendMoney( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // systemBookCode
            cursor.getInt(offset + 2), // branchNum
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // shiftTableNum
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // bizday
            cursor.getFloat(offset + 5) // money
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, VipStrangeSuccessSendMoney entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSystemBookCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBranchNum(cursor.getInt(offset + 2));
        entity.setShiftTableNum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBizday(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMoney(cursor.getFloat(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(VipStrangeSuccessSendMoney entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(VipStrangeSuccessSendMoney entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(VipStrangeSuccessSendMoney entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}