package tfu;

import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.constants.VarLifetime;
import java.io.IOException;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;

public final class Fg140 extends SparseVarDomain {
   public static final int d = 1;
   private static final Logger logger = LoggerFactory.getLogger(Fg140.class);
   private final boolean[] e;
   public long j = -1L;
   public boolean q = false;

   public static void d(Fg140 var0) {
      for(int var1 = 0; var1 < var0.e.length; ++var1) {
         if (!var0.e[var1]) {
            var0.varValues.l(var1);
         }
      }

   }

   public void setVarValueInt(VarType var1, int var2) {
      if (this.e[var1.id]) {
         this.q = true;
      }

      super.setVarValueInt(var1, var2);
   }

   public void setVarValue(VarType var1, Object var2) {
      if (this.e[var1.id]) {
         this.q = true;
      }

      super.setVarValue(var1, var2);
   }

   public void setVarValueLong(VarType var1, long var2) {
      if (this.e[var1.id]) {
         this.q = true;
      }

      super.setVarValueLong(var1, var2);
   }

   public void q(Is139 var1) {
      try {
         try {
            label198: {
               byte[] var2 = new byte[(int)Is139.e(var1)];

               int var4;
               for(int var3 = 0; var3 < var2.length; var3 += var4) {
                  var4 = Is139.h(var1, var2, var3, var2.length - var3);
                  if (var4 == -1) {
                     throw new IOException("EOF");
                  }
               }

               Gg3 var29 = new Gg3(var2);
               if (var29.r.length - var29.v < 1) {
                  try {
                     Is139.j(var1);
                  } catch (Exception var24) {
                  }

                  return;
               }

               int var5 = Gg3.ar(var29);
               if (var5 >= 0 && var5 <= 1) {
                  if (var29.r.length - var29.v < 2) {
                     try {
                        Is139.j(var1);
                     } catch (Exception var23) {
                     }

                     return;
                  }

                  int var6 = Gg3.au(var29);
                  if (var29.r.length - var29.v < var6 * 6) {
                     try {
                        Is139.j(var1);
                     } catch (Exception var22) {
                     }

                     return;
                  }

                  int var7 = 0;

                  while(true) {
                     if (var7 >= var6) {
                        break label198;
                     }

                     Kr260 var8 = client.fo.decodeVarValue(var29);
                     if (g(client.jr, var8.g)) {
                        if (!client.fo.list(var8.g).dataType.getVarBaseType().javaClass.isAssignableFrom(var8.d.getClass())) {
                           logger.info("Tried to load {} as {}", client.fo.list(var8.g).dataType.getVarBaseType(), var8.d.getClass());
                        } else {
                           super.varValues.s(var8.g, var8.d);
                        }
                     }

                     ++var7;
                  }
               }

               try {
                  Is139.j(var1);
               } catch (Exception var26) {
               }

               return;
            }
         } catch (Exception var27) {
            logger.error("Unable to load varcs", var27);

            try {
               Is139.j(var1);
            } catch (Exception var21) {
            }

            return;
         }

         try {
            Is139.j(var1);
         } catch (Exception var25) {
         }

      } finally {
         try {
            Is139.j(var1);
         } catch (Exception var20) {
         }

      }
   }

   public void j(Is139 var1) {
      boolean var14 = false;

      try {
         label102: {
            try {
               var14 = true;
               int var2 = 3;
               int var3 = 0;
               Iterator var4 = super.varValues.iterator();

               while(true) {
                  if (!var4.hasNext()) {
                     Gg3 var20 = new Gg3(var2);
                     Gg3.k(var20, 1);
                     Gg3.i(var20, var3);
                     Iterator var21 = super.varValues.iterator();

                     while(var21.hasNext()) {
                        Kr260 var6 = (Kr260)var21.next();
                        if (g(this, var6.g)) {
                           client.fo.encodeVarValue(var20, var6);
                        }
                     }

                     var1.q(var20.r, 0, var20.v);
                     break;
                  }

                  Kr260 var5 = (Kr260)var4.next();
                  if (g(this, var5.g)) {
                     var2 += client.fo.getValueEncodingLength(var5);
                     ++var3;
                  }
               }
            } catch (Exception var18) {
               logger.error("Unable to save varcs", var18);

               try {
                  Is139.j(var1);
                  var14 = false;
               } catch (Exception var16) {
                  var14 = false;
               }
               break label102;
            }

            try {
               Is139.j(var1);
               var14 = false;
            } catch (Exception var17) {
               var14 = false;
            }
         }
      } finally {
         if (var14) {
            try {
               Is139.j(var1);
            } catch (Exception var15) {
            }

         }
      }

      this.j = Gz143.g();
      this.q = false;
   }

   public static boolean g(Fg140 var0, int var1) {
      return var1 >= 0 && var1 < var0.e.length ? var0.e[var1] : false;
   }

   public Fg140(VarTypeList var1) {
      super(var1);
      this.e = new boolean[var1.length()];

      for(int var2 = 0; var2 < var1.length(); ++var2) {
         if (var1.list(var2).lifeTime == VarLifetime.PERMANENT) {
            this.e[var2] = true;
         }
      }

   }
}
