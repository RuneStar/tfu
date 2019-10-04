// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Lt501
{
    LPS("LPS", 7, "LPS: %.1f"), 
    FPS("FPS", 1, "FPS: %.1f"), 
    FPSH("FPSH", 4, "High: %.1f"), 
    PING("PING", 0, "Ping: %dms"), 
    FPS_TRACKING_PAUSED("FPS_TRACKING_PAUSED", 5, "FPS Tracking Paused: %d"), 
    FPSL("FPSL", 3, "Low: %.1f"), 
    SCRIPTEVENTS_HANDLERSACTIVE("SCRIPTEVENTS_HANDLERSACTIVE", 20, "ScrEvt (Hdlrs Active): %d"), 
    PPS("PPS", 8, "PPS: %.1f"), 
    SCRIPTEVENTS_TRIGGERED("SCRIPTEVENTS_TRIGGERED", 18, "ScrEvt Calls (Hdlrs/sec): %d"), 
    SCRIPTEVENTS_HANDLERSEXIST("SCRIPTEVENTS_HANDLERSEXIST", 19, "ScrEvt (Hdlrs All): %d"), 
    BOT_NUMBER("BOT_NUMBER", 13, "%s"), 
    FPSAverage("FPSAverage", 2, "Average: %.1f"), 
    POSITION("POSITION", 10, "LocXYZ CamFace: %s"), 
    PPS_TRACKING_PAUSED("PPS_TRACKING_PAUSED", 6, "PPS Tracking Paused: %d"), 
    GAME_ENTITIES("GAME_ENTITIES", 17, "Game entities: %d"), 
    LUA_MEMORY("LUA_MEMORY", 15, "Lua memory: %.2fMB"), 
    NPCS("NPCS", 11, "NPCs: %d"), 
    FRAMES_AHEAD("FRAMES_AHEAD", 9, "frames ahead: %d"), 
    JAVA_MEMORY("JAVA_MEMORY", 14, "Java memory: %s"), 
    PLAYERS("PLAYERS", 12, "Players: %d"), 
    SCENE_NODES("SCENE_NODES", 16, "Scene graph node: %d");
    
    private String i;
    private La499 o;
    
    public static void d(final Lt501 lt501, final double n) {
        if (lt501.o == null) {
            lt501.o = Lv148.j(lt501.i);
        }
        if (lt501.o != null) {
            lt501.o.g(n);
        }
    }
    
    public static void g(final Lt501 lt501, final String s) {
        if (lt501.o == null) {
            lt501.o = Lv148.j(lt501.i);
        }
        if (lt501.o != null) {
            lt501.o.d(s);
        }
    }
    
    private Lt501(final String name, final int ordinal, final String i) {
        this.i = i;
    }
}
