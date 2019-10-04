package tfu;

import java.util.ArrayList;
import java.util.Iterator;

public class Ao128 extends Throwable {
   private static ThreadLocal d = new ThreadLocal();
   private static ArrayList g = new ArrayList();

   public synchronized Throwable fillInStackTrace() {
      super.fillInStackTrace();
      ArrayList var1 = new ArrayList();
      StackTraceElement[] var2 = this.getStackTrace();
      int var3 = 2;

      for(Class var4 = this.getClass(); var4 != Throwable.class; var4 = var4.getSuperclass()) {
         ++var3;
      }

      for(int var11 = var3; var11 < var2.length; ++var11) {
         var1.add(var2[var11]);
      }

      Iterator var12 = g.iterator();

      while(true) {
         Aa129 var5;
         StackTraceElement[] var6;
         int var8;
         do {
            do {
               if (!var12.hasNext()) {
                  Ao128 var14 = (Ao128)d.get();
                  if (var14 != null) {
                     StackTraceElement[] var13 = var14.getStackTrace();
                     if (var13 != null && var13.length > 0) {
                        var1.add(d("Cross-thread link"));
                        var6 = var13;
                        int var15 = var13.length;

                        for(var8 = 0; var8 < var15; ++var8) {
                           StackTraceElement var16 = var6[var8];
                           var1.add(var16);
                        }
                     }
                  }

                  this.setStackTrace((StackTraceElement[])var1.toArray(new StackTraceElement[var1.size()]));
                  return this;
               }

               var5 = (Aa129)var12.next();
               var6 = var5.getElements();
            } while(var6 == null);
         } while(var6.length <= 0);

         var1.add(d(var5.getHeading()));
         StackTraceElement[] var7 = var6;
         var8 = var6.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            StackTraceElement var10 = var7[var9];
            if (var10 != null) {
               var1.add(var10);
            }
         }
      }
   }

   public static StackTraceElement d(String var0) {
      return new StackTraceElement(".", ".", var0 == null ? "null" : var0, -1);
   }

   public Ao128() {
   }

   public Ao128(Throwable var1) {
      super(var1);
   }

   public static void g(Aa129 var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         g.add(var0);
      }
   }

   public Ao128(String var1, Throwable var2) {
      super(var1, var2);
   }

   public Ao128(String var1) {
      super(var1);
   }
}
