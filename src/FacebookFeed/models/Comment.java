package FacebookFeed.models;

public class Comment {
    private Integer userId;
    private String userName;
    private String content;

    public Comment(Integer userId, String userName, String content) {
        this.userId = userId;
        this.userName = userName;
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
