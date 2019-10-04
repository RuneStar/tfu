// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

public class Im133
{
    private static final boolean d = true;
    private static final boolean g = false;
    private static final int j = 200000000;
    private static final boolean q = true;
    private byte[] b;
    private Is139 e;
    private int h;
    private long l;
    private long p;
    private byte[] r;
    private int s;
    private long u;
    private long v;
    private int w;
    private long x;
    private int y;
    private long z;
    
    private static void w(final Im133 im133, final long n) throws IOException {
        final long x = (n + im133.h - 1L) / im133.h * im133.h + im133.s;
        Is139.s(im133.e, x);
        im133.x = x;
    }
    
    public static void g(final Im133 im133) throws IOException {
        l(im133);
        Is139.j(im133.e);
    }
    
    public Im133(final Is139 e, final int n, final int n2) throws IOException {
        this.l = -1L;
        this.v = -1L;
        this.y = 0;
        this.e = e;
        final long e2 = Is139.e(e);
        this.x = e2;
        this.u = e2;
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
    
    public static final File j(final Im133 im133) {
        return Is139.g(im133.e);
    }
    
    public void h(final byte[] array, int i, int j) throws IOException {
        try {
            if (i + j > array.length) {
                throw new ArrayIndexOutOfBoundsException(i + j - array.length);
            }
            if (this.v != -1L && this.p >= this.v && this.p + j <= this.v + this.y) {
                System.arraycopy(this.r, (int)(this.p - this.v), array, i, j);
                this.p += j;
                return;
            }
            final long p3 = this.p;
            final int n = i;
            final int n2 = j;
            if (this.p >= this.l && this.p < this.l + this.w) {
                int n3 = (int)(this.w - (this.p - this.l));
                if (n3 > j) {
                    n3 = j;
                }
                System.arraycopy(this.b, (int)(this.p - this.l), array, i, n3);
                this.p += n3;
                i += n3;
                j -= n3;
            }
            if (j > this.b.length) {
                Is139.d(this.e, this.p);
                this.z = this.p;
                while (j > 0) {
                    final int h = Is139.h(this.e, array, i, j);
                    if (h == -1) {
                        break;
                    }
                    this.z += h;
                    this.p += h;
                    i += h;
                    j -= h;
                }
            }
            else if (j > 0) {
                s(this);
                int w = j;
                if (w > this.w) {
                    w = this.w;
                }
                System.arraycopy(this.b, 0, array, i, w);
                i += w;
                j -= w;
                this.p += w;
            }
            if (this.v != -1L) {
                if (this.v > this.p && j > 0) {
                    int n4 = i + (int)(this.v - this.p);
                    if (n4 > i + j) {
                        n4 = i + j;
                    }
                    while (i < n4) {
                        array[i++] = 0;
                        --j;
                        ++this.p;
                    }
                }
                long v = -1L;
                long p4 = -1L;
                if (this.v >= p3 && this.v < p3 + n2) {
                    v = this.v;
                }
                else if (p3 >= this.v && p3 < this.v + this.y) {
                    v = p3;
                }
                if (this.v + this.y > p3 && this.v + this.y <= p3 + n2) {
                    p4 = this.v + this.y;
                }
                else if (p3 + n2 > this.v && p3 + n2 <= this.v + this.y) {
                    p4 = p3 + n2;
                }
                if (v > -1L && p4 > v) {
                    System.arraycopy(this.r, (int)(v - this.v), array, n + (int)(v - p3), (int)(p4 - v));
                    if (p4 > this.p) {
                        j -= (int)(p4 - this.p);
                        this.p = p4;
                    }
                }
            }
        }
        catch (IOException ex) {
            this.z = -1L;
            throw ex;
        }
        if (j > 0) {
            throw new EOFException();
        }
    }
    
    private static void s(final Im133 im133) throws IOException {
        im133.w = 0;
        if (im133.z != im133.p) {
            Is139.d(im133.e, im133.p);
            im133.z = im133.p;
        }
        im133.l = im133.p;
        while (im133.w < im133.b.length) {
            int n = im133.b.length - im133.w;
            if (n > 200000000) {
                n = 200000000;
            }
            final int h = Is139.h(im133.e, im133.b, im133.w, n);
            if (h == -1) {
                break;
            }
            im133.z += h;
            im133.w += h;
        }
    }
    
    public static void b(final Im133 im133, final byte[] array, int n, int n2) throws IOException {
        try {
            if (im133.p + n2 > im133.u) {
                im133.u = im133.p + n2;
            }
            if (im133.v != -1L && (im133.p < im133.v || im133.p > im133.v + im133.y)) {
                l(im133);
            }
            if (im133.v != -1L && im133.p + n2 > im133.v + im133.r.length) {
                final int n3 = (int)(im133.r.length - (im133.p - im133.v));
                System.arraycopy(array, n, im133.r, (int)(im133.p - im133.v), n3);
                im133.p += n3;
                n += n3;
                n2 -= n3;
                im133.y = im133.r.length;
                l(im133);
            }
            if (n2 > im133.r.length) {
                if (im133.z != im133.p) {
                    Is139.d(im133.e, im133.p);
                    im133.z = im133.p;
                }
                if (im133.h > 0 && im133.z + n2 > im133.x) {
                    w(im133, im133.z + n2);
                }
                im133.e.q(array, n, n2);
                im133.z += n2;
                if (im133.z > im133.x) {
                    im133.x = im133.z;
                }
                long n4 = -1L;
                long n5 = -1L;
                if (im133.p >= im133.l && im133.p < im133.l + im133.w) {
                    n4 = im133.p;
                }
                else if (im133.l >= im133.p && im133.l < im133.p + n2) {
                    n4 = im133.l;
                }
                if (im133.p + n2 > im133.l && im133.p + n2 <= im133.l + im133.w) {
                    n5 = im133.p + n2;
                }
                else if (im133.l + im133.w > im133.p && im133.l + im133.w <= im133.p + n2) {
                    n5 = im133.l + im133.w;
                }
                if (n4 > -1L && n5 > n4) {
                    System.arraycopy(array, (int)(n + n4 - im133.p), im133.b, (int)(n4 - im133.l), (int)(n5 - n4));
                }
                im133.p += n2;
                return;
            }
            if (n2 > 0) {
                if (im133.v == -1L) {
                    im133.v = im133.p;
                }
                System.arraycopy(array, n, im133.r, (int)(im133.p - im133.v), n2);
                im133.p += n2;
                if (im133.p - im133.v > im133.y) {
                    im133.y = (int)(im133.p - im133.v);
                }
            }
        }
        catch (IOException ex) {
            im133.z = -1L;
            throw ex;
        }
    }
    
    public static void l(final Im133 im133) throws IOException {
        if (im133.v != -1L) {
            if (im133.z != im133.v) {
                Is139.d(im133.e, im133.v);
                im133.z = im133.v;
            }
            if (im133.h > 0 && im133.z + im133.y > im133.x) {
                w(im133, im133.z + im133.y);
            }
            im133.e.q(im133.r, 0, im133.y);
            if (Io438.g(Is139.g(im133.e))) {
                Is139.b(im133.e);
            }
            im133.z += im133.y;
            if (im133.z > im133.x) {
                im133.x = im133.z;
            }
            long n = -1L;
            long n2 = -1L;
            if (im133.v >= im133.l && im133.v < im133.l + im133.w) {
                n = im133.v;
            }
            else if (im133.l >= im133.v && im133.l < im133.v + im133.y) {
                n = im133.l;
            }
            if (im133.v + im133.y > im133.l && im133.v + im133.y <= im133.l + im133.w) {
                n2 = im133.v + im133.y;
            }
            else if (im133.l + im133.w > im133.v && im133.l + im133.w <= im133.v + im133.y) {
                n2 = im133.l + im133.w;
            }
            if (n > -1L && n2 > n) {
                System.arraycopy(im133.r, (int)(n - im133.v), im133.b, (int)(n - im133.l), (int)(n2 - n));
            }
            im133.v = -1L;
            im133.y = 0;
        }
    }
    
    public static void e(final Im133 im133, final byte[] array) throws IOException {
        im133.h(array, 0, array.length);
    }
    
    public void d(final long p) throws IOException {
        if (p < 0L) {
            throw new IOException();
        }
        this.p = p;
    }
    
    public Im133(final File file, final String s, final int n, final int n2, final int h, final int s2) throws IOException {
        this.l = -1L;
        this.v = -1L;
        this.y = 0;
        this.e = new Is139(file, s, -1L);
        final long length = file.length();
        this.x = length;
        this.u = length;
        this.b = new byte[n];
        this.r = new byte[n2];
        this.h = h;
        this.s = s2;
        this.p = 0L;
    }
}
