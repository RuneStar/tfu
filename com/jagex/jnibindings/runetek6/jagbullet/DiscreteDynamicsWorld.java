// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.nio.ByteOrder;
import java.util.List;
import java.nio.ByteBuffer;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;

public class DiscreteDynamicsWorld
{
    private static final Logger logger;
    float[] a;
    public final int b;
    long d;
    public final int e;
    float[] f;
    public final int h;
    long[] i;
    BulletVehicle[] j;
    boolean[][] k;
    public final int l;
    final float m;
    public float n;
    float[] o;
    int p;
    CollisionObject[] q;
    int r;
    public final int s;
    Vector3 t;
    private final ByteBuffer u;
    int v;
    int w;
    private final ByteBuffer x;
    int y;
    private final ByteBuffer z;
    static final /* synthetic */ boolean c;
    
    public static long g(final DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.d;
    }
    
    private static native long nativeInit(final int p0, final ByteBuffer p1, final ByteBuffer p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8);
    
    public static Vector3 af(final DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.t;
    }
    
    public void d(final Vector3 vector3) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeSetGravity(final long p0, final float p1, final float p2, final float p3);
    
    private static native boolean getHeightfieldNormalAt(final long p0, final float p1, final float p2, final float[] p3);
    
    public E6 j(final int n, final float n2, final float n3) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native long nativeCreateSphereShape(final long p0, final float p1);
    
    public E6 e(final float n, final float n2, final float n3, final float n4) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native long nativeCreateBoxShape(final long p0, final float p1, final float p2, final float p3, final float p4);
    
    public static E6 h(final DiscreteDynamicsWorld discreteDynamicsWorld, final float n, final float n2, final float n3) {
        return discreteDynamicsWorld.e(n, n2, n3, 0.0f);
    }
    
    public void at(final boolean[][] k) {
        for (int i = 0; i < k.length; ++i) {
            for (int j = i; j < k[0].length; ++j) {
                this.am(i, j, k[i][j], true);
                if (k[i][j] != k[j][i]) {
                    throw new IllegalArgumentException("Collision table must be symmetric!");
                }
            }
        }
        this.ac();
        this.k = k;
    }
    
