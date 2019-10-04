// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.maths.RotTrans;
import java.util.Iterator;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.Hashtable;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public class SoundComponent extends Component implements G345
{
    public static final int d;
    private Hashtable g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static SoundComponent create() {
        return new SoundComponent();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public boolean isPlaying(final String key) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not query SoundAdapter about its current state. Specified sound event does not exist.");
        }
        return soundAdapter.isPlaying();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return SoundComponent.d;
    }
    
    public static void g(final SoundComponent soundComponent, final float n) {
        final Iterator iterator = soundComponent.g.values().iterator();
        while (iterator.hasNext()) {
            SoundAdapter.g(iterator.next(), n);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter getSoundWithID(final int n) {
        for (final SoundAdapter soundAdapter : this.g.values()) {
            if (n == soundAdapter.getHandle()) {
                return soundAdapter;
            }
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter addSoundAtTransform(final String s, final String s2, final RotTrans rotTrans) {
        if (this.g.containsKey(s)) {
            throw new RuntimeException("Could not add sound since it already exists.");
        }
        final SoundAdapter value = new SoundAdapter(this, s, s2, rotTrans);
        this.g.put(s, value);
        return value;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter getSound(final String key) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("The specified SoundAdapter could not be retrieved since it does not exist.");
        }
        return soundAdapter;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean hasSound(final String key) {
        return this.g.containsKey(key);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void attachSound(final String key) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not attach SoundAdapter. Specified sound event does not exist.");
        }
        SoundAdapter.b(soundAdapter);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void setParams(final String key, final String s) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not set fmod params of SoundAdapter event. Specified sound event does not exist.");
        }
        soundAdapter.s(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void detachSound(final String key) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not detach SoundAdapter. Specified sound event does not exist.");
        }
        SoundAdapter.l(soundAdapter);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeSound(final String s) {
        final SoundAdapter soundAdapter = this.g.get(s);
        SoundAdapter.e(soundAdapter, "SoundRemovedEvent", soundAdapter);
        this.g.remove(s);
    }
    
    @Override
    public void d(final String key) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("Failed to stop the sound on the GameEntity since it was not attached to the SoundComponent. Did you use the correct SoundManager function to play the sound?");
        }
        if (soundAdapter.isPlaying()) {
            SoundAdapter.q(soundAdapter);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void setVolume(final String key, final float n) {
        final SoundAdapter soundAdapter = this.g.get(key);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not set volume of SoundAdapter event. Specified sound event does not exist.");
        }
        soundAdapter.h(n);
    }
    
    static {
        d = StringTools.l(SoundComponent.class.getName());
    }
    
    public SoundComponent() {
        this.g = new Hashtable();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter addSound(final String s, final String s2) {
        if (this.g.containsKey(s)) {
            throw new RuntimeException("Could not add sound since it already exists.");
        }
        final SoundAdapter value = new SoundAdapter(this, s, s2);
        this.g.put(s, value);
        return value;
    }
}
