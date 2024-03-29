package FacebookFeed.models;

public class TextPost extends Post {
    private String content;
    public TextPost(Integer userId, String content) {
        super(userId, PostType.TEXTPOST);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
