// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Gn5
{
    ENVIRONMENT_QUERY("ENVIRONMENT_QUERY", 23), 
    NPC_NODRIVECOLLIDE("NPC_NODRIVECOLLIDE", 7), 
    NUM_GROUPS("NUM_GROUPS", 25), 
    COLLIDES_WITH_EVERYTHING("COLLIDES_WITH_EVERYTHING", 1), 
    PLAYER_AS_BODY("PLAYER_AS_BODY", 4), 
    CUSTOM_QUERY("CUSTOM_QUERY", 24), 
    DONT_USE("DONT_USE", 0), 
    CAR_WHEELS("CAR_WHEELS", 5), 
    PHYSDEBUG_QUERY("PHYSDEBUG_QUERY", 21), 
    PLAYER_AS_CAR("PLAYER_AS_CAR", 3), 
    SCENERY_QUERY("SCENERY_QUERY", 20), 
    NPC_NOPLAYERCOLLIDE("NPC_NOPLAYERCOLLIDE", 8), 
    NPC_VOLUME_QUERY("NPC_VOLUME_QUERY", 18), 
    PLAYER_OR_NPC_VOLUME_QUERY("PLAYER_OR_NPC_VOLUME_QUERY", 19), 
    HEIGHTFIELD_QUERY("HEIGHTFIELD_QUERY", 22), 
    CAMERA_COLLIDE("CAMERA_COLLIDE", 13), 
    PLAYER_AS_ROBOT("PLAYER_AS_ROBOT", 2), 
    SCENERY("SCENERY", 10), 
    NPC_FULLCOLLIDE("NPC_FULLCOLLIDE", 6), 
    PLAYER_VOLUME_QUERY("PLAYER_VOLUME_QUERY", 17), 
    SOUND_RAY("SOUND_RAY", 15), 
    HEIGHTFIELD("HEIGHTFIELD", 11), 
    NPC_NOCOLLIDE("NPC_NOCOLLIDE", 9), 
    CAMERA_SIGHT("CAMERA_SIGHT", 14), 
    TRIGGER_VOLUME("TRIGGER_VOLUME", 12), 
    NPC_SIGHT("NPC_SIGHT", 16);
    
    static final boolean ag = false;
    public static boolean[][] ai;
    public static boolean[][] al;
    public static boolean[][] aq;
    
    private Gn5(final String name, final int ordinal) {
    }
    
    static {
        Gn5.aq = new boolean[][] { { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false }, { false, true, false, false, false, false, true, true, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false }, { false, true, false, false, false, false, true, false, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false }, { false, true, false, false, false, false, true, false, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false }, { false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, true, true, true, true, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false }, { false, true, true, false, false, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false }, { false, true, false, false, false, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false }, { false, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, true, true, false, false, false, false, false }, { false, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, true, true, false, true, false }, { false, true, true, true, true, true, true, true, true, true, false, false, false, true, true, false, false, false, false, false, false, false, true, true, false }, { false, true, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false }, { false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, true, true, true, true, false, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false } };
        Gn5.ai = new boolean[Gn5.aq.length][Gn5.aq[0].length];
        for (int i = 0; i < Gn5.aq.length; ++i) {
            for (int j = 0; j < Gn5.aq[i].length; ++j) {
                Gn5.ai[i][j] = Gn5.aq[i][j];
            }
        }
        Gn5.ai[Gn5.PLAYER_AS_ROBOT.ordinal()][Gn5.PLAYER_AS_ROBOT.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_CAR.ordinal()][Gn5.PLAYER_AS_CAR.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_BODY.ordinal()][Gn5.PLAYER_AS_BODY.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_ROBOT.ordinal()][Gn5.PLAYER_AS_CAR.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_CAR.ordinal()][Gn5.PLAYER_AS_ROBOT.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_ROBOT.ordinal()][Gn5.PLAYER_AS_BODY.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_BODY.ordinal()][Gn5.PLAYER_AS_ROBOT.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_CAR.ordinal()][Gn5.PLAYER_AS_BODY.ordinal()] = true;
        Gn5.ai[Gn5.PLAYER_AS_BODY.ordinal()][Gn5.PLAYER_AS_CAR.ordinal()] = true;
        Gn5.al = new boolean[Gn5.aq.length][Gn5.aq[0].length];
        for (int k = 0; k < Gn5.aq.length; ++k) {
            for (int l = 0; l < Gn5.aq[k].length; ++l) {
                Gn5.al[k][l] = Gn5.aq[k][l];
            }
        }
        Gn5.al[Gn5.SCENERY.ordinal()][Gn5.PLAYER_AS_ROBOT.ordinal()] = false;
        Gn5.al[Gn5.SCENERY.ordinal()][Gn5.PLAYER_AS_CAR.ordinal()] = false;
        Gn5.al[Gn5.SCENERY.ordinal()][Gn5.PLAYER_AS_BODY.ordinal()] = false;
        Gn5.al[Gn5.PLAYER_AS_ROBOT.ordinal()][Gn5.SCENERY.ordinal()] = false;
        Gn5.al[Gn5.PLAYER_AS_CAR.ordinal()][Gn5.SCENERY.ordinal()] = false;
        Gn5.al[Gn5.PLAYER_AS_BODY.ordinal()][Gn5.SCENERY.ordinal()] = false;
        Gn5.al[Gn5.SCENERY.ordinal()][Gn5.CAR_WHEELS.ordinal()] = false;
        Gn5.al[Gn5.CAR_WHEELS.ordinal()][Gn5.SCENERY.ordinal()] = false;
    }
}
