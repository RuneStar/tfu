// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.Iterator;
import com.jagex.jnibindings.runetek6.StateEventManager;
import tfu.Lb33;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.event.EventHandler;

final class T404 extends EventHandler
{
    public static void d(final T404 t404, final GameEntity key, final Object o) {
        Lb33.g(Lb33.BuildXMap_XElement_trigger);
        try {
            g(t404, key);
            final Ap386 ap386 = client.ca.remove(key);
            if (ap386.g != null) {
                final Iterator iterator = ap386.g.iterator();
                while (iterator.hasNext()) {
                    iterator.next().j();
                }
            }
            ++client.nw;
            client.ba();
            final long currentTimeMillis = System.currentTimeMillis();
            if (client.ca.isEmpty() || currentTimeMillis > client.ng + 100L) {
                client.cj.event.triggerEvent("__onMapBuildPart", client.nw);
                client.nw = 0;
                client.ng = currentTimeMillis;
            }
            if (client.ca.isEmpty()) {
                client.bb();
                client.nw = 0;
                StateEventManager.sendEvent(client.nh);
            }
        }
        finally {
            Lb33.d(Lb33.BuildXMap_XElement_trigger);
        }
    }
    
    private static void g(final T404 t404, final GameEntity gameEntity) {
        client.gz.d(gameEntity, (float)client.gn, (float)client.gj, client.ds, null);
        for (final SceneGraphNode sceneGraphNode : gameEntity.ai()) {
            if (sceneGraphNode instanceof GameEntity) {
                g(t404, (GameEntity)sceneGraphNode);
            }
        }
    }
}
