/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.maths.RotTrans;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import rs2.shared.sound.G345;
import rs2.shared.sound.SoundAdapter;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class SoundComponent
extends Component
implements G345 {
    public static final int d = StringTools.l(SoundComponent.class.getName());
    private Hashtable g = new Hashtable();

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
    public boolean isPlaying(String string) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not query SoundAdapter about its current state. Specified sound event does not exist.");
        }
        return soundAdapter.isPlaying();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return d;
    }

    public static void g(SoundComponent soundComponent, float f) {
        Collection collection = soundComponent.g.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            SoundAdapter.g((SoundAdapter)iterator.next(), f);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter getSoundWithID(int n) {
        Collection collection = this.g.values();
        for (SoundAdapter soundAdapter : collection) {
            if (n != soundAdapter.getHandle()) continue;
            return soundAdapter;
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter addSoundAtTransform(String string, String string2, RotTrans rotTrans) {
        if (this.g.containsKey(string)) {
            throw new RuntimeException("Could not add sound since it already exists.");
        }
        SoundAdapter soundAdapter = new SoundAdapter(this, string, string2, rotTrans);
        this.g.put(string, soundAdapter);
        return soundAdapter;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter getSound(String string) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        if (soundAdapter == null) {
            throw new RuntimeException("The specified SoundAdapter could not be retrieved since it does not exist.");
        }
        return soundAdapter;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean hasSound(String string) {
        return this.g.containsKey(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void attachSound(String string) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not attach SoundAdapter. Specified sound event does not exist.");
        }
        SoundAdapter.b(soundAdapter);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void setParams(String string, String string2) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not set fmod params of SoundAdapter event. Specified sound event does not exist.");
        }
        soundAdapter.s(string2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void detachSound(String string) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not detach SoundAdapter. Specified sound event does not exist.");
        }
        SoundAdapter.l(soundAdapter);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeSound(String string) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        SoundAdapter.e(soundAdapter, "SoundRemovedEvent", soundAdapter);
        this.g.remove(string);
    }

    @Override
    public void d(String string) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
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
    public void setVolume(String string, float f) {
        SoundAdapter soundAdapter = (SoundAdapter)this.g.get(string);
        if (soundAdapter == null) {
            throw new RuntimeException("Could not set volume of SoundAdapter event. Specified sound event does not exist.");
        }
        soundAdapter.h(f);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public SoundAdapter addSound(String string, String string2) {
        if (this.g.containsKey(string)) {
            throw new RuntimeException("Could not add sound since it already exists.");
        }
        SoundAdapter soundAdapter = new SoundAdapter(this, string, string2);
        this.g.put(string, soundAdapter);
        return soundAdapter;
    }
}

