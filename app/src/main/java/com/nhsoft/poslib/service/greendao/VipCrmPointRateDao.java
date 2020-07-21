package com.nhsoft.poslib.service.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.nhsoft.poslib.entity.VipCrmPointRate;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VIP_CRM_POINT_RATE".
*/
public class VipCrmPointRateDao extends AbstractDao<VipCrmPointRate, Long> {

    public static final String TABLENAME = "VIP_CRM_POINT_RATE";

    /**
     * Properties of entity VipCrmPointRate.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Point_rule_id = new Property(0, Long.class, "point_rule_id", true, "_id");
        public final static Property Check_psw = new Property(1, boolean.class, "check_psw", false, "CHECK_PSW");
        public final static Property Point_value = new Property(2, int.class, "point_value", false, "POINT_VALUE");
        public final static Property Money_value = new Property(3, float.class, "money_value", false, "MONEY_VALUE");
    }


    public VipCrmPointRateDao(DaoConfig config) {
        super(config);
    }
    
    public VipCrmPointRateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VIP_CRM_POINT_RATE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: point_rule_id
                "\"CHECK_PSW\" INTEGER NOT NULL ," + // 1: check_psw
                "\"POINT_VALUE\" INTEGER NOT NULL ," + // 2: point_value
                "\"MONEY_VALUE\" REAL NOT NULL );"); // 3: money_value
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VIP_CRM_POINT_RATE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, VipCrmPointRate entity) {
        stmt.clearBindings();
 
        Long point_rule_id = entity.getPoint_rule_id();
        if (point_rule_id != null) {
            stmt.bindLong(1, point_rule_id);
        }
        stmt.bindLong(2, entity.getCheck_psw() ? 1L: 0L);
        stmt.bindLong(3, entity.getPoint_value());
        stmt.bindDouble(4, entity.getMoney_value());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, VipCrmPointRate entity) {
        stmt.clearBindings();
 
        Long point_rule_id = entity.getPoint_rule_id();
        if (point_rule_id != null) {
            stmt.bindLong(1, point_rule_id);
        }
        stmt.bindLong(2, entity.getCheck_psw() ? 1L: 0L);
        stmt.bindLong(3, entity.getPoint_value());
        stmt.bindDouble(4, entity.getMoney_value());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public VipCrmPointRate readEntity(Cursor cursor, int offset) {
        VipCrmPointRate entity = new VipCrmPointRate( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // point_rule_id
            cursor.getShort(offset + 1) != 0, // check_psw
            cursor.getInt(offset + 2), // point_value
            cursor.getFloat(offset + 3) // money_value
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, VipCrmPointRate entity, int offset) {
        entity.setPoint_rule_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCheck_psw(cursor.getShort(offset + 1) != 0);
        entity.setPoint_value(cursor.getInt(offset + 2));
        entity.setMoney_value(cursor.getFloat(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(VipCrmPointRate entity, long rowId) {
        entity.setPoint_rule_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(VipCrmPointRate entity) {
        if(entity != null) {
            return entity.getPoint_rule_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(VipCrmPointRate entity) {
        return entity.getPoint_rule_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}