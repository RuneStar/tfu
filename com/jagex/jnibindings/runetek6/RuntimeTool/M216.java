/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.A213;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

class M216
extends DefaultTreeCellRenderer {
    final /* synthetic */ RuntimeTool g;

    M216(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)object;
        super.getTreeCellRendererComponent(jTree, object, bl, bl2, bl3, n, bl4);
        A213 a213 = (A213)defaultMutableTreeNode.getUserObject();
        int n2 = a213.d.indexOf(" - ");
        if (n2 > 0) {
            String string = a213.d.substring(0, n2);
            a213.d = a213.d.substring(0, n2) + " - " + Float.toString(StateManager.getZoneLastTime(a213.g));
        } else {
            a213.d = a213.d + " - " + StateManager.getZoneLastTime(a213.g);
        }
        this.setForeground(Color.black);
        return this;
    }
}

