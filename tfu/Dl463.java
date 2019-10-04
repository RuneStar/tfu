/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.StringTools;
import jaclib.nanotime.QueryPerformanceCounter;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.AWTEvent;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import tfu.Do629;
import tfu.Dq324;
import tfu.Ds621;
import tfu.Du625;
import tfu.Dv322;
import tfu.Gi430;
import tfu.Gz143;
import tfu.Hw321;
import tfu.Im133;
import tfu.Kt125;
import tfu.Mu209;

public abstract class Dl463
implements Do629,
Runnable,
FocusListener,
WindowListener {
    public static int a;
    public static Applet aa;
    public static Hw321 ab;
    public static volatile boolean ac;
    private static File ad;
    private static File ae;
    public static int af;
    public static int ag;
    public static Frame ah;
    public static int ai;
    private static final int aj = 786432000;
    private static final int ak = 1048576;
    public static int al;
    public static Image am;
    public static volatile boolean an;
    public static Canvas ao;
    public static Frame ap;
    public static int aq;
    private static volatile boolean ar;
    private static int as;
    private static volatile long at;
    public static Dv322 au;
    private static Font av;
    public static boolean aw;
    public static boolean ax;
    private static final String ay = "rw";
    public static String az;
    static final boolean b = true;
    public static int ba;
    public static int bb;
    public static String bc;
    private static int bd;
    public static String be;
    public static Du625 bf;
    private static boolean bg;
    public static Im133[] bh;
    public static Im133 bj;
    public static Im133 bk;
    private static final String bl = "random.dat";
    private static final String bm = "main_file_cache.dat2";
    private static long bn;
    private static final String bo = "main_file_cache.idx255";
    private static int bp;
    private static final String bq = "main_file_cache.idx";
    private static final int br = 0;
    public static String bs;
    public static String bt;
    private static final int bv = 1;
    private static Im133 bw;
    private static String[] bx;
    private static String[] by;
    public static String bz;
    public static int c;
    public static EventQueue cp;
    public static String cq;
    public static String cw;
    private static final boolean d = true;
    static final boolean e = true;
    public static int f;
    private static final boolean g = true;
    static final boolean h = true;
    private static long[] i;
    static final boolean j = true;
    private static int k;
    private static final boolean l = true;
    private static final int m = 32;
    private static long[] n;
    private static int o;
    static int p;
    static final boolean q = true;
    private static final boolean r = true;
    static final boolean s = true;
    public static Ds621 t;
    public static int u;
    private static final boolean v = true;
    private static final boolean w = true;
    static long x;
    private static final boolean y = true;
    public static int z;
    public boolean bi = false;
    public boolean bu = false;

    public static Container s() {
        if (ap != null) {
            return ap;
        }
        if (ah != null) {
            return ah;
        }
        return aa;
    }

    public static void b(Dl463 dl463, Container container) {
        container.setBackground(Color.black);
        container.setLayout(null);
        container.add(ao);
        ao.setSize(c, ag);
        ao.setVisible(true);
        if (container == ah) {
            Insets insets = ah.getInsets();
            ao.setLocation(insets.left + al, insets.top + af);
        } else {
            ao.setLocation(al, af);
        }
        ao.addFocusListener(dl463);
        ao.requestFocus();
        ax = true;
        ar = true;
        ao.setFocusTraversalKeysEnabled(false);
        an = true;
        ac = false;
        at = Gz143.g();
    }

    private static void y(Dl463 dl463) {
        long l = Gz143.g();
        long l2 = n[k];
        Dl463.n[Dl463.k] = l;
        k = k + 1 & 0x1F;
        if (l2 != 0L && l > l2) {
            int n = (int)(l - l2);
            u = (32000 + (n >> 1)) / n;
        }
        if (as++ > 50) {
            as -= 50;
            an = true;
            ao.setSize(c, ag);
            ao.setVisible(true);
            if (ah != null && ap == null) {
                Insets insets = ah.getInsets();
                ao.setLocation(insets.left + al, insets.top + af);
            } else {
                ao.setLocation(al, af);
            }
        }
        dl463.t();
    }

    private final void p(boolean bl) {
        Dl463 dl463 = this;
        synchronized (dl463) {
            if (bg) {
                return;
            }
            bg = true;
        }
        System.out.println("Shutdown start - clean:" + bl);
        try {
            this.m();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            Im133.g(bj);
            for (int i = 0; i < bd; ++i) {
                Im133.g(bh[i]);
            }
            Im133.g(bk);
            Im133.g(bw);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (this.bi) {
            try {
                QueryPerformanceCounter.quit();
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        if (Kt125.q()) {
            Kt125.d().b();
        }
        if (ao != null) {
            try {
                ao.removeFocusListener(this);
                ao.getParent().remove(ao);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (ah != null) {
            ah.setVisible(false);
            ah.dispose();
            ah = null;
        }
        System.out.println("Shutdown complete - clean:" + bl);
    }

    @Override
    public final void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public final void focusGained(FocusEvent focusEvent) {
        ar = true;
        an = true;
    }

    @Override
    public final void focusLost(FocusEvent focusEvent) {
        ar = false;
    }

    @Override
    public final void windowActivated(WindowEvent windowEvent) {
    }

    public abstract void u();

    @Override
    public final void windowClosing(WindowEvent windowEvent) {
        aw = true;
        this.q();
    }

    @Override
    public final void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public final void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void q() {
        if (bg) {
            return;
        }
        bn = Gz143.g();
        Gi430.g(5000L);
        this.p(false);
    }

    @Override
    public final void windowOpened(WindowEvent windowEvent) {
    }

    public abstract void z();

    public abstract void t();

    public abstract void m();

    public void n(String string) {
        if (this.bu) {
            return;
        }
        this.bu = true;
        System.out.println("error_game_" + string);
        try {
            Mu209.g(aa, "loggedout");
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            aa.getAppletContext().showDocument(new URL(aa.getCodeBase(), "error_game_" + string + ".ws"), "_top");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static {
        x = 20000000L;
        u = 0;
        z = 0;
        n = new long[32];
        i = new long[32];
        al = 0;
        af = 0;
        az = null;
        an = true;
        as = 500;
        ac = false;
        at = 0L;
        aw = false;
        ar = true;
        bw = null;
        bj = null;
        bk = null;
        bf = null;
        bn = 0L;
        bg = false;
        bb = -1;
        ba = 1;
    }

    public static void r(Object object) {
        if (cp == null) {
            return;
        }
        for (int i = 0; i < 50 && cp.peekEvent() != null; ++i) {
            Gi430.g(1L);
        }
        try {
            if (object != null) {
                cp.postEvent(new ActionEvent(object, 1001, "dummy"));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final int x() {
        return (int)(1000000000L / x);
    }

    @Override
    public void run() {
        Dl463.w(this);
        this.p(true);
    }

    private static void v(Dl463 dl463) {
        long l = Gz143.g();
        long l2 = i[o];
        Dl463.i[Dl463.o] = l;
        o = o + 1 & 0x1F;
        if (l2 != 0L && l > l2) {
            int n = (int)(l - l2);
            z = (32000 + (n >> 1)) / n;
        }
        Dl463 dl4632 = dl463;
        synchronized (dl4632) {
            ax = ar;
        }
        dl463.z();
    }

    @Override
    public final void windowDeactivated(WindowEvent windowEvent) {
    }

    private static void w(Dl463 dl463) {
        String string;
        if (bt != null && ((string = bt.toLowerCase()).indexOf("sun") != -1 || string.indexOf("apple") != -1)) {
            String string2 = bz;
            if (string2.equals("1.1") || string2.startsWith("1.1.") || string2.equals("1.2") || string2.startsWith("1.2.") || string2.equals("1.3") || string2.startsWith("1.3.") || string2.equals("1.4") || string2.startsWith("1.4.") || string2.equals("1.5") || string2.startsWith("1.5.") || string2.equals("1.6.0")) {
                dl463.n("wrongjava");
                return;
            }
            if (string2.startsWith("1.6.0_")) {
                int n;
                for (n = 6; n < string2.length() && StringTools.w(string2.charAt(n)); ++n) {
                }
                String string3 = string2.substring(6, n);
                if (StringTools.d(string3) && StringTools.j(string3) < 10) {
                    dl463.n("wrongjava");
                    return;
                }
            }
        }
        Dl463.s().setFocusCycleRoot(true);
        bb = (int)(Runtime.getRuntime().maxMemory() / 0x100000L) + 1;
        ba = Runtime.getRuntime().availableProcessors();
        dl463.h();
        dl463.u();
        t = Ds621.r();
        while (bn == 0L || Gz143.g() < bn) {
            p = Ds621.v(t, x);
            for (int i = 0; i < p; ++i) {
                Dl463.v(dl463);
            }
            Dl463.y(dl463);
            Dl463.r(ao);
        }
    }

    public synchronized void h() {
        Dl463.l(this);
        Container container = Dl463.s();
        ao = new Dq324(container);
        Dl463.b(this, container);
    }

    public static void l(Dl463 dl463) {
        if (ao != null) {
            ao.removeFocusListener(dl463);
            ao.getParent().setBackground(Color.black);
            ao.getParent().remove(ao);
        }
    }
}

