// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.StringTools;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import jaclib.nanotime.QueryPerformanceCounter;
import java.awt.Insets;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Frame;
import java.io.File;
import java.applet.Applet;
import java.awt.event.WindowListener;
import java.awt.event.FocusListener;

public abstract class Dl463 implements Do629, Runnable, FocusListener, WindowListener
{
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
    public boolean bi;
    public boolean bu;
    
    public static Container s() {
        if (Dl463.ap != null) {
            return Dl463.ap;
        }
        if (Dl463.ah != null) {
            return Dl463.ah;
        }
        return Dl463.aa;
    }
    
    public static void b(final Dl463 l, final Container container) {
        container.setBackground(Color.black);
        container.setLayout(null);
        container.add(Dl463.ao);
        Dl463.ao.setSize(Dl463.c, Dl463.ag);
        Dl463.ao.setVisible(true);
        if (container == Dl463.ah) {
            final Insets insets = Dl463.ah.getInsets();
            Dl463.ao.setLocation(insets.left + Dl463.al, insets.top + Dl463.af);
        }
        else {
            Dl463.ao.setLocation(Dl463.al, Dl463.af);
        }
        Dl463.ao.addFocusListener(l);
        Dl463.ao.requestFocus();
        Dl463.ax = true;
        Dl463.ar = true;
        Dl463.ao.setFocusTraversalKeysEnabled(false);
        Dl463.an = true;
        Dl463.ac = false;
        Dl463.at = Gz143.g();
    }
    
    private static void y(final Dl463 dl463) {
        final long g = Gz143.g();
        final long n = Dl463.n[Dl463.k];
        Dl463.n[Dl463.k] = g;
        Dl463.k = (Dl463.k + 1 & 0x1F);
        if (n != 0L && g > n) {
            final int n2 = (int)(g - n);
            Dl463.u = (32000 + (n2 >> 1)) / n2;
        }
        if (Dl463.as++ > 50) {
            Dl463.as -= 50;
            Dl463.an = true;
            Dl463.ao.setSize(Dl463.c, Dl463.ag);
            Dl463.ao.setVisible(true);
            if (Dl463.ah != null && Dl463.ap == null) {
                final Insets insets = Dl463.ah.getInsets();
                Dl463.ao.setLocation(insets.left + Dl463.al, insets.top + Dl463.af);
            }
            else {
                Dl463.ao.setLocation(Dl463.al, Dl463.af);
            }
        }
        dl463.t();
    }
    
