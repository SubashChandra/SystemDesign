package FacebookFeed.service;

import FacebookFeed.models.User;

import java.util.ArrayList;
import java.util.HashMap;

public class FacebookServiceImpl implements FacebookService {

    private String activeUser = null;
    private HashMap<Integer, User> userMap;

    @Override
    public boolean initialize(){
        if(userMap != null)
            return false;
        userMap = new HashMap<>();
        return true;
    }


    @Override
    public void printUserInfo() {
        System.out.println("User List:");
        for(Integer userId: userMap.keySet()){
            printUser(userMap.get(userId));
        }
        System.out.println("------------------------------------------");
    }

    private void printUser(User user) {
        System.out.println(user.getUsedId() + "->" + user.getName() + " " + user.getSex());
    }

    @Override
    public void printActiveUserInfo() {
        if(activeUser == null){
            System.out.println("No active user");
            return;
        }
        System.out.println("Active User");
        printUser(userMap.get(activeUser));
        System.out.println("------------------------------------------");
    }

    @Override
    public boolean createUser(String name, String sex) {
        User newUser = new User(name, sex);
        userMap.put(newUser.getUsedId(), newUser);
        return true;
    }

    @Override
    public boolean activateUser(String id) {
        if(userMap.containsKey(id)){
            activeUser = id;
            return true;
        }
        return false;
    }

    @Override
    public boolean addFriend(Integer userId) {
        if(activeUser == null){
            System.out.println("No active user.");
            return false;
        }
        if(!userMap.containsKey(userId)){
            System.out.println("No user found");
            return false;
        }


        User curUser = userMap.get(activeUser);
        curUser.getFriendList().add(userId);
        return true;
    }

    @Override
    public boolean addPost(Integer userId, String postType, String content) {
        return false;
    }

    @Override
    public boolean addLike(Integer postId) {
        return false;
    }

    @Override
    public boolean addComment(Integer postId, Integer userId, String comment) {
        return false;
    }

    @Override
    public void printFeedDefault() {

    }

    @Override
    public void printFeedPopular() {

    }
}
