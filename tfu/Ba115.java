/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Bb4;
import tfu.Bc288;
import tfu.Bi663;
import tfu.Bo314;
import tfu.Bt286;
import tfu.Lb33;

public final class Ba115 {
    private static final boolean d = false;
    private static final Logger logger = LoggerFactory.getLogger(Ba115.class);
    private static IdentityHashMap q = new IdentityHashMap();
    private final short[] b;
    private int e;
    private final int h;
    private final Bc288 j;
    private final ConcurrentHashMap l = new ConcurrentHashMap();
    private final SecureRandom s;
    private final ReferenceQueue w = new ReferenceQueue();

    public static Ba115 d(Bc288 bc288) {
        Ba115 ba115 = (Ba115)q.get(bc288);
        if (ba115 != null) {
            throw new IllegalStateException("Generator has already been created for GameEntityIdType " + bc288);
        }
        ba115 = new Ba115(bc288, false, 0);
        q.put(bc288, ba115);
        return ba115;
    }

    public static boolean q(Bc288 bc288) {
        return q.containsKey(bc288);
    }

    public static Ba115 j(Bc288 bc288) {
        Ba115 ba115 = (Ba115)q.get(bc288);
        if (ba115 == null) {
            throw new IllegalStateException("Generator hasn't been created for GameEntityIdType " + bc288);
        }
        return ba115;
    }

    public static Ba115 g(Bc288 bc288, int n) {
        Ba115 ba115 = (Ba115)q.get(bc288);
        if (ba115 != null) {
            throw new IllegalStateException("Generator has already been created for GameEntityIdType " + bc288);
        }
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        ba115 = new Ba115(bc288, true, n);
        q.put(bc288, ba115);
        return ba115;
    }

    private Ba115(Bc288 bc288, boolean bl, int n) {
        this.j = bc288;
        this.e = 0;
        if (bl) {
            this.s = null;
            this.b = null;
        } else {
            this.s = new SecureRandom();
            this.b = new short[65536];
            for (int i = 0; i < 65536; ++i) {
                this.b[i] = (short)i;
            }
            Bo314.d(this.s, this.b);
        }
        this.h = n;
    }

