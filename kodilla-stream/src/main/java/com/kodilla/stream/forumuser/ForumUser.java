package com.kodilla.stream.forumuser;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class ForumUser {
    private final int userID;
    private final String userName;
    private final char sex;
    private LocalDate dateOfBirth;
    private final int postsQty;

    public ForumUser(int userID, String userName, char sex, LocalDate dateOfBirth, int postsQty) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postsQty = postsQty;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsQty() {
        return postsQty;
    }
}
