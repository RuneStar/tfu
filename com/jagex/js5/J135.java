// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Gg3;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

public class J135 extends S136
{
    protected H362 d;
    private byte[] g;
    protected boolean j;
    protected byte[][] q;
    
    public J135(final URL url) throws IOException {
        this(url, false);
    }
    
    public J135(final DataInputStream dataInputStream) throws IOException {
        this(dataInputStream, false);
    }
    
    public J135(final byte[] buf, final boolean b) throws IOException {
        this.j = false;
        this.e(new DataInputStream(new ByteArrayInputStream(buf)), b, false);
    }
    
    @Override
    protected int w(final int n) {
        if (this.q[n] != null) {
            return 100;
        }
        return 0;
    }
    
    public J135(final File file) throws IOException {
        this(file, false);
    }
    
    public J135(final File file, final boolean b) throws IOException {
        this.j = false;
        final DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        this.e(dataInputStream, b, false);
        dataInputStream.close();
    }
    
    public J135(final File file, final boolean b, final boolean b2) throws IOException {
        this.j = false;
        final DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        this.e(dataInputStream, b, b2);
        dataInputStream.close();
    }
    
    public static void j(final J135 j135, final boolean i) {
        j135.j = i;
    }
    
    public J135(final URL url, final boolean b) throws IOException {
        this.j = false;
        final DataInputStream dataInputStream = new DataInputStream(url.openStream());
        this.e(dataInputStream, b, false);
        dataInputStream.close();
    }
    
    public byte[] q(final int n) {
        final byte[] array = this.q[n];
        if (this.j) {
            this.q[n] = null;
        }
        return array;
    }
    
    public H362 d() {
        return this.d;
    }
    
    public static int h(final J135 j135) {
        return j135.q.length;
    }
    
    private void e(final DataInputStream dataInputStream, final boolean b, final boolean b2) throws IOException {
        final int read = dataInputStream.read();
        final int int1;
        int len = int1 = dataInputStream.readInt();
        if (read != 0) {
            len += 4;
        }
        final Gg3 gg3 = new Gg3(len + 5);
        Gg3.k(gg3, read);
        Gg3.a(gg3, int1);
        dataInputStream.readFully(gg3.r, gg3.v, len);
        if (b) {
            this.g = gg3.r;
        }
        this.d = new H362(gg3.r, true);
        this.q = new byte[this.d.l][];
        if (b2) {
            return;
        }
        for (int i = 0; i < this.d.e; ++i) {
            final int read2 = dataInputStream.read();
            final int int2;
            int j = int2 = dataInputStream.readInt();
            if (read2 != 0) {
                j += 4;
            }
            final Gg3 gg4 = new Gg3(j + 5);
            Gg3.k(gg4, read2);
            Gg3.a(gg4, int2);
            while (j > 33554432) {
                dataInputStream.readFully(gg4.r, gg4.v, 33554432);
                final Gg3 gg5 = gg4;
                gg5.v += 33554432;
                j -= 33554432;
            }
            dataInputStream.readFully(gg4.r, gg4.v, j);
            this.q[this.d.h[i]] = gg4.r;
        }
    }
    
    @Override
    public int s() {
        return S136.i(this);
    }
    
    @Override
    public int b() {
        return h(this);
    }
    
    public J135(final DataInputStream dataInputStream, final boolean b) throws IOException {
        this.e(dataInputStream, b, this.j = false);
    }
    
    public J135(final byte[] array) throws IOException {
        this(array, false);
    }
}
