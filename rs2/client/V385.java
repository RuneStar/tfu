/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import rs2.client.Ap386;
import rs2.client.client;
import tfu.Bb4;

abstract class V385 {
    final Bb4 q;

    final void j() {
        try {
            SceneGraphNode sceneGraphNode;
            if (!client.ca.isEmpty() && (sceneGraphNode = Scene.t(client.mm, this.q)) != null) {
                Ap386 ap386;
                SceneGraphNode sceneGraphNode2;
                while (SceneGraphNode.a(sceneGraphNode) != null) {
                    sceneGraphNode = SceneGraphNode.a(sceneGraphNode);
                }
                if (sceneGraphNode instanceof GameEntity && (ap386 = (Ap386)client.ca.get(sceneGraphNode2 = sceneGraphNode)) != null) {
                    if (ap386.g == null) {
                        ap386.g = new ArrayList();
                    }
                    ap386.g.add(this);
                    return;
                }
            }
            this.g();
        }
        catch (Exception exception) {
            System.out.print("Error processing broadcast packet: ");
            exception.printStackTrace(System.out);
        }
    }

    V385(Bb4 bb4) {
        this.q = bb4;
    }

    abstract void g();
}

