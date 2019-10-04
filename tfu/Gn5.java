package tfu;

public enum Gn5 {
   ENVIRONMENT_QUERY,
   NPC_NODRIVECOLLIDE,
   NUM_GROUPS,
   COLLIDES_WITH_EVERYTHING,
   PLAYER_AS_BODY,
   CUSTOM_QUERY,
   DONT_USE,
   CAR_WHEELS,
   PHYSDEBUG_QUERY,
   PLAYER_AS_CAR,
   SCENERY_QUERY,
   NPC_NOPLAYERCOLLIDE,
   NPC_VOLUME_QUERY,
   PLAYER_OR_NPC_VOLUME_QUERY,
   HEIGHTFIELD_QUERY,
   CAMERA_COLLIDE,
   PLAYER_AS_ROBOT,
   SCENERY,
   NPC_FULLCOLLIDE,
   PLAYER_VOLUME_QUERY,
   SOUND_RAY,
   HEIGHTFIELD,
   NPC_NOCOLLIDE,
   CAMERA_SIGHT,
   TRIGGER_VOLUME,
   NPC_SIGHT;

   static final boolean ag = false;
   public static boolean[][] ai = new boolean[aq.length][aq[0].length];
   public static boolean[][] al;
   public static boolean[][] aq = new boolean[][]{{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false}, {false, true, false, false, false, false, true, true, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false}, {false, true, false, false, false, false, true, false, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false}, {false, true, false, false, false, false, true, false, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, true, true, true, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false}, {false, true, true, false, false, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false}, {false, true, false, false, false, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, true, true, false, false, false, false, false}, {false, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, true, true, false, true, false}, {false, true, true, true, true, true, true, true, true, true, false, false, false, true, true, false, false, false, false, false, false, false, true, true, false}, {false, true, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, true, true, true, false, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}};

   static {
      int var0;
      int var1;
      for(var0 = 0; var0 < aq.length; ++var0) {
         for(var1 = 0; var1 < aq[var0].length; ++var1) {
            ai[var0][var1] = aq[var0][var1];
         }
      }

      ai[PLAYER_AS_ROBOT.ordinal()][PLAYER_AS_ROBOT.ordinal()] = true;
      ai[PLAYER_AS_CAR.ordinal()][PLAYER_AS_CAR.ordinal()] = true;
      ai[PLAYER_AS_BODY.ordinal()][PLAYER_AS_BODY.ordinal()] = true;
      ai[PLAYER_AS_ROBOT.ordinal()][PLAYER_AS_CAR.ordinal()] = true;
      ai[PLAYER_AS_CAR.ordinal()][PLAYER_AS_ROBOT.ordinal()] = true;
      ai[PLAYER_AS_ROBOT.ordinal()][PLAYER_AS_BODY.ordinal()] = true;
      ai[PLAYER_AS_BODY.ordinal()][PLAYER_AS_ROBOT.ordinal()] = true;
      ai[PLAYER_AS_CAR.ordinal()][PLAYER_AS_BODY.ordinal()] = true;
      ai[PLAYER_AS_BODY.ordinal()][PLAYER_AS_CAR.ordinal()] = true;
      al = new boolean[aq.length][aq[0].length];

      for(var0 = 0; var0 < aq.length; ++var0) {
         for(var1 = 0; var1 < aq[var0].length; ++var1) {
            al[var0][var1] = aq[var0][var1];
         }
      }

      al[SCENERY.ordinal()][PLAYER_AS_ROBOT.ordinal()] = false;
      al[SCENERY.ordinal()][PLAYER_AS_CAR.ordinal()] = false;
      al[SCENERY.ordinal()][PLAYER_AS_BODY.ordinal()] = false;
      al[PLAYER_AS_ROBOT.ordinal()][SCENERY.ordinal()] = false;
      al[PLAYER_AS_CAR.ordinal()][SCENERY.ordinal()] = false;
      al[PLAYER_AS_BODY.ordinal()][SCENERY.ordinal()] = false;
      al[SCENERY.ordinal()][CAR_WHEELS.ordinal()] = false;
      al[CAR_WHEELS.ordinal()][SCENERY.ordinal()] = false;
   }
}
