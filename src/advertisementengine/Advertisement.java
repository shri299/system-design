package advertisementengine;

import java.time.Instant;
import java.util.Set;

public class Advertisement {

    private final String id;
    private final String advertiserId;
    private final double bidAmount;
    private final String url;
    private final String type;
    private final int targetAge;
    private final String city;
    private final Set<String> targetInterests;
    private final Instant createdAt;

    public Advertisement(String id, String advertiserId, double bidAmount, String url,
                         String type, int targetAge, String city, Set<String> targetInterests) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.bidAmount = bidAmount;
        this.url = url;
        this.type = type;
        this.targetAge = targetAge;
        this.city = city;
        this.targetInterests = targetInterests;
        this.createdAt = Instant.now();
    }

    public String getId() { return id; }
    public String getAdvertiserId() { return advertiserId; }
    public double getBidAmount() { return bidAmount; }
    public int getTargetAge() { return targetAge; }
    public String getCity() { return city; }
}
