package com.jagex.jnibindings.runetek6.jagbullet;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H46 {
   private static final boolean d = false;
   static StackTraceElement[] e = null;
   static StackTraceElement[] j = null;
   private static final Logger logger = LoggerFactory.getLogger(H46.class);
   static ReentrantReadWriteLock q = new ReentrantReadWriteLock();

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
}
