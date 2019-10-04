/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import tfu.Io438;
import tfu.Is139;

public class Im133 {
    private static final boolean d = true;
    private static final boolean g = false;
    private static final int j = 200000000;
    private static final boolean q = true;
    private byte[] b;
    private Is139 e;
    private int h;
    private long l = -1L;
    private long p;
    private byte[] r;
    private int s;
    private long u;
    private long v = -1L;
    private int w;
    private long x;
    private int y = 0;
    private long z;

    private static void w(Im133 im133, long l) throws IOException {
        long l2 = (l + (long)im133.h - 1L) / (long)im133.h * (long)im133.h + (long)im133.s;
        Is139.s(im133.e, l2);
        im133.x = l2;
    }

    public static void g(Im133 im133) throws IOException {
        Im133.l(im133);
        Is139.j(im133.e);
    }

    public Im133(Is139 is139, int n, int n2) throws IOException {
        this.e = is139;
        this.u = this.x = Is139.e(is139);
        this.b = new byte[n];
        this.r = new byte[n2];
        this.h = 0;
        this.s = 0;
        this.p = 0L;
    }

    public long q() {
        if (this.h > 0) {
            throw new IllegalArgumentException("Cannot calculate simulated length because prealloc is on");
        }
        return this.u;
    }

    public static final File j(Im133 im133) {
        return Is139.g(im133.e);
    }

    public void h(byte[] arrby, int n, int n2) throws IOException {
        try {
            int n3;
            if (n + n2 > arrby.length) {
                throw new ArrayIndexOutOfBoundsException(n + n2 - arrby.length);
            }
            if (this.v != -1L && this.p >= this.v && this.p + (long)n2 <= this.v + (long)this.y) {
                System.arraycopy(this.r, (int)(this.p - this.v), arrby, n, n2);
                this.p += (long)n2;
                return;
            }
            long l = this.p;
            int n4 = n;
            int n5 = n2;
            if (this.p >= this.l && this.p < this.l + (long)this.w) {
                n3 = (int)((long)this.w - (this.p - this.l));
                if (n3 > n2) {
                    n3 = n2;
                }
                System.arraycopy(this.b, (int)(this.p - this.l), arrby, n, n3);
                this.p += (long)n3;
                n += n3;
                n2 -= n3;
            }
            if (n2 > this.b.length) {
                Is139.d(this.e, this.p);
                this.z = this.p;
                while (n2 > 0 && (n3 = Is139.h(this.e, arrby, n, n2)) != -1) {
                    this.z += (long)n3;
                    this.p += (long)n3;
                    n += n3;
                    n2 -= n3;
                }
            } else if (n2 > 0) {
                Im133.s(this);
                n3 = n2;
                if (n3 > this.w) {
                    n3 = this.w;
                }
                System.arraycopy(this.b, 0, arrby, n, n3);
                n += n3;
                n2 -= n3;
                this.p += (long)n3;
            }
            if (this.v != -1L) {
                if (this.v > this.p && n2 > 0) {
                    n3 = n + (int)(this.v - this.p);
                    if (n3 > n + n2) {
                        n3 = n + n2;
                    }
                    while (n < n3) {
                        arrby[n++] = 0;
                        --n2;
                        ++this.p;
                    }
                }
                long l2 = -1L;
                long l3 = -1L;
                if (this.v >= l && this.v < l + (long)n5) {
                    l2 = this.v;
                } else if (l >= this.v && l < this.v + (long)this.y) {
                    l2 = l;
                }
                if (this.v + (long)this.y > l && this.v + (long)this.y <= l + (long)n5) {
                    l3 = this.v + (long)this.y;
                } else if (l + (long)n5 > this.v && l + (long)n5 <= this.v + (long)this.y) {
                    l3 = l + (long)n5;
                }
                if (l2 > -1L && l3 > l2) {
                    int n6 = (int)(l3 - l2);
                    System.arraycopy(this.r, (int)(l2 - this.v), arrby, n4 + (int)(l2 - l), n6);
                    if (l3 > this.p) {
                        n2 = (int)((long)n2 - (l3 - this.p));
                        this.p = l3;
                    }
                }
            }
        }
        catch (IOException iOException) {
            this.z = -1L;
            throw iOException;
        }
        if (n2 > 0) {
            throw new EOFException();
        }
    }

    private static void s(Im133 im133) throws IOException {
        im133.w = 0;
        if (im133.z != im133.p) {
            Is139.d(im133.e, im133.p);
            im133.z = im133.p;
        }
        im133.l = im133.p;
        while (im133.w < im133.b.length) {
            int n;
            int n2 = im133.b.length - im133.w;
            if (n2 > 200000000) {
                n2 = 200000000;
            }
            if ((n = Is139.h(im133.e, im133.b, im133.w, n2)) == -1) break;
            im133.z += (long)n;
            im133.w += n;
        }
    }

