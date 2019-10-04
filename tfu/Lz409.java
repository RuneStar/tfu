// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.TreeSet;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.X382;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.maths.Quaternion;
import java.util.Collection;
import rs2.client.worldelement.player;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.client.client;
import java.util.Collections;
import rs2.shared.movement.PlayerPhysicsAvatar;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.shared.movement.PlayerPhysicsComponent;
import com.jagex.maths.Vector3;
import rs2.shared.movement.E181;
import java.util.LinkedList;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import java.util.Map;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;

public class Lz409 implements LossyStateStreamSynchronizerListener
{
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
    private int j;
    
    public static void b(final Lz409 lz409) {
        int intValue = -1;
        for (final Integer n : Lz409.x) {
            if (Lz409.ai.containsKey(n)) {
                intValue = n;
            }
        }
        if (intValue != -1) {
            lz409.l(intValue);
        }
    }
    
    void l(final int i) {
        final int diffIDs = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(i, this.j);
        if (diffIDs != 2) {
            Lz409.l += diffIDs / 2 - 1;
        }
        this.j = i;
        Lz409.w = System.currentTimeMillis();
        final long nanoTime = System.nanoTime();
        if (Lz409.p != 0L) {
            final long n = nanoTime - Lz409.p;
            Lz409.y -= Lz409.r[Lz409.v];
            Lz409.r[Lz409.v] = n;
            Lz409.y += n;
            Lz409.v = (Lz409.v + 1) % Lz409.r.length;
        }
        Lz409.p = nanoTime;
        final LinkedList<Integer> list = new LinkedList<Integer>();
        for (final Integer n2 : Lz409.x) {
            if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(i, n2) < 0) {
                break;
            }
            list.add(n2);
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Lz409.x.remove(iterator2.next());
        }
        if (Lz409.ag != -1) {
            for (int j = Lz409.ag; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(j, i) < 0; j = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(j, 1)) {
                Lz409.ai.remove(j);
            }
            Lz409.ag = i;
            if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(Lz409.aq, Lz409.ag) <= 0) {
                Lz409.ag = (Lz409.aq = -1);
            }
        }
        final Lj497 lj497 = Lz409.ai.get(i);
        if (lj497 == null) {
            return;
        }
        Lz409.c = 0.0f;
        Lz409.al.clear();
        Lz409.af.clear();
        for (final Map.Entry<Integer, V> entry : lj497.g.entrySet()) {
            final player e = Gc330.e(entry.getKey());
            if (e != null && e.c.hasExplicitState(i)) {
                final E181 e2 = (E181)e.c.getState(i);
                final Q7 g = e2.g;
                if (e == Gc330.j()) {
                    Lz409.e = g;
                }
                final Q7 q7 = (Q7)entry.getValue();
                final Lw500 lw500 = new Lw500(Vector3.k(g.g, q7.g), q7.d.q().b().s().r(g.d.q().b()), Vector3.k(e2.d, lj497.d.get(entry.getKey())), Vector3.k(e2.q, lj497.q.get(entry.getKey())));
                if (Vector3.f(lw500.g) > 10.0f) {
                    Lz409.logger.warn("Snapping player {}", e.aq);
                    final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(e, PlayerPhysicsComponent.class);
                    if (playerPhysicsComponent == null) {
                        continue;
                    }
                    PlayerPhysicsAvatar.e(playerPhysicsComponent.getAvatar(false), g);
                }
                else {
                    Lz409.al.put(entry.getKey(), lw500);
                }
            }
        }
        Collection<Object> collection = Collections.emptySet();
        if (client.mm != null) {
            collection = (Collection<Object>)client.mm.x(ScheduledMovementComponent.class);
        }
        for (final ScheduledMovementComponent scheduledMovementComponent : collection) {
            final int h = scheduledMovementComponent.getEntity().bg.h();
            if (!lj497.j.containsKey(h)) {
                continue;
            }
            final E181 r = ScheduledMovementComponent.r(scheduledMovementComponent, i);
            if (r == null) {
                continue;
            }
            final Q7 g2 = r.g;
            final Q7 q8 = lj497.j.get(h);
            final Lw500 lw501 = new Lw500(Vector3.k(g2.g, q8.g), q8.d.q().b().s().r(g2.d.q().b()), null, null);
            if (Vector3.f(lw501.g) > 10.0f) {
                Lz409.logger.warn("Snapping npc {}", scheduledMovementComponent.getEntity().bg.toString());
                ScheduledMovementComponent.v(scheduledMovementComponent, g2);
            }
            else {
                Lz409.af.put(h, lw501);
            }
        }
        for (int sumIDs = i, n3 = 0; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(sumIDs, Lz409.aq) <= 0; sumIDs = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(sumIDs, 1), ++n3) {
            final Lj497 lj498 = Lz409.ai.get(sumIDs);
            if (lj498 == null) {
                break;
            }
            for (final Map.Entry<Object, V> entry2 : lj498.g.entrySet()) {
                final Lw500 lw502 = Lz409.al.get(entry2.getKey());
                if (lw502 != null) {
                    entry2.setValue((V)w((Q7)entry2.getValue(), lw502.g, lw502.d, 0.1f, 0.4f, 0.2f));
                }
            }
            for (final Map.Entry<Object, V> entry3 : lj498.d.entrySet()) {
                final Lw500 lw503 = Lz409.al.get(entry3.getKey());
                if (lw503 != null) {
                    entry3.setValue((V)Vector3.n((Vector3)entry3.getValue(), lw503.q, 0.2f));
                }
            }
            for (final Map.Entry<Object, V> entry4 : lj498.q.entrySet()) {
                final Lw500 lw504 = Lz409.al.get(entry4.getKey());
                if (lw504 != null) {
                    entry4.setValue((V)Vector3.n((Vector3)entry4.getValue(), lw504.j, 0.2f));
                }
            }
            for (final Map.Entry<Object, V> entry5 : lj498.j.entrySet()) {
                final Lw500 lw505 = Lz409.af.get(entry5.getKey());
                if (lw505 != null) {
                    entry5.setValue((V)w((Q7)entry5.getValue(), lw505.g, lw505.d, 0.1f, 0.4f, 0.2f));
                }
            }
        }
    }
    
    static Q7 w(final Q7 q7, final Vector3 vector3, final Quaternion quaternion, final float n, final float n2, final float n3) {
        final Quaternion p6 = q7.d.q().p(q7.d.q().r(quaternion).b(), n3);
        final Vector3 al = Vector3.al(new Vector3(0.0f, 1.0f, 0.0f), p6);
        final Vector3 ai = Vector3.ai(al, Vector3.o(vector3, al));
        return new Q7(p6.m(), Vector3.n(Vector3.n(q7.g, ai, n), Vector3.k(vector3, ai), n2));
    }
    
    @Override
    public void newStateReceived(final LossyStateStreamSynchronizer lossyStateStreamSynchronizer, final LossyStateStream lossyStateStream, final StateWrapper stateWrapper, final long n) {
        final int n2 = lossyStateStream.id & 0xFF000000;
        if (n2 == 33554432 && n >= 0L && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, Lq191.j() - client.dz)) < 0) {
            ++Lz409.b;
        }
        if (n2 != 67108864 && n2 != 83886080 && n2 != 100663296) {
            return;
        }
        if (this.j != -1 && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, this.j) <= 0) {
            Lz409.logger.info("Not processing old dynamic state packet {} {}", this.j, stateWrapper.timestamp);
            return;
        }
        if (client.y(client.ac)) {
            return;
        }
        if (!Lz409.q) {
            return;
        }
        final int timestamp = stateWrapper.timestamp;
        final player j = Gc330.j();
        if (j == null) {
            return;
        }
        if (!j.ag.hasExplicitState(timestamp)) {
            return;
        }
        final Iterator iterator = ((X382)j.ag.getState(timestamp)).g.iterator();
        while (iterator.hasNext()) {
            final LossyStateStream stream = client.dq.getStream(iterator.next());
            if (stream == null) {
                continue;
            }
            if (!stream.hasExplicitState(timestamp)) {
                return;
            }
        }
        if (Lz409.ai.containsKey(timestamp)) {
            this.l(timestamp);
        }
        else {
            Lz409.x.add(timestamp);
        }
    }
    
    public static void v(final int aq) {
        final Lj497 lj497 = new Lj497();
        for (final player player : Gc330.h()) {
            final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(player, PlayerPhysicsComponent.class);
            if (playerPhysicsComponent != null) {
                final E181 e = playerPhysicsComponent.e(null, false);
                if (e == null) {
                    continue;
                }
                lj497.g.put(player.m, e.g);
                lj497.d.put(player.m, e.d);
                lj497.q.put(player.m, e.q);
            }
        }
        Collection<Object> collection = Collections.emptySet();
        if (client.mm != null) {
            collection = (Collection<Object>)client.mm.x(ScheduledMovementComponent.class);
        }
        for (final ScheduledMovementComponent scheduledMovementComponent : collection) {
            final int h = scheduledMovementComponent.getEntity().bg.h();
            final E181 y = ScheduledMovementComponent.y(scheduledMovementComponent);
            if (y != null) {
                lj497.j.put(h, y.g);
            }
        }
        Lz409.ai.put(aq, lj497);
        if (Lz409.ag == -1) {
            Lz409.ag = aq;
        }
        Lz409.aq = aq;
    }
    
    @Override
    public void streamAdded(final LossyStateStreamSynchronizer lossyStateStreamSynchronizer, final LossyStateStream lossyStateStream, final boolean b) {
    }
    
    @Override
    public void streamRemoved(final LossyStateStreamSynchronizer lossyStateStreamSynchronizer, final LossyStateStream lossyStateStream) {
    }
    
    @Override
    public void newStateAddedToMaster(final LossyStateStreamSynchronizer lossyStateStreamSynchronizer, final LossyStateStream lossyStateStream, final StateWrapper stateWrapper) {
    }
    
    public static int p(final Lz409 lz409) {
        return lz409.j;
    }
    
    static {
        logger = LoggerFactory.getLogger(Lz409.class);
        d = new Lz409();
        Lz409.q = true;
        Lz409.e = null;
        Lz409.s = 0;
        Lz409.b = 0;
        Lz409.l = 0;
        Lz409.w = System.currentTimeMillis();
        Lz409.r = new long[20];
        Lz409.v = 0;
        Lz409.y = 0L;
        Lz409.p = 0L;
        x = new TreeSet(new Lh494());
        Lz409.c = 0.0f;
        Lz409.ag = -1;
        Lz409.aq = -1;
        Lz409.ai = new TreeMap(new Lg498());
        Lz409.al = new HashMap();
        Lz409.af = new HashMap();
    }
    
    private Lz409() {
        this.j = -1;
    }
    
    public static void r() {
        Lz409.ai.clear();
        Lz409.ag = -1;
        Lz409.aq = -1;
    }
    
    public static void x(final Lz409 lz409) {
        lz409.j = -1;
    }
    
    public static void y() {
        if (Lz409.c >= 2.0f) {
            return;
        }
        ++Lz409.c;
        for (final Map.Entry<Integer, V> entry : Lz409.al.entrySet()) {
            final player e = Gc330.e(entry.getKey());
            if (e != null) {
                final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(e, PlayerPhysicsComponent.class);
                if (playerPhysicsComponent == null) {
                    continue;
                }
                final PlayerPhysicsAvatar avatar = playerPhysicsComponent.getAvatar(false);
                final Lw500 lw500 = (Lw500)entry.getValue();
                final Q7 currentTransform = avatar.getCurrentTransform();
                if (currentTransform == null) {
                    continue;
                }
                PlayerPhysicsAvatar.e(avatar, w(currentTransform, lw500.g, lw500.d, 0.05f, 0.2f, 0.1f));
                final Vector3 linearVelocity = playerPhysicsComponent.getLinearVelocity(false);
                PlayerPhysicsComponent.h(playerPhysicsComponent, Vector3.av(linearVelocity, Vector3.z(linearVelocity, lw500.q), 0.1f), true, false);
                final Vector3 angularVelocity = playerPhysicsComponent.getAngularVelocity(false);
                PlayerPhysicsComponent.s(playerPhysicsComponent, Vector3.av(angularVelocity, Vector3.z(angularVelocity, lw500.j), 0.1f), true, false);
            }
        }
        Collection<Object> collection = Collections.emptySet();
        if (client.mm != null) {
            collection = (Collection<Object>)client.mm.x(ScheduledMovementComponent.class);
        }
        for (final ScheduledMovementComponent scheduledMovementComponent : collection) {
            final Lw500 lw501 = Lz409.af.get(scheduledMovementComponent.getEntity().bg.h());
            if (lw501 == null) {
                continue;
            }
            final Q7 g = ScheduledMovementComponent.y(scheduledMovementComponent).g;
            if (g == null) {
                continue;
            }
            ScheduledMovementComponent.v(scheduledMovementComponent, w(g, lw501.g, lw501.d, 0.05f, 0.2f, 0.1f));
        }
    }
}
