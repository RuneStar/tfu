package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Fs455 {
   TWO_TONE_PPL(6, "TwoTonePPL"),
   PPL(5, "PPL"),
   ALWAYS_ON_TOP_PPL(7, "AlwaysOnTopPPL");

   private static final Logger logger = LoggerFactory.getLogger(Fs455.class);
   public int e;
   public int h;
   public String s;

   private Fs455(int var3, String var4) {
      this.e = var3;
      this.s = var4;
   }

   public static Fs455 g(int var0) {
      Fs455[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Fs455 var4 = var1[var3];
         if (var4.e == var0) {
            return var4;
         }
      }

      return PPL;
   }

   public static boolean d(Fs455 var0) {
      return var0 == PPL || var0 == TWO_TONE_PPL || var0 == ALWAYS_ON_TOP_PPL;
   }
}
