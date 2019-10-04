package fmod;

public class S237 {
   public long g;

   public S237(long var1) {
      this.g = var1;
   }

   public static boolean g(S237 var0) {
      return var0.g != 0L;
   }

   public H238 d(int var1) {
      return new H238(fmod.ChannelGroup_getChannel(this.g, var1));
   }

   public static int q(S237 var0) {
      return fmod.ChannelGroup_getNumChannels(var0.g);
   }
}
