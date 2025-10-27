package advertisementengine;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AdvertisementEngine {
    private final List<ConstraintValidator> validators = new ArrayList<>();

    public AdvertisementEngine() {
        validators.add(new UserRecentViewConstraint());
        validators.add(new GlobalAdFrequencyConstraint());
    }

    public void addAdvertiser(String advertiserId, String name) {
        if (advertiserId==null || advertiserId.isEmpty() || name==null || name.isEmpty())
            System.out.println("Invalid advertiser details");
        InMemoryDatabase.advertisers.put(advertiserId, new Advertiser(advertiserId, name, 0.0));
    }

    public void addBudget(String advertiserId, double budget) {
        if (advertiserId==null || advertiserId.isEmpty() || budget==0.0)
            System.out.println("Invalid budget details");
        Advertiser adv = InMemoryDatabase.advertisers.get(advertiserId);
        if (adv == null) throw new IllegalArgumentException("Advertiser not found: " + advertiserId);
        adv.addBudget(budget);
    }

    public void addUser(String userId, int age, String gender) {
        if (userId==null || userId.isEmpty() || age==0 || gender==null || gender.isEmpty())
            System.out.println("Invalid user details");
        InMemoryDatabase.users.put(userId, new User(userId, age, gender));
    }

    public void addAttribute(String userId, Set<String> interests) {
        User user = InMemoryDatabase.users.get(userId);
        if (user == null) throw new IllegalArgumentException("User not found: " + userId);
        user.addInterests(interests);
    }

    public void createCampaign(String adId, String advertiserId, double bidAmount, String url, String type,
                               int targetAge, String city, Set<String> interests) {
        InMemoryDatabase.ads.put(adId,
                new Advertisement(adId, advertiserId, bidAmount, url, type, targetAge, city, interests));
    }

    public synchronized Advertisement matchAdvertisement(String userId, String city) {
        User user = InMemoryDatabase.users.get(userId);
        if (user == null) return null;

        List<Advertisement> candidates = InMemoryDatabase.ads.values().stream()
                .filter(ad -> ad.getCity().equalsIgnoreCase(city))
                .filter(ad -> ad.getTargetAge() <= user.getAge())
                .sorted(Comparator.comparingDouble(Advertisement::getBidAmount).reversed())
                .toList();

        for (Advertisement ad : candidates) {
            if (validators.stream().allMatch(v -> v.validate(ad, user))) {
                Advertiser adv = InMemoryDatabase.advertisers.get(ad.getAdvertiserId());
                if (adv.getBudget() >= ad.getBidAmount()) {
                    adv.deductBudget(ad.getBidAmount());
                    user.recordAdView(ad.getId());
                    InMemoryDatabase.recentServes.addLast(new AdServeEvent(ad.getId(), Instant.now()));
                    return ad;
                }
            }
        }
        return null;
    }
}
