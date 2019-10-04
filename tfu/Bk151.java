package tfu;

import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import rs2.client.client;

public class Bk151 {
   private static int d = 0;
   private static Ja527[] g;
   private static long q = 0L;

   public static int g() {
      if (d == 0) {
         d = 1;
      }

      long var14;
      if (d == 1) {
         g = Ja527.values();
         Ja527.JS5_DEFAULTS.j(new Bp655(client.eu));
         Ja527.NL_JAGTHEORA.j(new Bx652("jagtheora"));
         Ja527.NL_JNIBINDINGS.j(new Bx652("JNIBindings"));
         Ja527.JS5_SHADERS.j(new Bp655(client.ea));
         Ja527.JS5_CONFIG.j(new Bp655(client.dr));
         Ja527.JS5_CONFIG_OBJ.j(new Bp655(client.et));
         Ja527.JS5_GFX_CONFIG.j(new Bp655(client.eg));
         Ja527.JS5FILE_HUFFMAN.j(new Bh662(client.dg, "huffman"));
         Ja527.JS5_SCALEFORM.j(new Bp655(client.db));
         Ja527.JS5_SCALEFORMDDS.j(new Bp655(client.dd));
         Ja527.JS5_FONTMETRICS.j(new Bp655(client.er));
         Ja527.JS5GROUP_PROPERTYINDEX.j(new Bj661(client.ek, "_propertynameindex"));
         Ja527.JS5_LUA.j(new Bp655(client.ee));
         Ja527.JS5_STATES.j(new Bp655(client.ep));
         Ja527.JS5_SPRITES.j(new Bp655(client.dy));

         for(int var0 = 0; var0 < g.length; ++var0) {
            if (Ja527.q(g[var0]) == null) {
               throw new RuntimeException();
            }
         }

         var14 = 0L;
         Ja527[] var2 = g;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Ja527 var5 = var2[var4];
            long var6 = (long)Ja527.g(var5);
            if (var6 < 0L) {
               throw new RuntimeException();
            }

            long var8 = (long)Ja527.q(var5).g();
            var14 += var8 * var6 / 100L;
         }

         q = var14;
         d = 2;
      }

      if (g == null) {
         return 100;
      } else {
         var14 = 0L;
         long var15 = 0L;
         boolean var16 = true;
         Ja527[] var17 = g;
         int var19 = var17.length;

         for(int var7 = 0; var7 < var19; ++var7) {
            Ja527 var20 = var17[var7];
            long var9 = (long)Ja527.g(var20);
            if (var9 < 0L) {
               throw new RuntimeException();
            }

            long var11 = 0L;
            boolean var13 = false;
            if (var16) {
               var13 = true;
               var11 = (long)Ja527.q(var20).g();
            }

            if (var11 < 100L) {
               var16 = false;
            }

            var14 += var9;
            var15 += var11 * var9 / 100L;
            if (var13 && !F511.j(var20.m)) {
               F511.d(var20.m);
               Z132.d("PACKAGE_" + var20.name(), "size:" + Ja527.g(var20) + " perc:" + var11);
            }

            if (var13 && var11 >= 100L && !F511.e(var20.m)) {
               F511.q(var20.m);
               Z132.q("PACKAGE_" + var20.name());
            }

            if (var15 < 0L) {
               throw new RuntimeException("td " + var15 + " s " + var9);
            }
         }

         if (var16) {
            if (!Bx652.w((Bx652)((Bx652)Ja527.q(Ja527.NL_JAGTHEORA)))) {
               client.bc = client.bu.load_jagtheora();
            }

            g = null;
         }

         var15 -= q;
         var14 -= q;
         int var18 = (int)(var14 > 0L ? var15 * 100L / var14 : 100L);
         if (!var16 && var18 > 99) {
            var18 = 99;
         }

         return var18;
      }
   }
}
