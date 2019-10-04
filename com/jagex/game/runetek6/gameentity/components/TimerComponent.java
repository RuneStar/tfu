/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.G268;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.ArrayList;
import java.util.List;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="Timer")
public class TimerComponent
extends Component {
    public static final int d = StringTools.l(TimerComponent.class.getName());
    private List g = new ArrayList();

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return d;
    }

    public static void g(TimerComponent timerComponent, float f) {
        for (int i = timerComponent.g.size() - 1; i >= 0; --i) {
            float f2;
            G268 g268 = (G268)timerComponent.g.get(i);
            g268.g -= f;
            if (!(f2 < 0.0f)) continue;
            g268.d.trigger(timerComponent.getEntity(), null);
            timerComponent.g.remove(i);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void addEvent(float f, EventHandler eventHandler) {
        this.g.add(new G268(f, eventHandler));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static TimerComponent create() {
        return new TimerComponent();
    }
}

