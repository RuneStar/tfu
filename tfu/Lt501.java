/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.La499;
import tfu.Lv148;

public enum Lt501 {
    PING("Ping: %dms"),
    FPS("FPS: %.1f"),
    FPSAverage("Average: %.1f"),
    FPSL("Low: %.1f"),
    FPSH("High: %.1f"),
    FPS_TRACKING_PAUSED("FPS Tracking Paused: %d"),
    PPS_TRACKING_PAUSED("PPS Tracking Paused: %d"),
    LPS("LPS: %.1f"),
    PPS("PPS: %.1f"),
    FRAMES_AHEAD("frames ahead: %d"),
    POSITION("LocXYZ CamFace: %s"),
    NPCS("NPCs: %d"),
    PLAYERS("Players: %d"),
    BOT_NUMBER("%s"),
    JAVA_MEMORY("Java memory: %s"),
    LUA_MEMORY("Lua memory: %.2fMB"),
    SCENE_NODES("Scene graph node: %d"),
    GAME_ENTITIES("Game entities: %d"),
    SCRIPTEVENTS_TRIGGERED("ScrEvt Calls (Hdlrs/sec): %d"),
    SCRIPTEVENTS_HANDLERSEXIST("ScrEvt (Hdlrs All): %d"),
    SCRIPTEVENTS_HANDLERSACTIVE("ScrEvt (Hdlrs Active): %d");
    
    private String i;
    private La499 o;

    public static void d(Lt501 lt501, double d) {
        if (lt501.o == null) {
            lt501.o = Lv148.j(lt501.i);
        }
        if (lt501.o != null) {
            lt501.o.g(d);
        }
    }

    public static void g(Lt501 lt501, String string) {
        if (lt501.o == null) {
            lt501.o = Lv148.j(lt501.i);
        }
        if (lt501.o != null) {
            lt501.o.d(string);
        }
    }

    private Lt501(String string2) {
        this.i = string2;
    }
}

