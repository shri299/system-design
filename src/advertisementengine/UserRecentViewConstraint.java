package advertisementengine;

public class UserRecentViewConstraint implements ConstraintValidator {
    @Override
    public boolean validate(Advertisement ad, User user) {
        return !user.hasSeenRecently(ad.getId());
    }
}
