/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.F304;
import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import rs2.client.ScriptCamera;
import rs2.client.client;
import rs2.client.lua.D346;
import rs2.client.lua.G347;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.I187;
import rs2.shared.movement.PhysicsWorldWrapper;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gc330;
import tfu.Gn5;
import tfu.Ll42;

@ScriptEntryClass(value="Client")
public class ClientScriptAPI {
    private static Q344 d;
    public static List g;

    static {
        g = new Vector();
        d = new G347();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean addCamera(ScriptCamera scriptCamera) {
        scriptCamera.et(d);
        if (client.mm != null) {
            client.mm.add(scriptCamera);
        }
        return g.add(scriptCamera);
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
    public static GameEntity[] getEntitiesInCameraFrustum(@ScriptDefaults(defaultNumber=0.0) float f, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultBoolean=false) boolean bl, @ScriptDefaults(defaultInteger=1000) int n3) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        if (client.gz == null || client.gz.d == null) {
            return new GameEntity[0];
        }
        Vector3[] arrvector3 = ClientScriptAPI.g(null, f);
        if (arrvector3 != null) {
            PhysicsWorldWrapper physicsWorldWrapper = client.dc.g(arrvector3[0]);
            Vector3 vector3 = null;
            if (bl) {
                vector3 = Vector3.g(0.5f * (arrvector3[0].x + arrvector3[3].x), 0.5f * (arrvector3[0].y + arrvector3[3].y), 0.5f * (arrvector3[0].z + arrvector3[3].z));
            }
            if (physicsWorldWrapper != null) {
                Vector3 vector32 = Vector3.g(0.25f * (arrvector3[0].x + arrvector3[3].x + arrvector3[4].x + arrvector3[7].x), 0.25f * (arrvector3[0].y + arrvector3[3].y + arrvector3[4].y + arrvector3[7].y), 0.25f * (arrvector3[0].z + arrvector3[3].z + arrvector3[4].z + arrvector3[7].z));
                for (int i = 0; i < arrvector3.length; ++i) {
                    arrvector3[i] = Vector3.k(arrvector3[i], vector32);
                }
                E6 e6 = physicsWorldWrapper.d.b(arrvector3);
                ArrayList arrayList = new ArrayList();
                RotTrans rotTrans = new RotTrans(Quaternion.g, vector32);
                physicsWorldWrapper.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
                physicsWorldWrapper.d.t(e6);
                int n4 = 0;
                for (Object object : arrayList) {
                    Object object2 = (CollisionObjectData)physicsWorldWrapper.d.ap(((L8)object).g);
                    if (((CollisionObjectData)object2).d == null) continue;
                    ++n4;
                }
                GameEntity[] arrgameEntity = new GameEntity[]{};
                if (n4 > 0) {
                    arrgameEntity = new GameEntity[n4];
                    n4 = 0;
                    for (Object object2 : arrayList) {
                        CollisionObjectData collisionObjectData = (CollisionObjectData)physicsWorldWrapper.d.ap(((L8)object2).g);
                        if (collisionObjectData.d == null) continue;
                        arrgameEntity[n4++] = collisionObjectData.d;
                    }
                    if (bl) {
                        Object object;
                        object = new D346(vector3);
                        Arrays.sort(arrgameEntity, object);
                    }
                }
                return arrgameEntity;
            }
            return new GameEntity[0];
        }
        return new GameEntity[0];
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static RotTrans clientToServerTransform(RotTrans rotTrans) {
        return rotTrans.w(client.gn, 0.0f, client.gj);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static RotTrans serverToClientTransform(RotTrans rotTrans) {
        return rotTrans.v(client.gn, 0.0f, client.gj);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 clientToServerPos(Vector3 vector3) {
        return Vector3.m(vector3, client.gn, 0.0f, client.gj);
    }

    public static Vector3[] g(Vector3[] arrvector3, float f) {
        if (arrvector3 == null) {
            arrvector3 = new Vector3[8];
        }
        Matrix4 matrix4 = client.bl;
        Matrix4 matrix42 = matrix4.j();
        Vector3 vector3 = Vector3.g(-1.0f, -1.0f, 0.0f);
        Vector3 vector32 = Vector3.g(1.0f, 1.0f, 1.0f);
        F304 f304 = new F304();
        for (int i = 0; i < 8; ++i) {
            f304.g = i / 1 % 2 == 0 ? vector3.x : vector32.x;
            f304.d = i / 2 % 2 == 0 ? vector3.y : vector32.y;
            f304.q = i / 4 % 2 == 0 ? vector3.z : vector32.z;
            f304.j = 1.0f;
            F304.h(f304, matrix42);
            arrvector3[i] = new Vector3(f304.g / f304.j, f304.d / f304.j, f304.q / f304.j);
        }
        if (f != 0.0f) {
            Vector3 vector33 = Vector3.g(0.5f * (arrvector3[0].x + arrvector3[3].x), 0.5f * (arrvector3[0].y + arrvector3[3].y), 0.5f * (arrvector3[0].z + arrvector3[3].z));
            Vector3 vector34 = Vector3.g(0.5f * (arrvector3[4].x + arrvector3[7].x), 0.5f * (arrvector3[4].y + arrvector3[7].y), 0.5f * (arrvector3[4].z + arrvector3[7].z));
            float f2 = Vector3.f(Vector3.k(vector34, vector33));
            float f3 = f / f2;
            for (int i = 0; i < 4; ++i) {
                arrvector3[4 + i] = Vector3.av(arrvector3[i], arrvector3[4 + i], f3);
            }
        }
        return arrvector3;
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
    public static GameEntity GetBotEntity(int n) {
        return (GameEntity)Gc330.j.get(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getCameraHeading() {
        ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
        if (scriptCamera != null) {
            Quaternion quaternion = scriptCamera.getWorldTransform().rot;
            Vector3 vector3 = Vector3.g(0.0f, 0.0f, 1.0f);
            vector3 = Vector3.al(vector3, quaternion);
            float f = (float)Math.atan2(vector3.x, vector3.z);
            return f;
        }
        return 0.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static float getavh(float f, float f2) {
        return client.bh(f, f2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3[] getPhysicsRayFromPixelSpace(float f, float f2) {
        float f3 = f / (float)GameShell3.canvasWid * 2.0f - 1.0f;
        float f4 = -(f2 / (float)GameShell3.canvasHei * 2.0f - 1.0f);
        float[] arrf = new float[]{f3, f4, 0.0f};
        float[] arrf2 = new float[]{f3, f4, 1.0f};
        Matrix4 matrix4 = client.ar.j();
        float f5 = Matrix4.s(matrix4, arrf[0], arrf[1], arrf[2]);
        float f6 = Matrix4.s(matrix4, arrf2[0], arrf2[1], arrf2[2]);
        Matrix4.h(matrix4, arrf);
        Matrix4.h(matrix4, arrf2);
        float[] arrf3 = arrf;
        arrf3[0] = arrf3[0] / f5;
        float[] arrf4 = arrf;
        arrf4[1] = arrf4[1] / f5;
        float[] arrf5 = arrf;
        arrf5[2] = arrf5[2] / f5;
        float[] arrf6 = arrf2;
        arrf6[0] = arrf6[0] / f6;
        float[] arrf7 = arrf2;
        arrf7[1] = arrf7[1] / f6;
        float[] arrf8 = arrf2;
        arrf8[2] = arrf8[2] / f6;
        H303.w(client.ax, arrf);
        H303.w(client.ax, arrf2);
        Vector3 vector3 = new Vector3(arrf[0] + (float)client.gn, arrf[1], arrf[2] + (float)client.gj);
        Vector3 vector32 = new Vector3(arrf2[0] + (float)client.gn, arrf2[1], arrf2[2] + (float)client.gj);
        return new Vector3[]{vector3, vector32};
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static Vector3 serverToClientPos(Vector3 vector3) {
        return Vector3.i(vector3, client.gn, 0.0f, client.gj);
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
        Vector3[] arrvector3 = ClientScriptAPI.g(null, 0.0f);
        if (arrvector3 != null) {
            PhysicsWorldWrapper physicsWorldWrapper = client.dc.g(arrvector3[0]);
            if (physicsWorldWrapper != null) {
                Vector3 vector3 = arrvector3[0];
                Vector3 vector32 = arrvector3[3];
                Vector3 vector33 = new Vector3(0.5f * (vector3.x + vector32.x), 0.5f * (vector3.y + vector32.y), 0.5f * (vector3.z + vector32.z));
                return vector33;
            }
            return null;
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean removeCamera(ScriptCamera scriptCamera, @ScriptDefaults(defaultBoolean=true) boolean bl) {
        ScriptCamera.eu(scriptCamera, d);
        if (client.mm != null) {
            client.mm.remove(scriptCamera, true, bl);
        }
        return g.remove(scriptCamera);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void GameConNoTimout() {
        client.au();
    }

    public static final native void setNativeSelfGameEntity(long var0, long var2, GameEntity var4);
}

