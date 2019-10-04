package tfu;

public enum Lt501 {
   LPS("LPS: %.1f"),
   FPS("FPS: %.1f"),
   FPSH("High: %.1f"),
   PING("Ping: %dms"),
   FPS_TRACKING_PAUSED("FPS Tracking Paused: %d"),
   FPSL("Low: %.1f"),
   SCRIPTEVENTS_HANDLERSACTIVE("ScrEvt (Hdlrs Active): %d"),
   PPS("PPS: %.1f"),
   SCRIPTEVENTS_TRIGGERED("ScrEvt Calls (Hdlrs/sec): %d"),
   SCRIPTEVENTS_HANDLERSEXIST("ScrEvt (Hdlrs All): %d"),
   BOT_NUMBER("%s"),
   FPSAverage("Average: %.1f"),
   POSITION("LocXYZ CamFace: %s"),
   PPS_TRACKING_PAUSED("PPS Tracking Paused: %d"),
   GAME_ENTITIES("Game entities: %d"),
   LUA_MEMORY("Lua memory: %.2fMB"),
   NPCS("NPCs: %d"),
   FRAMES_AHEAD("frames ahead: %d"),
   JAVA_MEMORY("Java memory: %s"),
   PLAYERS("Players: %d"),
   SCENE_NODES("Scene graph node: %d");

   private String i;
   private La499 o;

   public static void d(Lt501 var0, double var1) {
      if (var0.o == null) {
         var0.o = Lv148.j(var0.i);
      }

      if (var0.o != null) {
         var0.o.g(var1);
      }

   }

   public static void g(Lt501 var0, String var1) {
      if (var0.o == null) {
         var0.o = Lv148.j(var0.i);
      }

      if (var0.o != null) {
         var0.o.d(var1);
      }

   }

   private Lt501(String var3) {
      this.i = var3;
   }
}
