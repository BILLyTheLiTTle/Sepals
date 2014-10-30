/**This file is part of Sepals.
 *
 * Sepals is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * Sepals is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Sepals.  If not, see <http://www.gnu.org/licenses/>.
 */
package gr.sepals.eshop.util.db;

import android.content.Context;

import gr.sepals.eshop.persistence.InternalDatabaseHandler;

public class Settings {

    public static void setString(Context context, String name, String value) {
        InternalDatabaseTableHandler.setString(context, InternalDatabaseHandler.TABLE_SETTINGS, name,
                value);
    }

    public static String getString(Context context, String name) {
        return InternalDatabaseTableHandler.getString(context, InternalDatabaseHandler.TABLE_SETTINGS,
                name, null);
    }

    public static String getString(Context context, String name, String defaultValue) {
        return InternalDatabaseTableHandler.getString(context, InternalDatabaseHandler.TABLE_SETTINGS,
                name, defaultValue);
    }

    public static void setInt(Context context, String name, int value) {
        InternalDatabaseTableHandler.setString(context, InternalDatabaseHandler.TABLE_SETTINGS, name,
                ((Integer) value).toString());
    }

    public static int getInt(Context context, String name, int defaultValue) {
        return InternalDatabaseTableHandler.getInt(context, InternalDatabaseHandler.TABLE_SETTINGS, name,
                defaultValue);
    }

    public static void setLong(Context context, String name, long value) {
        InternalDatabaseTableHandler
                .setLong(context, InternalDatabaseHandler.TABLE_SETTINGS, name, value);
    }

    public static long getLong(Context context, String name, long defaultValue) {
        return InternalDatabaseTableHandler.getLong(context, InternalDatabaseHandler.TABLE_SETTINGS,
                name, defaultValue);
    }

    public static void setBoolean(Context context, String name, boolean value) {
        InternalDatabaseTableHandler.setBoolean(context, InternalDatabaseHandler.TABLE_SETTINGS, name,
                value);
    }

    public static boolean getBoolean(Context context, String name, boolean defaultValue) {
        return InternalDatabaseTableHandler.getBoolean(context, InternalDatabaseHandler.TABLE_SETTINGS,
                name, defaultValue);
    }
}
