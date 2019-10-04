// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.lang.ref.ReferenceQueue;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;
import java.util.IdentityHashMap;
import org.slf4j.Logger;

public final class Ba115
{
    private static final boolean d = false;
    private static final Logger logger;
    private static IdentityHashMap q;
    private final short[] b;
    private int e;
    private final int h;
    private final Bc288 j;
    private final ConcurrentHashMap l;
    private final SecureRandom s;
    private final ReferenceQueue w;
    
    public static Ba115 d(final Bc288 key) {
        if (Ba115.q.get(key) != null) {
            throw new IllegalStateException("Generator has already been created for GameEntityIdType " + key);
        }
        final Ba115 value = new Ba115(key, false, 0);
        Ba115.q.put(key, value);
        return value;
    }
    
    public static boolean q(final Bc288 key) {
        return Ba115.q.containsKey(key);
    }
    
    public static Ba115 j(final Bc288 bc288) {
        final Ba115 ba115 = Ba115.q.get(bc288);
        if (ba115 == null) {
            throw new IllegalStateException("Generator hasn't been created for GameEntityIdType " + bc288);
        }
        return ba115;
    }
    
    public static Ba115 g(final Bc288 key, final int n) {
        if (Ba115.q.get(key) != null) {
            throw new IllegalStateException("Generator has already been created for GameEntityIdType " + key);
        }
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        final Ba115 value = new Ba115(key, true, n);
        Ba115.q.put(key, value);
        return value;
    }
    
    private Ba115(final Bc288 j, final boolean b, final int h) {
        this.l = new ConcurrentHashMap();
        this.w = new ReferenceQueue();
        this.j = j;
        this.e = 0;
        if (b) {
            this.s = null;
            this.b = null;
        }
        else {
            this.s = new SecureRandom();
            this.b = new short[65536];
            for (int i = 0; i < 65536; ++i) {
                this.b[i] = (short)i;
            }
            Bo314.d(this.s, this.b);
        }
        this.h = h;
    }
    
