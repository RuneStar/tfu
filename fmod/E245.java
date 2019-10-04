package fmod;

import tfu.Lb33;

public class E245 {
   private long g = 0L;

   public static int s(E245 var0, int var1, long var2, int var4) {
      return var0.g != 0L ? fmod.EventSystem_init(var0.g, var1, var2, var4) : 0;
   }

   public M249 g(int var1) {
      return this.g != 0L ? new M249(fmod.EventSystem_getCategoryByIndex(this.g, var1)) : null;
   }

   public static M249[] d(E245 var0) {
      if (var0.g == 0L) {
         return null;
      } else {
         int var1 = j(var0);
         M249[] var2 = new M249[var1];

         for(int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = var0.g(var3);
         }

         return var2;
      }
   }

   public U240 q() {
      return this.g != 0L ? new U240(fmod.EventSystem_getSystemObject(this.g)) : null;
   }

   public E245(long var1) {
      this.g = var1;
   }

   public static int e(E245 var0) {
      return var0.g != 0L ? fmod.EventSystem_getNumProjects(var0.g) : 0;
   }

   public Z256 w(byte[] var1) {
      return this.g != 0L ? new Z256(fmod.EventSystem_loadFromMemory(this.g, var1)) : new Z256(0L);
   }

   public static int l(E245 var0, String var1) {
      return var0.g != 0L ? fmod.EventSystem_setMediaPath(var0.g, var1) : 0;
   }

   public X243 r(String var1, int var2) {
      Lb33.g(Lb33.Fmod_getEvent);

      try {
         if (var1 != null && this.g != 0L) {
            X243 var3 = new X243(fmod.EventSystem_getEvent(this.g, var1, var2));
            var3.n = fmod.EventSystem_getEvent(this.g, var1, 4);
            var3.aq = var1;
            var3.al = this;
            var3.af = var2;
            var3.ai = var1;
            var3.az = false;
            if (var2 != 4 && var3.m == -1L) {
               String[] var12 = this.n(var1);
               if (var12 != null) {
                  String[] var5 = var12;
                  int var6 = var12.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     String var8 = var5[var7];
                     fmod.e.g(var8);
                  }
               }

               X243.e(var3);
            }

            Lb33.d(Lb33.Fmod_getEvent);
            return var3;
         } else {
            X243 var4 = new X243(0L);
            Lb33.d(Lb33.Fmod_getEvent);
            return var4;
         }
      } finally {
         Lb33.d(Lb33.Fmod_getEvent);
      }
   }

   public X243 y(String var1, Q244 var2) {
      if (this.g == 0L) {
         return new X243(0L);
      } else {
         X243 var3 = v(this, var1);
         if (var2 != null) {
            X243.u(var3, var2);
         }

         if (X243.h(var3)) {
            var3.az = true;
            var3.a();
         }

         return var3;
      }
   }

   public X243 p(String var1, float var2, float var3, float var4) {
      return this.g != 0L ? this.y(var1, new Q244(var2, var3, var4)) : new X243(0L);
   }

   public static int u(E245 var0, int var1, Q244 var2, Q244 var3, Q244 var4, Q244 var5) {
      return var0.g != 0L ? fmod.EventSystem_set3DListenerAttributes(var0.g, var1, var2.g, var2.d, var2.q, var3.g, var3.d, var3.q, var4.g, var4.d, var4.q, var5.g, var5.d, var5.q) : 0;
   }

   public X243 x(String var1, int var2) {
      if (var1 == null) {
         return new X243(0L);
      } else {
         X243 var3 = this.g != 0L ? v(this, var1) : new X243(0L);
         if (var3.m != 0L) {
            var3.az = true;
            var3.a();
         }

         return var3;
      }
   }

   public static void t(E245 var0) {
      Lb33.g(Lb33.FmodEventSystem);

      try {
         if (var0.g != 0L) {
            fmod.EventSystem_update(var0.g);
         }

         Lb33.d(Lb33.FmodEventSystem);
      } finally {
         Lb33.d(Lb33.FmodEventSystem);
      }
   }

   public Z256 h(int var1) {
      return this.g != 0L ? new Z256(fmod.EventSystem_getProjectByIndex(this.g, var1)) : null;
   }

   public static Z256[] m(E245 var0) {
      if (var0.g == 0L) {
         return null;
      } else {
         int var1 = e(var0);
         Z256[] var2 = new Z256[var1];

         for(int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = var0.h(var3);
         }

         return var2;
      }
   }

   public String[] n(String var1) {
      if (this.g == 0L) {
         return new String[0];
      } else {
         String var2 = fmod.EventSystem_getWaveBanksNeeded(this.g, var1);
         if (var2 == null) {
            return null;
         } else {
            String[] var3 = var2.split("\\|");

            for(int var4 = 0; var4 < var3.length; ++var4) {
               var3[var4] = var3[var4] + ".fsb";
            }

            return var3;
         }
      }
   }

   public D564 z(String var1) {
      if (this.g == 0L) {
         return new D564(0L);
      } else {
         long var2 = fmod.EventSystem_create3dReverb(this.g, var1);
         D564 var4 = new D564(var2);
         var4.d = var1;
         return var4;
      }
   }

   public static int b(E245 var0) {
      return var0.g != 0L ? fmod.EventSystem_release(var0.g) : 0;
   }

   public static X243 v(E245 var0, String var1) {
      return var0.r(var1, 0);
   }

   public static int j(E245 var0) {
      return var0.g != 0L ? fmod.EventSystem_getNumCategories(var0.g) : 0;
   }
}
