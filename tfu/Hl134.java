/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import tfu.Im133;

public final class Hl134 {
    private static final boolean g = true;
    private static byte[] q = new byte[520];
    private Im133 d = null;
    private int e;
    private int h = 65000;
    private Im133 j = null;
    File[] s = new File[256];

    public static byte[] g(Hl134 hl134, int n) {
        Im133 im133 = hl134.j;
        synchronized (im133) {
            try {
                if (hl134.d.q() < (long)(n * 6 + 6)) {
                    return null;
                }
                hl134.d.d(n * 6);
                hl134.d.h(q, 0, 6);
                int n2 = ((q[0] & 0xFF) << 16) + ((q[1] & 0xFF) << 8) + (q[2] & 0xFF);
                int n3 = ((q[3] & 0xFF) << 16) + ((q[4] & 0xFF) << 8) + (q[5] & 0xFF);
                if (n2 < 0 || n2 > hl134.h) {
                    return null;
                }
                if (n3 <= 0 || (long)n3 > hl134.j.q() / 520L) {
                    return null;
                }
                byte[] arrby = new byte[n2];
                int n4 = 0;
                int n5 = 0;
                while (n4 < n2) {
                    int n6;
                    int n7;
                    int n8;
                    int n9;
                    int n10;
                    if (n3 == 0) {
                        return null;
                    }
                    hl134.j.d((long)n3 * 520L);
                    int n11 = n2 - n4;
                    if (n > 65535) {
                        if (n11 > 510) {
                            n11 = 510;
                        }
                        n7 = 10;
                        hl134.j.h(q, 0, n11 + n7);
                        n10 = ((q[0] & 0xFF) << 24) + ((q[1] & 0xFF) << 16) + ((q[2] & 0xFF) << 8) + (q[3] & 0xFF);
                        n8 = ((q[4] & 0xFF) << 8) + (q[5] & 0xFF);
                        n6 = ((q[6] & 0xFF) << 16) + ((q[7] & 0xFF) << 8) + (q[8] & 0xFF);
                        n9 = q[9] & 0xFF;
                    } else {
                        if (n11 > 512) {
                            n11 = 512;
                        }
                        n7 = 8;
                        hl134.j.h(q, 0, n11 + n7);
                        n10 = ((q[0] & 0xFF) << 8) + (q[1] & 0xFF);
                        n8 = ((q[2] & 0xFF) << 8) + (q[3] & 0xFF);
                        n6 = ((q[4] & 0xFF) << 16) + ((q[5] & 0xFF) << 8) + (q[6] & 0xFF);
                        n9 = q[7] & 0xFF;
                    }
                    if (n10 != n || n8 != n5 || n9 != hl134.e) {
                        return null;
                    }
                    if (n6 < 0 || (long)n6 > hl134.j.q() / 520L) {
                        return null;
                    }
                    int n12 = n7 + n11;
                    for (int i = n7; i < n12; ++i) {
                        arrby[n4++] = q[i];
                    }
                    n3 = n6;
                    ++n5;
                }
                return arrby;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return null;
            }
        }
    }

