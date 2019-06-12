package FacebookFeed.controller;

import FacebookFeed.service.FacebookService;
import FacebookFeed.service.FacebookServiceImpl;

import java.util.Scanner;

public class FBController {
    private static String CREATEUSER = "createuser";
    private static String PRINT = "print";
    private static String USERINFO = "userinfo";
    private static String ACTIVEUSER = "activeuser";
    private static String ACTIVATEUSER = "activateuser";
    private static String ADD = "add";
    private static String FRIEND = "friend";
    private static String POST = "post";
    private static String LIKE = "like";
    private static String COMMENT = "comment";
    private static String FEEDDEFAULT = "feeddefault";
    private static String EXIT = "exit";


    public static void main(String[] args) {


        FacebookService service = new FacebookServiceImpl();
        service.initialize();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printInstructions();
            String input = scanner.nextLine();
            String[] inputSplit = input.split(" ");
            if(inputSplit.length == 1 && EXIT.equalsIgnoreCase(inputSplit[0])){
                System.out.println("Shutting Down Facebook Feed");
                break;
            }
            if(inputSplit.length < 2){
                InvalidInput();
                continue;
            }
            if(CREATEUSER.equalsIgnoreCase(inputSplit[0])){
                if(inputSplit.length != 3) {
                    InvalidInput();
                    continue;
                }
                String name = inputSplit[1];
                String sex = inputSplit[2];
                service.createUser(name, sex);
            }

            else if(PRINT.equalsIgnoreCase(inputSplit[0])){
                if(inputSplit.length != 2){
                    InvalidInput();
                    continue;
                }
                if(USERINFO.equalsIgnoreCase(inputSplit[1])){
                    service.printUserInfo();
                }
                else if(ACTIVEUSER.equalsIgnoreCase(inputSplit[1])){
                    service.printActiveUserInfo();
                }
                else if(FEEDDEFAULT.equalsIgnoreCase(inputSplit[1])){
                    service.printFeedDefault();
                }
                else{
                    InvalidInput();
                    continue;
                }
            }

            else if(ACTIVATEUSER.equalsIgnoreCase(inputSplit[0])){
                if(inputSplit.length != 2){
                    InvalidInput();
                    continue;
                }
                service.activateUser(Integer.parseInt(inputSplit[1]));
            }

            else if(ADD.equalsIgnoreCase(inputSplit[0])){
                if(inputSplit.length < 3){
                    InvalidInput();
                    continue;
                }
                if(FRIEND.equalsIgnoreCase(inputSplit[1])){
                    if(inputSplit.length != 3){
                        InvalidInput();
                        continue;
                    }
                    service.addFriend(Integer.parseInt(inputSplit[2]));
                }
                else if(POST.equalsIgnoreCase(inputSplit[1])){
                    if(inputSplit.length != 5){
                        InvalidInput();
                        continue;
                    }
                    Integer userId = Integer.parseInt(inputSplit[2]);
                    String postType = inputSplit[3];
                    String content = inputSplit[4];
                    service.addPost(userId, postType, content);
                }
                else if(LIKE.equalsIgnoreCase(inputSplit[1])){
                    if(inputSplit.length != 4){
                        InvalidInput();
                        continue;
                    }
                    Integer postOwnerId = Integer.parseInt(inputSplit[2]);
                    Integer postId = Integer.parseInt(inputSplit[3]);
                    service.addLike(postOwnerId, postId);
                }
                else if(COMMENT.equalsIgnoreCase(inputSplit[1])){
                    if(inputSplit.length != 6){
                        InvalidInput();
                        continue;
                    }
                    Integer postOwnerId = Integer.parseInt(inputSplit[2]);
                    Integer postId = Integer.parseInt(inputSplit[3]);
                    Integer userId = Integer.parseInt(inputSplit[4]);
                    String comment = inputSplit[5];
                    service.addComment(postOwnerId, postId, userId, comment);
                }
                else{

                }
            }

        }
    }

    private static void InvalidInput() {
        System.out.println("Invalid Input");
        return;
    }

    private static void printInstructions(){
        System.out.println("===================================================");
        System.out.println();
        System.out.println("Instructions");
        System.out.println("To create user-----> createuser <username> <gender>");
        System.out.println("To print list of users-----> print userinfo");
        System.out.println("To print active user-----> print activeuser");
        System.out.println("To activate a user-----> activateuser <userid>");
        System.out.println("To add friend-----> add friend <userid>");
        System.out.println("To add post-----> add post <userid> <textPost/image/video> contentWithoutSpace");
        System.out.println("To add like-----> add like <postOwnerId> <postId");
        System.out.println("To add comment-----> add comment <postOwnerId> <postId> <commentedId> <commentWithoutSpace>");
        System.out.println("To print default feed of active user-----> print feeddefault");
        System.out.println("To Exit-----> exit");
        System.out.println();
        System.out.println("===================================================");
    }

}
