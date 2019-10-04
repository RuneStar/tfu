package tfu;

public enum Ex582 {
   CREATE_CHECK_EMAIL(28, -2),
   INIT_JS5REMOTE_CONNECTION(15, 8),
   REQUEST_WORLDLIST(23, 4),
   INIT_GAME_CONNECTION(14, 1),
   CHECK_WORLD_SUITABILITY(24, -1),
   CREATE_ACCOUNT(22, -2),
   INIT_SOCIAL_NETWORK_CONNECTION(29, -2),
   GAMELOGIN(16, -2),
   SSL_WEBCONNECTION(27, 0);

   public static final Ex582[] v = new Ex582[32];
   public final int r;
   public final int w;

   static {
      Ex582[] var0 = values();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         v[var0[var1].w] = var0[var1];
      }

   }

   private Ex582(int var3, int var4) {
      this.w = var3;
      this.r = var4;
   }
}
