
package gr.sepals.eshop.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InternalDatabaseHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "sepals_data";
    public static final String TABLE_SETTINGS = "settings";
    private static final String TABLE_PERSONAL_DATA = "personal_data";
    private static final int DB_VERSION = 1;

    public InternalDatabaseHandler(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table " + TABLE_SETTINGS
                + " (key text primary key not null, value text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Do nothing at the moment
    }
}
