/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.D363;
import com.jagex.js5.E361;
import tfu.Hl134;
import tfu.Hn359;
import tfu.Kp349;
import tfu.Ku323;

public class L145
implements Runnable {
    int d = 0;
    private Hn359 g = new Hn359();
    private Thread j = new Thread(this);
    private boolean q = false;

    public L145() {
        this.j.setDaemon(true);
        this.j.start();
        this.j.setPriority(1);
    }

    D363 j(int n, byte[] arrby, Hl134 hl134) {
        D363 d363 = new D363();
        d363.j = 2;
        d363.p = n;
        d363.h = arrby;
        d363.e = hl134;
        d363.s = false;
        L145.h(this, d363);
        return d363;
    }

    private static void h(L145 l145, D363 d363) {
        Hn359 hn359 = l145.g;
        synchronized (hn359) {
            Hn359.q(l145.g, d363);
            ++l145.d;
            l145.g.notifyAll();
        }
    }

    @Override
    public void run() {
        while (!this.q) {
            D363 d363;
            Hn359 hn359 = this.g;
            synchronized (hn359) {
                d363 = (D363)Hn359.e(this.g);
                if (d363 != null) {
                    --this.d;
                } else {
                    try {
                        this.g.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    continue;
                }
            }
            try {
                if (d363.j == 2) {
                    d363.e.d((int)d363.p, d363.h, d363.h.length);
                } else if (d363.j == 3) {
                    d363.h = Hl134.g(d363.e, (int)d363.p);
                }
            }
            catch (Exception exception) {
                Ku323.g(null, exception);
            }
            d363.l = false;
        }
    }

    D363 q(int n, Hl134 hl134) {
        D363 d363 = new D363();
        d363.j = 1;
        Hn359 hn359 = this.g;
        synchronized (hn359) {
            D363 d3632 = (D363)Hn359.h(this.g);
            while (d3632 != null) {
                if (d3632.p == (long)n && d3632.e == hl134 && d3632.j == 2) {
                    d363.h = d3632.h;
                    d363.l = false;
                    return d363;
                }
                d3632 = (D363)Hn359.b(this.g);
            }
        }
        d363.h = Hl134.g(hl134, n);
        d363.l = false;
        d363.s = true;
        return d363;
    }

    D363 e(int n, Hl134 hl134) {
        D363 d363 = new D363();
        d363.j = 3;
        d363.p = n;
        d363.e = hl134;
        d363.s = false;
        L145.h(this, d363);
        return d363;
    }

    public static void s(L145 l145) {
        l145.q = true;
        Hn359 hn359 = l145.g;
        synchronized (hn359) {
            l145.g.notifyAll();
        }
        try {
            l145.j.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        l145.j = null;
    }
}

