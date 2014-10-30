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
package gr.sepals.eshop.util.device;

import java.io.File;
import java.text.DecimalFormat;

import android.content.Context;

public class DeviceOptionsHandler {

    public static long checkAvailableInternalMemory(Context ctx) {
        String pathToTarget = ctx.getFilesDir().getAbsoluteFile().toString();
        return new File(pathToTarget).getUsableSpace();
    }

    public static long checkAvailableEmbeddedExternalMemory(Context ctx) {
        String pathToTarget = System.getenv("EXTERNAL_STORAGE");
        return new File(pathToTarget).getUsableSpace();
    }

    public static long checkAvailableExternalMemory(Context ctx) {
        String pathToTarget = System.getenv("SECONDARY_STORAGE");
        String[] str_array = pathToTarget.split(":");
        String stringa = str_array[0];
        return new File(stringa).getUsableSpace();
    }

    public static String ByteToGB(long bytes) {
        double gigabytes = (double) bytes / (1024 * 1024 * 1024);
        DecimalFormat dec = new DecimalFormat("0.00");
        return dec.format(gigabytes);
    }
}
