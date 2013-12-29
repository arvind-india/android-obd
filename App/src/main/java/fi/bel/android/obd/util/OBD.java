package fi.bel.android.obd.util;

import java.util.HashMap;
import java.util.Map;

public class OBD {
    /* XXX: uninterpreted stuff we might want to add later: 03, 12, 13, 1c, 1d, 1e */
    public static String unit(String pid) {
        switch (pid) {
            case "04":
            case "11":
                return "%";
            case "05":
            case "0f":
                return "C";
            case "06":
            case "07":
            case "08":
            case "09":
                return "%";
            case "0a":
            case "0b":
                return "kPa";
            case "0d":
                return "km/h";
            case "0c":
                return "rpm";
            case "0e":
                return "deg";
            case "10":
                return "g/s";
            case "14-1":
            case "15-1":
            case "16-1":
            case "17-1":
            case "18-1":
            case "19-1":
            case "1a-1":
            case "1b-1":
                return "V";
            case "14-2":
            case "15-2":
            case "16-2":
            case "17-2":
            case "18-2":
            case "19-2":
            case "1a-2":
            case "1b-2":
                return "%";
            case "1f":
                return "s";
            case "21":
                return "km";
            default:
                return null;
        }
    }

    public static float convert(String pid, String response) {
        switch (pid) {
            case "04":
            case "11":
                return Integer.parseInt(response.substring(4, 5), 16) * 100 / 255.0f;
            case "05":
            case "0f":
                return Integer.parseInt(response.substring(4, 5), 16) - 40;
            case "06":
            case "07":
            case "08":
            case "09":
                return (Integer.parseInt(response.substring(4, 5), 16) - 128) * 100 / 128.0f;
            case "0a":
                return Integer.parseInt(response.substring(4, 5), 16) * 3.0f;
            case "0b":
            case "0d":
            case "1f":
            case "21":
                return Integer.parseInt(response.substring(4, 6), 16);
            case "0c":
                return Integer.parseInt(response.substring(4, 6), 16) / 4.0f;
            case "0e":
                return (Integer.parseInt(response.substring(4, 5), 16) - 128) / 2.0f;
            case "10":
                return Integer.parseInt(response.substring(4, 6), 16) / 100.0f;
            case "14-1":
            case "15-1":
            case "16-1":
            case "17-1":
            case "18-1":
            case "19-1":
            case "1a-1":
            case "1b-1":
                return Integer.parseInt(response.substring(4, 5)) / 200.0f;
            case "14-2":
            case "15-2":
            case "16-2":
            case "17-2":
            case "18-2":
            case "19-2":
            case "1a-2":
            case "1b-2":
                return (Integer.parseInt(response.substring(5, 6)) - 128) * 100 / 128.0f;

            default:
                return 0;
        }
    }
}
