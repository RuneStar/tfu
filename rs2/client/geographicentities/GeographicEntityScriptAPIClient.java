/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.geographicentities;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="GeographicEntitiesPRIVATE")
public class GeographicEntityScriptAPIClient {
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GeographicEntityWranglerClient getWrangler(String string) {
        return GeographicEntityWranglerClient.h(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GeographicEntityWranglerClient createWrangler(String string) {
        return GeographicEntityWranglerClient.e(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void destroyWrangler(String string) {
        GeographicEntityWranglerClient.s(string);
    }
}

