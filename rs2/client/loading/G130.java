package rs2.client.loading;

import tfu.Mk163;

public enum G130 {
   REGISTER_NATIVE_JS5S(Mk163.DOWNLOADING_UPDATES, 87),
   INIT_NATIVE_REGISTRY(Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 2, 5),
   OPEN_JS5_ARCHIVES(Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 9, 15),
   WAIT_FOR_MEMORY(Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 0, 1),
   GET_JS5_INDEXES(Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 16, 20, true, true),
   CONSTRUCT_TOOLKIT(Mk163.CHECKING_FOR_UPDATES, 7),
   SETUP_CONFIG_DECODERS(Mk163.DOWNLOADING_UPDATES, 87),
   FETCH_FONTS(Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 94, 96),
   LOAD_NATIVE_DLLS(Mk163.CHECKING_FOR_UPDATES, 6),
   SETUP_GRAPHICS_CONFIGURATIONS(Mk163.DOWNLOADING_UPDATES, 89),
   DOWNLOAD_STUFF(Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 21, 86, true, true),
   CLEANUP(Mk163.DOWNLOADING_UPDATES, 99),
   INIT_SCRIPTING(Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 90, 91),
   SETUP_SOUND_LIBRARY(Mk163.CHECKING_FOR_UPDATES, 88),
   SETUP_VARC_SYSTEM(Mk163.DOWNLOADING_UPDATES, 98),
   SETUP_STATIC_SPRITES(Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 92, 93),
   LOADING_COMPLETE(Mk163.DOWNLOADING_UPDATES, 100);

   public final boolean i;
   public final int k;
   public final Mk163 m;
   public final int n;
   public final boolean o;
   public final Mk163 t;

   private G130(Mk163 var3, Mk163 var4, int var5, int var6) {
      this(var3, var4, var5, var6, true, false);
   }

   private G130(Mk163 var3, int var4) {
      this(var3, var3, var4, var4, true, false);
   }

   private G130(Mk163 var3, Mk163 var4, int var5, int var6, boolean var7, boolean var8) {
      this.t = var3;
      this.m = var4;
      this.n = var5;
      this.k = var6;
      this.i = var7;
      this.o = var8;
   }
}
