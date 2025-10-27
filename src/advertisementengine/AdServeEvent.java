package advertisementengine;

import java.time.Instant;

public class AdServeEvent {

    String adId;
    Instant timestamp;

    AdServeEvent(String adId, Instant timestamp) {
        this.adId = adId;
        this.timestamp = timestamp;
    }
}
