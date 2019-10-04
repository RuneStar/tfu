package tfu;

import java.lang.ref.ReferenceQueue;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

   public static Ba115 d(Bc288 var0) {
      Ba115 var1 = (Ba115)q.get(var0);
      if (var1 != null) {
         throw new IllegalStateException("Generator has already been created for GameEntityIdType " + var0);
      } else {
         var1 = new Ba115(var0, false, 0);
         q.put(var0, var1);
         return var1;
      }
   }

   public static boolean q(Bc288 var0) {
      return q.containsKey(var0);
   }

   public static Ba115 j(Bc288 var0) {
      Ba115 var1 = (Ba115)q.get(var0);
      if (var1 == null) {
         throw new IllegalStateException("Generator hasn't been created for GameEntityIdType " + var0);
      } else {
         return var1;
      }
   }

   public static Ba115 g(Bc288 var0, int var1) {
      Ba115 var2 = (Ba115)q.get(var0);
      if (var2 != null) {
         throw new IllegalStateException("Generator has already been created for GameEntityIdType " + var0);
      } else if (var1 < 1) {
         throw new IllegalArgumentException();
      } else {
         var2 = new Ba115(var0, true, var1);
         q.put(var0, var2);
         return var2;
      }
   }

   private Ba115(Bc288 var1, boolean var2, int var3) {
      this.j = var1;
      this.e = 0;
      if (var2) {
         this.s = null;
         this.b = null;
      } else {
         this.s = new SecureRandom();
         this.b = new short[65536];

         for(int var4 = 0; var4 < 65536; ++var4) {
            this.b[var4] = (short)var4;
         }

         Bo314.d(this.s, this.b);
      }

      this.h = var3;
   }

   public synchronized Bb4 h() {
      this.e();

      for(int var1 = 0; var1 < 2; ++var1) {
         for(int var2 = 0; var2 < 65536; ++var2) {
            int var3 = this.e++ & '\uffff';
            if (this.b != null) {
               if (var3 == 0) {
                  for(int var4 = 0; var4 < 65536; ++var4) {
                     int var5 = var4 + 16384;
                     if (var5 > 65536) {
                        var5 = 65536;
                     }

                     int var6 = var4 + this.s.nextInt(var5 - var4);
                     short var7 = this.b[var4];
                     this.b[var4] = this.b[var6];
                     this.b[var6] = var7;
                  }
               }

               var3 = this.b[var3] & '\uffff';
            }

            Integer var8 = var3;
            if (!this.l.containsKey(var8)) {
               Bb4 var9 = new Bb4(this.j, var3);
               Bi663 var10 = (Bi663)this.l.putIfAbsent(var8, new Bi663(var9, this.w));
               if (var10 == null) {
                  return var9;
               }
            }
         }

         if (var1 == 0) {
            logger.warn("Having trouble finding an unused GameEntityId - invoking GC. This will be slow and should never normally be necessary. Check for errors about IDs never explicitly released.");
            System.gc();
            this.e();
         }
      }

      throw new IllegalStateException("No slots free for GameEntityIdType " + this.j);
   }

   private void e() {
      while(true) {
         Bi663 var1 = (Bi663)this.w.poll();
         if (var1 == null) {
            return;
         }

         boolean var2 = this.l.remove(var1.g, var1);
         if (var2) {
            logger.error("GameEntityId " + new Bb4(this.j, var1.g) + " provided by GameEntityIdGenerator.allocateNext() has been garbage-collected and was never explicitly released! Please enable GameEntityIdGenerator.debugWhereAllocated if necessary.");
         }
      }
   }

   public synchronized Bt286 b(int var1) {
      if (this.b != null) {
         throw new IllegalStateException("If you're using ID block functionality, you probably want sequential IDs!");
      } else if (var1 <= this.h) {
         Bb4[] var18 = new Bb4[var1];

         for(int var19 = 0; var19 < var1; ++var19) {
            var18[var19] = this.h();
         }

         return new Bt286(var18, this.h);
      } else {
         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList(var1);
         Bb4 var4 = this.h();
         var3.add(var4);
         int var5 = 1;
         int var6 = 1;
         int[] var7 = new int[var1 + 1];

         Bb4 var9;
         int var10;
         int var10002;
         for(int var8 = 0; var5 < var1; var4 = var9) {
            var9 = this.h();
            if (var9.d != (var4.d + 1 & '\uffff')) {
               var10 = var3.size();
               var2.add(var3.toArray(new Bb4[var10]));
               if (var10 > var8) {
                  ++var6;
                  var10002 = var7[var10]++;
                  if (var6 > this.h) {
                     while(var7[var8] == 0) {
                        ++var8;
                     }

                     var10002 = var7[var8]--;
                     --var6;
                     var5 -= var8;
                  }
               }

               var3.clear();
            }

            var3.add(var9);
            ++var5;
         }

         Bb4[] var20 = new Bb4[var1];
         var10 = 0;
         Iterator var11 = var2.iterator();

         while(true) {
            while(var11.hasNext()) {
               Bb4[] var12 = (Bb4[])var11.next();
               int var13 = var12.length;
               if (var7[var13] > 0) {
                  var10002 = var7[var13]--;
                  System.arraycopy(var12, 0, var20, var10, var13);
                  var10 += var13;
               } else {
                  Bb4[] var14 = var12;
                  int var15 = var12.length;

                  for(int var16 = 0; var16 < var15; ++var16) {
                     Bb4 var17 = var14[var16];
                     this.l(var17);
                  }
               }
            }

            Bb4 var21;
            for(var11 = var3.iterator(); var11.hasNext(); var20[var10++] = var21) {
               var21 = (Bb4)var11.next();
            }

            if (var10 != var1) {
               throw new IllegalStateException();
            }

            return new Bt286(var20, this.h);
         }
      }
   }

   public synchronized Bb4 s() {
      Lb33.g(Lb33.IdProcessGcInitial);
      this.e();
      Lb33.d(Lb33.IdProcessGcInitial);

      for(int var1 = 0; var1 < 2; ++var1) {
         Lb33.g(Lb33.IdAttemptAll);
         boolean var16 = false;

         try {
            var16 = true;

            for(int var2 = 0; var2 < 65536; ++var2) {
               Lb33.g(Lb33.IdAttemptOne);
               boolean var21 = false;

               try {
                  var21 = true;
                  int var3 = this.e++ & '\uffff';
                  if (this.b != null) {
                     Lb33.g(Lb33.IdShuffle);
                     if (var3 == 0) {
                        for(int var4 = 0; var4 < 65536; ++var4) {
                           int var5 = var4 + 16384;
                           if (var5 > 65536) {
                              var5 = 65536;
                           }

                           int var6 = var4 + this.s.nextInt(var5 - var4);
                           short var7 = this.b[var4];
                           this.b[var4] = this.b[var6];
                           this.b[var6] = var7;
                        }
                     }

                     var3 = this.b[var3] & '\uffff';
                     Lb33.d(Lb33.IdShuffle);
                  }

                  Lb33.g(Lb33.IdsInUseCheck);
                  boolean var31 = false;

                  Integer var36;
                  try {
                     var31 = true;
                     var36 = var3;
                     if (this.l.containsKey(var36)) {
                        Lb33.d(Lb33.IdsInUseCheck);
                        Lb33.d(Lb33.IdAttemptOne);
                        var21 = false;
                        var31 = false;
                        continue;
                     }

                     Lb33.d(Lb33.IdsInUseCheck);
                     var31 = false;
                  } finally {
                     if (var31) {
                        Lb33.d(Lb33.IdsInUseCheck);
                     }
                  }

                  Lb33.g(Lb33.IdLastMinuteCheck);
                  boolean var26 = false;

                  Bb4 var37;
                  try {
                     var26 = true;
                     var37 = new Bb4(this.j, var3);
                     Bi663 var38 = (Bi663)this.l.putIfAbsent(var36, new Bi663(var37, this.w));
                     if (var38 != null) {
                        Lb33.d(Lb33.IdLastMinuteCheck);
                        Lb33.d(Lb33.IdAttemptOne);
                        var21 = false;
                        var26 = false;
                        continue;
                     }

                     Lb33.d(Lb33.IdLastMinuteCheck);
                     var26 = false;
                  } finally {
                     if (var26) {
                        Lb33.d(Lb33.IdLastMinuteCheck);
                     }
                  }

                  Lb33.d(Lb33.IdAttemptOne);
                  Lb33.d(Lb33.IdAttemptAll);
                  return var37;
               } finally {
                  if (var21) {
                     Lb33.d(Lb33.IdAttemptOne);
                  }
               }
            }

            if (var1 == 0) {
               logger.warn("Having trouble finding an unused GameEntityId - invoking GC. This will be slow and should never normally be necessary. Check for errors about IDs never explicitly released.");
               Lb33.g(Lb33.IdSystemGc);
               System.gc();
               Lb33.d(Lb33.IdSystemGc);
               Lb33.g(Lb33.IdProcessGcLater);
               this.e();
               Lb33.d(Lb33.IdProcessGcLater);
            }

            Lb33.d(Lb33.IdAttemptAll);
            var16 = false;
         } finally {
            if (var16) {
               Lb33.d(Lb33.IdAttemptAll);
            }
         }
      }

      throw new IllegalStateException("No slots free for GameEntityIdType " + this.j);
   }

   public void l(Bb4 var1) {
      Integer var2 = var1.d;
      Bi663 var3 = (Bi663)this.l.get(var2);
      if (var3 != null && var3.get() == var1) {
         this.l.remove(var2, var3);
      } else {
         throw new IllegalArgumentException("ID " + var1 + " was already released, or you didn't pass me the original Java object instance I returned in allocateNext()!");
      }
   }
}
