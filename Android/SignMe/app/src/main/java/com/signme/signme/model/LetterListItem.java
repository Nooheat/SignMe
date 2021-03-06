package com.signme.signme.model;

import com.signme.signme.LetterTypes;

/**
 * Created by dsm2016 on 2017-09-17.
 */

public class LetterListItem {
    private LetterTypes type;
    private int letterNumber;
    private String title;
    private String writerName;
    private String openDate;
    private String closeDate;
    private boolean isAnswered = false;

    public LetterListItem() {
    }

    public LetterListItem(LetterTypes type, int letterNumber, String title, String writerName, String openDate, boolean isAnswered) {
        this.type = type;
        this.letterNumber = letterNumber;
        this.title = title;
        this.writerName = writerName;
        this.openDate = openDate;
        this.isAnswered = isAnswered;
    }

    public LetterListItem(LetterTypes type, int letterNumber, String title, String writerName, String openDate, String closeDate, boolean isAnswered) {
        this.type = type;
        this.letterNumber = letterNumber;
        this.title = title;
        this.writerName = writerName;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.isAnswered = isAnswered;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public LetterTypes getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public void setType(LetterTypes type) {
        this.type = type;
    }

    public void setLetterNumber(int letterNumber) {
        this.letterNumber = letterNumber;
    }

    public int getLetterNumber() {
        return letterNumber;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}
