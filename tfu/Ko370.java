/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Lb33;

public class Ko370 {
    private static Thread d;
    private static Logger logger;
    private static ConcurrentLinkedQueue q;

    static {
        logger = LoggerFactory.getLogger(Ko370.class);
        q = new ConcurrentLinkedQueue();
    }

    public static void d() {
        Lb33.g(Lb33.MainThreadExecutor);
        try {
            Runnable runnable;
            if (d == null) {
                d = Thread.currentThread();
            }
            if (d != Thread.currentThread()) {
                throw new IllegalStateException("Wrong thread!");
            }
            while ((runnable = (Runnable)q.poll()) != null) {
                try {
                    runnable.run();
                }
                catch (Exception exception) {
                    logger.error("Error running task:", exception);
                }
            }
            Lb33.d(Lb33.MainThreadExecutor);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.MainThreadExecutor);
            throw throwable;
        }
    }

    public static void g(Runnable runnable) {
        q.add(runnable);
    }
}

