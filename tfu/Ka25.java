package tfu;

import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ka25 extends It12 {
   private static final Logger logger = LoggerFactory.getLogger(Ka25.class);
   public Vector3[] d = null;
   public Ie21 e;
   public String h;
   public int[] j = null;
   public int[] q = null;
   public int s;

   public Ka25(Fk353 var1) {
      this.e = Ie21.GENERIC_STATIC_MESH;
      this.h = null;
      this.s(var1);
      this.e = Ie21.GENERIC_STATIC_MESH;
      this.s = -1;
   }

   public static Ka25 h(Gg3 var0, Hi86 var1, Z165 var2, boolean var3) {
      Z165.q(var2);
      Gg3.bm(var0);
      int var4 = Gg3.bm(var0);
      if (var4 == -1) {
         return null;
      } else {
         try {
            Fk353 var5 = (Fk353)var1.j(Fk353.class, var4);
            if (var3) {
               Object[] var6 = new Object[]{var4, var5.s, var5.m / 3};
               logger.info("    static mesh fully loaded: js5_index = {} numVertices {} numTriangles {}", var6);
            }

            return new Ka25(var5);
         } catch (Ik357 var7) {
            logger.error("Error while loading mesh_raw file", var7);
            return null;
         }
      }
   }

   private void s(Fk353 var1) {
      int var2 = var1.s;
      this.d = new Vector3[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         float var4 = (float)var1.b[var3] * Ai354.q / var1.n;
         float var5 = (float)var1.l[var3] * Ai354.q / var1.n;
         float var6 = (float)var1.w[var3] * Ai354.q / var1.n;
         this.d[var3] = new Vector3(var4, var5, var6);
      }

      var3 = 0;

      int var7;
      for(var7 = 0; var7 < var1.u; ++var7) {
         var3 += var1.z[var7].g;
      }

      this.q = new int[var3 * 3];
      this.j = new int[var3];
      var3 = 0;

      for(var7 = 0; var7 < var1.u; ++var7) {
         int var8 = 0;

         while(var8 < var1.z[var7].g) {
            assert 0 <= var1.z[var7].e[var8] && var1.z[var7].e[var8] < this.d.length;

            if (b || 0 <= var1.z[var7].h[var8] && var1.z[var7].h[var8] < this.d.length) {
               if (b || 0 <= var1.z[var7].s[var8] && var1.z[var7].s[var8] < this.d.length) {
                  this.q[var3 * 3 + 0] = var1.z[var7].e[var8];
                  this.q[var3 * 3 + 1] = var1.z[var7].h[var8];
                  this.q[var3 * 3 + 2] = var1.z[var7].s[var8];
                  this.j[var3] = var1.z[var7].b;
                  ++var3;
                  ++var8;
                  continue;
               }

               throw new AssertionError();
            }

            throw new AssertionError();
         }
      }

   }

   public Ie21 g() {
      return this.e;
   }

   public static Ka25 e(Gg3 var0, Z165 var1, boolean var2) {
      Z165.q(var1);
      Gg3.bm(var0);
      String var3 = var0.bp();
      if (var2) {
         logger.info("    static mesh: meshName = \"{}\"", var3);
      }

      return new Ka25(var3);
   }

   public Ka25(String var1) {
      this.e = Ie21.GENERIC_STATIC_MESH;
      this.h = var1;
      this.s = -1;
      this.e = Ie21.GENERIC_STATIC_MESH;
   }
}
