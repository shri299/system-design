package advertisementengine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class User {
    private final String id;
    private final int age;
    private final String gender;
    private final Set<String> interests = new HashSet<>();
    private final Deque<String> lastSeenAds = new ArrayDeque<>();

    public User(String id, int age, String gender) {
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public void addInterests(Set<String> newInterests) {
        interests.addAll(newInterests);
    }

    public int getAge() { return age; }

    public void recordAdView(String adId) {
        if (lastSeenAds.size() >= 10) lastSeenAds.pollFirst();
        lastSeenAds.addLast(adId);
    }

    public boolean hasSeenRecently(String adId) {
        return lastSeenAds.contains(adId);
    }
}
