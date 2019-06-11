package FacebookFeed.models;

public class ImagePost extends Post {
    private String content;
    public ImagePost(Integer userId, String content){
        super(userId, PostType.IMAGE);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

