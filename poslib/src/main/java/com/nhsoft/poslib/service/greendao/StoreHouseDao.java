package com.nhsoft.poslib.service.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.nhsoft.poslib.entity.StoreHouse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STORE_HOUSE".
*/
public class StoreHouseDao extends AbstractDao<StoreHouse, Long> {

    public static final String TABLENAME = "STORE_HOUSE";

    /**
     * Properties of entity StoreHouse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Storehouse_num = new Property(0, Long.class, "storehouse_num", true, "STOREHOUSE_NUM");
        public final static Property Branch_num = new Property(1, int.class, "branch_num", false, "BRANCH_NUM");
        public final static Property Storehouse_code = new Property(2, String.class, "storehouse_code", false, "STOREHOUSE_CODE");
        public final static Property Storehouse_name = new Property(3, String.class, "storehouse_name", false, "STOREHOUSE_NAME");
        public final static Property Storehouse_actived = new Property(4, boolean.class, "storehouse_actived", false, "STOREHOUSE_ACTIVED");
        public final static Property Storehouse_center_tag = new Property(5, boolean.class, "storehouse_center_tag", false, "STOREHOUSE_CENTER_TAG");
    }


    public StoreHouseDao(DaoConfig config) {
        super(config);
    }
    
    public StoreHouseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STORE_HOUSE\" (" + //
                "\"STOREHOUSE_NUM\" INTEGER PRIMARY KEY ," + // 0: storehouse_num
                "\"BRANCH_NUM\" INTEGER NOT NULL ," + // 1: branch_num
                "\"STOREHOUSE_CODE\" TEXT," + // 2: storehouse_code
                "\"STOREHOUSE_NAME\" TEXT," + // 3: storehouse_name
                "\"STOREHOUSE_ACTIVED\" INTEGER NOT NULL ," + // 4: storehouse_actived
                "\"STOREHOUSE_CENTER_TAG\" INTEGER NOT NULL );"); // 5: storehouse_center_tag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STORE_HOUSE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StoreHouse entity) {
        stmt.clearBindings();
 
        Long storehouse_num = entity.getStorehouse_num();
        if (storehouse_num != null) {
            stmt.bindLong(1, storehouse_num);
        }
        stmt.bindLong(2, entity.getBranch_num());
 
        String storehouse_code = entity.getStorehouse_code();
        if (storehouse_code != null) {
            stmt.bindString(3, storehouse_code);
        }
 
        String storehouse_name = entity.getStorehouse_name();
        if (storehouse_name != null) {
            stmt.bindString(4, storehouse_name);
        }
        stmt.bindLong(5, entity.getStorehouse_actived() ? 1L: 0L);
        stmt.bindLong(6, entity.getStorehouse_center_tag() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StoreHouse entity) {
        stmt.clearBindings();
 
        Long storehouse_num = entity.getStorehouse_num();
        if (storehouse_num != null) {
            stmt.bindLong(1, storehouse_num);
        }
        stmt.bindLong(2, entity.getBranch_num());
 
        String storehouse_code = entity.getStorehouse_code();
        if (storehouse_code != null) {
            stmt.bindString(3, storehouse_code);
        }
 
        String storehouse_name = entity.getStorehouse_name();
        if (storehouse_name != null) {
            stmt.bindString(4, storehouse_name);
        }
        stmt.bindLong(5, entity.getStorehouse_actived() ? 1L: 0L);
        stmt.bindLong(6, entity.getStorehouse_center_tag() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StoreHouse readEntity(Cursor cursor, int offset) {
        StoreHouse entity = new StoreHouse( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // storehouse_num
            cursor.getInt(offset + 1), // branch_num
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // storehouse_code
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // storehouse_name
            cursor.getShort(offset + 4) != 0, // storehouse_actived
            cursor.getShort(offset + 5) != 0 // storehouse_center_tag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StoreHouse entity, int offset) {
        entity.setStorehouse_num(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBranch_num(cursor.getInt(offset + 1));
        entity.setStorehouse_code(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStorehouse_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStorehouse_actived(cursor.getShort(offset + 4) != 0);
        entity.setStorehouse_center_tag(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StoreHouse entity, long rowId) {
        entity.setStorehouse_num(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StoreHouse entity) {
        if(entity != null) {
            return entity.getStorehouse_num();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StoreHouse entity) {
        return entity.getStorehouse_num() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}