package com.jagex.maths;

import tfu.Gg3;

public final class N319 {
   public static final int d = 1;
   public static final int g = 0;
   private float[] j;
   private A307[] q;

   public void g(Vector3 var1, Vector3 var2, float var3) {
      A307[] var4 = new A307[this.q.length + 1];
      System.arraycopy(this.q, 0, var4, 0, this.q.length);
      A307 var5 = new A307();
      A307 var6 = this.q[this.q.length - 1];
      A307.d(var5, 0, A307.q(var6, 3));
      Vector3 var7 = Vector3.k(A307.q(var6, 3), A307.q(var6, 2));
      A307.d(var5, 1, Vector3.z(A307.q(var6, 3), var7));
      A307.d(var5, 3, var1);
      A307.d(var5, 2, var2);
      var4[var4.length - 1] = var5;
      this.q = var4;
      float[] var8 = new float[this.j.length + 1];
      System.arraycopy(this.j, 0, var8, 0, this.j.length);
      var8[var8.length - 1] = var3;
      this.j = var8;
   }

   public N319(Vector3[] var1, float var2, float var3) {
      this.q = new A307[1];
      this.j = new float[2];
      this.q[0] = new A307();

      for(int var4 = 0; var4 < 4; ++var4) {
         A307.d(this.q[0], var4, var1[var4]);
      }

      this.j[0] = var2;
      this.j[1] = var3;
   }

   public N319(Vector3[] var1) {
      this(var1, 0.0F, 0.0F);
   }

   public N319(Gg3 var1) {
      this.q = new A307[1];
      this.j = new float[2];
      int var2 = Gg3.br(var1);
      this.q[0] = new A307();
      A307.d(this.q[0], 0, new Vector3(var1));
      A307.d(this.q[0], 1, new Vector3(var1));
      this.j[0] = Gg3.bl(var1);
      A307.d(this.q[0], 3, new Vector3(var1));
      A307.d(this.q[0], 2, new Vector3(var1));
      this.j[1] = Gg3.bl(var1);

      for(int var3 = 2; var3 < var2; ++var3) {
         Vector3 var4 = new Vector3(var1);
         Vector3 var5 = new Vector3(var1);
         this.g(var4, var5, Gg3.bl(var1));
      }

   }
}
