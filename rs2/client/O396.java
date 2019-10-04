/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import rs2.client.worldelement.Npc;

final class O396
extends EventHandler {
    final /* synthetic */ Vector3 d;
    final /* synthetic */ Npc g;
    final /* synthetic */ Quaternion q;

    public static void g(O396 o396, XElement xElement, Object object) {
        o396.g.bi(xElement, o396.d, o396.q);
    }

    O396(Npc npc, Vector3 vector3, Quaternion quaternion) {
        this.d = vector3;
        this.q = quaternion;
        this.g = npc;
    }
}

