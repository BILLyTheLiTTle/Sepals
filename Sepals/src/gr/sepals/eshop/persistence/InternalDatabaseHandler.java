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
