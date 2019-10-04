// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public class ProcessLogicEventComponent extends Component
{
    public static final int g;
    
    public static void g(final ProcessLogicEventComponent processLogicEventComponent, final float f) {
        processLogicEventComponent.getEntity().eh("__processLogic", f);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return ProcessLogicEventComponent.g;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ProcessLogicEventComponent create() {
        return new ProcessLogicEventComponent();
    }
    
    static {
        g = StringTools.l(ProcessLogicEventComponent.class.getName());
    }
}
