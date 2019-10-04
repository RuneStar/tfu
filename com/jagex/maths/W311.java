package com.jagex.maths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tfu.Bo314;
import tfu.Me312;

public final class W311 {
   private HashSet d = new HashSet();
   private Me312 g = new Me312();
   private HashSet j = new HashSet();
   private ArrayList q = new ArrayList();

   private static T313[] b(HashSet var0) {
      T313[] var1 = (T313[])var0.toArray(new T313[var0.size()]);
      Bo314.g(var1);
      return var1;
   }

   public W311(Vector3[] var1) {
      g(this, var1);
   }

   private void d(Vector3 var1) {
      if (!this.g.contains(var1)) {
         this.g.add(var1);
         if (this.g.size() >= 4) {
            if (this.g.size() == 4) {
               Iterator var9 = this.g.iterator();
               Vector3 var10 = (Vector3)var9.next();
               Vector3 var12 = (Vector3)var9.next();
               Vector3 var14 = (Vector3)var9.next();
               Vector3 var16 = (Vector3)var9.next();
               T313 var17 = new T313(var10, var12, var14);
               T313 var8 = new T313(var10, var14, var12);
               if (q(var16, var17)) {
                  this.d.add(var8);
                  this.j(var17, var16);
               } else {
                  this.d.add(var17);
                  this.j(var8, var16);
               }

               this.j.clear();
            } else {
               T313[] var2 = (T313[])this.d.toArray(new T313[this.d.size()]);
               T313[] var3 = var2;
               int var4 = var2.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  T313 var6 = var3[var5];
                  if (q(var1, var6)) {
                     this.d.remove(var6);
                     this.q.add(var6);
                     this.j(var6, var1);
                  }
               }

               var3 = b(this.j);
               Iterator var11 = this.q.iterator();

               while(true) {
                  T313 var13;
                  do {
                     if (!var11.hasNext()) {
                        this.q.clear();
                        this.j.clear();
                        return;
                     }

                     var13 = (T313)var11.next();
                  } while(var13.j == null);

                  Iterator var15 = var13.j.iterator();

                  while(var15.hasNext()) {
                     Vector3 var7 = (Vector3)var15.next();
                     this.s(var3, var7);
                  }
               }
            }
         }
      }
   }

   private void j(T313 var1, Vector3 var2) {
      e(this, new T313(var1.g, var1.d, var2));
      e(this, new T313(var1.d, var1.q, var2));
      e(this, new T313(var1.q, var1.g, var2));
   }

   private static void e(W311 var0, T313 var1) {
      boolean var2 = var0.d.remove(var1);
      if (var2) {
         var0.j.remove(var1);
      } else {
         var0.d.add(var1);
         var0.j.add(var1);
      }

   }

   private static void h(W311 var0, Vector3[] var1) {
      T313[] var2 = b(var0.d);
      Vector3[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Vector3 var6 = var3[var5];
         if (!var0.g.contains(var6)) {
            var0.s(var2, var6);
         }
      }

   }

   private void s(T313[] var1, Vector3 var2) {
      T313[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         T313 var6 = var3[var5];
         if (q(var2, var6)) {
            if (var6.j == null) {
               var6.j = new ArrayList();
            }

            var6.j.add(var2);
            return;
         }
      }

      this.g.add(var2);
   }

   public W311() {
   }

   private static boolean q(Vector3 var0, T313 var1) {
      Vector3 var2 = Vector3.k(var1.d, var1.g);
      Vector3 var3 = Vector3.k(var1.q, var1.g);
      Vector3 var4 = Vector3.a(var2, var3);
      Vector3 var5 = Vector3.k(var0, var1.g);
      return Vector3.o(var4, var5) >= 0.0F;
   }

   public static W311 g(W311 var0, Vector3[] var1) {
      var1 = (Vector3[])var1.clone();
      Bo314.g(var1);
      boolean var2 = false;
      Vector3[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Vector3 var6 = var3[var5];
         if (!var2 && var0.d.size() > 0) {
            h(var0, var1);
            var2 = true;
         }

         var0.d(var6);
      }

      return var0;
   }
}
