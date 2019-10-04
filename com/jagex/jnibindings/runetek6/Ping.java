package com.jagex.jnibindings.runetek6;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
   public static native void quit();

   public static int g(InetAddress var0, long var1) throws IOException {
      byte[] var3 = var0.getAddress();
      int var4 = nativePing(var3[0], var3[1], var3[2], var3[3], var1);
      if (var4 < 0) {
         switch(var4) {
         case -5:
            throw new IOException("An error occurred trying to reach the remote host");
         case -4:
            throw new IOException("Couldn't allocate memory");
         case -3:
            throw new IOException("Couldn't create ICMP file handle");
         case -2:
            throw new IOException("Couldn't find ICMP entry points");
         case -1:
            throw new IOException("Couldn't initialise ICMP library");
         default:
            throw new IOException("Unknown error");
         }
      } else {
         return var4;
      }
   }

   private static native int nativePing(byte var0, byte var1, byte var2, byte var3, long var4);
}
