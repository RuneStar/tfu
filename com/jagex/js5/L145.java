// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Ku323;
import tfu.Kp349;
import tfu.Hl134;
import tfu.Hn359;

public class L145 implements Runnable
{
    int d;
    private Hn359 g;
    private Thread j;
    private boolean q;
    
    public L145() {
        this.g = new Hn359();
        this.d = 0;
        this.q = false;
        (this.j = new Thread(this)).setDaemon(true);
        this.j.start();
        this.j.setPriority(1);
    }
    
    D363 j(final int n, final byte[] h, final Hl134 e) {
        final D363 d363 = new D363();
        d363.j = 2;
        d363.p = n;
        d363.h = h;
        d363.e = e;
        d363.s = false;
        h(this, d363);
        return d363;
    }
    
    private static void h(final L145 l145, final D363 d363) {
        synchronized (l145.g) {
            Hn359.q(l145.g, d363);
            ++l145.d;
            l145.g.notifyAll();
        }
    }
    
    @Override
    public void run() {
        while (!this.q) {
            final D363 d363;
            synchronized (this.g) {
                d363 = (D363)Hn359.e(this.g);
                if (d363 == null) {
                    try {
                        this.g.wait();
                    }
                    catch (InterruptedException ex2) {}
                    continue;
                }
                --this.d;
            }
            try {
                if (d363.j == 2) {
                    d363.e.d((int)d363.p, d363.h, d363.h.length);
                }
                else if (d363.j == 3) {
                    d363.h = Hl134.g(d363.e, (int)d363.p);
                }
            }
            catch (Exception ex) {
                Ku323.g(null, ex);
            }
            d363.l = false;
        }
    }
    
    D363 q(final int n, final Hl134 hl134) {
        final D363 d363 = new D363();
        d363.j = 1;
        synchronized (this.g) {
            for (D363 d364 = (D363)Hn359.h(this.g); d364 != null; d364 = (D363)Hn359.b(this.g)) {
                if (d364.p == n && d364.e == hl134 && d364.j == 2) {
                    d363.h = d364.h;
                    d363.l = false;
                    return d363;
                }
            }
        }
        d363.h = Hl134.g(hl134, n);
        d363.l = false;
        d363.s = true;
        return d363;
    }
    
    D363 e(final int n, final Hl134 e) {
        final D363 d363 = new D363();
        d363.j = 3;
        d363.p = n;
        d363.e = e;
        d363.s = false;
        h(this, d363);
        return d363;
    }
    
    public static void s(final L145 l145) {
        l145.q = true;
        synchronized (l145.g) {
            l145.g.notifyAll();
        }
        try {
            l145.j.join();
        }
        catch (InterruptedException ex) {}
        l145.j = null;
    }
}
