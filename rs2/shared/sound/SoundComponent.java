package rs2.shared.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.maths.RotTrans;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class SoundComponent extends Component implements G345 {
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
   public boolean isPlaying(String var1) {
      SoundAdapter var2 = (SoundAdapter)this.g.get(var1);
      if (var2 == null) {
         throw new RuntimeException("Could not query SoundAdapter about its current state. Specified sound event does not exist.");
      } else {
         return var2.isPlaying();
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return d;
   }

   public static void g(SoundComponent var0, float var1) {
      Collection var2 = var0.g.values();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         SoundAdapter.g((SoundAdapter)var3.next(), var1);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public SoundAdapter getSoundWithID(int var1) {
      Collection var2 = this.g.values();
      Iterator var3 = var2.iterator();

      SoundAdapter var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (SoundAdapter)var3.next();
      } while(var1 != var4.getHandle());

      return var4;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public SoundAdapter addSoundAtTransform(String var1, String var2, RotTrans var3) {
      if (this.g.containsKey(var1)) {
         throw new RuntimeException("Could not add sound since it already exists.");
      } else {
         SoundAdapter var4 = new SoundAdapter(this, var1, var2, var3);
         this.g.put(var1, var4);
         return var4;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public SoundAdapter getSound(String var1) {
      SoundAdapter var2 = (SoundAdapter)this.g.get(var1);
      if (var2 == null) {
         throw new RuntimeException("The specified SoundAdapter could not be retrieved since it does not exist.");
      } else {
         return var2;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean hasSound(String var1) {
      return this.g.containsKey(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void attachSound(String var1) {
      SoundAdapter var2 = (SoundAdapter)this.g.get(var1);
      if (var2 == null) {
         throw new RuntimeException("Could not attach SoundAdapter. Specified sound event does not exist.");
      } else {
         SoundAdapter.b(var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setParams(String var1, String var2) {
      SoundAdapter var3 = (SoundAdapter)this.g.get(var1);
      if (var3 == null) {
         throw new RuntimeException("Could not set fmod params of SoundAdapter event. Specified sound event does not exist.");
      } else {
         var3.s(var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void detachSound(String var1) {
      SoundAdapter var2 = (SoundAdapter)this.g.get(var1);
      if (var2 == null) {
         throw new RuntimeException("Could not detach SoundAdapter. Specified sound event does not exist.");
      } else {
         SoundAdapter.l(var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeSound(String var1) {
      SoundAdapter var2 = (SoundAdapter)this.g.get(var1);
      SoundAdapter.e(var2, "SoundRemovedEvent", var2);
      this.g.remove(var1);
   }

   public void d(String var1) {
      SoundAdapter var2 = (SoundAdapter)this.g.get(var1);
      if (var2 == null) {
         throw new RuntimeException("Failed to stop the sound on the GameEntity since it was not attached to the SoundComponent. Did you use the correct SoundManager function to play the sound?");
      } else {
         if (var2.isPlaying()) {
            SoundAdapter.q(var2);
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setVolume(String var1, float var2) {
      SoundAdapter var3 = (SoundAdapter)this.g.get(var1);
      if (var3 == null) {
         throw new RuntimeException("Could not set volume of SoundAdapter event. Specified sound event does not exist.");
      } else {
         var3.h(var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public SoundAdapter addSound(String var1, String var2) {
      if (this.g.containsKey(var1)) {
         throw new RuntimeException("Could not add sound since it already exists.");
      } else {
         SoundAdapter var3 = new SoundAdapter(this, var1, var2);
         this.g.put(var1, var3);
         return var3;
      }
   }
}
