
package gr.sepals.eshop.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import gr.sepals.eshop.persistence.InternalDatabaseHelper;

public class Settings {
    private SQLiteDatabase mDatabase;
    private Context mContext;

    public static void setString(Context context, String name, String value) {
        ContentValues cv = new ContentValues();
        cv.put("key", name);
        cv.put("value", value);
        SQLiteDatabase db = new InternalDatabaseHelper(context).getWritableDatabase();
        try {
            db.replace(InternalDatabaseHelper.TABLE_SETTINGS, null, cv);
        } finally {
            db.close();
        }
    }

    public static String getString(Context context, String name) {
        return getString(context, name, null);
    }

    public static String getString(Context context, String name, String defaultValue) {
        SQLiteDatabase db = new InternalDatabaseHelper(context).getReadableDatabase();
        Cursor cursor = db.query(InternalDatabaseHelper.TABLE_SETTINGS, new String[] {
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

    public static void setInt(Context context, String name, int value) {
        setString(context, name, ((Integer) value).toString());
    }

    public static int getInt(Context context, String name, int defaultValue) {
        try {
            return Integer.parseInt(getString(context, name, null));
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    public static void setLong(Context context, String name, long value) {
        setString(context, name, ((Long) value).toString());
    }

    public static long getLong(Context context, String name, long defaultValue) {
        try {
            return Long.parseLong(getString(context, name, null));
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    public static void setBoolean(Context context, String name, boolean value) {
        setString(context, name, ((Boolean) value).toString());
    }

    public static boolean getBoolean(Context context, String name, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(getString(context, name,
                    ((Boolean) defaultValue).toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return defaultValue;
        }
    }
}
