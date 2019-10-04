package com.jagex.jnibindings.runetek6;

final class G211 implements Runnable {
   public void run() {
      Js5NativeInterface.BindToThread();
      NativeResourceLoader.ComandeerThreadForDataAcquisition();
   }
}
