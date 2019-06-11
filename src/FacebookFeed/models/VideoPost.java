package FacebookFeed.models;

public class VideoPost extends Post{
    String content;

    public VideoPost(Integer userId, String content) {
        super(userId, PostType.VIDEO);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
