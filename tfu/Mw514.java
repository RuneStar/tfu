/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.ThreadFactory;

public class Mw514
implements ThreadFactory {
    private static long g = 0L;
    private String d;

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName(this.d + "/" + ++g);
        return thread;
    }

    public Mw514(String string) {
        this.d = string;
    }

    public String toString() {
        return this.getClass().getName() + " \"" + this.d + "\"";
    }
}

