package com.jagex.jnibindings.runetek6;

public class NativeResourceLoader {
   private static Thread g;

   private static native void InitNative();

   public static void g() {
      InitNative();
      g = new Thread(new G211());
      g.setName("Native Data Acquisition Thread");
      g.start();
   }

   public static void d() {
      PurgeNative();

      try {
         g.join();
      } catch (InterruptedException var1) {
      }

   }

   public static native void ComandeerThreadForDataAcquisition();

   private static native void PurgeNative();
}
