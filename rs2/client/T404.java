/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.StateEventManager;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import rs2.client.Ap386;
import rs2.client.V385;
import rs2.client.client;
import rs2.shared.movement.Q40;
import tfu.Lb33;
import tfu.Ll42;

final class T404
extends EventHandler {
    public static void d(T404 t404, GameEntity gameEntity, Object object) {
        Lb33.g(Lb33.BuildXMap_XElement_trigger);
        try {
            T404.g(t404, gameEntity);
            Ap386 ap386 = (Ap386)client.ca.remove(gameEntity);
            if (ap386.g != null) {
                for (V385 v385 : ap386.g) {
                    v385.j();
                }
            }
            ++client.nw;
            client.ba();
            long l = System.currentTimeMillis();
            if (client.ca.isEmpty() || l > client.ng + 100L) {
                client.cj.event.triggerEvent("__onMapBuildPart", (Object)client.nw);
                client.nw = 0;
                client.ng = l;
            }
            if (client.ca.isEmpty()) {
                client.bb();
                client.nw = 0;
                StateEventManager.sendEvent(client.nh);
            }
            Lb33.d(Lb33.BuildXMap_XElement_trigger);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.BuildXMap_XElement_trigger);
            throw throwable;
        }
    }

    private static void g(T404 t404, GameEntity gameEntity) {
        client.gz.d(gameEntity, client.gn, client.gj, client.ds, null);
        for (SceneGraphNode sceneGraphNode : gameEntity.ai()) {
            if (!(sceneGraphNode instanceof GameEntity)) continue;
            T404.g(t404, (GameEntity)sceneGraphNode);
        }
    }

    T404() {
    }
}

