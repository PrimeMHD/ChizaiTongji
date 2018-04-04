package chizaitongji.example.com.chizaitongji.DatabaseTool;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static SQLiteDatabase sqdb;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.mContext = context;
    }

    private static final String CREATE_TABLE_CMD_CANTEEN = "create table if not exists canteen_table"
            + " (autoID integer primary key autoincrement,"
            + "id integer," //食堂ID
            + "name VARCHAR(60),"//食堂名称
            + "opentime VARCHAR(60),"//食堂营业时间
            + "address VARCHAR(60),"//食堂地址
            + "beriefinfo VARCHAR(200),"//简介
            + "star float)";//评分


    public void createTable(String table_name) {
        String CREATE_TABLE_CMD = "create table if not exists " + table_name
                + " (TBID integer primary key autoincrement,"
                + "id integer," //K线ID
                + "amount VARCHAR(60),"
                + "open VARCHAR(60),"
                + "close VARCHAR(60),"
                + "low VARCHAR(60),"
                + "high VARCHAR(60),"
                + "vol VARCHAR(60),"
                + "count integer)";
        if (sqdb != null)
            sqdb.execSQL(CREATE_TABLE_CMD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        sqdb = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }

}
