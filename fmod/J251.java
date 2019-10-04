package fmod;

public class J251 {
   private long g;

   public static boolean g(J251 var0) {
      return var0.g != 0L;
   }

   public static void d(J251 var0, X243 var1) {
      fmod.EventGroup_freeEventData(var0.g, var1.m, true);
   }

   public X243 q(int var1, int var2) {
      return new X243(fmod.EventGroup_getEventByIndex(this.g, var1, var2));
   }

   public T239 s() {
      T239 var1 = new T239();
      String var2 = fmod.EventGroup_getInfo(this.g);
      R257[] var3 = fmod.j(var2);
      R257[] var4 = var3;
      int var5 = var3.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         R257 var7 = var4[var6];
         if (var7.g.equals("index")) {
            var1.g = Integer.parseInt((String)var7.d);
         }

         if (var7.g.equals("name")) {
            var1.d = (String)var7.d;
         }
      }

      return var1;
   }

   public String toString() {
      return this.s().d;
   }

   public J251 h(int var1) {
      return new J251(fmod.EventGroup_getGroupByIndex(this.g, var1, false));
   }

   public static int b(J251 var0) {
      return fmod.EventGroup_getNumEvents(var0.g);
   }

   public static int l(J251 var0) {
      return fmod.EventGroup_getNumGroups(var0.g);
   }

   public static X243[] e(J251 var0) {
      int var1 = b(var0);
      X243[] var2 = new X243[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0.q(var3, 4);
      }

      return var2;
   }

   public J251(long var1) {
      this.g = var1;
   }

   public static J251[] j(J251 var0) {
      int var1 = l(var0);
      J251[] var2 = new J251[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0.h(var3);
      }

      return var2;
   }
}
