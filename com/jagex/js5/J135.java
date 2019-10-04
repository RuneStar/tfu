/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.H362;
import com.jagex.js5.S136;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import tfu.Gg3;

public class J135
extends S136 {
    protected H362 d;
    private byte[] g;
    protected boolean j = false;
    protected byte[][] q;

    public J135(URL uRL) throws IOException {
        this(uRL, false);
    }

    public J135(DataInputStream dataInputStream) throws IOException {
        this(dataInputStream, false);
    }

    public J135(byte[] arrby, boolean bl) throws IOException {
        this.e(new DataInputStream(new ByteArrayInputStream(arrby)), bl, false);
    }

    @Override
    protected int w(int n) {
        if (this.q[n] != null) {
            return 100;
        }
        return 0;
    }

    public J135(File file) throws IOException {
        this(file, false);
    }

    public J135(File file, boolean bl) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        this.e(dataInputStream, bl, false);
        dataInputStream.close();
    }

    public J135(File file, boolean bl, boolean bl2) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        this.e(dataInputStream, bl, bl2);
        dataInputStream.close();
    }

    public static void j(J135 j135, boolean bl) {
        j135.j = bl;
    }

    public J135(URL uRL, boolean bl) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
        this.e(dataInputStream, bl, false);
        dataInputStream.close();
    }

    @Override
    public byte[] q(int n) {
        byte[] arrby = this.q[n];
        if (this.j) {
            this.q[n] = null;
        }
        return arrby;
    }

    @Override
    public H362 d() {
        return this.d;
    }

    public static int h(J135 j135) {
        return j135.q.length;
    }

    private void e(DataInputStream dataInputStream, boolean bl, boolean bl2) throws IOException {
        int n;
        int n2 = dataInputStream.read();
        int n3 = n = dataInputStream.readInt();
        if (n2 != 0) {
            n += 4;
        }
        Gg3 gg3 = new Gg3(n + 5);
        Gg3.k(gg3, n2);
        Gg3.a(gg3, n3);
        dataInputStream.readFully(gg3.r, gg3.v, n);
        if (bl) {
            this.g = gg3.r;
        }
        this.d = new H362(gg3.r, true);
        this.q = new byte[this.d.l][];
        if (bl2) {
            return;
        }
        for (int i = 0; i < this.d.e; ++i) {
            n2 = dataInputStream.read();
            n3 = n = dataInputStream.readInt();
            if (n2 != 0) {
                n += 4;
            }
            gg3 = new Gg3(n + 5);
            Gg3.k(gg3, n2);
            Gg3.a(gg3, n3);
            int n4 = 33554432;
            while (n > 33554432) {
                dataInputStream.readFully(gg3.r, gg3.v, 33554432);
                gg3.v += 33554432;
                n -= 33554432;
            }
            dataInputStream.readFully(gg3.r, gg3.v, n);
            this.q[this.d.h[i]] = gg3.r;
        }
    }

    @Override
    public int s() {
        return J135.i(this);
    }

    @Override
    public int b() {
        return J135.h(this);
    }

    public J135(DataInputStream dataInputStream, boolean bl) throws IOException {
        this.e(dataInputStream, bl, false);
    }

    public J135(byte[] arrby) throws IOException {
        this(arrby, false);
    }
}

