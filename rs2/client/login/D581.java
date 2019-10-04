/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import rs2.client.login.Q580;

class D581 {
    static final /* synthetic */ int[] g;

    static {
        g = new int[Q580.values().length];
        try {
            D581.g[Q580.CONNECT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D581.g[Q580.WAIT_FOR_CONNECTION_ACK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D581.g[Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D581.g[Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D581.g[Q580.WAIT_FOR_SSO_KEY_RESPONSE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            D581.g[Q580.WAIT_FOR_SSO_KEY.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

