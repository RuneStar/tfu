package rs2.client.lua;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.cursortype.CursorType;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("JavaMouse")
public class Mouse2ScriptAPI {
   private static final Logger logger = LoggerFactory.getLogger(Mouse2ScriptAPI.class);

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetDefaultCursor(String var0) {
   }

   private static int g(String var0) {
      int var1 = StringTools.l(var0);

      for(int var2 = 0; var2 < client.en.num; ++var2) {
         CursorType var3 = client.en.list(var2);
         if (var3.hash32 == var1) {
            return var2;
         }
      }

      logger.warn("Could not find a cursor called {}", var0);
      return -1;
   }

   public static final native void initNativeMouse(long var0);

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetCursor(String var0) {
      int var1 = g(var0);
      if (var1 != -1) {
         client.af(var1);
      }

   }
}
