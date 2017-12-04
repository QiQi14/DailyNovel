package main.dailynovel.Objects;

import java.io.Serializable;

public class Novel implements Serializable{

    private String novelID;
    public String getNovelID() {
        return novelID;
    }
    public void setNovelID(String novelID) {
        this.novelID = novelID;
    }

    private String novelName;
    public String getNovelName() {
        return novelName;
    }
    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    private String novelAuthors;
    public String getNovelAuthors() {
        return novelAuthors;
    }
    public void setNovelAuthors(String novelAuthors) {
        this.novelAuthors = novelAuthors;
    }

    private String novelType;
    public String getNovelType() {
        return novelType;
    }
    public void setNovelType(String novelType) {
        this.novelType = novelType;
    }

    private String novelStatus;
    public String getNovelStatus() {
        return novelStatus;
    }
    public void setNovelStatus(String novelStatus) {
        this.novelStatus = novelStatus;
    }

    private int novelVote;
    public int getNovelVote() {
        return novelVote;
    }
    public void setNovelVote(int novelVote) {
        this.novelVote = novelVote;
    }

    private String novelCover;
    public String getNovelCover() {
        return novelCover;
    }
    public void setNovelCover(String novelCover) {
        this.novelCover = novelCover;
    }

    private int novelChapter;
    public int getNovelChapter() {
        return novelChapter;
    }
    public void setNovelChapter(int novelChapter) {
        this.novelChapter = novelChapter;
    }

    private int viewCount;
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Novel() {

    }

    public Novel(String novelID, String novelName, String novelAuthors, String novelType, String novelStatus, int novelVote, String novelCover) {
        this.novelID = novelID;
        this.novelName = novelName;
        this.novelAuthors = novelAuthors;
        this.novelType = novelType;
        this.novelStatus = novelStatus;
        this.novelVote = novelVote;
        this.novelCover = novelCover;
    }
}
