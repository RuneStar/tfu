/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import rs2.client.Av403;
import rs2.client.B402;
import rs2.client.loading.Q162;

class S401
implements Runnable {
    final /* synthetic */ B402 g;

    S401(B402 b402) {
        this.g = b402;
    }

    @Override
    public void run() {
        while (!this.g.q) {
            Q162 q162 = this.g.h;
            this.g.h(q162.d, q162.g, Av403.g, Av403.q, Av403.d, Color.WHITE);
            try {
                Thread.sleep(20L);
            }
            catch (InterruptedException interruptedException) {
                break;
            }
        }
        B402.e(this.g);
        this.g.q = false;
        this.g.l = null;
        this.g.s = null;
        this.g.d = null;
    }
}

