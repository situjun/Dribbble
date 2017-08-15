package com.my.jerrychan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;
import com.my.jerrychan.constant.DbConstants;
import com.my.jerrychan.data.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linchen on 16/2/20.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class DBhelper extends OrmLiteSqliteOpenHelper {

    private Map<String, Dao> daos = new HashMap<String, Dao>();
    private static DBhelper instance;
    private Context context;
    public DBhelper(Context context) {
        super(context, DbConstants.TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, com.j256.ormlite.support.ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e("SqliteError","create the table wrong:"+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, com.j256.ormlite.support.ConnectionSource connectionSource, int i, int i1) {

    }
    public static  synchronized DBhelper getInstance(Context context){

        if (instance == null)
        {
            synchronized (DBhelper.class)
            {
                if (instance == null)
                    instance = new DBhelper(context);
            }
        }

        return instance;
    }

    public synchronized Dao getDao(Class clazz) throws SQLException
    {
        Dao dao = null;
        String className = clazz.getSimpleName();

        if (daos.containsKey(className))
        {
            dao = daos.get(className);
        }
        if (dao == null)
        {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet())
        {
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
