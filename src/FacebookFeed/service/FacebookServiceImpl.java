package FacebookFeed.service;

import FacebookFeed.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

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
        if(!userMap.containsKey(userId)){
            System.out.println("User doesn't exist");
            return false;
        }
        Post newPost = null;
        if(postType.equalsIgnoreCase(PostType.TEXTPOST.toString())){
            newPost = new TextPost(userId, content);

        }
        else if(postType.equalsIgnoreCase(PostType.IMAGE.toString())){
            newPost = new ImagePost(userId, content);
        }
        else if(postType.equalsIgnoreCase(PostType.VIDEO.toString())){
            newPost = new VideoPost(userId, content);
        }
        if(newPost==null){
            System.out.println("Invalid Input");
            return false;
        }


        User curUser = userMap.get(userId);
        curUser.getPostsMap().put(newPost.getPostId(), newPost);
        return true;
    }

    @Override
    public boolean addLike(Integer postOwnerId, Integer postId) {
        if(!userMap.containsKey(postOwnerId) || !userMap.get(postOwnerId).getPostsMap().containsKey(postId)){
            System.out.println("Invalid Input");
        }

        User user = userMap.get(postOwnerId);
        user.getPostsMap().get(postId).addLike();
        return true;
    }

    @Override
    public boolean addComment(Integer postOwnerId, Integer postId, Integer userId, String comment) {
        if(!userMap.containsKey(postOwnerId) || !userMap.get(postOwnerId).getPostsMap().containsKey(postId) || !userMap.containsKey(userId)){
            System.out.println("Invalid Input");
        }

        User postOwner = userMap.get(postOwnerId);
        User commenter = userMap.get(userId);
        postOwner.getPostsMap().get(postId).addComment(userId, commenter.getName(), comment);
        return true;

    }

    @Override
    public void printFeedDefault() {
        if(activeUser == null){
            System.out.println("No active user currently");
            return;
        }

        Comparator<Post> defaultComparator = new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                if(p1.getCreatedDate().before(p2.getCreatedDate()))
                    return 1;
                return 0;
            }
        };

        PriorityQueue posts = new PriorityQueue<Post>(defaultComparator);
        User curUser = userMap.get(activeUser);
        ArrayList<Integer> friendList = curUser.getFriendList();

        for(Integer friendId : friendList){
            HashMap<Integer, Post> friendsPosts = userMap.get(friendId).getPostsMap();
            posts.addAll(friendsPosts.values());
        }
        posts.addAll(curUser.getPostsMap().values());

        printFeed(posts);
    }

    private void printFeed(PriorityQueue<Post> posts) {
        while(!posts.isEmpty()){
            Post post = posts.poll();
            if(post.getPostType().equals(PostType.TEXTPOST)){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(userMap.get(post.getUserId()).getName());
                System.out.println("Text Post");
                System.out.println(((TextPost)post).getContent());
                System.out.println("Likes: " + post.getLikes());
                System.out.println("Comments:");

                for(Comment comment : post.getComments()){
                    System.out.println(comment.getUserName() + " -> "+ comment.getContent());
                    System.out.println("---");
                }
                System.out.println("---------------------");
            }
        }
        System.out.println("end of feed");
    }

    @Override
    public void printFeedPopular() {

    }
}
