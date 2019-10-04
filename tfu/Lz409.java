/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.worldelement.player;
import rs2.shared.movement.E181;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.movement.X382;
import tfu.Bb4;
import tfu.Gc330;
import tfu.Lg498;
import tfu.Lh494;
import tfu.Lj497;
import tfu.Lq191;
import tfu.Lw500;

public class Lz409
implements LossyStateStreamSynchronizerListener {
    static final float a = 0.1f;
    static Map af;
    static int ag;
    static Map ai;
    static Map al;
    static int aq;
    public static int b;
    static float c;
    public static final Lz409 d;
    public static Q7 e;
    static final float f = 0.1f;
    public static final int h = 2;
    static final float i = 0.05f;
    static final float k = 0.2f;
    public static int l;
    private static final Logger logger;
    static final float m = 0.2f;
    static final float n = 0.2f;
    static final float o = 0.1f;
    static long p;
    public static boolean q;
    static long[] r;
    static int s;
    static final float t = 0.2f;
    static final float u = 0.4f;
    static int v;
    public static long w;
    static final Set x;
    static long y;
    static final float z = 0.1f;
    private int j = -1;

    public static void b(Lz409 lz409) {
        int n = -1;
        for (Integer n2 : x) {
            if (!ai.containsKey(n2)) continue;
            n = n2;
        }
        if (n != -1) {
            lz409.l(n);
        }
    }

    void l(int n) {
        Object n4;
        Object object;
        Iterator iterator;
        Object object2;
        Collection<Object> collection;
        int n2 = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, this.j);
        if (n2 != 2) {
            l += n2 / 2 - 1;
        }
        this.j = n;
        w = System.currentTimeMillis();
        long l = System.nanoTime();
        if (p != 0L) {
            long l2 = l - p;
            y -= r[v];
            Lz409.r[Lz409.v] = l2;
            y += l2;
            v = (v + 1) % r.length;
        }
        p = l;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Object object4 = x.iterator();
        while (object4.hasNext() && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, (Integer)((Object)(collection = (Integer)object4.next()))) >= 0) {
            linkedList.add((Integer)((Object)collection));
        }
        object4 = linkedList.iterator();
        while (object4.hasNext()) {
            collection = (Integer)object4.next();
            x.remove(collection);
        }
        if (ag != -1) {
            int n3 = ag;
            while (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n3, n) < 0) {
                ai.remove(n3);
                n3 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n3, 1);
            }
            ag = n;
            if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(aq, ag) <= 0) {
                aq = -1;
                ag = -1;
            }
        }
        if ((object4 = (Lj497)ai.get(n)) == null) {
            return;
        }
        c = 0.0f;
        al.clear();
        af.clear();
        for (Map.Entry object5 : ((Lj497)object4).g.entrySet()) {
            Object n6 = Gc330.e((Integer)object5.getKey());
            if (n6 == null || !((player)n6).c.hasExplicitState(n)) continue;
            n4 = (E181)((player)n6).c.getState(n);
            iterator = ((E181)n4).g;
            if (n6 == Gc330.j()) {
                e = iterator;
            }
            Q7 q7 = (Q7)object5.getValue();
            object = ((E181)n4).d;
            object2 = (Vector3)((Lj497)object4).d.get(object5.getKey());
            Vector3 vector3 = ((E181)n4).q;
            Vector3 vector32 = (Vector3)((Lj497)object4).q.get(object5.getKey());
            Lw500 lw500 = new Lw500(Vector3.k(((Q7)iterator).g, q7.g), q7.d.q().b().s().r(((Q7)iterator).d.q().b()), Vector3.k((Vector3)object, (Vector3)object2), Vector3.k(vector3, vector32));
            if (Vector3.f(lw500.g) > 10.0f) {
                logger.warn("Snapping player {}", (Object)((player)n6).aq);
                PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)player.eb((GameEntity)n6, PlayerPhysicsComponent.class);
                if (playerPhysicsComponent == null) continue;
                PlayerPhysicsAvatar.e(playerPhysicsComponent.getAvatar(false), iterator);
                continue;
            }
            al.put(object5.getKey(), lw500);
        }
        collection = Collections.emptySet();
        if (client.mm != null) {
            collection = client.mm.x(ScheduledMovementComponent.class);
        }
        for (Object n6 : collection) {
            int n3 = n6.getEntity().bg.h();
            if (!((Lj497)object4).j.containsKey(n3) || (iterator = ScheduledMovementComponent.r((ScheduledMovementComponent)n6, n)) == null) continue;
            Q7 q7 = ((E181)iterator).g;
            object = (Q7)((Lj497)object4).j.get(n3);
            object2 = new Lw500(Vector3.k(q7.g, ((Q7)object).g), ((Q7)object).d.q().b().s().r(q7.d.q().b()), null, null);
            if (Vector3.f(((Lw500)object2).g) > 10.0f) {
                logger.warn("Snapping npc {}", (Object)n6.getEntity().bg.toString());
                ScheduledMovementComponent.v((ScheduledMovementComponent)n6, q7);
                continue;
            }
            af.put(n3, object2);
        }
        int n5 = n;
        int n6 = 0;
        while (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n5, aq) <= 0 && (n4 = (Lj497)ai.get(n5)) != null) {
            for (Map.Entry entry : ((Lj497)n4).g.entrySet()) {
                object = (Lw500)al.get(entry.getKey());
                if (object == null) continue;
                object2 = (Q7)entry.getValue();
                entry.setValue(Lz409.w((Q7)object2, ((Lw500)object).g, ((Lw500)object).d, 0.1f, 0.4f, 0.2f));
            }
            for (Map.Entry entry : ((Lj497)n4).d.entrySet()) {
                object = (Lw500)al.get(entry.getKey());
                if (object == null) continue;
                object2 = (Vector3)entry.getValue();
                entry.setValue(Vector3.n((Vector3)object2, ((Lw500)object).q, 0.2f));
            }
            for (Map.Entry entry : ((Lj497)n4).q.entrySet()) {
                object = (Lw500)al.get(entry.getKey());
                if (object == null) continue;
                object2 = (Vector3)entry.getValue();
                entry.setValue(Vector3.n((Vector3)object2, ((Lw500)object).j, 0.2f));
            }
            for (Map.Entry entry : ((Lj497)n4).j.entrySet()) {
                object = (Lw500)af.get(entry.getKey());
                if (object == null) continue;
                object2 = (Q7)entry.getValue();
                entry.setValue(Lz409.w((Q7)object2, ((Lw500)object).g, ((Lw500)object).d, 0.1f, 0.4f, 0.2f));
            }
            n5 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n5, 1);
            ++n6;
        }
    }

    static Q7 w(Q7 q7, Vector3 vector3, Quaternion quaternion, float f, float f2, float f3) {
        Quaternion quaternion2 = q7.d.q().p(q7.d.q().r(quaternion).b(), f3);
        Vector3 vector32 = Vector3.al(new Vector3(0.0f, 1.0f, 0.0f), quaternion2);
        Vector3 vector33 = Vector3.ai(vector32, Vector3.o(vector3, vector32));
        Vector3 vector34 = Vector3.k(vector3, vector33);
        Vector3 vector35 = Vector3.n(Vector3.n(q7.g, vector33, f), vector34, f2);
        return new Q7(quaternion2.m(), vector35);
    }

    @Override
    public void newStateReceived(LossyStateStreamSynchronizer lossyStateStreamSynchronizer, LossyStateStream lossyStateStream, StateWrapper stateWrapper, long l) {
        int n;
        int n2;
        int n3 = lossyStateStream.id & 0xFF000000;
        if (n3 == 33554432 && l >= 0L && (n2 = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, n = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, Lq191.j() - client.dz))) < 0) {
            ++b;
        }
        if (n3 != 67108864 && n3 != 83886080 && n3 != 100663296) {
            return;
        }
        if (this.j != -1 && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, this.j) <= 0) {
            logger.info("Not processing old dynamic state packet {} {}", this.j, (Object)stateWrapper.timestamp);
            return;
        }
        if (client.y(client.ac)) {
            return;
        }
        if (!q) {
            return;
        }
        n = stateWrapper.timestamp;
        player player2 = Gc330.j();
        if (player2 == null) {
            return;
        }
        if (!player2.ag.hasExplicitState(n)) {
            return;
        }
        X382 x382 = (X382)player2.ag.getState(n);
        for (Integer n4 : x382.g) {
            LossyStateStream lossyStateStream2 = client.dq.getStream(n4);
            if (lossyStateStream2 == null || lossyStateStream2.hasExplicitState(n)) continue;
            return;
        }
        if (ai.containsKey(n)) {
            this.l(n);
        } else {
            x.add(n);
        }
    }

    public static void v(int n) {
        Component component;
        Object object;
        Object object22;
        Lj497 lj497 = new Lj497();
        for (Object object22 : Gc330.h()) {
            E181 e181;
            component = (PlayerPhysicsComponent)player.eb((GameEntity)object22, PlayerPhysicsComponent.class);
            if (component == null || (e181 = ((PlayerPhysicsComponent)component).e(null, false)) == null) continue;
            object = e181.g;
            lj497.g.put(((player)object22).m, object);
            lj497.d.put(((player)object22).m, e181.d);
            lj497.q.put(((player)object22).m, e181.q);
        }
        Object object3 = Collections.emptySet();
        if (client.mm != null) {
            object3 = client.mm.x(ScheduledMovementComponent.class);
        }
        object22 = object3.iterator();
        while (object22.hasNext()) {
            component = (ScheduledMovementComponent)object22.next();
            int n2 = component.getEntity().bg.h();
            object = ScheduledMovementComponent.y((ScheduledMovementComponent)component);
            if (object == null) continue;
            Q7 q7 = ((E181)object).g;
            lj497.j.put(n2, q7);
        }
        ai.put(n, lj497);
        if (ag == -1) {
            ag = n;
        }
        aq = n;
    }

    @Override
    public void streamAdded(LossyStateStreamSynchronizer lossyStateStreamSynchronizer, LossyStateStream lossyStateStream, boolean bl) {
    }

    @Override
    public void streamRemoved(LossyStateStreamSynchronizer lossyStateStreamSynchronizer, LossyStateStream lossyStateStream) {
    }

    @Override
    public void newStateAddedToMaster(LossyStateStreamSynchronizer lossyStateStreamSynchronizer, LossyStateStream lossyStateStream, StateWrapper stateWrapper) {
    }

    public static int p(Lz409 lz409) {
        return lz409.j;
    }

    static {
        logger = LoggerFactory.getLogger(Lz409.class);
        d = new Lz409();
        q = true;
        e = null;
        s = 0;
        b = 0;
        l = 0;
        w = System.currentTimeMillis();
        r = new long[20];
        v = 0;
        y = 0L;
        p = 0L;
        x = new TreeSet(new Lh494());
        c = 0.0f;
        ag = -1;
        aq = -1;
        ai = new TreeMap(new Lg498());
        al = new HashMap();
        af = new HashMap();
    }

    private Lz409() {
    }

    public static void r() {
        ai.clear();
        ag = -1;
        aq = -1;
    }

    public static void x(Lz409 lz409) {
        lz409.j = -1;
    }

    public static void y() {
        Object object;
        Q7 q7;
        Map.Entry entry2;
        Object object2;
        Object object3;
        Object object4;
        if (c >= 2.0f) {
            return;
        }
        c += 1.0f;
        for (Map.Entry entry2 : al.entrySet()) {
            object2 = Gc330.e((Integer)entry2.getKey());
            if (object2 == null || (object4 = (PlayerPhysicsComponent)player.eb((GameEntity)object2, PlayerPhysicsComponent.class)) == null) continue;
            object = ((PlayerPhysicsComponent)object4).getAvatar(false);
            object3 = (Lw500)entry2.getValue();
            q7 = ((PlayerPhysicsAvatar)object).getCurrentTransform();
            if (q7 == null) continue;
            Q7 q72 = Lz409.w(q7, ((Lw500)object3).g, ((Lw500)object3).d, 0.05f, 0.2f, 0.1f);
            PlayerPhysicsAvatar.e((PlayerPhysicsAvatar)object, q72);
            Vector3 vector3 = ((PlayerPhysicsComponent)object4).getLinearVelocity(false);
            Vector3 vector32 = Vector3.z(vector3, ((Lw500)object3).q);
            PlayerPhysicsComponent.h((PlayerPhysicsComponent)object4, Vector3.av(vector3, vector32, 0.1f), true, false);
            Vector3 vector33 = ((PlayerPhysicsComponent)object4).getAngularVelocity(false);
            Vector3 vector34 = Vector3.z(vector33, ((Lw500)object3).j);
            PlayerPhysicsComponent.s((PlayerPhysicsComponent)object4, Vector3.av(vector33, vector34, 0.1f), true, false);
        }
        Object object5 = Collections.emptySet();
        if (client.mm != null) {
            object5 = client.mm.x(ScheduledMovementComponent.class);
        }
        entry2 = object5.iterator();
        while (entry2.hasNext()) {
            object2 = (ScheduledMovementComponent)entry2.next();
            object4 = object2.getEntity().bg.h();
            object = (Lw500)af.get((int)object4);
            if (object == null || (object3 = ScheduledMovementComponent.y((ScheduledMovementComponent)object2).g) == null) continue;
            q7 = Lz409.w((Q7)object3, ((Lw500)object).g, ((Lw500)object).d, 0.05f, 0.2f, 0.1f);
            ScheduledMovementComponent.v((ScheduledMovementComponent)object2, q7);
        }
    }
}

