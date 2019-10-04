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

class M216 extends DefaultTreeCellRenderer
{
    final /* synthetic */ RuntimeTool g;
    
    M216(final RuntimeTool g) {
        this.g = g;
    }
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object value, final boolean sel, final boolean expanded, final boolean leaf, final int row, final boolean hasFocus) {
        final DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)value;
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        final A213 a213 = (A213)defaultMutableTreeNode.getUserObject();
        final int index = a213.d.indexOf(" - ");
        if (index > 0) {
            a213.d.substring(0, index);
            a213.d = a213.d.substring(0, index) + " - " + Float.toString(StateManager.getZoneLastTime(a213.g));
        }
        else {
            a213.d = a213.d + " - " + StateManager.getZoneLastTime(a213.g);
        }
        this.setForeground(Color.black);
        return this;
    }
}
