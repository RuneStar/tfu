// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import java.util.ArrayList;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.scenegraph.Scene;
import tfu.Bb4;

abstract class V385
{
    final Bb4 q;
    
    final void j() {
        try {
            if (!client.ca.isEmpty()) {
                SceneGraphNode sceneGraphNode = Scene.t(client.mm, this.q);
                if (sceneGraphNode != null) {
                    while (SceneGraphNode.a(sceneGraphNode) != null) {
                        sceneGraphNode = SceneGraphNode.a(sceneGraphNode);
                    }
                    if (sceneGraphNode instanceof GameEntity) {
                        final Ap386 ap386 = client.ca.get(sceneGraphNode);
                        if (ap386 != null) {
                            if (ap386.g == null) {
                                ap386.g = new ArrayList();
                            }
                            ap386.g.add(this);
                            return;
                        }
                    }
                }
            }
            this.g();
        }
        catch (Exception ex) {
            System.out.print("Error processing broadcast packet: ");
            ex.printStackTrace(System.out);
        }
    }
    
    V385(final Bb4 q) {
        this.q = q;
    }
    
    abstract void g();
}
