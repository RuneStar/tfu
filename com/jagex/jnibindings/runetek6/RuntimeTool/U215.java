/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.R212;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

class U215
extends DefaultTreeCellRenderer {
    final /* synthetic */ RuntimeTool g;

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)object;
        super.getTreeCellRendererComponent(jTree, object, bl, bl2, bl3, n, bl4);
        R212 r212 = (R212)defaultMutableTreeNode.getUserObject();
        if (StateManager.isActive(r212.g)) {
            this.setForeground(Color.green);
        } else {
            this.setForeground(Color.black);
        }
        return this;
    }

    U215(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }
}

