/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Gi430 {
    private static final void d(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public static final void g(long l) {
        if (l <= 0L) {
            return;
        }
        if (l % 10L == 0L) {
            Gi430.d(l - 1L);
            Gi430.d(1L);
        } else {
            Gi430.d(l);
        }
    }
}

