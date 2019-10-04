package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class T516 implements ActionListener {
   // $FF: synthetic field
   final Y227 g;

   // $FF: synthetic method
   T516(Y227 var1, G510 var2) {
      this(var1);
   }

   private T516(Y227 var1) {
      this.g = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      float[] var2 = new float[16];
      if (this.g.g != 0L) {
         int var3 = 0;
         String var4 = "final_position=\"";
         Component[] var5 = this.g.e.getComponents();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Component var8 = var5[var7];
            if (var8 instanceof JTextField) {
               if (var3 > 0) {
                  var4 = var4 + ",";
               }

               var4 = var4 + ((JTextField)var8).getText();
               ++var3;
               if (var3 == 3 || var3 == 7 || var3 == 11 || var3 == 15) {
                  ++var3;
               }
            }
         }

         System.out.println(var4 + "\"");
      }

   }
}
