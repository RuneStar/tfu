/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H46 {
    private static final boolean d = false;
    static StackTraceElement[] e;
    static StackTraceElement[] j;
    private static final Logger logger;
    static ReentrantReadWriteLock q;

    public static void j() {
        q.writeLock().unlock();
    }

    public static void g() {
        q.writeLock().lock();
    }

    public static void q() {
        q.writeLock().lock();
    }

    public static void d() {
        q.writeLock().unlock();
    }

    static {
        logger = LoggerFactory.getLogger(H46.class);
        q = new ReentrantReadWriteLock();
        j = null;
        e = null;
    }
}

