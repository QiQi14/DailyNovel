package main.dailynovel.Objects;

public class UserHistory {

    private String userID;
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    private int novelView;
    public int getNovelView() {
        return novelView;
    }
    public void setNovelView(int novelView) {
        this.novelView = novelView;
    }

    private String[] novelSubscribe;
    public String[] getNovelSubscribe() {
        return novelSubscribe;
    }
    public void setNovelSubscribe(String[] novelSubscribe) {
        this.novelSubscribe = novelSubscribe;
    }

    private String[] lastView;
    public String[] getLastView() {
        return lastView;
    }
    public void setLastView(String[] lastView) {
        this.lastView = lastView;
    }

    public UserHistory() {

    }

    public UserHistory(String userID, int novelView, String[] novelSubscribe, String[] lastView) {
        this.userID = userID;
        this.novelView = novelView;
        this.novelSubscribe = novelSubscribe;
        this.lastView = lastView;
    }
}