    public synchronized Bb4 h() {
        this.e();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 65536; ++j) {
                Object object;
                Integer n;
                Object object2;
                int n2 = this.e++ & 0xFFFF;
                if (this.b != null) {
                    if (n2 == 0) {
                        for (int k = 0; k < 65536; ++k) {
                            object2 = k + 16384;
                            if (object2 > 65536) {
                                object2 = 65536;
                            }
                            object = k + this.s.nextInt(object2 - k);
                            short s = this.b[k];
                            this.b[k] = this.b[object];
                            this.b[object] = s;
                        }
                    }
                    n2 = this.b[n2] & 0xFFFF;
                }
                if (this.l.containsKey(n = Integer.valueOf(n2)) || (object = (Object)this.l.putIfAbsent(n, new Bi663((Bb4)(object2 = (Object)new Bb4(this.j, n2)), this.w))) != null) continue;
                return object2;
            }
            if (i != 0) continue;
            logger.warn("Having trouble finding an unused GameEntityId - invoking GC. This will be slow and should never normally be necessary. Check for errors about IDs never explicitly released.");
            System.gc();
            this.e();
        }
        throw new IllegalStateException("No slots free for GameEntityIdType " + this.j);
    }

    private void e() {
        Bi663 bi663;
        while ((bi663 = (Bi663)this.w.poll()) != null) {
            boolean bl = this.l.remove(bi663.g, bi663);
            if (!bl) continue;
            logger.error("GameEntityId " + new Bb4(this.j, bi663.g) + " provided by GameEntityIdGenerator.allocateNext() has been garbage-collected and was never explicitly released! Please enable GameEntityIdGenerator.debugWhereAllocated if necessary.");
        }
    }

    public synchronized Bt286 b(int n) {
        int n2;
        Bb4[] arrbb4;
        if (this.b != null) {
            throw new IllegalStateException("If you're using ID block functionality, you probably want sequential IDs!");
        }
        if (n <= this.h) {
            Bb4[] arrbb42 = new Bb4[n];
            for (int i = 0; i < n; ++i) {
                arrbb42[i] = this.h();
            }
            return new Bt286(arrbb42, this.h);
        }
        ArrayList<Bb4[]> arrayList = new ArrayList<Bb4[]>();
        ArrayList<Bb4[]> arrayList2 = new ArrayList<Bb4[]>(n);
        Bb4[] arrbb43 = this.h();
        arrayList2.add(arrbb43);
        int n3 = 1;
        int[] arrn = new int[n + 1];
        int n4 = 0;
        for (int i = 1; i < n; ++i) {
            arrbb4 = this.h();
            if (arrbb4.d != (arrbb43.d + 1 & 0xFFFF)) {
                n2 = arrayList2.size();
                arrayList.add(arrayList2.toArray(new Bb4[n2]));
                if (n2 > n4) {
                    int[] arrn2 = arrn;
                    int n5 = n2;
                    arrn2[n5] = arrn2[n5] + 1;
                    if (++n3 > this.h) {
                        while (arrn[n4] == 0) {
                            ++n4;
                        }
                        int[] arrn3 = arrn;
                        int n6 = n4;
                        arrn3[n6] = arrn3[n6] - 1;
                        --n3;
                        i -= n4;
                    }
                }
                arrayList2.clear();
            }
            arrayList2.add(arrbb4);
            arrbb43 = arrbb4;
        }
        arrbb4 = new Bb4[n];
        n2 = 0;
        for (Object object : arrayList) {
            int n7 = ((Bb4[])object).length;
            if (arrn[n7] > 0) {
                int[] arrn4 = arrn;
                int n8 = n7;
                arrn4[n8] = arrn4[n8] - 1;
                System.arraycopy(object, 0, arrbb4, n2, n7);
                n2 += n7;
                continue;
            }
            for (Bb4 bb4 : object) {
                this.l(bb4);
            }
        }
        for (Object object : arrayList2) {
            arrbb4[n2++] = object;
        }
        if (n2 != n) {
            throw new IllegalStateException();
        }
        return new Bt286(arrbb4, this.h);
    }

    public synchronized Bb4 s() {
        Lb33.g(Lb33.IdProcessGcInitial);
        this.e();
        Lb33.d(Lb33.IdProcessGcInitial);
        for (int i = 0; i < 2; ++i) {
            Lb33.g(Lb33.IdAttemptAll);
            try {
                for (int j = 0; j < 65536; ++j) {
                    Object object;
                    Bb4 bb4;
                    Lb33.g(Lb33.IdAttemptOne);
                    int n = this.e++ & 0xFFFF;
                    if (this.b != null) {
                        Lb33.g(Lb33.IdShuffle);
                        if (n == 0) {
                            for (int k = 0; k < 65536; ++k) {
                                int n2 = k + 16384;
                                if (n2 > 65536) {
                                    n2 = 65536;
                                }
                                int n3 = k + this.s.nextInt(n2 - k);
                                short s = this.b[k];
                                this.b[k] = this.b[n3];
                                this.b[n3] = s;
                            }
                        }
                        n = this.b[n] & 0xFFFF;
                        Lb33.d(Lb33.IdShuffle);
                    }
                    Lb33.g(Lb33.IdsInUseCheck);
                    Integer n4 = n;
                    if (this.l.containsKey(n4)) {
                        Lb33.d(Lb33.IdsInUseCheck);
                        Lb33.d(Lb33.IdAttemptOne);
                        continue;
                    }
                    Lb33.d(Lb33.IdsInUseCheck);
                    Lb33.g(Lb33.IdLastMinuteCheck);
                    try {
                        bb4 = new Bb4(this.j, n);
                        object = this.l.putIfAbsent(n4, new Bi663(bb4, this.w));
                        if (object != null) {
                            Lb33.d(Lb33.IdLastMinuteCheck);
                            Lb33.d(Lb33.IdAttemptOne);
                            continue;
                        }
                        Lb33.d(Lb33.IdLastMinuteCheck);
                    }
                    catch (Throwable throwable) {
                        Lb33.d(Lb33.IdLastMinuteCheck);
                        throw throwable;
                    }
                    object = bb4;
                    Lb33.d(Lb33.IdAttemptOne);
                    Lb33.d(Lb33.IdAttemptAll);
                    return object;
                }
                if (i == 0) {
                    logger.warn("Having trouble finding an unused GameEntityId - invoking GC. This will be slow and should never normally be necessary. Check for errors about IDs never explicitly released.");
                    Lb33.g(Lb33.IdSystemGc);
                    System.gc();
                    Lb33.d(Lb33.IdSystemGc);
                    Lb33.g(Lb33.IdProcessGcLater);
                    this.e();
                    Lb33.d(Lb33.IdProcessGcLater);
                }
                Lb33.d(Lb33.IdAttemptAll);
                continue;
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.IdAttemptAll);
                throw throwable;
            }
        }
        throw new IllegalStateException("No slots free for GameEntityIdType " + this.j);
    }

    public void l(Bb4 bb4) {
        Integer n = bb4.d;
        Bi663 bi663 = (Bi663)this.l.get(n);
        if (bi663 == null || bi663.get() != bb4) {
            throw new IllegalArgumentException("ID " + bb4 + " was already released, or you didn't pass me the original Java object instance I returned in allocateNext()!");
        }
        this.l.remove(n, bi663);
    }
}

