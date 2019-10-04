package com.jagex.js5;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import tfu.Gg3;

public class J135 extends S136 {
   protected H362 d;
   private byte[] g;
   protected boolean j;
   protected byte[][] q;

   public J135(URL var1) throws IOException {
      this(var1, false);
   }

   public J135(DataInputStream var1) throws IOException {
      this(var1, false);
   }

   public J135(byte[] var1, boolean var2) throws IOException {
      this.j = false;
      this.e(new DataInputStream(new ByteArrayInputStream(var1)), var2, false);
   }

   protected int w(int var1) {
      return this.q[var1] != null ? 100 : 0;
   }

   public J135(File var1) throws IOException {
      this(var1, false);
   }

   public J135(File var1, boolean var2) throws IOException {
      this.j = false;
      DataInputStream var3 = new DataInputStream(new BufferedInputStream(new FileInputStream(var1)));
      this.e(var3, var2, false);
      var3.close();
   }

   public J135(File var1, boolean var2, boolean var3) throws IOException {
      this.j = false;
      DataInputStream var4 = new DataInputStream(new BufferedInputStream(new FileInputStream(var1)));
      this.e(var4, var2, var3);
      var4.close();
   }

   public static void j(J135 var0, boolean var1) {
      var0.j = var1;
   }

   public J135(URL var1, boolean var2) throws IOException {
      this.j = false;
      DataInputStream var3 = new DataInputStream(var1.openStream());
      this.e(var3, var2, false);
      var3.close();
   }

   public byte[] q(int var1) {
      byte[] var2 = this.q[var1];
      if (this.j) {
         this.q[var1] = null;
      }

      return var2;
   }

   public H362 d() {
      return this.d;
   }

   public static int h(J135 var0) {
      return var0.q.length;
   }

   private void e(DataInputStream var1, boolean var2, boolean var3) throws IOException {
      int var4 = var1.read();
      int var5 = var1.readInt();
      int var6 = var5;
      if (var4 != 0) {
         var5 += 4;
      }

      Gg3 var7 = new Gg3(var5 + 5);
      Gg3.k(var7, var4);
      Gg3.a(var7, var6);
      var1.readFully(var7.r, var7.v, var5);
      if (var2) {
         this.g = var7.r;
      }

      this.d = new H362(var7.r, true);
      this.q = new byte[this.d.l][];
      if (!var3) {
         for(int var8 = 0; var8 < this.d.e; ++var8) {
            var4 = var1.read();
            var5 = var1.readInt();
            var6 = var5;
            if (var4 != 0) {
               var5 += 4;
            }

            var7 = new Gg3(var5 + 5);
            Gg3.k(var7, var4);
            Gg3.a(var7, var6);

            for(int var9 = 33554432; var5 > 33554432; var5 -= 33554432) {
               var1.readFully(var7.r, var7.v, 33554432);
               var7.v += 33554432;
            }

            var1.readFully(var7.r, var7.v, var5);
            this.q[this.d.h[var8]] = var7.r;
         }

      }
   }

   public int s() {
      return i(this);
   }

   public int b() {
      return h(this);
   }

   public J135(DataInputStream var1, boolean var2) throws IOException {
      this.j = false;
      this.e(var1, var2, false);
   }

   public J135(byte[] var1) throws IOException {
      this(var1, false);
   }
}
