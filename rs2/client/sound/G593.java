// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.io.FileInputStream;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.io.File;
import com.jagex.js5.G137;
import com.jagex.js5.js5;
import rs2.client.client;
import tfu.Gz143;
import java.util.ArrayList;
import org.slf4j.Logger;

public class G593
{
    public static final int d = 0;
    public static int j;
    private static final Logger logger;
    public static final int q = 1;
    private static String r;
    private static ArrayList w;
    private ArrayList b;
    private String e;
    private long h;
    private Object l;
    private boolean s;
    
    public static byte[] s(final int i, final int j, final boolean b) {
        final long g = Gz143.g();
        final long n = g + 100000L;
        if (b) {
            byte[] h;
            do {
                h = js5.h(client.ez, i, j);
                if (!client.dm.s()) {
                    client.bu.m((Gz143.g() - g) * 0.001f);
                }
                G137.j(client.dt);
                G593.logger.trace("Loading file {} from group {}", j, i);
            } while (h == null && Gz143.g() < n);
            return h;
        }
        return js5.h(client.ez, i, j);
    }
    
    public static void g(final String s, final long n, final boolean b, final Z674 e, final Object o) {
        if (G593.j == 1) {
            if (client.ez.getgroupid(s) == -1) {
                if (e != null) {
                    e.q();
                }
                return;
            }
        }
        else if (!new File(SoundManager.aq + s).exists()) {
            return;
        }
        for (final G593 g593 : G593.w) {
            if (g593.e.equalsIgnoreCase(s)) {
                g593.b.add(e);
                return;
            }
        }
        G593.w.add(new G593(s, Gz143.g() + n, b, e, o));
    }
    
    public static void d(final String s, final long n) {
        g(s, n, true, null, null);
    }
    
    public static void q() {
        final long g = Gz143.g();
        for (final G593 g2 : G593.w) {
            final byte[] e = e(g2.e, false);
            if (e != null) {
                if (g2.s) {
                    b(g2.e, e);
                    for (final Z674 z674 : g2.b) {
                        if (z674 != null) {
                            z674.g(g2.e, g2.l);
                        }
                    }
                    g2.b.clear();
                }
                else {
                    for (final Z674 z675 : g2.b) {
                        if (z675 != null) {
                            z675.d(e, g2.l);
                        }
                    }
                    g2.b.clear();
                }
                G593.w.remove(g2);
                break;
            }
            if (g > g2.h) {
                for (final Z674 z676 : g2.b) {
                    if (z676 != null) {
                        z676.q();
                    }
                }
                g2.b.clear();
                G593.w.remove(g2);
                break;
            }
        }
    }
    
    public G593(final String e, final long h, final boolean s, final Z674 e2, final Object l) {
        this.s = false;
        this.b = new ArrayList();
        this.e = e;
        this.h = h;
        this.b.add(e2);
        this.s = s;
        this.l = l;
    }
    
    public static byte[] e(final String str, final boolean b) {
        if (G593.j == 0) {
            G593.logger.trace("Reading file {}", str);
            return j(SoundManager.aq + str);
        }
        return s(client.ez.getgroupid(str), 0, b);
    }
    
    public static char[] h(final String s, final boolean b) {
        final byte[] s2 = s(client.ez.getgroupid(s), 0, b);
        char[] array = null;
        if (s2 != null) {
            array = new char[s2.length];
            for (int i = 0; i < s2.length; ++i) {
                array[i] = (char)s2[i];
            }
        }
        return array;
    }
    
    static boolean b(final String str, final byte[] b) {
        boolean b2 = false;
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(new File(SoundManager.ag + str));
            fileOutputStream.write(b);
            fileOutputStream.close();
            b2 = true;
        }
        catch (FileNotFoundException ex) {}
        catch (IOException ex2) {}
        return b2;
    }
    
    static {
        logger = LoggerFactory.getLogger(G593.class);
        G593.j = 1;
        G593.w = new ArrayList();
        G593.r = "\\";
    }
    
    public static byte[] j(final String pathname) {
        final File file = new File(pathname);
        if (!file.exists()) {
            return null;
        }
        final byte[] b = new byte[(int)file.length()];
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            fileInputStream.close();
        }
        catch (FileNotFoundException ex) {
            return null;
        }
        catch (IOException ex2) {
            return null;
        }
        return b;
    }
}
