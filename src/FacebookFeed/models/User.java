package FacebookFeed.models;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private static int counter =1;
    private Integer usedId;
    private String name;
    private String sex;
    private ArrayList<Integer> friendList;
    private HashMap<Integer, Post> postsMap;

    public User(String name, String sex) {
        this.usedId = counter++;
        this.name = name;
        this.sex = sex;
        this.friendList = new ArrayList<>();
        this.postsMap = new HashMap<>();
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

    public HashMap<Integer, Post> getPostsMap() {
        return postsMap;
    }

    public void setPosts(HashMap<Integer, Post> postsMap) {
        this.postsMap = postsMap;
    }
}
