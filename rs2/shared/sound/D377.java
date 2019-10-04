/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.sound;

import rs2.shared.sound.SoundAdapter;

class D377
implements Runnable {
    final /* synthetic */ SoundAdapter g;

    @Override
    public void run() {
        SoundAdapter.e(this.g, "SoundRemovedEvent", this.g);
    }

    D377(SoundAdapter soundAdapter) {
        this.g = soundAdapter;
    }
}

