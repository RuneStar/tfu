package com.jagex.game.runetek6.xelement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class N78 extends D80 {
   protected List af;
   protected List al;
   protected List av;

   public static int da(N78 var0) {
      return var0.af != null ? var0.af.size() : 0;
   }

   public static XElement dx(N78 var0, int var1) {
      return (XElement)var0.af.get(var1);
   }

   public void dr(XElement var1) throws Ae201 {
      if (this.af == null) {
         this.af = new ArrayList();
      }

      this.af.add(var1);
   }

   protected static void eg(N78 var0, Gg3 var1) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public static J113 dd(N78 var0, int var1) {
      return (J113)var0.al.get(var1);
   }

   public void dy(J113 var1) {
      if (this.al == null) {
         this.al = new ArrayList();
      }

      this.al.add(var1);
   }

   public N78(D80 var1) {
      super(var1);
   }

   public static Ao74 er(N78 var0, int var1) {
      return (Ao74)var0.av.get(var1);
   }

   public void ez(Ao74 var1) {
      if (this.av == null) {
         this.av = new ArrayList();
      }

      this.av.add(var1);
   }

   public void r(Gg3 var1, Hk84 var2, Hg85 var3, Hi86 var4) {
      int var5;
      Iterator var6;
      if (this.af != null && !this.af.isEmpty()) {
         Gg3.k(var1, Ax92.ELEMENTS.j);
         var5 = var1.v += 4;
         Gg3.i(var1, this.af.size());
         var6 = this.af.iterator();

         while(var6.hasNext()) {
            XElement var7 = (XElement)var6.next();
            var7.r(var1, var2, var3, var4);
         }

         Gg3.am(var1, var1.v - var5);
      }

      if (this.al != null && !this.al.isEmpty()) {
         Gg3.k(var1, Ax92.LIGHTS.j);
         var5 = var1.v += 4;
         Gg3.i(var1, this.al.size());
         var6 = this.al.iterator();

         while(var6.hasNext()) {
            J113 var8 = (J113)var6.next();
            var8.r(var1, var2, var3, var4);
         }

         Gg3.am(var1, var1.v - var5);
      }

      if (this.av != null && !this.av.isEmpty()) {
         Gg3.k(var1, Ax92.PARTICLE_SYSTEMS.j);
         var5 = var1.v += 4;
         Gg3.i(var1, this.av.size());
         var6 = this.av.iterator();

         while(var6.hasNext()) {
            Ao74 var9 = (Ao74)var6.next();
            var9.r(var1, var2, var3, var4);
         }

         Gg3.am(var1, var1.v - var5);
      }

      Gg3.k(var1, 0);
   }

   public static int dg(N78 var0) {
      return var0.av != null ? var0.av.size() : 0;
   }

   public static int db(N78 var0) {
      return var0.al != null ? var0.al.size() : 0;
   }
}
