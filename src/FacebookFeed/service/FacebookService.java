package FacebookFeed.service;

public interface FacebookService {
    //info
    public boolean initialize();
    public void printUserInfo();
    public void printActiveUserInfo();

    //updates
    public boolean createUser(String name, String sex);
    public boolean activateUser(String id);
    public boolean addFriend(Integer userId);
    public boolean addPost(Integer userId, String postType, String content);
    public boolean addLike(Integer postOwnerId, Integer postId);
    public boolean addComment(Integer postOwnerId, Integer postId, Integer userId, String comment);

    //get
    public void printFeedDefault();
    public void printFeedPopular();
}
