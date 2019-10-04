/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import tfu.Mu209;

public class Dp208 {
    private static Applet d = null;
    public static final int e = 1;
    private static final boolean g = true;
    public static final int h = 2;
    public static final int j = 0;
    private static String q = null;
    public static final int s = 3;

    public static void g(Applet applet, String string) {
        d = applet;
        q = string;
    }

    public static void d(String string, boolean bl, boolean bl2) {
        Dp208.e(string, bl, "openjs", bl2);
    }

    @Deprecated
    public static void q(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Dp208.e(string, bl, "openjs", bl4);
    }

    @Deprecated
    public static void j(String string, boolean bl, boolean bl2, String string2, boolean bl3, boolean bl4) {
        Dp208.e(string, bl, string2, bl3);
    }

    public static boolean h(String string, int n) {
        return Dp208.s(string, n, "openjs");
    }

    public static boolean s(String string, int n, String string2) {
        if (n == 0) {
            try {
                if (!q.startsWith("win")) {
                    throw new Exception();
                }
                if (!string.startsWith("http://") && !string.startsWith("https://")) {
                    throw new Exception();
                }
                String string3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
                for (int i = 0; i < string.length(); ++i) {
                    if (string3.indexOf(string.charAt(i)) != -1) continue;
                    throw new Exception();
                }
                Runtime.getRuntime().exec("cmd /c start \"j\" \"" + string + "\"");
                return true;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                return false;
            }
        }
        if (n == 1) {
            try {
                Object object = Mu209.d(d, string2, new URL(d.getCodeBase(), string).toString());
                return object != null;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                return false;
            }
        }
        if (n == 2) {
            try {
                d.getAppletContext().showDocument(new URL(d.getCodeBase(), string), "_blank");
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        if (n == 3) {
            try {
                Mu209.g(d, "loggedout");
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                d.getAppletContext().showDocument(new URL(d.getCodeBase(), string), "_top");
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void e(String string, boolean bl, String string2, boolean bl2) {
        if (bl) {
            if (!bl2 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(string));
                    return;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (q.startsWith("win") && !bl2) {
                Dp208.h(string, 0);
                return;
            }
            if (q.startsWith("mac")) {
                Dp208.s(string, 1, string2);
                return;
            }
            Dp208.h(string, 2);
        } else {
            Dp208.h(string, 3);
        }
    }
}

