package FacebookFeed.models;

import java.util.ArrayList;
import java.util.Date;

public abstract class Post {
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
    private ArrayList<Comment> comments;
    private Date createdDate;
    private Integer userId;

    public Post(Integer userId, PostType postType) {
        this.postId = counter++;
        this.postType = postType;
        this.likes = 0;
        this.comments = new ArrayList<>();
        this.createdDate = new Date();
        this.userId = userId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public void addLike(){
        this.likes++;
    }

    public void addComment(Integer userId, String userName, String content){
        Comment comment = new Comment(userId, userName, content);
        this.comments.add(comment);
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
