package tfu;

import com.jagex.jnibindings.runetek6.RuntimeTool.F511;

public enum Ja527 {
   JS5FILE_HUFFMAN(Jb525.JS5_FILE),
   NL_JAGTHEORA(Jb525.NATIVE_LIBRARY),
   JS5_CONFIG(Jb525.JS5),
   JS5_DEFAULTS(Jb525.JS5),
   JS5_CONFIG_OBJ(Jb525.JS5),
   JS5_SHADERS(Jb525.JS5),
   JS5_SCALEFORM(Jb525.JS5),
   JS5_STATES(Jb525.JS5),
   NL_JNIBINDINGS(Jb525.NATIVE_LIBRARY),
   JS5_FONTMETRICS(Jb525.JS5),
   JS5_GFX_CONFIG(Jb525.JS5),
   JS5GROUP_PROPERTYINDEX(Jb525.JS5_GROUP),
   JS5_SCALEFORMDDS(Jb525.JS5),
   JS5_SPRITES(Jb525.JS5),
   JS5_LUA(Jb525.JS5);

   public F511 m = new F511();
   private Jj524 t;
   public final Jb525 u;
   private int z;

   public static Jj524 q(Ja527 var0) {
      return var0.t;
   }

   public static void d(Ja527 var0, int var1) {
      var0.z = var1;
   }

   public void j(Jj524 var1) {
      if (var1.d() != this.u) {
         throw new IllegalArgumentException();
      } else {
         this.t = var1;
      }
   }

   public static int g(Ja527 var0) {
      return var0.z;
   }

   private Ja527(Jb525 var3) {
      this.u = var3;
      this.z = 1;
   }
}
