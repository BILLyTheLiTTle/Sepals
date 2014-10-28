
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
