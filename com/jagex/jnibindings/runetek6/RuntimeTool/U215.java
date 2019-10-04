// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.Color;
import com.jagex.jnibindings.runetek6.StateManager;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

class U215 extends DefaultTreeCellRenderer
{
    final /* synthetic */ RuntimeTool g;
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object value, final boolean sel, final boolean expanded, final boolean leaf, final int row, final boolean hasFocus) {
        final DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)value;
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        if (StateManager.isActive(((R212)defaultMutableTreeNode.getUserObject()).g)) {
            this.setForeground(Color.green);
        }
        else {
            this.setForeground(Color.black);
        }
        return this;
    }
    
    U215(final RuntimeTool g) {
        this.g = g;
    }
}
