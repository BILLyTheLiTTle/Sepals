
package gr.sepals.eshop.util.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import gr.sepals.eshop.persistence.InternalDatabaseHelper;

public class Settings {

    public static void setString(Context context, String name, String value) {
        InternalDatabaseHandler.setString(context, InternalDatabaseHelper.TABLE_SETTINGS, name,
                value);
    }

    public static String getString(Context context, String name) {
        return InternalDatabaseHandler.getString(context, InternalDatabaseHelper.TABLE_SETTINGS,
                name, null);
    }

    public static String getString(Context context, String name, String defaultValue) {
        return InternalDatabaseHandler.getString(context, InternalDatabaseHelper.TABLE_SETTINGS,
                name, defaultValue);
    }

    public static void setInt(Context context, String name, int value) {
        InternalDatabaseHandler.setString(context, InternalDatabaseHelper.TABLE_SETTINGS, name,
                ((Integer) value).toString());
    }

    public static int getInt(Context context, String name, int defaultValue) {
        return InternalDatabaseHandler.getInt(context, InternalDatabaseHelper.TABLE_SETTINGS, name,
                defaultValue);
    }

    public static void setLong(Context context, String name, long value) {
        InternalDatabaseHandler
                .setLong(context, InternalDatabaseHelper.TABLE_SETTINGS, name, value);
    }

    public static long getLong(Context context, String name, long defaultValue) {
        return InternalDatabaseHandler.getLong(context, InternalDatabaseHelper.TABLE_SETTINGS,
                name, defaultValue);
    }

    public static void setBoolean(Context context, String name, boolean value) {
        InternalDatabaseHandler.setBoolean(context, InternalDatabaseHelper.TABLE_SETTINGS, name,
                value);
    }

    public static boolean getBoolean(Context context, String name, boolean defaultValue) {
        return InternalDatabaseHandler.getBoolean(context, InternalDatabaseHelper.TABLE_SETTINGS,
                name, defaultValue);
    }
}
