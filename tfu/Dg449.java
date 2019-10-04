package tfu;

import com.jagex.core.stringtools.general.Q280;

public class Dg449 {
   private static final int b = 5;
   private static final int e = 2;
   private static final int h = 3;
   private static final int j = 1;
   private static final int l = 6;
   private static final int p = 11;
   private static final int r = 8;
   private static final int s = 4;
   private static final int u = 13;
   private static final int v = 9;
   private static final int w = 7;
   private static final int x = 12;
   private static final int y = 10;
   private static final int z = 14;
   public int d = -1;
   public long g;
   Gx298 q = new Gx298();

   public Dg449(Gg3 var1) {
      this.g(var1);
   }

   public void g(Gg3 var1) {
      this.g = Gg3.bq(var1);
      this.d = Gg3.bd(var1);

      for(int var2 = Gg3.ar(var1); var2 != 0; var2 = Gg3.ar(var1)) {
         if (Ef450.g) {
            System.out.println("t:" + var2);
         }

         Object var3;
         if (var2 == 3) {
            var3 = new Dk626(this);
         } else if (var2 == 1) {
            var3 = new Ec614(this);
         } else if (var2 == 13) {
            var3 = new Ei604(this);
         } else if (var2 == 4) {
            var3 = new Ep612(this);
         } else if (var2 == 6) {
            var3 = new Eo611(this);
         } else if (var2 == 5) {
            var3 = new Db630(this);
         } else if (var2 == 2) {
            var3 = new Eh618(this);
         } else if (var2 == 7) {
            var3 = new Dy619(this);
         } else if (var2 == 14) {
            var3 = new Di627(this);
         } else if (var2 == 8) {
            var3 = new Em610(this);
         } else if (var2 == 9) {
            var3 = new Da631(this);
         } else if (var2 == 10) {
            var3 = new Eb613(this);
         } else if (var2 == 11) {
            var3 = new Es576(this);
         } else {
            if (var2 != 12) {
               throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
            }

            var3 = new Ez447(this);
         }

         ((Dm448)var3).g(var1);
         Gx298.t(this.q, (Ln265)var3);
      }

   }

   public void d(Ef450 var1) {
      if (var1.h == this.g && var1.s == this.d) {
         for(Dm448 var2 = (Dm448)Gx298.i(this.q); var2 != null; var2 = (Dm448)Gx298.c(this.q)) {
            var2.d(var1);
         }

         ++var1.s;
      } else {
         throw new RuntimeException("ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:" + Q280.g(var1.h) + " updateNum:" + var1.s + " delta.owner:" + Q280.g(this.g) + " updateNum:" + this.d);
      }
   }

   public Dg449(Ef450 var1) {
      this.g = var1.h;
      this.d = var1.s;
   }
}
