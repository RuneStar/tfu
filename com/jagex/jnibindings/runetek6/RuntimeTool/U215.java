package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

class U215 extends DefaultTreeCellRenderer {
   // $FF: synthetic field
   final RuntimeTool g;

   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      DefaultMutableTreeNode var8 = (DefaultMutableTreeNode)var2;
      super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      R212 var9 = (R212)var8.getUserObject();
      if (StateManager.isActive(var9.g)) {
         this.setForeground(Color.green);
      } else {
         this.setForeground(Color.black);
      }

      return this;
   }

   U215(RuntimeTool var1) {
      this.g = var1;
   }
}
