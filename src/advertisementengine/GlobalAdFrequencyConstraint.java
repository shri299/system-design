package advertisementengine;

import java.time.Instant;

public class GlobalAdFrequencyConstraint implements ConstraintValidator {
    @Override
    public boolean validate(Advertisement ad, User user) {
        Instant now = Instant.now();
        InMemoryDatabase.recentServes.removeIf(e -> e.timestamp.isBefore(now.minusSeconds(60)));

        long count = InMemoryDatabase.recentServes.stream()
                .filter(e -> e.adId.equals(ad.getId()))
                .count();

        return count < 5;
    }
}
