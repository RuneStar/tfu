/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity.animation;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.AnimationGraph;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.jnibindings.runetek6.SkinnedModel;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import tfu.Be2;
import tfu.Bs1;
import tfu.Kc180;

@ScriptEntryClass(value="AnimGraph")
public class AnimationGraphComponent
extends Component {
    private static final int g = 1024;
    public static final int w = StringTools.l(AnimationGraphComponent.class.getName());
    private int b;
    public Integer d;
    private final Skeleton e;
    private final AnimationGraph h;
    public Integer j;
    private long l;
    public Integer q;
    private long s;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public LuaUserData getAnimationGraph() {
        return new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph");
    }

    @Override
    public void bd() {
        if (this.s != 0L) {
            Kc180.d(this.s);
            this.s = 0L;
        }
        AnimationGraph.e(this.h);
    }

    public AnimationGraphComponent(String string, Skeleton skeleton, Map map, Map map2) {
        long l;
        this.e = skeleton;
        int n = map.size();
        int n2 = 8 + n * (4 + Kc180.e());
        for (Map.Entry entry : map2.entrySet()) {
            n2 += 8 + ((float[])entry.getValue()).length * 4;
        }
        long l2 = l = Kc180.g(n2);
        Kc180.r(l2, n);
        l2 += 4L;
        for (Map.Entry entry : map.entrySet()) {
            Kc180.r(l2, (Integer)entry.getKey());
            Kc180.r(l2 += 4L, (Integer)entry.getValue());
            l2 += 4L;
        }
        Kc180.r(l2, map2.size());
        l2 += 4L;
        for (Map.Entry entry : map2.entrySet()) {
            float[] arrf = (float[])entry.getValue();
            Kc180.r(l2, (Integer)entry.getKey());
            Kc180.r(l2 += 4L, arrf.length);
            l2 += 4L;
            for (float f : arrf) {
                Kc180.v(l2, f);
                l2 += 4L;
            }
        }
        this.h = new AnimationGraph();
        AnimationGraph.g(this.h, string, skeleton, l, n2);
        Kc180.d(l);
        this.s = Kc180.g(1024L);
        this.b = 1024;
    }

    @Override
    protected void detachFromEntity() {
        GameEntity gameEntity = this.getEntity();
        if (GameEntity.eq(gameEntity)) {
            SkinnedModel.clearAnimations(gameEntity.g());
            if (this.j != null) {
                gameEntity.triggerEvent(this.j, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return w;
    }

    private String d() {
        int n = Kc180.x(this.l);
        this.l += 4L;
        byte[] arrby = new byte[n];
        for (int i = 0; i < n; ++i) {
            arrby[i] = Kc180.y(this.l++);
        }
        return new String(arrby, Charset.forName("UTF-8"));
    }

    public void g(float f) {
        String string;
        String string2;
        int n;
        GameEntity gameEntity = this.getEntity();
        if (this.d != null) {
            gameEntity.triggerEvent(this.d, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
        }
        int n2 = AnimationGraph.q(this.h, f, this.s, this.b);
        this.l = this.s;
        int n3 = Kc180.x(this.l);
        this.l += 4L;
        for (n = 0; n < n2; ++n) {
            string = this.d();
            string2 = this.d();
            gameEntity.eh(string, string2);
        }
        while (n2 < n3) {
            n = n2;
            n2 = AnimationGraph.j(this.h, n, this.s, this.b);
            if (n2 == n) {
                if (this.b > 1000000) {
                    throw new IllegalStateException();
                }
                Kc180.d(this.s);
                this.b *= 2;
                this.s = Kc180.g(this.b);
                continue;
            }
            this.l = this.s;
            while (n < n2) {
                string = this.d();
                string2 = this.d();
                gameEntity.eh(string, string2);
                ++n;
            }
        }
    }

    @Override
    protected void attachToEntity() {
        GameEntity gameEntity = this.getEntity();
        if (GameEntity.eq(gameEntity) && GameEntity.el(gameEntity) == this.e) {
            AnimationGraph.d(this.h, gameEntity.g());
            if (this.q != null) {
                gameEntity.triggerEvent(this.q, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
            }
        }
    }
}

