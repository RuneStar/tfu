/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.J204;

public enum Mf509 implements J204
{
    OK(2),
    INVALID_USERNAME_OR_PASSWORD(3),
    BANNED(4),
    DUPLICATE(5),
    CLIENT_OUT_OF_DATE(6),
    SERVER_FULL(7),
    LOGINSERVER_OFFLINE(8),
    IP_LIMIT(9),
    FORCE_PASSWORD_CHANGE(11),
    NEED_MEMBERS_ACCOUNT(12),
    INVALID_SAVE(13),
    UPDATE_IN_PROGRESS(14),
    RECONNECT_OK(15),
    TOO_MANY_ATTEMPTS(16),
    LOCKED(18),
    HOP_BLOCKED(21),
    INVALID_LOGIN_PACKET(22),
    LOGINSERVER_LOAD_ERROR(24),
    UNKNOWN_REPLY_FROM_LOGINSERVER(25),
    IP_BLOCKED(26),
    DISALLOWED_BY_SCRIPT(29),
    NEGATIVE_CREDIT(32),
    INVALID_SINGLE_SIGNON(35),
    NO_REPLY_FROM_SINGLE_SIGNON(36),
    PROFILE_BEING_EDITED(37),
    NO_BETA_ACCESS(38),
    INSTANCE_INVALID(39),
    INSTANCE_NOT_SPECIFIED(40),
    INSTANCE_FULL(41),
    IN_QUEUE(42),
    ALREADY_IN_QUEUE(43),
    BILLING_TIMEOUT(44),
    NOT_AGREED_TO_NDA(45),
    EMAIL_NOT_VALIDATED(47),
    CONNECT_FAIL(50);
    
    private final int ao;

    @Override
    public int getId() {
        return this.ao;
    }

    private Mf509(int n2) {
        this.ao = n2;
    }
}

