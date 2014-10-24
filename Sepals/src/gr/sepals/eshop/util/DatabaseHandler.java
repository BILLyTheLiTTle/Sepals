package gr.sepals.eshop.util;

import gr.sepals.eshop.persistence.InternalDatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHandler {

    public static void setString(Context context, String database, String name, String value) {
        ContentValues cv = new ContentValues();
        cv.put("key", name);
        cv.put("value", value);
        SQLiteDatabase db = new InternalDatabaseHelper(context).getWritableDatabase();
        try {
            db.replace(database, null, cv);
        } finally {
            db.close();
        }
    }

    public static String getString(Context context, String database, String name) {
        return getString(context, database, name, null);
    }

    public static String getString(Context context, String database, String name, String defaultValue) {
        SQLiteDatabase db = new InternalDatabaseHelper(context).getReadableDatabase();
        Cursor cursor = db.query(database, new String[] {
            "value"
        }, "key='" + name + "'", null, null, null, null);
        try {
            if (cursor.moveToNext())
                return cursor.getString(0);
        } finally {
            cursor.close();
            db.close();
        }
        return defaultValue;
    }

    public static void setInt(Context context, String database, String name, int value) {
        setString(context, database, name, ((Integer) value).toString());
    }

    public static int getInt(Context context, String database, String name, int defaultValue) {
        try {
            return Integer.parseInt(getString(context, database, name, null));
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    public static void setLong(Context context, String database, String name, long value) {
        setString(context, database, name, ((Long) value).toString());
    }

    public static long getLong(Context context, String database, String name, long defaultValue) {
        try {
            return Long.parseLong(getString(context, database, name, null));
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    public static void setBoolean(Context context, String database, String name, boolean value) {
        setString(context, database, name, ((Boolean) value).toString());
    }

    public static boolean getBoolean(Context context, String database, String name, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(getString(context, database, name,
                    ((Boolean) defaultValue).toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return defaultValue;
        }
    }
}