    private final void p(final boolean b) {
        synchronized (this) {
            if (Dl463.bg) {
                return;
            }
            Dl463.bg = true;
        }
        System.out.println("Shutdown start - clean:" + b);
        try {
            this.m();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Im133.g(Dl463.bj);
            for (int i = 0; i < Dl463.bd; ++i) {
                Im133.g(Dl463.bh[i]);
            }
            Im133.g(Dl463.bk);
            Im133.g(Dl463.bw);
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
        if (this.bi) {
            try {
                QueryPerformanceCounter.quit();
            }
            catch (Throwable t) {
                t.printStackTrace();
            }
        }
        if (Kt125.q()) {
            Kt125.d().b();
        }
        if (Dl463.ao != null) {
            try {
                Dl463.ao.removeFocusListener(this);
                Dl463.ao.getParent().remove(Dl463.ao);
            }
            catch (Exception ex3) {
                ex3.printStackTrace();
            }
        }
        if (Dl463.ah != null) {
            Dl463.ah.setVisible(false);
            Dl463.ah.dispose();
            Dl463.ah = null;
        }
        System.out.println("Shutdown complete - clean:" + b);
    }
    
    @Override
    public final void windowIconified(final WindowEvent windowEvent) {
    }
    
    @Override
    public final void focusGained(final FocusEvent focusEvent) {
        Dl463.ar = true;
        Dl463.an = true;
    }
    
    @Override
    public final void focusLost(final FocusEvent focusEvent) {
        Dl463.ar = false;
    }
    
    @Override
    public final void windowActivated(final WindowEvent windowEvent) {
    }
    
    public abstract void u();
    
    @Override
    public final void windowClosing(final WindowEvent windowEvent) {
        Dl463.aw = true;
        this.q();
    }
    
    @Override
    public final void windowClosed(final WindowEvent windowEvent) {
    }
    
    @Override
    public final void windowDeiconified(final WindowEvent windowEvent) {
    }
    
    @Override
    public void q() {
        if (Dl463.bg) {
            return;
        }
        Dl463.bn = Gz143.g();
        Gi430.g(5000L);
        this.p(false);
    }
    
    @Override
    public final void windowOpened(final WindowEvent windowEvent) {
    }
    
    public abstract void z();
    
    public abstract void t();
    
    public abstract void m();
    
    public void n(final String s) {
        if (this.bu) {
            return;
        }
        this.bu = true;
        System.out.println("error_game_" + s);
        try {
            Mu209.g(Dl463.aa, "loggedout");
        }
        catch (Throwable t) {}
        try {
            Dl463.aa.getAppletContext().showDocument(new URL(Dl463.aa.getCodeBase(), "error_game_" + s + ".ws"), "_top");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        Dl463.x = 20000000L;
        Dl463.u = 0;
        Dl463.z = 0;
        Dl463.n = new long[32];
        Dl463.i = new long[32];
        Dl463.al = 0;
        Dl463.af = 0;
        Dl463.az = null;
        Dl463.an = true;
        Dl463.as = 500;
        Dl463.ac = false;
        Dl463.at = 0L;
        Dl463.aw = false;
        Dl463.ar = true;
        Dl463.bw = null;
        Dl463.bj = null;
        Dl463.bk = null;
        Dl463.bf = null;
        Dl463.bn = 0L;
        Dl463.bg = false;
        Dl463.bb = -1;
        Dl463.ba = 1;
    }
    
    public static void r(final Object source) {
        if (Dl463.cp == null) {
            return;
        }
        for (int n = 0; n < 50 && Dl463.cp.peekEvent() != null; ++n) {
            Gi430.g(1L);
        }
        try {
            if (source != null) {
                Dl463.cp.postEvent(new ActionEvent(source, 1001, "dummy"));
            }
        }
        catch (Exception ex) {}
    }
    
    public static final int x() {
        return (int)(1000000000L / Dl463.x);
    }
    
    @Override
    public void run() {
        w(this);
        this.p(true);
    }
    
    private static void v(final Dl463 dl463) {
        final long g = Gz143.g();
        final long n = Dl463.i[Dl463.o];
        Dl463.i[Dl463.o] = g;
        Dl463.o = (Dl463.o + 1 & 0x1F);
        if (n != 0L && g > n) {
            final int n2 = (int)(g - n);
            Dl463.z = (32000 + (n2 >> 1)) / n2;
        }
        synchronized (dl463) {
            Dl463.ax = Dl463.ar;
        }
        dl463.z();
    }
    
    @Override
    public final void windowDeactivated(final WindowEvent windowEvent) {
    }
    
    private static void w(final Dl463 dl463) {
        if (Dl463.bt != null) {
            final String lowerCase = Dl463.bt.toLowerCase();
            if (lowerCase.indexOf("sun") != -1 || lowerCase.indexOf("apple") != -1) {
                final String bz = Dl463.bz;
                if (bz.equals("1.1") || bz.startsWith("1.1.") || bz.equals("1.2") || bz.startsWith("1.2.") || bz.equals("1.3") || bz.startsWith("1.3.") || bz.equals("1.4") || bz.startsWith("1.4.") || bz.equals("1.5") || bz.startsWith("1.5.") || bz.equals("1.6.0")) {
                    dl463.n("wrongjava");
                    return;
                }
                if (bz.startsWith("1.6.0_")) {
                    int n;
                    for (n = 6; n < bz.length() && StringTools.w(bz.charAt(n)); ++n) {}
                    final String substring = bz.substring(6, n);
                    if (StringTools.d(substring) && StringTools.j(substring) < 10) {
                        dl463.n("wrongjava");
                        return;
                    }
                }
            }
        }
        s().setFocusCycleRoot(true);
        Dl463.bb = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
        Dl463.ba = Runtime.getRuntime().availableProcessors();
        dl463.h();
        dl463.u();
        Dl463.t = Ds621.r();
        while (Dl463.bn == 0L || Gz143.g() < Dl463.bn) {
            Dl463.p = Ds621.v(Dl463.t, Dl463.x);
            for (int i = 0; i < Dl463.p; ++i) {
                v(dl463);
            }
            y(dl463);
            r(Dl463.ao);
        }
    }
    
    public Dl463() {
        this.bu = false;
        this.bi = false;
    }
    
    public synchronized void h() {
        l(this);
        final Container s = s();
        Dl463.ao = new Dq324(s);
        b(this, s);
    }
    
    public static void l(final Dl463 l) {
        if (Dl463.ao != null) {
            Dl463.ao.removeFocusListener(l);
            Dl463.ao.getParent().setBackground(Color.black);
            Dl463.ao.getParent().remove(Dl463.ao);
        }
    }
}
