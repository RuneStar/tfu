/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.js5.G137;
import com.jagex.js5.W144;
import com.jagex.js5.js5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.sound.SoundManager;
import rs2.client.sound.Z674;
import tfu.Gz143;

public class G593 {
    public static final int d = 0;
    public static int j;
    private static final Logger logger;
    public static final int q = 1;
    private static String r;
    private static ArrayList w;
    private ArrayList b = new ArrayList();
    private String e;
    private long h;
    private Object l;
    private boolean s = false;

    public static byte[] s(int n, int n2, boolean bl) {
        long l = Gz143.g();
        long l2 = l + 100000L;
        if (bl) {
            byte[] arrby;
            do {
                arrby = js5.h(client.ez, n, n2);
                if (!client.dm.s()) {
                    float f = (float)(Gz143.g() - l) * 0.001f;
                    client.bu.m(f);
                }
                G137.j(client.dt);
                logger.trace("Loading file {} from group {}", n2, (Object)n);
            } while (arrby == null && Gz143.g() < l2);
            return arrby;
        }
        byte[] arrby = js5.h(client.ez, n, n2);
        return arrby;
    }

    public static void g(String string, long l, boolean bl, Z674 z674, Object object) {
        if (j == 1) {
            if (client.ez.getgroupid(string) == -1) {
                if (z674 != null) {
                    z674.q();
                }
                return;
            }
        } else {
            File file = new File(SoundManager.aq + string);
            if (!file.exists()) {
                return;
            }
        }
        for (G593 g593 : w) {
            if (!g593.e.equalsIgnoreCase(string)) continue;
            g593.b.add(z674);
            return;
        }
        w.add(new G593(string, Gz143.g() + l, bl, z674, object));
    }

    public static void d(String string, long l) {
        G593.g(string, l, true, null, null);
    }

    public static void q() {
        long l = Gz143.g();
        for (G593 g593 : w) {
            byte[] arrby = G593.e(g593.e, false);
            if (arrby != null) {
                if (g593.s) {
                    G593.b(g593.e, arrby);
                    for (Z674 z674 : g593.b) {
                        if (z674 == null) continue;
                        z674.g(g593.e, g593.l);
                    }
                    g593.b.clear();
                } else {
                    for (Z674 z674 : g593.b) {
                        if (z674 == null) continue;
                        z674.d(arrby, g593.l);
                    }
                    g593.b.clear();
                }
                w.remove(g593);
                break;
            }
            if (l <= g593.h) continue;
            for (Z674 z674 : g593.b) {
                if (z674 == null) continue;
                z674.q();
            }
            g593.b.clear();
            w.remove(g593);
            break;
        }
    }

    public G593(String string, long l, boolean bl, Z674 z674, Object object) {
        this.e = string;
        this.h = l;
        this.b.add(z674);
        this.s = bl;
        this.l = object;
    }

    public static byte[] e(String string, boolean bl) {
        if (j == 0) {
            logger.trace("Reading file {}", (Object)string);
            byte[] arrby = G593.j(SoundManager.aq + string);
            return arrby;
        }
        return G593.s(client.ez.getgroupid(string), 0, bl);
    }

    public static char[] h(String string, boolean bl) {
        byte[] arrby = G593.s(client.ez.getgroupid(string), 0, bl);
        char[] arrc = null;
        if (arrby != null) {
            arrc = new char[arrby.length];
            for (int i = 0; i < arrby.length; ++i) {
                arrc[i] = (char)arrby[i];
            }
        }
        return arrc;
    }

    static boolean b(String string, byte[] arrby) {
        boolean bl = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(SoundManager.ag + string));
            fileOutputStream.write(arrby);
            fileOutputStream.close();
            bl = true;
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return bl;
    }

    static {
        logger = LoggerFactory.getLogger(G593.class);
        j = 1;
        w = new ArrayList();
        r = "\\";
    }

    public static byte[] j(String string) {
        File file = new File(string);
        if (!file.exists()) {
            return null;
        }
        byte[] arrby = new byte[(int)file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ((InputStream)fileInputStream).read(arrby);
            ((InputStream)fileInputStream).close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        catch (IOException iOException) {
            return null;
        }
        return arrby;
    }
}

