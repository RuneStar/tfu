// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.sound;

class D377 implements Runnable
{
    final /* synthetic */ SoundAdapter g;
    
    @Override
    public void run() {
        SoundAdapter.e(this.g, "SoundRemovedEvent", this.g);
    }
    
    D377(final SoundAdapter g) {
        this.g = g;
    }
}
