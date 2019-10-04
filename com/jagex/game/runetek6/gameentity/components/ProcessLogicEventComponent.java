/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class ProcessLogicEventComponent
extends Component {
    public static final int g = StringTools.l(ProcessLogicEventComponent.class.getName());

    public static void g(ProcessLogicEventComponent processLogicEventComponent, float f) {
        processLogicEventComponent.getEntity().eh("__processLogic", Float.valueOf(f));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ProcessLogicEventComponent create() {
        return new ProcessLogicEventComponent();
    }
}