    private static boolean q(Hl134 hl134, int n, byte[] arrby, int n2, boolean bl) {
        Im133 im133 = hl134.j;
        synchronized (im133) {
            try {
                int n3;
                if (bl) {
                    if (hl134.d.q() < (long)(n * 6 + 6)) {
                        return false;
                    }
                    hl134.d.d(n * 6);
                    hl134.d.h(q, 0, 6);
                    n3 = ((q[3] & 0xFF) << 16) + ((q[4] & 0xFF) << 8) + (q[5] & 0xFF);
                    if (n3 <= 0 || (long)n3 > hl134.j.q() / 520L) {
                        return false;
                    }
                } else {
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
                Im133.b(hl134.d, q, 0, 6);
                int n4 = 0;
                int n5 = 0;
                while (n4 < n2) {
                    int n6;
                    int n7 = 0;
                    if (bl) {
                        int n8;
                        int n9;
                        hl134.j.d((long)n3 * 520L);
                        if (n > 65535) {
                            try {
                                hl134.j.h(q, 0, 10);
                            }
                            catch (EOFException eOFException) {
                                break;
                            }
                            n6 = ((q[0] & 0xFF) << 24) + ((q[1] & 0xFF) << 16) + ((q[2] & 0xFF) << 8) + (q[3] & 0xFF);
                            n8 = ((q[4] & 0xFF) << 8) + (q[5] & 0xFF);
                            n7 = ((q[6] & 0xFF) << 16) + ((q[7] & 0xFF) << 8) + (q[8] & 0xFF);
                            n9 = q[9] & 0xFF;
                        } else {
                            try {
                                hl134.j.h(q, 0, 8);
                            }
                            catch (EOFException eOFException) {
                                break;
                            }
                            n6 = ((q[0] & 0xFF) << 8) + (q[1] & 0xFF);
                            n8 = ((q[2] & 0xFF) << 8) + (q[3] & 0xFF);
                            n7 = ((q[4] & 0xFF) << 16) + ((q[5] & 0xFF) << 8) + (q[6] & 0xFF);
                            n9 = q[7] & 0xFF;
                        }
                        if (n6 != n || n8 != n5 || n9 != hl134.e) {
                            return false;
                        }
                        if (n7 < 0 || (long)n7 > hl134.j.q() / 520L) {
                            return false;
                        }
                    }
                    if (n7 == 0) {
                        bl = false;
                        n7 = (int)((hl134.j.q() + 519L) / 520L);
                        if (n7 == 0) {
                            ++n7;
                        }
                        if (n7 == n3) {
                            ++n7;
                        }
                    }
                    if (n2 - n4 <= 512) {
                        n7 = 0;
                    }
                    if (n > 65535) {
                        Hl134.q[0] = (byte)(n >> 24);
                        Hl134.q[1] = (byte)(n >> 16);
                        Hl134.q[2] = (byte)(n >> 8);
                        Hl134.q[3] = (byte)n;
                        Hl134.q[4] = (byte)(n5 >> 8);
                        Hl134.q[5] = (byte)n5;
                        Hl134.q[6] = (byte)(n7 >> 16);
                        Hl134.q[7] = (byte)(n7 >> 8);
                        Hl134.q[8] = (byte)n7;
                        Hl134.q[9] = (byte)hl134.e;
                        hl134.j.d((long)n3 * 520L);
                        Im133.b(hl134.j, q, 0, 10);
                        n6 = n2 - n4;
                        if (n6 > 510) {
                            n6 = 510;
                        }
                        Im133.b(hl134.j, arrby, n4, n6);
                        n4 += n6;
                    } else {
                        Hl134.q[0] = (byte)(n >> 8);
                        Hl134.q[1] = (byte)n;
                        Hl134.q[2] = (byte)(n5 >> 8);
                        Hl134.q[3] = (byte)n5;
                        Hl134.q[4] = (byte)(n7 >> 16);
                        Hl134.q[5] = (byte)(n7 >> 8);
                        Hl134.q[6] = (byte)n7;
                        Hl134.q[7] = (byte)hl134.e;
                        hl134.j.d((long)n3 * 520L);
                        Im133.b(hl134.j, q, 0, 8);
                        n6 = n2 - n4;
                        if (n6 > 512) {
                            n6 = 512;
                        }
                        Im133.b(hl134.j, arrby, n4, n6);
                        n4 += n6;
                    }
                    n3 = n7;
                    ++n5;
                }
                return true;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return false;
            }
        }
    }

    public String toString() {
        return "Cache:" + this.e;
    }

    public boolean d(int n, byte[] arrby, int n2) {
        Im133 im133 = this.j;
        synchronized (im133) {
            if (n2 < 0 || n2 > this.h) {
                throw new IllegalArgumentException("Error in filesystem_client.save invalid len - len:" + n2 + " maxlen:" + this.h);
            }
            boolean bl = Hl134.q(this, n, arrby, n2, true);
            if (!bl) {
                bl = Hl134.q(this, n, arrby, n2, false);
            }
            return bl;
        }
    }

    public Hl134(int n, Im133 im133, Im133 im1332, int n2) {
        this.e = n;
        this.j = im133;
        this.d = im1332;
        this.h = n2;
        if (this.s[n] != null && !this.s[n].equals(Im133.j(im1332))) {
            throw new RuntimeException("filesystem_client: duplicate fsid - fsid:" + this.e + " idx1:" + this.s[n] + " idx2:" + Im133.j(im1332));
        }
        this.s[n] = Im133.j(im1332);
    }
}

