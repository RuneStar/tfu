// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import org.slf4j.LoggerFactory;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.slf4j.Logger;

public class H46
{
    private static final boolean d = false;
    static StackTraceElement[] e;
    static StackTraceElement[] j;
    private static final Logger logger;
    static ReentrantReadWriteLock q;
    
    public static void j() {
        H46.q.writeLock().unlock();
    }
    
    public static void g() {
        H46.q.writeLock().lock();
    }
    
    public static void q() {
        H46.q.writeLock().lock();
    }
    
    public static void d() {
        H46.q.writeLock().unlock();
    }
    
    static {
        logger = LoggerFactory.getLogger(H46.class);
        H46.q = new ReentrantReadWriteLock();
        H46.j = null;
        H46.e = null;
    }
}
