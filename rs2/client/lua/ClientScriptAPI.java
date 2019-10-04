// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.maths.H303;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.maths.Matrix4;
import com.jagex.maths.F304;
import java.util.Iterator;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import rs2.shared.movement.PhysicsWorldWrapper;
import java.util.Comparator;
import java.util.Arrays;
import rs2.shared.movement.CollisionObjectData;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Quaternion;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import java.util.ArrayList;
import com.jagex.maths.Vector3;
import tfu.Gn5;
import com.jagex.game.runetek6.script.ScriptDefaults;
import tfu.Gc330;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import rs2.client.client;
import rs2.client.ScriptCamera;
import java.util.Vector;
import java.util.List;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("Client")
public class ClientScriptAPI
{
    private static Q344 d;
    public static List g;
    
    static {
        ClientScriptAPI.g = new Vector();
        ClientScriptAPI.d = new G347();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean addCamera(final ScriptCamera scriptCamera) {
        scriptCamera.et(ClientScriptAPI.d);
        if (client.mm != null) {
            client.mm.add(scriptCamera);
        }
        return ClientScriptAPI.g.add(scriptCamera);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity GetSelfGameEntity() {
        return Gc330.j();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity[] getEntitiesInCameraFrustum(@ScriptDefaults(defaultNumber = 0.0) final float n, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n2, @ScriptDefaults(defaultBoolean = false) final boolean b, @ScriptDefaults(defaultInteger = 1000) final int n3) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        if (client.gz == null || client.gz.d == null) {
            return new GameEntity[0];
        }
        final Vector3[] g = g(null, n);
        if (g == null) {
            return new GameEntity[0];
        }
        final PhysicsWorldWrapper g2 = client.dc.g(g[0]);
        Vector3 g3 = null;
        if (b) {
            g3 = Vector3.g(0.5f * (g[0].x + g[3].x), 0.5f * (g[0].y + g[3].y), 0.5f * (g[0].z + g[3].z));
        }
        if (g2 != null) {
            final Vector3 g4 = Vector3.g(0.25f * (g[0].x + g[3].x + g[4].x + g[7].x), 0.25f * (g[0].y + g[3].y + g[4].y + g[7].y), 0.25f * (g[0].z + g[3].z + g[4].z + g[7].z));
            for (int i = 0; i < g.length; ++i) {
                g[i] = Vector3.k(g[i], g4);
            }
            final E6 b2 = g2.d.b(g);
            final ArrayList<L8> list = new ArrayList<L8>();
            g2.d.al(b2, Q7.g(new RotTrans(Quaternion.g, g4)), ordinal, n2, list, n3);
            g2.d.t(b2);
            int n4 = 0;
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (((CollisionObjectData)g2.d.ap(iterator.next().g)).d != null) {
                    ++n4;
                }
            }
            GameEntity[] a = new GameEntity[0];
            if (n4 > 0) {
                a = new GameEntity[n4];
                int n5 = 0;
                final Iterator<Object> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    final CollisionObjectData collisionObjectData = (CollisionObjectData)g2.d.ap(iterator2.next().g);
                    if (collisionObjectData.d != null) {
                        a[n5++] = collisionObjectData.d;
                    }
                }
                if (b) {
                    Arrays.sort(a, new D346(g3));
                }
            }
            return a;
        }
        return new GameEntity[0];
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static RotTrans clientToServerTransform(final RotTrans rotTrans) {
        return rotTrans.w((float)client.gn, 0.0f, (float)client.gj);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static RotTrans serverToClientTransform(final RotTrans rotTrans) {
        return rotTrans.v((float)client.gn, 0.0f, (float)client.gj);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 clientToServerPos(final Vector3 vector3) {
        return Vector3.m(vector3, (float)client.gn, 0.0f, (float)client.gj);
    }
    
    public static Vector3[] g(Vector3[] array, final float n) {
        if (array == null) {
            array = new Vector3[8];
        }
        final Matrix4 j = client.bl.j();
        final Vector3 g = Vector3.g(-1.0f, -1.0f, 0.0f);
        final Vector3 g2 = Vector3.g(1.0f, 1.0f, 1.0f);
        final F304 f304 = new F304();
        for (int i = 0; i < 8; ++i) {
            f304.g = ((i / 1 % 2 == 0) ? g.x : g2.x);
            f304.d = ((i / 2 % 2 == 0) ? g.y : g2.y);
            f304.q = ((i / 4 % 2 == 0) ? g.z : g2.z);
            f304.j = 1.0f;
            F304.h(f304, j);
            array[i] = new Vector3(f304.g / f304.j, f304.d / f304.j, f304.q / f304.j);
        }
        if (n != 0.0f) {
            final float n2 = n / Vector3.f(Vector3.k(Vector3.g(0.5f * (array[4].x + array[7].x), 0.5f * (array[4].y + array[7].y), 0.5f * (array[4].z + array[7].z)), Vector3.g(0.5f * (array[0].x + array[3].x), 0.5f * (array[0].y + array[3].y), 0.5f * (array[0].z + array[3].z))));
            for (int k = 0; k < 4; ++k) {
                array[4 + k] = Vector3.av(array[k], array[4 + k], n2);
            }
        }
        return array;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int GetBotCount() {
        return Gc330.j.size();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static GameEntity GetBotEntity(final int index) {
        return Gc330.j.get(index);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getCameraHeading() {
        final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
        if (activeCamera != null) {
            final Vector3 al = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), activeCamera.getWorldTransform().rot);
            return (float)Math.atan2(al.x, al.z);
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getavh(final float n, final float n2) {
        return client.bh(n, n2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3[] getPhysicsRayFromPixelSpace(final float n, final float n2) {
        final float n3 = n / GameShell3.canvasWid * 2.0f - 1.0f;
        final float n4 = -(n2 / GameShell3.canvasHei * 2.0f - 1.0f);
        final float[] array = { n3, n4, 0.0f };
        final float[] array2 = { n3, n4, 1.0f };
        final Matrix4 j = client.ar.j();
        final float s = Matrix4.s(j, array[0], array[1], array[2]);
        final float s2 = Matrix4.s(j, array2[0], array2[1], array2[2]);
        Matrix4.h(j, array);
        Matrix4.h(j, array2);
        final float[] array3 = array;
        final int n5 = 0;
        array3[n5] /= s;
        final float[] array4 = array;
        final int n6 = 1;
        array4[n6] /= s;
        final float[] array5 = array;
        final int n7 = 2;
        array5[n7] /= s;
        final float[] array6 = array2;
        final int n8 = 0;
        array6[n8] /= s2;
        final float[] array7 = array2;
        final int n9 = 1;
        array7[n9] /= s2;
        final float[] array8 = array2;
        final int n10 = 2;
        array8[n10] /= s2;
        H303.w(client.ax, array);
        H303.w(client.ax, array2);
        return new Vector3[] { new Vector3(array[0] + client.gn, array[1], array[2] + client.gj), new Vector3(array2[0] + client.gn, array2[1], array2[2] + client.gj) };
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 serverToClientPos(final Vector3 vector3) {
        return Vector3.i(vector3, (float)client.gn, 0.0f, (float)client.gj);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Scene getScene() {
        return client.mm;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 getCameraNearPlaneCentre() {
        final Vector3[] g = g(null, 0.0f);
        if (g == null) {
            return null;
        }
        if (client.dc.g(g[0]) != null) {
            final Vector3 vector3 = g[0];
            final Vector3 vector4 = g[3];
            return new Vector3(0.5f * (vector3.x + vector4.x), 0.5f * (vector3.y + vector4.y), 0.5f * (vector3.z + vector4.z));
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean removeCamera(final ScriptCamera scriptCamera, @ScriptDefaults(defaultBoolean = true) final boolean b) {
        GameEntity.eu(scriptCamera, ClientScriptAPI.d);
        if (client.mm != null) {
            client.mm.remove(scriptCamera, true, b);
        }
        return ClientScriptAPI.g.remove(scriptCamera);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void GameConNoTimout() {
        client.au();
    }
    
    public static final native void setNativeSelfGameEntity(final long p0, final long p1, final GameEntity p2);
}
