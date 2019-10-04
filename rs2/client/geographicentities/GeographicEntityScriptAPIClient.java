package rs2.client.geographicentities;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("GeographicEntitiesPRIVATE")
public class GeographicEntityScriptAPIClient {
   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GeographicEntityWranglerClient getWrangler(String var0) {
      return GeographicEntityWranglerClient.h(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static GeographicEntityWranglerClient createWrangler(String var0) {
      return GeographicEntityWranglerClient.e(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void destroyWrangler(String var0) {
      GeographicEntityWranglerClient.s(var0);
   }
}
