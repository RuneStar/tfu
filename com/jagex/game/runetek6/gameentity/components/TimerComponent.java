// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import java.util.ArrayList;
import com.jagex.game.runetek6.event.EventHandler;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.List;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass("Timer")
public class TimerComponent extends Component
{
    public static final int d;
    private List g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return TimerComponent.d;
    }
    
    public static void g(final TimerComponent timerComponent, final float n) {
        for (int i = timerComponent.g.size() - 1; i >= 0; --i) {
            final G268 g269;
            final G268 g268 = g269 = timerComponent.g.get(i);
            final float g270 = g269.g - n;
            g269.g = g270;
            if (g270 < 0.0f) {
                g268.d.trigger(timerComponent.getEntity(), null);
                timerComponent.g.remove(i);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void addEvent(final float n, final EventHandler eventHandler) {
        this.g.add(new G268(n, eventHandler));
    }
    
    public TimerComponent() {
        this.g = new ArrayList();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static TimerComponent create() {
        return new TimerComponent();
    }
    
    static {
        d = StringTools.l(TimerComponent.class.getName());
    }
}
