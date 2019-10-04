package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

class M216 extends DefaultTreeCellRenderer {
   // $FF: synthetic field
   final RuntimeTool g;

   M216(RuntimeTool var1) {
      this.g = var1;
   }

   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      DefaultMutableTreeNode var8 = (DefaultMutableTreeNode)var2;
      super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      A213 var9 = (A213)var8.getUserObject();
      int var10 = var9.d.indexOf(" - ");
      if (var10 > 0) {
         var9.d.substring(0, var10);
         var9.d = var9.d.substring(0, var10) + " - " + Float.toString(StateManager.getZoneLastTime(var9.g));
      } else {
         var9.d = var9.d + " - " + StateManager.getZoneLastTime(var9.g);
      }

      this.setForeground(Color.black);
      return this;
   }
}
