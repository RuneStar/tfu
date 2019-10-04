// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.geographicentities;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("GeographicEntitiesPRIVATE")
public class GeographicEntityScriptAPIClient
{
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GeographicEntityWranglerClient getWrangler(final String s) {
        return GeographicEntityWranglerClient.h(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GeographicEntityWranglerClient createWrangler(final String s) {
        return GeographicEntityWranglerClient.e(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void destroyWrangler(final String s) {
        GeographicEntityWranglerClient.s(s);
    }
}
