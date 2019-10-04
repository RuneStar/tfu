package fmod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class fmod {
   public static boolean b = false;
   public static final int d = 0;
   public static K560 e = null;
   public static final long h = 274951L;
   public static int j = 1;
   public static boolean l = true;
   private static final Logger logger = LoggerFactory.getLogger(fmod.class);
   public static final int q = 1;
   public static U240 s;

   public static U240 g() {
      s = new U240(Sys_Create());
      return s;
   }

   public static E245 d() {
      E245 var0 = new E245(CreateEventSystem());
      s = var0.q();
      return var0;
   }

   public static native int getChannelsPlaying();

   public static native int getMemoryUsed();

   public static native int Sound_getLength(long var0, int var2);

   public static native int EventSystem_setMediaPath(long var0, String var2);

   public static native int EventGroup_getNumEvents(long var0);

   public static native int Event_setPitch(long var0, float var2, int var3);

   public static native long EventSystem_getCategoryByIndex(long var0, int var2);

   public static native String Event_getInfo(long var0);

   public static native int EventSystem_getNumProjects(long var0);

   public static native long Event_getParentGroup(long var0);

   public static native void EventReverb_release(long var0);

   private static native long Sys_Create();

   public static native int EventSystem_set3DListenerAttributes(long var0, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14);

   public static native long EventSystem_create3dReverb(long var0, String var2);

   public static native int Event_stop(long var0);

   public static native long EventSystem_loadFromMemory(long var0, byte[] var2);

   public static native long EventSystem_getEvent(long var0, String var2, int var3);

   private static native long CreateEventSystem();

   public static native String EventSystem_getWaveBanksNeeded(long var0, String var2);

   public static native long Event_getCategory(long var0);

   public static native long Event_getChannelGroup(long var0);

   public static native long EventSystem_getSystemObject(long var0);

   public static native String EventProject_getWaveBanksNeeded(long var0);

   public static native int EventParameter_keyOff(long var0);

   public static native int Event_getState(long var0);

   public static native void EventReverb_setActive(long var0, boolean var2);

   public static native int Event_set3DAttributes(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10);

   public static native int Event_setMute(long var0, boolean var2);

   public static native int Event_setPaused(long var0, boolean var2);

   public static native int EventGroup_freeEventData(long var0, long var2, boolean var4);

   public static native int Event_setVolume(long var0, float var2);

   public static native int EventSystem_getNumCategories(long var0);

   public static native int EventProject_getNumGroups(long var0);

   public static native int Event_stopImmediate(long var0);

   public static native String Event_getWaveBanksNeeded(long var0);

   public static native int EventSystem_release(long var0);

   public static native void Event_setPropertyByIndex(long var0, int var2, float var3);

   public static native int ChannelGroup_getNumChannels(long var0);

   public static native float Event_release(long var0, boolean var2, boolean var3);

   public static native long EventGroup_getEventByIndex(long var0, int var2, int var3);

   public static native long EventGroup_getGroupByIndex(long var0, int var2, boolean var3);

   public static native String EventGroup_getInfo(long var0);

   public static native void EventSystem_update(long var0);

   public static native int EventGroup_getNumGroups(long var0);

   public static native long EventProject_getGroupByIndex(long var0, int var2, boolean var3);

   public static native String EventProject_getInfo(long var0);

   public static native int EventProject_stopAllEvents(long var0, boolean var2);

   public static native int EventSystem_init(long var0, int var2, long var3, int var5);

   public static native long EventCategory_getInfo(long var0, B561 var2);

   public static native int EventCategory_setVolume(long var0, float var2);

   public static native long ChannelGroup_getChannel(long var0, int var2);

   public static native int EventParameter_setValue(long var0, float var2);

   public static native long Channel_getCurrentSound(long var0);

   public static native int Channel_getPosition(long var0, int var2);

   public static native int Channel_setPosition(long var0, int var2, int var3);

   public static native void Event_setIntPropertyByIndex(long var0, int var2, int var3);

   public static native int Event_getIntPropertyByIndex(long var0, int var2);

   public static native void EventReverb_set3DAttributes(long var0, float var2, float var3, float var4, float var5, float var6);

   public static void q(K560 var0) {
      e = var0;
   }

   public static R257[] j(String var0) {
      var0 = var0.replace(" ", "");
      String[] var1 = var0.split(",");
      R257[] var2 = new R257[var1.length];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         String[] var4 = var1[var3].split("=");
         if (var4.length == 2) {
            var2[var3] = new R257();
            var2[var3].g = (String)var4[0];
            var2[var3].d = var4[1];
         }
      }

      return var2;
   }

   public static native long Event_getParameter(long var0, String var2);

   public static native long EventSystem_getProjectByIndex(long var0, int var2);

   public static native int Event_start(long var0);
}
