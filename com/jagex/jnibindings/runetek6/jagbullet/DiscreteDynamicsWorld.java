/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CameraController;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.H46;
import com.jagex.jnibindings.runetek6.jagbullet.HeightfieldTerrainCollisionShape;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscreteDynamicsWorld {
    private static final Logger logger = LoggerFactory.getLogger(DiscreteDynamicsWorld.class);
    float[] a;
    public final int b;
    long d;
    public final int e;
    float[] f;
    public final int h;
    long[] i = new long[128];
    BulletVehicle[] j;
    boolean[][] k = null;
    public final int l;
    final float m;
    public float n = 0.0f;
    float[] o = new float[this.i.length * 3];
    int p = 0;
    CollisionObject[] q;
    int r = 0;
    public final int s;
    Vector3 t;
    private final ByteBuffer u;
    int v = 0;
    int w = 0;
    private final ByteBuffer x;
    int y = 0;
    private final ByteBuffer z;

    public static long g(DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.d;
    }

    private static native long nativeInit(int var0, ByteBuffer var1, ByteBuffer var2, int var3, int var4, int var5, int var6, int var7, int var8);

    public static Vector3 af(DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.t;
    }

    public void d(Vector3 vector3) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeSetGravity(long var0, float var2, float var3, float var4);

    private static native boolean getHeightfieldNormalAt(long var0, float var2, float var3, float[] var4);

    public E6 j(int n, float f, float f2) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native long nativeCreateSphereShape(long var0, float var2);

    public E6 e(float f, float f2, float f3, float f4) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native long nativeCreateBoxShape(long var0, float var2, float var3, float var4, float var5);

    public static E6 h(DiscreteDynamicsWorld discreteDynamicsWorld, float f, float f2, float f3) {
        return discreteDynamicsWorld.e(f, f2, f3, 0.0f);
    }

    public void at(boolean[][] arrbl) {
        for (int i = 0; i < arrbl.length; ++i) {
            for (int j = i; j < arrbl[0].length; ++j) {
                this.am(i, j, arrbl[i][j], true);
                if (arrbl[i][j] == arrbl[j][i]) continue;
                throw new IllegalArgumentException("Collision table must be symmetric!");
            }
        }
        this.ac();
        this.k = arrbl;
    }

    public boolean an(int n, int n2) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public E6 b(Vector3[] arrvector3) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        Vector3[] arrvector32 = arrvector3;
        return null;
    }

    private static native long nativeCreateConvexHullShape(long var0, float[] var2, float[] var3, float[] var4);

    private static native void nativeReset(long var0);

    private static native long nativeCreateGenericMeshShape(long var0, float[] var2, float[] var3, float[] var4, int[] var5);

    public HeightfieldTerrainCollisionShape w(float[][] arrf, float f, float f2, float f3) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native long nativeCreateHeightfieldTerrainShape(long var0, float[][] var2, float var3, float var4, float var5);

    public E6 r(E6[] arre6, Q7[] arrq7) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native long nativeCreateCompoundShape(long var0, long[] var2, float[] var3, float[] var4, float[] var5, float[] var6, float[] var7, float[] var8, float[] var9, float[] var10, float[] var11, float[] var12, float[] var13, float[] var14);

    public RigidBody v(E6 e6, Q7 q7, float f, float f2, int n, int n2, boolean bl, boolean bl2, Object object) {
        RigidBody rigidBody;
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        if (e6 == null) {
            return null;
        }
        H46.q();
        if (Float.isNaN(q7.g.x) || Float.isInfinite(q7.g.x) || Float.isNaN(q7.g.y) || Float.isInfinite(q7.g.y) || Float.isNaN(q7.g.z) || Float.isInfinite(q7.g.z) || Float.isNaN(q7.d.f00) || Float.isInfinite(q7.d.f00) || Float.isNaN(q7.d.f01) || Float.isInfinite(q7.d.f01) || Float.isNaN(q7.d.f02) || Float.isInfinite(q7.d.f02) || Float.isNaN(q7.d.f10) || Float.isInfinite(q7.d.f10) || Float.isNaN(q7.d.f11) || Float.isInfinite(q7.d.f11) || Float.isNaN(q7.d.f12) || Float.isInfinite(q7.d.f12) || Float.isNaN(q7.d.f20) || Float.isInfinite(q7.d.f20) || Float.isNaN(q7.d.f21) || Float.isInfinite(q7.d.f21) || Float.isNaN(q7.d.f22) || Float.isInfinite(q7.d.f22)) {
            throw new IllegalArgumentException("Bad numbers fed to createStaticRigidBody()");
        }
        assert (this.r < this.h);
        if (this.r < this.h) {
            long l = DiscreteDynamicsWorld.nativeCreateStaticRigidBody(this.d, e6.g, q7.g.x, q7.g.y, q7.g.z, q7.d.f00, q7.d.f10, q7.d.f20, q7.d.f01, q7.d.f11, q7.d.f21, q7.d.f02, q7.d.f12, q7.d.f22, f, f2, n, n2, bl, bl2);
            rigidBody = new RigidBody(l, this, e6, n, n2, object, 0.0f);
            assert (l < (long)(this.s + this.b + this.h));
            assert (this.q[(int)l] == null);
            this.q[(int)l] = rigidBody;
            ++this.r;
        } else {
            rigidBody = null;
        }
        H46.j();
        return rigidBody;
    }

    private static native long nativeCreateCapsuleShape(long var0, int var2, float var3, float var4);

    public RigidBody y(float f, E6 e6, Q7 q7, float f2, float f3, int n, int n2, boolean bl, boolean bl2, Object object) {
        Vector3 vector3 = new Vector3(1.0f, 1.0f, 1.0f);
        Vector3 vector32 = new Vector3(0.0f, 0.0f, 0.0f);
        float f4 = 1.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 1.0f;
        return this.p(f, e6, q7, vector3, f2, f3, n, n2, bl, bl2, object, vector32, f4, f5, f6, f7);
    }

    public RigidBody p(float f, E6 e6, Q7 q7, Vector3 vector3, float f2, float f3, int n, int n2, boolean bl, boolean bl2, Object object, Vector3 vector32, float f4, float f5, float f6, float f7) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        if (e6 == null) {
            return null;
        }
        H46.q();
        assert (this.r < this.h);
        RigidBody rigidBody = null;
        if (this.r < this.h) {
            long l = DiscreteDynamicsWorld.nativeCreateDynamicRigidBody(this.d, f, e6.g, q7.g.x, q7.g.y, q7.g.z, q7.d.f00, q7.d.f10, q7.d.f20, q7.d.f01, q7.d.f11, q7.d.f21, q7.d.f02, q7.d.f12, q7.d.f22, vector3.x, vector3.y, vector3.z, f2, f3, n, n2, bl, bl2, vector32.x, vector32.y, vector32.z, f4, f5, f6, f7);
            rigidBody = new RigidBody(l, this, e6, n, n2, object, f);
            assert (l < (long)(this.s + this.b + this.h));
            assert (this.q[(int)l] == null);
            this.q[(int)l] = rigidBody;
            ++this.r;
        }
        H46.j();
        return rigidBody;
    }

    public List al(E6 e6, Q7 q7, int n, int n2, List list, int n3) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    /*
     * Exception decompiling
     */
    public CameraController x(E6 var1, Q7 var2, boolean var3, int var4, int var5, Object var6) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : NEW : trying to set 0 previously set to 2
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:314)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:188)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:133)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:225)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:109)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        // org.runestar.tfudeob.MainKt.decompileCfr(Main.kt:49)
        // org.runestar.tfudeob.MainKt.deob(Main.kt:37)
        // org.runestar.tfudeob.MainKt.main(Main.kt:11)
        // org.runestar.tfudeob.MainKt.main(Main.kt)
        throw new IllegalStateException("Decompilation failed");
    }

    private static native long nativeCreateCameraController(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, int var16, int var17, boolean var18);

    /*
     * Exception decompiling
     */
    public CharacterController u(E6 var1, Q7 var2, float var3, boolean var4, int var5, int var6, Object var7) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : NEW : trying to set 0 previously set to 2
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:314)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:188)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:133)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:225)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:109)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        // org.runestar.tfudeob.MainKt.decompileCfr(Main.kt:49)
        // org.runestar.tfudeob.MainKt.deob(Main.kt:37)
        // org.runestar.tfudeob.MainKt.main(Main.kt:11)
        // org.runestar.tfudeob.MainKt.main(Main.kt)
        throw new IllegalStateException("Decompilation failed");
    }

    private static native long nativeCreateCharacterController(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, int var17, int var18, boolean var19);

    public BulletVehicle z(RigidBody rigidBody, B45 b45, int n, int n2) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public DiscreteDynamicsWorld(int n, int n2, int n3, int n4, int n5, int n6, int n7, float f) {
        this.a = new float[this.i.length * 3];
        this.f = new float[this.i.length];
        H46.q();
        this.x = ByteBuffer.allocateDirect(n6 * 4 * 96);
        this.x.order(ByteOrder.LITTLE_ENDIAN);
        this.u = ByteBuffer.allocateDirect(4 + 8 * n7);
        this.u.order(ByteOrder.LITTLE_ENDIAN);
        this.z = ByteBuffer.allocateDirect(24576);
        this.z.order(ByteOrder.LITTLE_ENDIAN);
        this.e = n2;
        this.h = n3;
        this.s = n4;
        this.b = n5;
        this.l = n6;
        this.m = f;
        this.q = new CollisionObject[n3 + n5 + n4];
        this.j = new BulletVehicle[n6];
        this.d = DiscreteDynamicsWorld.nativeInit(n, this.x, this.u, n2, n3, n4, n5, n6, n7);
        logger.debug("DiscreteDynamicsWorld created. TimeStep {} s.", Float.valueOf(f));
        H46.j();
    }

    public E6 s(float f, float f2, float f3, float f4) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeDestroyCollisionShape(long var0, long var2);

    public void m(RigidBody rigidBody) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeDestroyBody(long var0, long var2);

    public void n(CharacterController characterController) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeDestroyCharacterController(long var0, long var2);

    public void k(BulletVehicle bulletVehicle) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeDestroyVehicle(long var0, long var2);

    public static int aj(DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.r + discreteDynamicsWorld.y + discreteDynamicsWorld.v;
    }

    private static native long nativeCreateCylinderSectorShape(long var0, float var2, float var3, float var4, float var5);

    public void o(RigidBody rigidBody) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public void a(RigidBody rigidBody) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeDisableBody(long var0, long var2);

    public boolean f(RigidBody rigidBody) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeIsBodyEnabled(long var0, long var2);

    public E6 l(Vector3[] arrvector3, int[] arrn) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native boolean nativeRayIntersectsAny(long var0, float var2, float var3, float var4, float var5, float var6, float var7, int var8, int var9);

    /*
     * Exception decompiling
     */
    public boolean ag(E6 var1, Q7 var2, int var3, int var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : NEW : trying to set 0 previously set to 2
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:314)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:188)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:133)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:225)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:109)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        // org.runestar.tfudeob.MainKt.decompileCfr(Main.kt:49)
        // org.runestar.tfudeob.MainKt.deob(Main.kt:37)
        // org.runestar.tfudeob.MainKt.main(Main.kt:11)
        // org.runestar.tfudeob.MainKt.main(Main.kt)
        throw new IllegalStateException("Decompilation failed");
    }

    private static native boolean nativeShapeIntersectsAny(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, int var16, int var17);

    private static void aq(DiscreteDynamicsWorld discreteDynamicsWorld, int n) {
        if (discreteDynamicsWorld.i.length < n) {
            discreteDynamicsWorld.i = new long[n];
            discreteDynamicsWorld.o = new float[n * 3];
            discreteDynamicsWorld.a = new float[n * 3];
            discreteDynamicsWorld.f = new float[n];
        }
    }

    public ArrayList ai(Vector3 vector3, Vector3 vector32, int n, int n2, boolean bl, boolean bl2, ArrayList arrayList, int n3) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native int nativeGetRayIntersections(long var0, float var2, float var3, float var4, float var5, float var6, float var7, long[] var8, float[] var9, float[] var10, float[] var11, boolean var12, boolean var13, int var14, int var15);

    private static native int nativeGetShapeIntersections(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, long[] var16, float[] var17, float[] var18, int var19, int var20);

    public void au() {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        this.ar();
        logger.debug("Optimizing broadphase... ");
        H46.q();
        DiscreteDynamicsWorld.nativeOptimizeBroadphase(this.d, 64);
        logger.debug("                          succeded.");
        H46.j();
    }

    public static float av(DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.m;
    }

    public float ao(float f, float f2) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        return DiscreteDynamicsWorld.getHeightfieldHeightAt(this.d, f, f2, Float.NaN);
    }

    private static native float getHeightfieldHeightAt(long var0, float var2, float var3, float var4);

    public void ar() {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native long nativeCreateDynamicRigidBody(long var0, float var2, long var3, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18, float var19, float var20, float var21, int var22, int var23, boolean var24, boolean var25, float var26, float var27, float var28, float var29, float var30, float var31, float var32);

    public void am(int n, int n2, boolean bl, boolean bl2) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public static void as(DiscreteDynamicsWorld discreteDynamicsWorld, int n, int n2, boolean bl) {
        discreteDynamicsWorld.am(n, n2, bl, false);
    }

    public void ac() {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public static native void nativeUpdateBroadphaseCache(long var0);

    protected void finalize() {
        if (this.d != 0L) {
            logger.error("DiscreteDynamicsWorld GC'd without being destroyed properly!");
            this.ab();
        }
    }

    public void ab() {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeQuit(long var0);

    private static native int nativeDumpProfile(long var0, ByteBuffer var2, int var3);

    private static native int nativeDumpStatus(long var0, ByteBuffer var2, int var3);

    public static void ax(DiscreteDynamicsWorld discreteDynamicsWorld, float f) {
        int n;
        Object object;
        for (n = 0; n < discreteDynamicsWorld.j.length; ++n) {
            object = discreteDynamicsWorld.j[n];
            if (object == null) continue;
            ((BulletVehicle)object).p(f);
        }
        for (n = 0; n < DiscreteDynamicsWorld.aj(discreteDynamicsWorld); ++n) {
            object = discreteDynamicsWorld.q[n];
            if (!(object instanceof CharacterController)) continue;
            ((CharacterController)object).z(f);
        }
    }

    private static native void nativeOptimizeBroadphase(long var0, int var2);

    private static native long nativeCreateVehicle(long var0, long var2, int var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18, float var19, float var20, float var21, float var22, float var23, float var24, boolean var25, boolean var26, boolean var27, boolean var28, boolean var29, boolean var30, float var31, float var32, float var33, float var34, int var35, int var36);

    public static native boolean nativeGroupsCollide(long var0, int var2, int var3);

    private static native void nativeStepSimulation(long var0, float var2);

    private static native long nativeCreateStaticRigidBody(long var0, long var2, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, int var18, int var19, boolean var20, boolean var21);

    public boolean c(Vector3 vector3, Vector3 vector32, int n, int n2) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public E6 q(float f) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    private static native void nativeEnableBody(long var0, long var2);

    public void i() {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public Object ap(long l) {
        assert (l < (long)(this.s + this.b + this.h));
        if (this.q[(int)l] != null) {
            return this.q[(int)l].w;
        }
        return null;
    }

    public void aw() {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    public static native void nativeSetGroupsCollide(long var0, int var2, int var3, boolean var4, boolean var5);

    public void ak(ArrayList arrayList) {
        long l = this.d;
        long l2 = 0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }

    /*
     * Exception decompiling
     */
    public void t(E6 var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : NEW : trying to set 0 previously set to 2
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:314)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:188)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:133)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:225)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:109)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        // org.runestar.tfudeob.MainKt.decompileCfr(Main.kt:49)
        // org.runestar.tfudeob.MainKt.deob(Main.kt:37)
        // org.runestar.tfudeob.MainKt.main(Main.kt:11)
        // org.runestar.tfudeob.MainKt.main(Main.kt)
        throw new IllegalStateException("Decompilation failed");
    }

    public Vector3 aa(float f, float f2) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        float[] arrf = new float[3];
        if (DiscreteDynamicsWorld.getHeightfieldNormalAt(this.d, f, f2, arrf)) {
            return new Vector3(arrf[0], arrf[1], arrf[2]);
        }
        return null;
    }
}

