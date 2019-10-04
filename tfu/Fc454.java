package tfu;

import com.jagex.core.constants.E294;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fc454 implements Hp62 {
   public static final int b = 4;
   private static final int d = 9;
   public static final int e = 1;
   public static final int h = 2;
   public static final Ia63 i = new Fz457();
   private static final int j = -87097619;
   public static final int l = 6;
   private static final Logger logger = LoggerFactory.getLogger(Fc454.class);
   private static final int q = 2;
   public static final int s = 3;
   public static final int w = 0;
   public float k;
   public ArrayList m;
   public float n;
   public int p;
   public String r;
   public Fs455 t;
   public int u;
   public String v;
   public int x;
   public String y;
   public Ig436 z;

   public Fc454(byte[] var1) {
      this.t = Fs455.PPL;
      this.m = new ArrayList();
      Gg3 var2 = new Gg3(var1);
      int var3 = Gg3.ar(var2);
      if (var3 > 9) {
         throw new RuntimeException();
      } else {
         this.p = Gg3.au(var2);
         if (this.p == 65535) {
            this.p = -1;
         }

         this.x = Gg3.au(var2);
         if (this.x == 65535) {
            this.x = -1;
         }

         this.u = Gg3.au(var2);
         if (this.u == 65535) {
            this.u = -1;
         }

         if (var3 >= 2) {
            this.z = (Ig436)E294.d(Ig436.values(), Gg3.ax(var2));
         } else {
            this.z = Ig436.ALPHA_BLENDED;
         }

         if (var3 >= 3) {
            int var4 = Gg3.ar(var2);
            int var5 = Gg3.ar(var2);
            this.t = Fs455.g(var4);
            if (this.t == null) {
               this.t = Fs455.PPL;
            }

            int var6;
            if (var3 < 8) {
               for(var6 = 0; var6 < var5; ++var6) {
                  Gg3.bl(var2);
               }
            } else {
               this.t = Fs455.g(var4);

               for(var6 = 0; var6 < var5; ++var6) {
                  String var7 = var2.bp();
                  int var8 = Gg3.ar(var2);
                  float[] var9 = new float[var8];

                  for(int var10 = 0; var10 < var8; ++var10) {
                     var9[var10] = Gg3.bl(var2);
                  }

                  Fq456 var13 = new Fq456(var7, var9);
                  this.m.add(var13);
               }
            }

            if (var3 >= 8) {
               this.n = Gg3.bl(var2);
               this.k = Gg3.bl(var2);
            } else if (var3 == 7) {
               this.m.add(new Fq456("UVTransSpeed", new float[]{Gg3.bl(var2), Gg3.bl(var2)}));
               this.n = Gg3.bl(var2);
               this.k = Gg3.bl(var2);
               this.m.add(new Fq456("UVRotOrigin", new float[]{Gg3.bl(var2), Gg3.bl(var2)}));
               this.m.add(new Fq456("UVRotSpeed", new float[]{Gg3.bl(var2)}));
            } else if (var3 >= 4) {
               this.m.add(new Fq456("UVTransSpeed", new float[]{Gg3.bl(var2), Gg3.bl(var2)}));
               this.n = Gg3.bl(var2);
               this.k = Gg3.bl(var2);
            } else {
               float var11 = Gg3.bl(var2);
               float var12 = Gg3.bl(var2);
               this.n = 0.0625F;
               this.k = 0.0625F;
               var11 *= this.n;
               var12 *= this.k;
               this.m.add(new Fq456("UVTransSpeed", new float[]{var11, var12}));
            }
         } else {
            this.t = Fs455.PPL;
         }

      }
   }

   public static void g(Fc454 var0, String var1, float[] var2) {
      for(int var3 = 0; var3 < var0.m.size(); ++var3) {
         if (((Fq456)var0.m.get(var3)).g.equals(var1)) {
            float[] var4 = ((Fq456)var0.m.get(var3)).d;
            if (var4.length == var2.length) {
               for(int var5 = 0; var5 < var2.length; ++var5) {
                  var2[var5] = var4[var5];
               }
            }
         }
      }

   }

   public Fc454() {
      this.t = Fs455.PPL;
      this.m = new ArrayList();
      this.z = Ig436.OPAQUE;
      this.p = this.x = this.u = -1;
   }

   public void onAllRefsReleased() {
   }
}
