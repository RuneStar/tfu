package com.jagex.jnibindings.runetek6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Lb33;

public class LuaNativeEvents {
   private static boolean d = false;
   private static final Logger logger = LoggerFactory.getLogger(LuaNativeEvents.class);

   public static final native void detachAllEventHandlers(long var0);

   public static final native void invokeOnUpdatePhysicsPost(long var0);

   public static final native void invokeOnClientFriendListUpdate(long var0);

   public static final native double serviceNative(long var0, float var2);

   public static final native void invokeOnUpdatePhysicsPre(long var0);

   public static final void g() {
      d = true;
   }

   public static final void d(long var0, float var2) {
      Lb33.g(Lb33.LuaNative);

      try {
         try {
            if (d) {
               serviceNative(var0, var2);
            }
         } catch (Exception var7) {
            logger.error("", var7);
            Lb33.d(Lb33.LuaNative);
            return;
         }

         Lb33.d(Lb33.LuaNative);
      } finally {
         Lb33.d(Lb33.LuaNative);
      }
   }
}
