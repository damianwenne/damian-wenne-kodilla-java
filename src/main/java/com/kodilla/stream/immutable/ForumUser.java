package com.kodilla.stream.immutable;

public final class ForumUser {
    private final String username;
    private final String realName;

    public ForumUser(final String username, final String realName) {
        this.realName = realName;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}
