// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.TimeZone;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Map;

public final class Gk481
{
    public static final String b = "dd-MMM-yyyy HH:mm";
    public static final long d = 1000L;
    public static final long e = 86400000L;
    public static final int g = 11745;
    public static final long h = 604800000L;
    public static final long j = 3600000L;
    public static final String l = "dd-MMM-yyyy HH:mm:ss";
    private static Map p;
    public static final long q = 60000L;
    public static final String r = "dd/MM/yy";
    public static final String s = "dd-MMM-yyyy";
    private static final Calendar u;
    public static final String v = "dd/MM/yy HH:mm";
    public static final String w = "yyyy-MM-dd_HH-mm-ss";
    private static final HashMap x;
    public static final String y = "dd/MM/yy HH:mm:ss";
    private static Map z;
    
    public static int d(final long n) {
        return (int)(n / 86400000L) - 11745;
    }
    
    public static int q() {
        return d(System.currentTimeMillis());
    }
    
    static {
        x = new HashMap();
        u = Calendar.getInstance(g("Europe/London"));
    }
    
    private Gk481() {
    }
    
    public static TimeZone g(final String key) {
        synchronized (Gk481.x) {
            TimeZone timeZone = Gk481.x.get(key);
            if (timeZone == null) {
                timeZone = TimeZone.getTimeZone(key);
                Gk481.x.put(key, timeZone);
            }
            return timeZone;
        }
    }
}
