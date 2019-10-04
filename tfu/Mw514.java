// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.ThreadFactory;

public class Mw514 implements ThreadFactory
{
    private static long g;
    private String d;
    
    static {
        Mw514.g = 0L;
    }
    
    @Override
    public Thread newThread(final Runnable target) {
        final Thread thread = new Thread(target);
        thread.setDaemon(true);
        ++Mw514.g;
        thread.setName(this.d + "/" + Mw514.g);
        return thread;
    }
    
    public Mw514(final String d) {
        this.d = d;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + " \"" + this.d + "\"";
    }
}
