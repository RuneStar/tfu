// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.EOFException;
import java.io.IOException;
import java.io.File;

public final class Hl134
{
    private static final boolean g = true;
    private static byte[] q;
    private Im133 d;
    private int e;
    private int h;
    private Im133 j;
    File[] s;
    
    public static byte[] g(final Hl134 hl134, final int n) {
        synchronized (hl134.j) {
            try {
                if (hl134.d.q() < n * 6 + 6) {
                    return null;
                }
                hl134.d.d(n * 6);
                hl134.d.h(Hl134.q, 0, 6);
                final int n2 = ((Hl134.q[0] & 0xFF) << 16) + ((Hl134.q[1] & 0xFF) << 8) + (Hl134.q[2] & 0xFF);
                int n3 = ((Hl134.q[3] & 0xFF) << 16) + ((Hl134.q[4] & 0xFF) << 8) + (Hl134.q[5] & 0xFF);
                if (n2 < 0 || n2 > hl134.h) {
                    return null;
                }
                if (n3 <= 0 || n3 > hl134.j.q() / 520L) {
                    return null;
                }
                final byte[] array = new byte[n2];
                int i = 0;
                int n4 = 0;
                while (i < n2) {
                    if (n3 == 0) {
                        return null;
                    }
                    hl134.j.d(n3 * 520L);
                    int n5 = n2 - i;
                    int n6;
                    int n7;
                    int n8;
                    int n9;
                    int n10;
                    if (n > 65535) {
                        if (n5 > 510) {
                            n5 = 510;
                        }
                        n6 = 10;
                        hl134.j.h(Hl134.q, 0, n5 + n6);
                        n7 = ((Hl134.q[0] & 0xFF) << 24) + ((Hl134.q[1] & 0xFF) << 16) + ((Hl134.q[2] & 0xFF) << 8) + (Hl134.q[3] & 0xFF);
                        n8 = ((Hl134.q[4] & 0xFF) << 8) + (Hl134.q[5] & 0xFF);
                        n9 = ((Hl134.q[6] & 0xFF) << 16) + ((Hl134.q[7] & 0xFF) << 8) + (Hl134.q[8] & 0xFF);
                        n10 = (Hl134.q[9] & 0xFF);
                    }
                    else {
                        if (n5 > 512) {
                            n5 = 512;
                        }
                        n6 = 8;
                        hl134.j.h(Hl134.q, 0, n5 + n6);
                        n7 = ((Hl134.q[0] & 0xFF) << 8) + (Hl134.q[1] & 0xFF);
                        n8 = ((Hl134.q[2] & 0xFF) << 8) + (Hl134.q[3] & 0xFF);
                        n9 = ((Hl134.q[4] & 0xFF) << 16) + ((Hl134.q[5] & 0xFF) << 8) + (Hl134.q[6] & 0xFF);
                        n10 = (Hl134.q[7] & 0xFF);
                    }
                    if (n7 != n || n8 != n4 || n10 != hl134.e) {
                        return null;
                    }
                    if (n9 < 0 || n9 > hl134.j.q() / 520L) {
                        return null;
                    }
                    for (int n11 = n6 + n5, j = n6; j < n11; ++j) {
                        array[i++] = Hl134.q[j];
                    }
                    n3 = n9;
                    ++n4;
                }
                return array;
            }
            catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
    
    static {
        Hl134.q = new byte[520];
    }
    
    private static boolean q(final Hl134 hl134, final int n, final byte[] array, final int n2, boolean b) {
        synchronized (hl134.j) {
            try {
                int n3;
                if (b) {
                    if (hl134.d.q() < n * 6 + 6) {
                        return false;
                    }
                    hl134.d.d(n * 6);
                    hl134.d.h(Hl134.q, 0, 6);
                    n3 = ((Hl134.q[3] & 0xFF) << 16) + ((Hl134.q[4] & 0xFF) << 8) + (Hl134.q[5] & 0xFF);
                    if (n3 <= 0 || n3 > hl134.j.q() / 520L) {
                        return false;
                    }
                }
                else {
                    n3 = (int)((hl134.j.q() + 519L) / 520L);
                    if (n3 == 0) {
                        n3 = 1;
                    }
                }
                Hl134.q[0] = (byte)(n2 >> 16);
                Hl134.q[1] = (byte)(n2 >> 8);
                Hl134.q[2] = (byte)n2;
                Hl134.q[3] = (byte)(n3 >> 16);
                Hl134.q[4] = (byte)(n3 >> 8);
                Hl134.q[5] = (byte)n3;
                hl134.d.d(n * 6);
                Im133.b(hl134.d, Hl134.q, 0, 6);
                int i = 0;
                int n4 = 0;
                while (i < n2) {
                    int n5 = 0;
                    if (b) {
                        hl134.j.d(n3 * 520L);
                        int n6;
                        int n7;
                        int n8;
                        if (n > 65535) {
                            try {
                                hl134.j.h(Hl134.q, 0, 10);
                            }
                            catch (EOFException ex2) {
                                break;
                            }
                            n6 = ((Hl134.q[0] & 0xFF) << 24) + ((Hl134.q[1] & 0xFF) << 16) + ((Hl134.q[2] & 0xFF) << 8) + (Hl134.q[3] & 0xFF);
                            n7 = ((Hl134.q[4] & 0xFF) << 8) + (Hl134.q[5] & 0xFF);
                            n5 = ((Hl134.q[6] & 0xFF) << 16) + ((Hl134.q[7] & 0xFF) << 8) + (Hl134.q[8] & 0xFF);
                            n8 = (Hl134.q[9] & 0xFF);
                        }
                        else {
                            try {
                                hl134.j.h(Hl134.q, 0, 8);
                            }
                            catch (EOFException ex3) {
                                break;
                            }
                            n6 = ((Hl134.q[0] & 0xFF) << 8) + (Hl134.q[1] & 0xFF);
                            n7 = ((Hl134.q[2] & 0xFF) << 8) + (Hl134.q[3] & 0xFF);
                            n5 = ((Hl134.q[4] & 0xFF) << 16) + ((Hl134.q[5] & 0xFF) << 8) + (Hl134.q[6] & 0xFF);
                            n8 = (Hl134.q[7] & 0xFF);
                        }
                        if (n6 != n || n7 != n4 || n8 != hl134.e) {
                            return false;
                        }
                        if (n5 < 0 || n5 > hl134.j.q() / 520L) {
                            return false;
                        }
                    }
                    if (n5 == 0) {
                        b = false;
                        n5 = (int)((hl134.j.q() + 519L) / 520L);
                        if (n5 == 0) {
                            ++n5;
                        }
                        if (n5 == n3) {
                            ++n5;
                        }
                    }
                    if (n2 - i <= 512) {
                        n5 = 0;
                    }
                    if (n > 65535) {
                        Hl134.q[0] = (byte)(n >> 24);
                        Hl134.q[1] = (byte)(n >> 16);
                        Hl134.q[2] = (byte)(n >> 8);
                        Hl134.q[3] = (byte)n;
                        Hl134.q[4] = (byte)(n4 >> 8);
                        Hl134.q[5] = (byte)n4;
                        Hl134.q[6] = (byte)(n5 >> 16);
                        Hl134.q[7] = (byte)(n5 >> 8);
                        Hl134.q[8] = (byte)n5;
                        Hl134.q[9] = (byte)hl134.e;
                        hl134.j.d(n3 * 520L);
                        Im133.b(hl134.j, Hl134.q, 0, 10);
                        int n9 = n2 - i;
                        if (n9 > 510) {
                            n9 = 510;
                        }
                        Im133.b(hl134.j, array, i, n9);
                        i += n9;
                    }
                    else {
                        Hl134.q[0] = (byte)(n >> 8);
                        Hl134.q[1] = (byte)n;
                        Hl134.q[2] = (byte)(n4 >> 8);
                        Hl134.q[3] = (byte)n4;
                        Hl134.q[4] = (byte)(n5 >> 16);
                        Hl134.q[5] = (byte)(n5 >> 8);
                        Hl134.q[6] = (byte)n5;
                        Hl134.q[7] = (byte)hl134.e;
                        hl134.j.d(n3 * 520L);
                        Im133.b(hl134.j, Hl134.q, 0, 8);
                        int n10 = n2 - i;
                        if (n10 > 512) {
                            n10 = 512;
                        }
                        Im133.b(hl134.j, array, i, n10);
                        i += n10;
                    }
                    n3 = n5;
                    ++n4;
                }
                return true;
            }
            catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
    
    @Override
    public String toString() {
        return "Cache:" + this.e;
    }
    
    public boolean d(final int n, final byte[] array, final int i) {
        synchronized (this.j) {
            if (i < 0 || i > this.h) {
                throw new IllegalArgumentException("Error in filesystem_client.save invalid len - len:" + i + " maxlen:" + this.h);
            }
            boolean b = q(this, n, array, i, true);
            if (!b) {
                b = q(this, n, array, i, false);
            }
            return b;
        }
    }
    
    public Hl134(final int e, final Im133 j, final Im133 d, final int h) {
        this.j = null;
        this.d = null;
        this.h = 65000;
        this.s = new File[256];
        this.e = e;
        this.j = j;
        this.d = d;
        this.h = h;
        if (this.s[e] != null && !this.s[e].equals(Im133.j(d))) {
            throw new RuntimeException("filesystem_client: duplicate fsid - fsid:" + this.e + " idx1:" + this.s[e] + " idx2:" + Im133.j(d));
        }
        this.s[e] = Im133.j(d);
    }
}
