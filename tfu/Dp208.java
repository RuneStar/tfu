// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.net.URI;
import java.awt.Desktop;
import java.net.URL;
import java.applet.Applet;

public class Dp208
{
    private static Applet d;
    public static final int e = 1;
    private static final boolean g = true;
    public static final int h = 2;
    public static final int j = 0;
    private static String q;
    public static final int s = 3;
    
    public static void g(final Applet d, final String q) {
        Dp208.d = d;
        Dp208.q = q;
    }
    
    public static void d(final String s, final boolean b, final boolean b2) {
        e(s, b, "openjs", b2);
    }
    
    @Deprecated
    public static void q(final String s, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        e(s, b, "openjs", b4);
    }
    
    @Deprecated
    public static void j(final String s, final boolean b, final boolean b2, final String s2, final boolean b3, final boolean b4) {
        e(s, b, s2, b3);
    }
    
    public static boolean h(final String s, final int n) {
        return s(s, n, "openjs");
    }
    
    public static boolean s(final String s, final int n, final String s2) {
        if (n == 0) {
            try {
                if (!Dp208.q.startsWith("win")) {
                    throw new Exception();
                }
                if (!s.startsWith("http://") && !s.startsWith("https://")) {
                    throw new Exception();
                }
                final String s3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
                for (int i = 0; i < s.length(); ++i) {
                    if (s3.indexOf(s.charAt(i)) == -1) {
                        throw new Exception();
                    }
                }
                Runtime.getRuntime().exec("cmd /c start \"j\" \"" + s + "\"");
                return true;
            }
            catch (Throwable t) {
                t.printStackTrace();
                return false;
            }
        }
        if (n == 1) {
            try {
                return Mu209.d(Dp208.d, s2, new URL(Dp208.d.getCodeBase(), s).toString()) != null;
            }
            catch (Throwable t2) {
                t2.printStackTrace();
                return false;
            }
        }
        if (n == 2) {
            try {
                Dp208.d.getAppletContext().showDocument(new URL(Dp208.d.getCodeBase(), s), "_blank");
                return true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        if (n == 3) {
            try {
                Mu209.g(Dp208.d, "loggedout");
            }
            catch (Throwable t3) {}
            try {
                Dp208.d.getAppletContext().showDocument(new URL(Dp208.d.getCodeBase(), s), "_top");
                return true;
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
                return false;
            }
        }
        throw new IllegalArgumentException();
    }
    
    static {
        Dp208.d = null;
        Dp208.q = null;
    }
    
    public static void e(final String str, final boolean b, final String s, final boolean b2) {
        if (b) {
            if (!b2 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(str));
                    return;
                }
                catch (Exception ex) {}
            }
            if (Dp208.q.startsWith("win") && !b2) {
                h(str, 0);
                return;
            }
            if (Dp208.q.startsWith("mac")) {
                s(str, 1, s);
                return;
            }
            h(str, 2);
        }
        else {
            h(str, 3);
        }
    }
}
