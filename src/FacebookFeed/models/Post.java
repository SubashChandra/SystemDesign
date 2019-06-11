package FacebookFeed.models;

import java.util.ArrayList;
import java.util.Date;

abstract class Post {
    private static int counter =1;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    private Integer postId;
    private PostType postType;
    private Integer likes;
    private ArrayList<String> comments;
    private Date createdDate;

    public Post(PostType postType) {
        this.postId = counter++;
        this.postType = postType;
        this.likes = 0;
        this.comments = new ArrayList<>();
        this.createdDate = new Date();
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
