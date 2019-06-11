package FacebookFeed.models;

import java.util.ArrayList;

public class User {

    private static int counter =1;
    private Integer usedId;
    private String name;
    private String sex;
    private ArrayList<Integer> friendList;
    private ArrayList<Post> posts;

    public User(String name, String sex) {
        this.usedId = counter++;
        this.name = name;
        this.sex = sex;
    }

    public Integer getUsedId() {
        return usedId;
    }

    public void setUsedId(Integer usedId) {
        this.usedId = usedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<Integer> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Integer> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
