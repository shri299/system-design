package advertisementengine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AdvertisementEngine engine = new AdvertisementEngine();

        //Happy case

//        engine.addAdvertiser("adv1", "Nike");
//        engine.addBudget("adv1", 100);
//
//        engine.addUser("u1", 25, "female");
//        engine.addAttribute("u1", new HashSet<>(Arrays.asList("sports", "fashion")));
//
//        engine.createCampaign("ad1", "adv1", 10, "nike.com", "image", 20, "Delhi", new HashSet<>(List.of("sports")));
//        engine.createCampaign("ad2", "adv1", 12, "nike-shoes.com", "video", 22, "Delhi", new HashSet<>(List.of("fashion")));
//
//        Advertisement matched = engine.matchAdvertisement("u1", "Delhi");
//        if (matched != null)
//            System.out.println("Matched Ad: " + matched.getUrl() + " | Bid: " + matched.getBidAmount());
//        else
//            System.out.println("No matching ad found.");



        //should not see the same ad more than once in 10 calls

//        engine.addAdvertiser("adv1", "Nike");
//        engine.addBudget("adv1", 100);
//
//        engine.addUser("u1", 25, "female");
//        engine.addAttribute("u1", new HashSet<>(Arrays.asList("sports", "fashion")));
//
//        engine.createCampaign("ad1", "adv1", 10, "nike.com", "image", 20, "Delhi", new HashSet<>(List.of("sports")));
//        engine.createCampaign("ad2", "adv1", 12, "nike-shoes.com", "video", 22, "Delhi", new HashSet<>(List.of("fashion")));
//
//        for (int i = 1; i <= 3; i++) {
//            Advertisement matched = engine.matchAdvertisement("u1", "Delhi");
//            if (matched != null)
//                System.out.println("Call " + i + " => Matched Ad: " + matched.getId());
//            else
//                System.out.println("Call " + i + " => No ad served.");
//        }



        //Do not show ad more than 5 times globally in 1 minute

        engine.addAdvertiser("adv1", "Nike");
        engine.addBudget("adv1", 100);
        engine.createCampaign("ad1", "adv1", 10, "nike.com", "image", 20, "Delhi", new HashSet<>(List.of("sports")));

        // Add multiple users
        for (int i = 1; i <= 6; i++) {
            engine.addUser("user" + i, 25, "female");
            engine.addAttribute("user1", new HashSet<>(Arrays.asList("sports", "fashion")));
        }

        // Try serving ad to 6 users rapidly
        for (int i = 1; i <= 6; i++) {
            Advertisement matched = engine.matchAdvertisement("user" + i, "Delhi");
            if (matched != null)
                System.out.println("User" + i + " got ad: " + matched.getId());
            else
                System.out.println("User" + i + " => No ad served (constraint hit)");
        }
    }
}