    public boolean an(final int n, final int n2) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public E6 b(final Vector3[] array) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        return null;
    }
    
    private static native long nativeCreateConvexHullShape(final long p0, final float[] p1, final float[] p2, final float[] p3);
    
    private static native void nativeReset(final long p0);
    
    private static native long nativeCreateGenericMeshShape(final long p0, final float[] p1, final float[] p2, final float[] p3, final int[] p4);
    
    public HeightfieldTerrainCollisionShape w(final float[][] array, final float n, final float n2, final float n3) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native long nativeCreateHeightfieldTerrainShape(final long p0, final float[][] p1, final float p2, final float p3, final float p4);
    
    public E6 r(final E6[] array, final Q7[] array2) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native long nativeCreateCompoundShape(final long p0, final long[] p1, final float[] p2, final float[] p3, final float[] p4, final float[] p5, final float[] p6, final float[] p7, final float[] p8, final float[] p9, final float[] p10, final float[] p11, final float[] p12, final float[] p13);
    
    public RigidBody v(final E6 e6, final Q7 q7, final float n, final float n2, final int n3, final int n4, final boolean b, final boolean b2, final Object o) {
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
        if (!DiscreteDynamicsWorld.c && this.r >= this.h) {
            throw new AssertionError();
        }
        RigidBody rigidBody;
        if (this.r < this.h) {
            final long nativeCreateStaticRigidBody = nativeCreateStaticRigidBody(this.d, e6.g, q7.g.x, q7.g.y, q7.g.z, q7.d.f00, q7.d.f10, q7.d.f20, q7.d.f01, q7.d.f11, q7.d.f21, q7.d.f02, q7.d.f12, q7.d.f22, n, n2, n3, n4, b, b2);
            rigidBody = new RigidBody(nativeCreateStaticRigidBody, this, e6, n3, n4, o, 0.0f);
            if (!DiscreteDynamicsWorld.c && nativeCreateStaticRigidBody >= this.s + this.b + this.h) {
                throw new AssertionError();
            }
            if (!DiscreteDynamicsWorld.c && this.q[(int)nativeCreateStaticRigidBody] != null) {
                throw new AssertionError();
            }
            this.q[(int)nativeCreateStaticRigidBody] = rigidBody;
            ++this.r;
        }
        else {
            rigidBody = null;
        }
        H46.j();
        return rigidBody;
    }
    
    private static native long nativeCreateCapsuleShape(final long p0, final int p1, final float p2, final float p3);
    
    public RigidBody y(final float n, final E6 e6, final Q7 q7, final float n2, final float n3, final int n4, final int n5, final boolean b, final boolean b2, final Object o) {
        return this.p(n, e6, q7, new Vector3(1.0f, 1.0f, 1.0f), n2, n3, n4, n5, b, b2, o, new Vector3(0.0f, 0.0f, 0.0f), 1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public RigidBody p(final float n, final E6 e6, final Q7 q7, final Vector3 vector3, final float n2, final float n3, final int n4, final int n5, final boolean b, final boolean b2, final Object o, final Vector3 vector4, final float n6, final float n7, final float n8, final float n9) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        if (e6 == null) {
            return null;
        }
        H46.q();
        if (!DiscreteDynamicsWorld.c && this.r >= this.h) {
            throw new AssertionError();
        }
        CollisionObject collisionObject = null;
        if (this.r < this.h) {
            final long nativeCreateDynamicRigidBody = nativeCreateDynamicRigidBody(this.d, n, e6.g, q7.g.x, q7.g.y, q7.g.z, q7.d.f00, q7.d.f10, q7.d.f20, q7.d.f01, q7.d.f11, q7.d.f21, q7.d.f02, q7.d.f12, q7.d.f22, vector3.x, vector3.y, vector3.z, n2, n3, n4, n5, b, b2, vector4.x, vector4.y, vector4.z, n6, n7, n8, n9);
            collisionObject = new RigidBody(nativeCreateDynamicRigidBody, this, e6, n4, n5, o, n);
            if (!DiscreteDynamicsWorld.c && nativeCreateDynamicRigidBody >= this.s + this.b + this.h) {
                throw new AssertionError();
            }
            if (!DiscreteDynamicsWorld.c && this.q[(int)nativeCreateDynamicRigidBody] != null) {
                throw new AssertionError();
            }
            this.q[(int)nativeCreateDynamicRigidBody] = collisionObject;
            ++this.r;
        }
        H46.j();
        return (RigidBody)collisionObject;
    }
    
    public List al(final E6 e6, final Q7 q7, final int n, final int n2, final List list, final int n3) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public CameraController x(final E6 p0, final Q7 p1, final boolean p2, final int p3, final int p4, final Object p5) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //     4: lconst_0       
        //     5: lcmp           
        //     6: ifeq            14
        //     9: aload_1        
        //    10: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    13: lconst_0       
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc             "The physics world has already been destroyed. Track the culprit who's still holding the reference."
        //    20: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    23: athrow         
        //    24: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.q:()V
        //    27: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //    30: ifne            52
        //    33: aload_0        
        //    34: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.v:I
        //    37: aload_0        
        //    38: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.s:I
        //    41: if_icmplt       52
        //    44: new             Ljava/lang/AssertionError;
        //    47: dup            
        //    48: invokespecial   java/lang/AssertionError.<init>:()V
        //    51: athrow         
        //    52: aconst_null    
        //    53: astore          7
        //    55: aload_0        
        //    56: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.v:I
        //    59: aload_0        
        //    60: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.s:I
        //    63: if_icmpge       267
        //    66: aload_0        
        //    67: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //    70: aload_1        
        //    71: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    74: aload_2        
        //    75: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    78: getfield        com/jagex/maths/Vector3.x:F
        //    81: aload_2        
        //    82: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    85: getfield        com/jagex/maths/Vector3.y:F
        //    88: aload_2        
        //    89: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    92: getfield        com/jagex/maths/Vector3.z:F
        //    95: aload_2        
        //    96: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    99: getfield        com/jagex/maths/M47.f00:F
        //   102: aload_2        
        //   103: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   106: getfield        com/jagex/maths/M47.f10:F
        //   109: aload_2        
        //   110: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   113: getfield        com/jagex/maths/M47.f20:F
        //   116: aload_2        
        //   117: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   120: getfield        com/jagex/maths/M47.f01:F
        //   123: aload_2        
        //   124: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   127: getfield        com/jagex/maths/M47.f11:F
        //   130: aload_2        
        //   131: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   134: getfield        com/jagex/maths/M47.f21:F
        //   137: aload_2        
        //   138: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   141: getfield        com/jagex/maths/M47.f02:F
        //   144: aload_2        
        //   145: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   148: getfield        com/jagex/maths/M47.f12:F
        //   151: aload_2        
        //   152: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   155: getfield        com/jagex/maths/M47.f22:F
        //   158: iload           4
        //   160: iload           5
        //   162: iload_3        
        //   163: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.nativeCreateCameraController:(JJFFFFFFFFFFFFIIZ)J
        //   166: lstore          8
        //   168: new             Lcom/jagex/jnibindings/runetek6/jagbullet/CameraController;
        //   171: dup            
        //   172: lload           8
        //   174: aload_1        
        //   175: aload_0        
        //   176: iload           4
        //   178: iload           5
        //   180: aload           6
        //   182: invokespecial   com/jagex/jnibindings/runetek6/jagbullet/CameraController.<init>:(JLcom/jagex/jnibindings/runetek6/jagbullet/E6;Lcom/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld;IILjava/lang/Object;)V
        //   185: astore          7
        //   187: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //   190: ifne            222
        //   193: lload           8
        //   195: aload_0        
        //   196: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.s:I
        //   199: aload_0        
        //   200: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.b:I
        //   203: iadd           
        //   204: aload_0        
        //   205: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.h:I
        //   208: iadd           
        //   209: i2l            
        //   210: lcmp           
        //   211: iflt            222
        //   214: new             Ljava/lang/AssertionError;
        //   217: dup            
        //   218: invokespecial   java/lang/AssertionError.<init>:()V
        //   221: athrow         
        //   222: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //   225: ifne            247
        //   228: aload_0        
        //   229: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.q:[Lcom/jagex/jnibindings/runetek6/jagbullet/CollisionObject;
        //   232: lload           8
        //   234: l2i            
        //   235: aaload         
        //   236: ifnull          247
        //   239: new             Ljava/lang/AssertionError;
        //   242: dup            
        //   243: invokespecial   java/lang/AssertionError.<init>:()V
        //   246: athrow         
        //   247: aload_0        
        //   248: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.q:[Lcom/jagex/jnibindings/runetek6/jagbullet/CollisionObject;
        //   251: lload           8
        //   253: l2i            
        //   254: aload           7
        //   256: aastore        
        //   257: aload_0        
        //   258: dup            
        //   259: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.v:I
        //   262: iconst_1       
        //   263: iadd           
        //   264: putfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.v:I
        //   267: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.j:()V
        //   270: aload           7
        //   272: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0014 (coming from #0013).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        //     at org.runestar.tfudeob.MainKt.decompileProcyon(Main.kt:63)
        //     at org.runestar.tfudeob.MainKt.deob(Main.kt:45)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt:11)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static native long nativeCreateCameraController(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final int p14, final int p15, final boolean p16);
    
    public CharacterController u(final E6 p0, final Q7 p1, final float p2, final boolean p3, final int p4, final int p5, final Object p6) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //     4: lconst_0       
        //     5: lcmp           
        //     6: ifeq            14
        //     9: aload_1        
        //    10: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    13: lconst_0       
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc             "The physics world has already been destroyed. Track the culprit who's still holding the reference."
        //    20: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    23: athrow         
        //    24: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.q:()V
        //    27: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //    30: ifne            52
        //    33: aload_0        
        //    34: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.y:I
        //    37: aload_0        
        //    38: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.b:I
        //    41: if_icmplt       52
        //    44: new             Ljava/lang/AssertionError;
        //    47: dup            
        //    48: invokespecial   java/lang/AssertionError.<init>:()V
        //    51: athrow         
        //    52: aconst_null    
        //    53: astore          8
        //    55: aload_0        
        //    56: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.y:I
        //    59: aload_0        
        //    60: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.b:I
        //    63: if_icmpge       269
        //    66: aload_0        
        //    67: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //    70: aload_1        
        //    71: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    74: fload_3        
        //    75: aload_2        
        //    76: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    79: getfield        com/jagex/maths/Vector3.x:F
        //    82: aload_2        
        //    83: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    86: getfield        com/jagex/maths/Vector3.y:F
        //    89: aload_2        
        //    90: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    93: getfield        com/jagex/maths/Vector3.z:F
        //    96: aload_2        
        //    97: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   100: getfield        com/jagex/maths/M47.f00:F
        //   103: aload_2        
        //   104: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   107: getfield        com/jagex/maths/M47.f10:F
        //   110: aload_2        
        //   111: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   114: getfield        com/jagex/maths/M47.f20:F
        //   117: aload_2        
        //   118: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   121: getfield        com/jagex/maths/M47.f01:F
        //   124: aload_2        
        //   125: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   128: getfield        com/jagex/maths/M47.f11:F
        //   131: aload_2        
        //   132: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   135: getfield        com/jagex/maths/M47.f21:F
        //   138: aload_2        
        //   139: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   142: getfield        com/jagex/maths/M47.f02:F
        //   145: aload_2        
        //   146: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   149: getfield        com/jagex/maths/M47.f12:F
        //   152: aload_2        
        //   153: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   156: getfield        com/jagex/maths/M47.f22:F
        //   159: iload           5
        //   161: iload           6
        //   163: iload           4
        //   165: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.nativeCreateCharacterController:(JJFFFFFFFFFFFFFIIZ)J
        //   168: lstore          9
        //   170: new             Lcom/jagex/jnibindings/runetek6/jagbullet/CharacterController;
        //   173: dup            
        //   174: lload           9
        //   176: aload_1        
        //   177: aload_0        
        //   178: iload           5
        //   180: iload           6
        //   182: aload           7
        //   184: invokespecial   com/jagex/jnibindings/runetek6/jagbullet/CharacterController.<init>:(JLcom/jagex/jnibindings/runetek6/jagbullet/E6;Lcom/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld;IILjava/lang/Object;)V
        //   187: astore          8
        //   189: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //   192: ifne            224
        //   195: lload           9
        //   197: aload_0        
        //   198: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.s:I
        //   201: aload_0        
        //   202: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.b:I
        //   205: iadd           
        //   206: aload_0        
        //   207: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.h:I
        //   210: iadd           
        //   211: i2l            
        //   212: lcmp           
        //   213: iflt            224
        //   216: new             Ljava/lang/AssertionError;
        //   219: dup            
        //   220: invokespecial   java/lang/AssertionError.<init>:()V
        //   223: athrow         
        //   224: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //   227: ifne            249
        //   230: aload_0        
        //   231: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.q:[Lcom/jagex/jnibindings/runetek6/jagbullet/CollisionObject;
        //   234: lload           9
        //   236: l2i            
        //   237: aaload         
        //   238: ifnull          249
        //   241: new             Ljava/lang/AssertionError;
        //   244: dup            
        //   245: invokespecial   java/lang/AssertionError.<init>:()V
        //   248: athrow         
        //   249: aload_0        
        //   250: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.q:[Lcom/jagex/jnibindings/runetek6/jagbullet/CollisionObject;
        //   253: lload           9
        //   255: l2i            
        //   256: aload           8
        //   258: aastore        
        //   259: aload_0        
        //   260: dup            
        //   261: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.y:I
        //   264: iconst_1       
        //   265: iadd           
        //   266: putfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.y:I
        //   269: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.j:()V
        //   272: aload           8
        //   274: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0014 (coming from #0013).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        //     at org.runestar.tfudeob.MainKt.decompileProcyon(Main.kt:63)
        //     at org.runestar.tfudeob.MainKt.deob(Main.kt:45)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt:11)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static native long nativeCreateCharacterController(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final float p14, final int p15, final int p16, final boolean p17);
    
    public BulletVehicle z(final RigidBody rigidBody, final B45 b45, final int n, final int n2) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public DiscreteDynamicsWorld(final int n, final int e, final int h, final int s, final int b, final int l, final int n2, final float n3) {
        this.w = 0;
        this.r = 0;
        this.v = 0;
        this.y = 0;
        this.p = 0;
        this.n = 0.0f;
        this.k = null;
        this.i = new long[128];
        this.o = new float[this.i.length * 3];
        this.a = new float[this.i.length * 3];
        this.f = new float[this.i.length];
        H46.q();
        (this.x = ByteBuffer.allocateDirect(l * 4 * 96)).order(ByteOrder.LITTLE_ENDIAN);
        (this.u = ByteBuffer.allocateDirect(4 + 8 * n2)).order(ByteOrder.LITTLE_ENDIAN);
        (this.z = ByteBuffer.allocateDirect(24576)).order(ByteOrder.LITTLE_ENDIAN);
        this.e = e;
        this.h = h;
        this.s = s;
        this.b = b;
        this.l = l;
        this.m = n3;
        this.q = new CollisionObject[h + b + s];
        this.j = new BulletVehicle[l];
        this.d = nativeInit(n, this.x, this.u, e, h, s, b, l, n2);
        DiscreteDynamicsWorld.logger.debug("DiscreteDynamicsWorld created. TimeStep {} s.", n3);
        H46.j();
    }
    
    public E6 s(final float n, final float n2, final float n3, final float n4) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeDestroyCollisionShape(final long p0, final long p1);
    
    public void m(final RigidBody rigidBody) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeDestroyBody(final long p0, final long p1);
    
    public void n(final CharacterController characterController) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeDestroyCharacterController(final long p0, final long p1);
    
    public void k(final BulletVehicle bulletVehicle) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeDestroyVehicle(final long p0, final long p1);
    
    public static int aj(final DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.r + discreteDynamicsWorld.y + discreteDynamicsWorld.v;
    }
    
    private static native long nativeCreateCylinderSectorShape(final long p0, final float p1, final float p2, final float p3, final float p4);
    
    public void o(final RigidBody rigidBody) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void a(final RigidBody rigidBody) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeDisableBody(final long p0, final long p1);
    
    public boolean f(final RigidBody rigidBody) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeIsBodyEnabled(final long p0, final long p1);
    
    public E6 l(final Vector3[] array, final int[] array2) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native boolean nativeRayIntersectsAny(final long p0, final float p1, final float p2, final float p3, final float p4, final float p5, final float p6, final int p7, final int p8);
    
    public boolean ag(final E6 p0, final Q7 p1, final int p2, final int p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //     4: lconst_0       
        //     5: lcmp           
        //     6: ifeq            14
        //     9: aload_1        
        //    10: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    13: lconst_0       
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc             "The physics world has already been destroyed. Track the culprit who's still holding the reference."
        //    20: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    23: athrow         
        //    24: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.g:()V
        //    27: aload_0        
        //    28: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //    31: aload_1        
        //    32: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    35: aload_2        
        //    36: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    39: getfield        com/jagex/maths/Vector3.x:F
        //    42: aload_2        
        //    43: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    46: getfield        com/jagex/maths/Vector3.y:F
        //    49: aload_2        
        //    50: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.g:Lcom/jagex/maths/Vector3;
        //    53: getfield        com/jagex/maths/Vector3.z:F
        //    56: aload_2        
        //    57: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    60: getfield        com/jagex/maths/M47.f00:F
        //    63: aload_2        
        //    64: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    67: getfield        com/jagex/maths/M47.f10:F
        //    70: aload_2        
        //    71: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    74: getfield        com/jagex/maths/M47.f20:F
        //    77: aload_2        
        //    78: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    81: getfield        com/jagex/maths/M47.f01:F
        //    84: aload_2        
        //    85: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    88: getfield        com/jagex/maths/M47.f11:F
        //    91: aload_2        
        //    92: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //    95: getfield        com/jagex/maths/M47.f21:F
        //    98: aload_2        
        //    99: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   102: getfield        com/jagex/maths/M47.f02:F
        //   105: aload_2        
        //   106: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   109: getfield        com/jagex/maths/M47.f12:F
        //   112: aload_2        
        //   113: getfield        com/jagex/jnibindings/runetek6/jagbullet/Q7.d:Lcom/jagex/maths/M47;
        //   116: getfield        com/jagex/maths/M47.f22:F
        //   119: iload_3        
        //   120: iload           4
        //   122: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.nativeShapeIntersectsAny:(JJFFFFFFFFFFFFII)Z
        //   125: istore          5
        //   127: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.d:()V
        //   130: iload           5
        //   132: ireturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0014 (coming from #0013).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        //     at org.runestar.tfudeob.MainKt.decompileProcyon(Main.kt:63)
        //     at org.runestar.tfudeob.MainKt.deob(Main.kt:45)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt:11)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static native boolean nativeShapeIntersectsAny(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final int p14, final int p15);
    
    private static void aq(final DiscreteDynamicsWorld discreteDynamicsWorld, final int n) {
        if (discreteDynamicsWorld.i.length < n) {
            discreteDynamicsWorld.i = new long[n];
            discreteDynamicsWorld.o = new float[n * 3];
            discreteDynamicsWorld.a = new float[n * 3];
            discreteDynamicsWorld.f = new float[n];
        }
    }
    
    public ArrayList ai(final Vector3 vector3, final Vector3 vector4, final int n, final int n2, final boolean b, final boolean b2, final ArrayList list, final int n3) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native int nativeGetRayIntersections(final long p0, final float p1, final float p2, final float p3, final float p4, final float p5, final float p6, final long[] p7, final float[] p8, final float[] p9, final float[] p10, final boolean p11, final boolean p12, final int p13, final int p14);
    
    private static native int nativeGetShapeIntersections(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final long[] p14, final float[] p15, final float[] p16, final int p17, final int p18);
    
    public void au() {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        this.ar();
        DiscreteDynamicsWorld.logger.debug("Optimizing broadphase... ");
        H46.q();
        nativeOptimizeBroadphase(this.d, 64);
        DiscreteDynamicsWorld.logger.debug("                          succeded.");
        H46.j();
    }
    
    public static float av(final DiscreteDynamicsWorld discreteDynamicsWorld) {
        return discreteDynamicsWorld.m;
    }
    
    public float ao(final float n, final float n2) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        return getHeightfieldHeightAt(this.d, n, n2, Float.NaN);
    }
    
    private static native float getHeightfieldHeightAt(final long p0, final float p1, final float p2, final float p3);
    
    public void ar() {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native long nativeCreateDynamicRigidBody(final long p0, final float p1, final long p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final float p14, final float p15, final float p16, final float p17, final float p18, final float p19, final int p20, final int p21, final boolean p22, final boolean p23, final float p24, final float p25, final float p26, final float p27, final float p28, final float p29, final float p30);
    
    public void am(final int n, final int n2, final boolean b, final boolean b2) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public static void as(final DiscreteDynamicsWorld discreteDynamicsWorld, final int n, final int n2, final boolean b) {
        discreteDynamicsWorld.am(n, n2, b, false);
    }
    
    public void ac() {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public static native void nativeUpdateBroadphaseCache(final long p0);
    
    @Override
    protected void finalize() {
        if (this.d != 0L) {
            DiscreteDynamicsWorld.logger.error("DiscreteDynamicsWorld GC'd without being destroyed properly!");
            this.ab();
        }
    }
    
    public void ab() {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeQuit(final long p0);
    
    private static native int nativeDumpProfile(final long p0, final ByteBuffer p1, final int p2);
    
    private static native int nativeDumpStatus(final long p0, final ByteBuffer p1, final int p2);
    
    public static void ax(final DiscreteDynamicsWorld discreteDynamicsWorld, final float n) {
        for (int i = 0; i < discreteDynamicsWorld.j.length; ++i) {
            final BulletVehicle bulletVehicle = discreteDynamicsWorld.j[i];
            if (bulletVehicle != null) {
                bulletVehicle.p(n);
            }
        }
        for (int j = 0; j < aj(discreteDynamicsWorld); ++j) {
            final CollisionObject collisionObject = discreteDynamicsWorld.q[j];
            if (collisionObject instanceof CharacterController) {
                ((CharacterController)collisionObject).z(n);
            }
        }
    }
    
    private static native void nativeOptimizeBroadphase(final long p0, final int p1);
    
    private static native long nativeCreateVehicle(final long p0, final long p1, final int p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final float p14, final float p15, final float p16, final float p17, final float p18, final float p19, final float p20, final float p21, final float p22, final boolean p23, final boolean p24, final boolean p25, final boolean p26, final boolean p27, final boolean p28, final float p29, final float p30, final float p31, final float p32, final int p33, final int p34);
    
    public static native boolean nativeGroupsCollide(final long p0, final int p1, final int p2);
    
    private static native void nativeStepSimulation(final long p0, final float p1);
    
    static {
        c = !DiscreteDynamicsWorld.class.desiredAssertionStatus();
        logger = LoggerFactory.getLogger(DiscreteDynamicsWorld.class);
    }
    
    private static native long nativeCreateStaticRigidBody(final long p0, final long p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final float p14, final float p15, final int p16, final int p17, final boolean p18, final boolean p19);
    
    public boolean c(final Vector3 vector3, final Vector3 vector4, final int n, final int n2) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public E6 q(final float n) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    private static native void nativeEnableBody(final long p0, final long p1);
    
    public void i() {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public Object ap(final long n) {
        if (!DiscreteDynamicsWorld.c && n >= this.s + this.b + this.h) {
            throw new AssertionError();
        }
        if (this.q[(int)n] != null) {
            return this.q[(int)n].w;
        }
        return null;
    }
    
    public void aw() {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public static native void nativeSetGroupsCollide(final long p0, final int p1, final int p2, final boolean p3, final boolean p4);
    
    public void ak(final ArrayList list) {
        this.d;
        0L;
        throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
    }
    
    public void t(final E6 p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //     4: lconst_0       
        //     5: lcmp           
        //     6: ifeq            14
        //     9: aload_1        
        //    10: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    13: lconst_0       
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc             "The physics world has already been destroyed. Track the culprit who's still holding the reference."
        //    20: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    23: athrow         
        //    24: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.q:()V
        //    27: getstatic       com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.c:Z
        //    30: ifne            48
        //    33: aload_0        
        //    34: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.w:I
        //    37: ifgt            48
        //    40: new             Ljava/lang/AssertionError;
        //    43: dup            
        //    44: invokespecial   java/lang/AssertionError.<init>:()V
        //    47: athrow         
        //    48: aload_1        
        //    49: getfield        com/jagex/jnibindings/runetek6/jagbullet/E6.g:J
        //    52: aload_0        
        //    53: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.d:J
        //    56: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.nativeDestroyCollisionShape:(JJ)V
        //    59: aload_0        
        //    60: dup            
        //    61: getfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.w:I
        //    64: iconst_1       
        //    65: isub           
        //    66: putfield        com/jagex/jnibindings/runetek6/jagbullet/DiscreteDynamicsWorld.w:I
        //    69: invokestatic    com/jagex/jnibindings/runetek6/jagbullet/H46.j:()V
        //    72: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0014 (coming from #0013).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        //     at org.runestar.tfudeob.MainKt.decompileProcyon(Main.kt:63)
        //     at org.runestar.tfudeob.MainKt.deob(Main.kt:45)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt:11)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Vector3 aa(final float n, final float n2) {
        if (this.d == 0L) {
            throw new IllegalStateException("The physics world has already been destroyed. Track the culprit who's still holding the reference.");
        }
        final float[] array = new float[3];
        if (getHeightfieldNormalAt(this.d, n, n2, array)) {
            return new Vector3(array[0], array[1], array[2]);
        }
        return null;
    }
}
