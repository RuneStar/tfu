/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.File;

public class Ke537 {
    public static final String d;
    public static final String e;
    public static final String g;
    public static final File h;
    public static final String j;
    public static final String q;

    static {
        String string = "Unknown";
        try {
            string = System.getProperty("java.vendor").toLowerCase();
        }
        catch (Exception exception) {
            // empty catch block
        }
        g = string.toLowerCase();
        string = "Unknown";
        try {
            string = System.getProperty("java.version").toLowerCase();
        }
        catch (Exception exception) {
            // empty catch block
        }
        d = string.toLowerCase();
        string = "Unknown";
        try {
            string = System.getProperty("os.name").toLowerCase();
        }
        catch (Exception exception) {
            // empty catch block
        }
        q = string.toLowerCase();
        string = "Unknown";
        try {
            string = System.getProperty("os.arch").toLowerCase();
        }
        catch (Exception exception) {
            // empty catch block
        }
        j = string.toLowerCase();
        string = "Unknown";
        try {
            string = System.getProperty("os.version").toLowerCase();
        }
        catch (Exception exception) {
            // empty catch block
        }
        e = string.toLowerCase();
        string = "~/";
        try {
            string = System.getProperty("user.home").toLowerCase();
        }
        catch (Exception exception) {
            // empty catch block
        }
        h = new File(string);
    }
}

