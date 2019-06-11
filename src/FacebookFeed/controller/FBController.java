package FacebookFeed.controller;

import FacebookFeed.service.FacebookService;
import FacebookFeed.service.FacebookServiceImpl;

public class FBController {
    public static void main(String[] args) {
        FacebookService service = new FacebookServiceImpl();
        service.initialize();

        while (true) {

        }
    }
}
