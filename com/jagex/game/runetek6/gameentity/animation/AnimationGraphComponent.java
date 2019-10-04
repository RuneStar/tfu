// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity.animation;

import com.jagex.core.stringtools.general.StringTools;
import java.nio.charset.Charset;
import com.jagex.jnibindings.runetek6.SkinnedModel;
import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.Iterator;
import java.util.Map;
import tfu.Kc180;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.LuaUserData;
import com.jagex.jnibindings.runetek6.AnimationGraph;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass("AnimGraph")
public class AnimationGraphComponent extends Component
{
    private static final int g = 1024;
    public static final int w;
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
    
    public AnimationGraphComponent(final String s, final Skeleton e, final Map map, final Map map2) {
        this.e = e;
        final int size = map.size();
        int n = 8 + size * (4 + Kc180.e());
        final Iterator<Map.Entry<K, float[]>> iterator = map2.entrySet().iterator();
        while (iterator.hasNext()) {
            n += 8 + iterator.next().getValue().length * 4;
        }
        final long g;
        final long n2 = g = Kc180.g(n);
        Kc180.r(g, size);
        long n3 = g + 4L;
        for (final Map.Entry<Integer, V> entry : map.entrySet()) {
            Kc180.r(n3, entry.getKey());
            final long n4 = n3 + 4L;
            Kc180.r(n4, (int)entry.getValue());
            n3 = n4 + 4L;
        }
        Kc180.r(n3, map2.size());
        long n5 = n3 + 4L;
        for (final Map.Entry<K, float[]> entry2 : map2.entrySet()) {
            final float[] array = entry2.getValue();
            Kc180.r(n5, (int)entry2.getKey());
            final long n6 = n5 + 4L;
            Kc180.r(n6, array.length);
            n5 = n6 + 4L;
            final float[] array2 = array;
            for (int length = array2.length, i = 0; i < length; ++i) {
                Kc180.v(n5, array2[i]);
                n5 += 4L;
            }
        }
        AnimationGraph.g(this.h = new AnimationGraph(), s, e, n2, n);
        Kc180.d(n2);
        this.s = Kc180.g(1024L);
        this.b = 1024;
    }
    
    @Override
    protected void detachFromEntity() {
        final GameEntity entity = this.getEntity();
        if (GameEntity.eq(entity)) {
            SkinnedModel.clearAnimations(entity.g());
            if (this.j != null) {
                entity.triggerEvent(this.j, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return AnimationGraphComponent.w;
    }
    
    private String d() {
        final int x = Kc180.x(this.l);
        this.l += 4L;
        final byte[] bytes = new byte[x];
        for (int i = 0; i < x; ++i) {
            bytes[i] = Kc180.y(this.l++);
        }
        return new String(bytes, Charset.forName("UTF-8"));
    }
    
    static {
        w = StringTools.l(AnimationGraphComponent.class.getName());
    }
    
    public void g(final float n) {
        final GameEntity entity = this.getEntity();
        if (this.d != null) {
            entity.triggerEvent(this.d, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
        }
        int i = AnimationGraph.q(this.h, n, this.s, this.b);
        this.l = this.s;
        final int x = Kc180.x(this.l);
        this.l += 4L;
        for (int j = 0; j < i; ++j) {
            entity.eh(this.d(), this.d());
        }
        while (i < x) {
            int k = i;
            i = AnimationGraph.j(this.h, k, this.s, this.b);
            if (i == k) {
                if (this.b > 1000000) {
                    throw new IllegalStateException();
                }
                Kc180.d(this.s);
                this.b *= 2;
                this.s = Kc180.g(this.b);
            }
            else {
                this.l = this.s;
                while (k < i) {
                    entity.eh(this.d(), this.d());
                    ++k;
                }
            }
        }
    }
    
    @Override
    protected void attachToEntity() {
        final GameEntity entity = this.getEntity();
        if (GameEntity.eq(entity) && GameEntity.el(entity) == this.e) {
            AnimationGraph.d(this.h, entity.g());
            if (this.q != null) {
                entity.triggerEvent(this.q, new LuaUserData(AnimationGraph.h(this.h), "AnimationGraph"));
            }
        }
    }
}
