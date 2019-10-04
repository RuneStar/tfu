package com.jagex.jnibindings.runetek6;

public class ProcessInfo {
   public static final native long GetWorkingSetSize();

   public static final native long GetPeakWorkingSetSize();

   public static final native long GetCommitCharge();

   public static final native long GetPeakCommitCharge();
}
