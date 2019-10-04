// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;

public class Ko370
{
    private static Thread d;
    private static Logger logger;
    private static ConcurrentLinkedQueue q;
    
    static {
        Ko370.logger = LoggerFactory.getLogger(Ko370.class);
        Ko370.q = new ConcurrentLinkedQueue();
    }
    
    public static void d() {
        Lb33.g(Lb33.MainThreadExecutor);
        try {
            if (Ko370.d == null) {
                Ko370.d = Thread.currentThread();
            }
            if (Ko370.d != Thread.currentThread()) {
                throw new IllegalStateException("Wrong thread!");
            }
            while (true) {
                final Runnable runnable = Ko370.q.poll();
                if (runnable == null) {
                    break;
                }
                try {
                    runnable.run();
                }
                catch (Exception ex) {
                    Ko370.logger.error("Error running task:", ex);
                }
            }
        }
        finally {
            Lb33.d(Lb33.MainThreadExecutor);
        }
    }
    
    public static void g(final Runnable e) {
        Ko370.q.add(e);
    }
}