    public synchronized Bb4 h() {
        this.e();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 65536; ++j) {
                int k = this.e++ & 0xFFFF;
                if (this.b != null) {
                    if (k == 0) {
                        for (int l = 0; l < 65536; ++l) {
                            int n = l + 16384;
                            if (n > 65536) {
                                n = 65536;
                            }
                            final int n2 = l + this.s.nextInt(n - l);
                            final short n3 = this.b[l];
                            this.b[l] = this.b[n2];
                            this.b[n2] = n3;
                        }
                    }
                    k = (this.b[k] & 0xFFFF);
                }
                final Integer value = k;
                if (!this.l.containsKey(value)) {
                    final Bb4 bb4 = new Bb4(this.j, k);
                    if (this.l.putIfAbsent(value, new Bi663(bb4, this.w)) == null) {
                        return bb4;
                    }
                }
            }
            if (i == 0) {
                Ba115.logger.warn("Having trouble finding an unused GameEntityId - invoking GC. This will be slow and should never normally be necessary. Check for errors about IDs never explicitly released.");
                System.gc();
                this.e();
            }
        }
        throw new IllegalStateException("No slots free for GameEntityIdType " + this.j);
    }
    
    private void e() {
        while (true) {
            final Bi663 value = (Bi663)this.w.poll();
            if (value == null) {
                break;
            }
            if (!this.l.remove(value.g, value)) {
                continue;
            }
            Ba115.logger.error("GameEntityId " + new Bb4(this.j, value.g) + " provided by GameEntityIdGenerator.allocateNext() has been garbage-collected and was never explicitly released! Please enable GameEntityIdGenerator.debugWhereAllocated if necessary.");
        }
    }
    
    public synchronized Bt286 b(final int initialCapacity) {
        if (this.b != null) {
            throw new IllegalStateException("If you're using ID block functionality, you probably want sequential IDs!");
        }
        if (initialCapacity <= this.h) {
            final Bb4[] array = new Bb4[initialCapacity];
            for (int i = 0; i < initialCapacity; ++i) {
                array[i] = this.h();
            }
            return new Bt286(array, this.h);
        }
        final ArrayList<Bb4[]> list = new ArrayList<Bb4[]>();
        final ArrayList<Bb4> list2 = new ArrayList<Bb4>(initialCapacity);
        Bb4 h = this.h();
        list2.add(h);
        int j = 1;
        int n = 1;
        final int[] array2 = new int[initialCapacity + 1];
        int n2 = 0;
        while (j < initialCapacity) {
            final Bb4 h2 = this.h();
            if (h2.d != (h.d + 1 & 0xFFFF)) {
                final int size = list2.size();
                list.add(list2.toArray(new Bb4[size]));
                if (size > n2) {
                    ++n;
                    final int[] array3 = array2;
                    final int n3 = size;
                    ++array3[n3];
                    if (n > this.h) {
                        while (array2[n2] == 0) {
                            ++n2;
                        }
                        final int[] array4 = array2;
                        final int n4 = n2;
                        --array4[n4];
                        --n;
                        j -= n2;
                    }
                }
                list2.clear();
            }
            list2.add(h2);
            ++j;
            h = h2;
        }
        final Bb4[] array5 = new Bb4[initialCapacity];
        int n5 = 0;
        for (final Bb4[] array6 : list) {
            final int length = array6.length;
            if (array2[length] > 0) {
                final int[] array7 = array2;
                final int n6 = length;
                --array7[n6];
                System.arraycopy(array6, 0, array5, n5, length);
                n5 += length;
            }
            else {
                final Bb4[] array8 = array6;
                for (int length2 = array8.length, k = 0; k < length2; ++k) {
                    this.l(array8[k]);
                }
            }
        }
        final Iterator<Bb4> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            array5[n5++] = iterator2.next();
        }
        if (n5 != initialCapacity) {
            throw new IllegalStateException();
        }
        return new Bt286(array5, this.h);
    }
    
    public synchronized Bb4 s() {
        Lb33.g(Lb33.IdProcessGcInitial);
        this.e();
        Lb33.d(Lb33.IdProcessGcInitial);
        for (int i = 0; i < 2; ++i) {
            Lb33.g(Lb33.IdAttemptAll);
            try {
                for (int j = 0; j < 65536; ++j) {
                    Lb33.g(Lb33.IdAttemptOne);
                    try {
                        int k = this.e++ & 0xFFFF;
                        if (this.b != null) {
                            Lb33.g(Lb33.IdShuffle);
                            if (k == 0) {
                                for (int l = 0; l < 65536; ++l) {
                                    int n = l + 16384;
                                    if (n > 65536) {
                                        n = 65536;
                                    }
                                    final int n2 = l + this.s.nextInt(n - l);
                                    final short n3 = this.b[l];
                                    this.b[l] = this.b[n2];
                                    this.b[n2] = n3;
                                }
                            }
                            k = (this.b[k] & 0xFFFF);
                            Lb33.d(Lb33.IdShuffle);
                        }
                        Lb33.g(Lb33.IdsInUseCheck);
                        Integer value;
                        try {
                            value = k;
                            if (this.l.containsKey(value)) {
                                continue;
                            }
                        }
                        finally {
                            Lb33.d(Lb33.IdsInUseCheck);
                        }
                        Lb33.g(Lb33.IdLastMinuteCheck);
                        Bb4 bb4;
                        try {
                            bb4 = new Bb4(this.j, k);
                            if (this.l.putIfAbsent(value, new Bi663(bb4, this.w)) != null) {
                                continue;
                            }
                        }
                        finally {
                            Lb33.d(Lb33.IdLastMinuteCheck);
                        }
                        return bb4;
                    }
                    finally {
                        Lb33.d(Lb33.IdAttemptOne);
                    }
                }
                if (i == 0) {
                    Ba115.logger.warn("Having trouble finding an unused GameEntityId - invoking GC. This will be slow and should never normally be necessary. Check for errors about IDs never explicitly released.");
                    Lb33.g(Lb33.IdSystemGc);
                    System.gc();
                    Lb33.d(Lb33.IdSystemGc);
                    Lb33.g(Lb33.IdProcessGcLater);
                    this.e();
                    Lb33.d(Lb33.IdProcessGcLater);
                }
            }
            finally {
                Lb33.d(Lb33.IdAttemptAll);
            }
        }
        throw new IllegalStateException("No slots free for GameEntityIdType " + this.j);
    }
    
    static {
        logger = LoggerFactory.getLogger(Ba115.class);
        Ba115.q = new IdentityHashMap();
    }
    
    public void l(final Bb4 obj) {
        final Integer value = obj.d;
        final Bi663 value2 = this.l.get(value);
        if (value2 == null || value2.get() != obj) {
            throw new IllegalArgumentException("ID " + obj + " was already released, or you didn't pass me the original Java object instance I returned in allocateNext()!");
        }
        this.l.remove(value, value2);
    }
}
