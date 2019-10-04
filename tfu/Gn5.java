/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public final class Gn5
extends Enum<Gn5> {
    public static final /* enum */ Gn5 ENVIRONMENT_QUERY;
    public static final /* enum */ Gn5 NPC_NODRIVECOLLIDE;
    public static final /* enum */ Gn5 NUM_GROUPS;
    public static final /* enum */ Gn5 COLLIDES_WITH_EVERYTHING;
    public static final /* enum */ Gn5 PLAYER_AS_BODY;
    public static final /* enum */ Gn5 CUSTOM_QUERY;
    public static final /* enum */ Gn5 DONT_USE;
    public static final /* enum */ Gn5 CAR_WHEELS;
    public static final /* enum */ Gn5 PHYSDEBUG_QUERY;
    public static final /* enum */ Gn5 PLAYER_AS_CAR;
    public static final /* enum */ Gn5 SCENERY_QUERY;
    public static final /* enum */ Gn5 NPC_NOPLAYERCOLLIDE;
    public static final /* enum */ Gn5 NPC_VOLUME_QUERY;
    public static final /* enum */ Gn5 PLAYER_OR_NPC_VOLUME_QUERY;
    public static final /* enum */ Gn5 HEIGHTFIELD_QUERY;
    public static final /* enum */ Gn5 CAMERA_COLLIDE;
    public static final /* enum */ Gn5 PLAYER_AS_ROBOT;
    public static final /* enum */ Gn5 SCENERY;
    public static final /* enum */ Gn5 NPC_FULLCOLLIDE;
    public static final /* enum */ Gn5 PLAYER_VOLUME_QUERY;
    public static final /* enum */ Gn5 SOUND_RAY;
    public static final /* enum */ Gn5 HEIGHTFIELD;
    public static final /* enum */ Gn5 NPC_NOCOLLIDE;
    public static final /* enum */ Gn5 CAMERA_SIGHT;
    public static final /* enum */ Gn5 TRIGGER_VOLUME;
    public static final /* enum */ Gn5 NPC_SIGHT;
    static final boolean ag = false;
    public static boolean[][] ai;
    public static boolean[][] al;
    public static boolean[][] aq;
    private static final /* synthetic */ Gn5[] $VALUES;

    public static Gn5 valueOf(String string) {
        return Enum.valueOf(Gn5.class, string);
    }

    public static Gn5[] values() {
        return (Gn5[])$VALUES.clone();
    }

    static {
        int n;
        int n2;
        DONT_USE = new Gn5();
        COLLIDES_WITH_EVERYTHING = new Gn5();
        PLAYER_AS_ROBOT = new Gn5();
        PLAYER_AS_CAR = new Gn5();
        PLAYER_AS_BODY = new Gn5();
        CAR_WHEELS = new Gn5();
        NPC_FULLCOLLIDE = new Gn5();
        NPC_NODRIVECOLLIDE = new Gn5();
        NPC_NOPLAYERCOLLIDE = new Gn5();
        NPC_NOCOLLIDE = new Gn5();
        SCENERY = new Gn5();
        HEIGHTFIELD = new Gn5();
        TRIGGER_VOLUME = new Gn5();
        CAMERA_COLLIDE = new Gn5();
        CAMERA_SIGHT = new Gn5();
        SOUND_RAY = new Gn5();
        NPC_SIGHT = new Gn5();
        PLAYER_VOLUME_QUERY = new Gn5();
        NPC_VOLUME_QUERY = new Gn5();
        PLAYER_OR_NPC_VOLUME_QUERY = new Gn5();
        SCENERY_QUERY = new Gn5();
        PHYSDEBUG_QUERY = new Gn5();
        HEIGHTFIELD_QUERY = new Gn5();
        ENVIRONMENT_QUERY = new Gn5();
        CUSTOM_QUERY = new Gn5();
        NUM_GROUPS = new Gn5();
        $VALUES = new Gn5[]{DONT_USE, COLLIDES_WITH_EVERYTHING, PLAYER_AS_ROBOT, PLAYER_AS_CAR, PLAYER_AS_BODY, CAR_WHEELS, NPC_FULLCOLLIDE, NPC_NODRIVECOLLIDE, NPC_NOPLAYERCOLLIDE, NPC_NOCOLLIDE, SCENERY, HEIGHTFIELD, TRIGGER_VOLUME, CAMERA_COLLIDE, CAMERA_SIGHT, SOUND_RAY, NPC_SIGHT, PLAYER_VOLUME_QUERY, NPC_VOLUME_QUERY, PLAYER_OR_NPC_VOLUME_QUERY, SCENERY_QUERY, PHYSDEBUG_QUERY, HEIGHTFIELD_QUERY, ENVIRONMENT_QUERY, CUSTOM_QUERY, NUM_GROUPS};
        aq = new boolean[][]{{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false}, {false, true, false, false, false, false, true, true, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false}, {false, true, false, false, false, false, true, false, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false}, {false, true, false, false, false, false, true, false, false, false, true, true, true, false, false, true, false, true, false, true, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, true, true, true, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false}, {false, true, true, false, false, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false}, {false, true, false, false, false, false, true, true, true, false, true, true, true, false, false, true, false, false, true, true, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, true, true, false, false, false, false, false}, {false, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, true, true, false, true, false}, {false, true, true, true, true, true, true, true, true, true, false, false, false, true, true, false, false, false, false, false, false, false, true, true, false}, {false, true, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, true, true, true, false, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}};
        ai = new boolean[aq.length][aq[0].length];
        for (n = 0; n < aq.length; ++n) {
            for (n2 = 0; n2 < aq[n].length; ++n2) {
                Gn5.ai[n][n2] = aq[n][n2];
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
        al = new boolean[aq.length][aq[0].length];
        for (n = 0; n < aq.length; ++n) {
            for (n2 = 0; n2 < aq[n].length; ++n2) {
                Gn5.al[n][n2] = aq[n][n2];
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

