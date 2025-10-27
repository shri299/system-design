package advertisementengine;

public interface ConstraintValidator {

    boolean validate(Advertisement ad, User user);
}
