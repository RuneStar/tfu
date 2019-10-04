/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import rs2.client.login.L606;
import tfu.Mf509;

class V607 {
    static final /* synthetic */ int[] d;
    static final /* synthetic */ int[] g;

    static {
        d = new int[L606.values().length];
        try {
            V607.d[L606.DELAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.CONNECT_UDP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.CONNECT_TCP.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_CONNECTION_ACK.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.SEND_LOGIN_REQUEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_LOGIN_RESPONSE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_HOP_BLOCK_DURATION.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_QUEUE_POSITION.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_SCRIPT_DISALLOW_REASON.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_LOGIN_OK_LENGTH.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_LOGIN_DETAILS.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_PLAYER_PACKET_LENGTH1.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_PLAYER_PACKET_LENGTH2.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_UDP_LOGIN_RECONNECT.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_PLAYER_PACKET.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.d[L606.WAIT_FOR_UDP_LOGIN.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        g = new int[Mf509.values().length];
        try {
            V607.g[Mf509.OK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.g[Mf509.RECONNECT_OK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.g[Mf509.DISALLOWED_BY_SCRIPT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.g[Mf509.HOP_BLOCKED.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.g[Mf509.IN_QUEUE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            V607.g[Mf509.INVALID_SINGLE_SIGNON.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