    public static void b(Im133 im133, byte[] arrby, int n, int n2) throws IOException {
        try {
            if (im133.p + (long)n2 > im133.u) {
                im133.u = im133.p + (long)n2;
            }
            if (im133.v != -1L && (im133.p < im133.v || im133.p > im133.v + (long)im133.y)) {
                Im133.l(im133);
            }
            if (im133.v != -1L && im133.p + (long)n2 > im133.v + (long)im133.r.length) {
                int n3 = (int)((long)im133.r.length - (im133.p - im133.v));
                System.arraycopy(arrby, n, im133.r, (int)(im133.p - im133.v), n3);
                im133.p += (long)n3;
                n += n3;
                n2 -= n3;
                im133.y = im133.r.length;
                Im133.l(im133);
            }
            if (n2 > im133.r.length) {
                if (im133.z != im133.p) {
                    Is139.d(im133.e, im133.p);
                    im133.z = im133.p;
                }
                if (im133.h > 0 && im133.z + (long)n2 > im133.x) {
                    Im133.w(im133, im133.z + (long)n2);
                }
                im133.e.q(arrby, n, n2);
                im133.z += (long)n2;
                if (im133.z > im133.x) {
                    im133.x = im133.z;
                }
                long l = -1L;
                long l2 = -1L;
                if (im133.p >= im133.l && im133.p < im133.l + (long)im133.w) {
                    l = im133.p;
                } else if (im133.l >= im133.p && im133.l < im133.p + (long)n2) {
                    l = im133.l;
                }
                if (im133.p + (long)n2 > im133.l && im133.p + (long)n2 <= im133.l + (long)im133.w) {
                    l2 = im133.p + (long)n2;
                } else if (im133.l + (long)im133.w > im133.p && im133.l + (long)im133.w <= im133.p + (long)n2) {
                    l2 = im133.l + (long)im133.w;
                }
                if (l > -1L && l2 > l) {
                    int n4 = (int)(l2 - l);
                    System.arraycopy(arrby, (int)((long)n + l - im133.p), im133.b, (int)(l - im133.l), n4);
                }
                im133.p += (long)n2;
                return;
            }
            if (n2 > 0) {
                if (im133.v == -1L) {
                    im133.v = im133.p;
                }
                System.arraycopy(arrby, n, im133.r, (int)(im133.p - im133.v), n2);
                im133.p += (long)n2;
                if (im133.p - im133.v > (long)im133.y) {
                    im133.y = (int)(im133.p - im133.v);
                }
                return;
            }
        }
        catch (IOException iOException) {
            im133.z = -1L;
            throw iOException;
        }
    }

    public static void l(Im133 im133) throws IOException {
        if (im133.v != -1L) {
            if (im133.z != im133.v) {
                Is139.d(im133.e, im133.v);
                im133.z = im133.v;
            }
            if (im133.h > 0 && im133.z + (long)im133.y > im133.x) {
                Im133.w(im133, im133.z + (long)im133.y);
            }
            im133.e.q(im133.r, 0, im133.y);
            if (Io438.g(Is139.g(im133.e))) {
                Is139.b(im133.e);
            }
            im133.z += (long)im133.y;
            if (im133.z > im133.x) {
                im133.x = im133.z;
            }
            long l = -1L;
            long l2 = -1L;
            if (im133.v >= im133.l && im133.v < im133.l + (long)im133.w) {
                l = im133.v;
            } else if (im133.l >= im133.v && im133.l < im133.v + (long)im133.y) {
                l = im133.l;
            }
            if (im133.v + (long)im133.y > im133.l && im133.v + (long)im133.y <= im133.l + (long)im133.w) {
                l2 = im133.v + (long)im133.y;
            } else if (im133.l + (long)im133.w > im133.v && im133.l + (long)im133.w <= im133.v + (long)im133.y) {
                l2 = im133.l + (long)im133.w;
            }
            if (l > -1L && l2 > l) {
                int n = (int)(l2 - l);
                System.arraycopy(im133.r, (int)(l - im133.v), im133.b, (int)(l - im133.l), n);
            }
            im133.v = -1L;
            im133.y = 0;
        }
    }

    public static void e(Im133 im133, byte[] arrby) throws IOException {
        im133.h(arrby, 0, arrby.length);
    }

    public void d(long l) throws IOException {
        if (l < 0L) {
            throw new IOException();
        }
        this.p = l;
    }

    public Im133(File file, String string, int n, int n2, int n3, int n4) throws IOException {
        this.e = new Is139(file, string, -1L);
        this.u = this.x = file.length();
        this.b = new byte[n];
        this.r = new byte[n2];
        this.h = n3;
        this.s = n4;
        this.p = 0L;
    }
}

