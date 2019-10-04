// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.File;

public class Ke537
{
    public static final String d;
    public static final String e;
    public static final String g;
    public static final File h;
    public static final String j;
    public static final String q;
    
    static {
        String lowerCase = "Unknown";
        try {
            lowerCase = System.getProperty("java.vendor").toLowerCase();
        }
        catch (Exception ex) {}
        g = lowerCase.toLowerCase();
        String lowerCase2 = "Unknown";
        try {
            lowerCase2 = System.getProperty("java.version").toLowerCase();
        }
        catch (Exception ex2) {}
        d = lowerCase2.toLowerCase();
        String lowerCase3 = "Unknown";
        try {
            lowerCase3 = System.getProperty("os.name").toLowerCase();
        }
        catch (Exception ex3) {}
        q = lowerCase3.toLowerCase();
        String lowerCase4 = "Unknown";
        try {
            lowerCase4 = System.getProperty("os.arch").toLowerCase();
        }
        catch (Exception ex4) {}
        j = lowerCase4.toLowerCase();
        String lowerCase5 = "Unknown";
        try {
            lowerCase5 = System.getProperty("os.version").toLowerCase();
        }
        catch (Exception ex5) {}
        e = lowerCase5.toLowerCase();
        String lowerCase6 = "~/";
        try {
            lowerCase6 = System.getProperty("user.home").toLowerCase();
        }
        catch (Exception ex6) {}
        h = new File(lowerCase6);
    }
}
