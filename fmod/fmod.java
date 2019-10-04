// 
// Decompiled by Procyon v0.5.36
// 

package fmod;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class fmod
{
    public static boolean b;
    public static final int d = 0;
    public static K560 e;
    public static final long h = 274951L;
    public static int j;
    public static boolean l;
    private static final Logger logger;
    public static final int q = 1;
    public static U240 s;
    
    public static U240 g() {
        return fmod.s = new U240(Sys_Create());
    }
    
    public static E245 d() {
        final E245 e245 = new E245(CreateEventSystem());
        fmod.s = e245.q();
        return e245;
    }
    
    public static native int getChannelsPlaying();
    
    public static native int getMemoryUsed();
    
    public static native int Sound_getLength(final long p0, final int p1);
    
    public static native int EventSystem_setMediaPath(final long p0, final String p1);
    
    public static native int EventGroup_getNumEvents(final long p0);
    
    public static native int Event_setPitch(final long p0, final float p1, final int p2);
    
    public static native long EventSystem_getCategoryByIndex(final long p0, final int p1);
    
    public static native String Event_getInfo(final long p0);
    
    public static native int EventSystem_getNumProjects(final long p0);
    
    public static native long Event_getParentGroup(final long p0);
    
    public static native void EventReverb_release(final long p0);
    
    private static native long Sys_Create();
    
    public static native int EventSystem_set3DListenerAttributes(final long p0, final int p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13);
    
    public static native long EventSystem_create3dReverb(final long p0, final String p1);
    
    public static native int Event_stop(final long p0);
    
    public static native long EventSystem_loadFromMemory(final long p0, final byte[] p1);
    
    public static native long EventSystem_getEvent(final long p0, final String p1, final int p2);
    
    private static native long CreateEventSystem();
    
    public static native String EventSystem_getWaveBanksNeeded(final long p0, final String p1);
    
    public static native long Event_getCategory(final long p0);
    
    public static native long Event_getChannelGroup(final long p0);
    
    public static native long EventSystem_getSystemObject(final long p0);
    
    public static native String EventProject_getWaveBanksNeeded(final long p0);
    
    public static native int EventParameter_keyOff(final long p0);
    
    public static native int Event_getState(final long p0);
    
    public static native void EventReverb_setActive(final long p0, final boolean p1);
    
    public static native int Event_set3DAttributes(final long p0, final float p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9);
    
    public static native int Event_setMute(final long p0, final boolean p1);
    
    public static native int Event_setPaused(final long p0, final boolean p1);
    
    public static native int EventGroup_freeEventData(final long p0, final long p1, final boolean p2);
    
    public static native int Event_setVolume(final long p0, final float p1);
    
    public static native int EventSystem_getNumCategories(final long p0);
    
    public static native int EventProject_getNumGroups(final long p0);
    
    public static native int Event_stopImmediate(final long p0);
    
    public static native String Event_getWaveBanksNeeded(final long p0);
    
    public static native int EventSystem_release(final long p0);
    
    public static native void Event_setPropertyByIndex(final long p0, final int p1, final float p2);
    
    public static native int ChannelGroup_getNumChannels(final long p0);
    
    public static native float Event_release(final long p0, final boolean p1, final boolean p2);
    
    public static native long EventGroup_getEventByIndex(final long p0, final int p1, final int p2);
    
    public static native long EventGroup_getGroupByIndex(final long p0, final int p1, final boolean p2);
    
    public static native String EventGroup_getInfo(final long p0);
    
    public static native void EventSystem_update(final long p0);
    
    public static native int EventGroup_getNumGroups(final long p0);
    
    public static native long EventProject_getGroupByIndex(final long p0, final int p1, final boolean p2);
    
    public static native String EventProject_getInfo(final long p0);
    
    public static native int EventProject_stopAllEvents(final long p0, final boolean p1);
    
    public static native int EventSystem_init(final long p0, final int p1, final long p2, final int p3);
    
    public static native long EventCategory_getInfo(final long p0, final B561 p1);
    
    public static native int EventCategory_setVolume(final long p0, final float p1);
    
    public static native long ChannelGroup_getChannel(final long p0, final int p1);
    
    public static native int EventParameter_setValue(final long p0, final float p1);
    
    public static native long Channel_getCurrentSound(final long p0);
    
    public static native int Channel_getPosition(final long p0, final int p1);
    
    public static native int Channel_setPosition(final long p0, final int p1, final int p2);
    
    public static native void Event_setIntPropertyByIndex(final long p0, final int p1, final int p2);
    
    public static native int Event_getIntPropertyByIndex(final long p0, final int p1);
    
    public static native void EventReverb_set3DAttributes(final long p0, final float p1, final float p2, final float p3, final float p4, final float p5);
    
    public static void q(final K560 e) {
        fmod.e = e;
    }
    
    public static R257[] j(String replace) {
        replace = replace.replace(" ", "");
        final String[] split = replace.split(",");
        final R257[] array = new R257[split.length];
        for (int i = 0; i < array.length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length == 2) {
                array[i] = new R257();
                array[i].g = split2[0];
                array[i].d = split2[1];
            }
        }
        return array;
    }
    
    static {
        logger = LoggerFactory.getLogger(fmod.class);
        fmod.j = 1;
        fmod.e = null;
        fmod.b = false;
        fmod.l = true;
    }
    
    public static native long Event_getParameter(final long p0, final String p1);
    
    public static native long EventSystem_getProjectByIndex(final long p0, final int p1);
    
    public static native int Event_start(final long p0);
}
