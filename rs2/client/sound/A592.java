package rs2.client.sound;

import java.io.File;
import java.io.FileFilter;

final class A592 implements FileFilter {
   public boolean accept(File var1) {
      return var1.getPath().toLowerCase().endsWith(".fsb");
   }
}
