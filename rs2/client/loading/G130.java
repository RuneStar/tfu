// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.loading;

import tfu.Mk163;

public enum G130
{
    REGISTER_NATIVE_JS5S("REGISTER_NATIVE_JS5S", 7, Mk163.DOWNLOADING_UPDATES, 87), 
    INIT_NATIVE_REGISTRY("INIT_NATIVE_REGISTRY", 1, Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 2, 5), 
    OPEN_JS5_ARCHIVES("OPEN_JS5_ARCHIVES", 4, Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 9, 15), 
    WAIT_FOR_MEMORY("WAIT_FOR_MEMORY", 0, Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 0, 1), 
    GET_JS5_INDEXES("GET_JS5_INDEXES", 5, Mk163.CHECKING_FOR_UPDATES, Mk163.CHECKING_FOR_UPDATES, 16, 20, true, true), 
    CONSTRUCT_TOOLKIT("CONSTRUCT_TOOLKIT", 3, Mk163.CHECKING_FOR_UPDATES, 7), 
    SETUP_CONFIG_DECODERS("SETUP_CONFIG_DECODERS", 8, Mk163.DOWNLOADING_UPDATES, 87), 
    FETCH_FONTS("FETCH_FONTS", 13, Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 94, 96), 
    LOAD_NATIVE_DLLS("LOAD_NATIVE_DLLS", 2, Mk163.CHECKING_FOR_UPDATES, 6), 
    SETUP_GRAPHICS_CONFIGURATIONS("SETUP_GRAPHICS_CONFIGURATIONS", 10, Mk163.DOWNLOADING_UPDATES, 89), 
    DOWNLOAD_STUFF("DOWNLOAD_STUFF", 6, Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 21, 86, true, true), 
    CLEANUP("CLEANUP", 15, Mk163.DOWNLOADING_UPDATES, 99), 
    INIT_SCRIPTING("INIT_SCRIPTING", 11, Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 90, 91), 
    SETUP_SOUND_LIBRARY("SETUP_SOUND_LIBRARY", 9, Mk163.CHECKING_FOR_UPDATES, 88), 
    SETUP_VARC_SYSTEM("SETUP_VARC_SYSTEM", 14, Mk163.DOWNLOADING_UPDATES, 98), 
    SETUP_STATIC_SPRITES("SETUP_STATIC_SPRITES", 12, Mk163.DOWNLOADING_UPDATES, Mk163.DOWNLOADING_UPDATES, 92, 93), 
    LOADING_COMPLETE("LOADING_COMPLETE", 16, Mk163.DOWNLOADING_UPDATES, 100);
    
    public final boolean i;
    public final int k;
    public final Mk163 m;
    public final int n;
    public final boolean o;
    public final Mk163 t;
    
    private G130(final String s, final int n, final Mk163 mk163, final Mk163 mk164, final int n2, final int n3) {
        this(s, n, mk163, mk164, n2, n3, true, false);
    }
    
    private G130(final String s, final int n, final Mk163 mk163, final int n2) {
        this(s, n, mk163, mk163, n2, n2, true, false);
    }
    
    private G130(final String name, final int ordinal, final Mk163 t, final Mk163 m, final int n, final int k, final boolean i, final boolean o) {
        this.t = t;
        this.m = m;
        this.n = n;
        this.k = k;
        this.i = i;
        this.o = o;
    }
}
