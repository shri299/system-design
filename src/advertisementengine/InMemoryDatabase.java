package advertisementengine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase {

    public static final Map<String, Advertiser> advertisers = new ConcurrentHashMap<>();
    public static final Map<String, User> users = new ConcurrentHashMap<>();
    public static final Map<String, Advertisement> ads = new ConcurrentHashMap<>();
    public static final Deque<AdServeEvent> recentServes = new ArrayDeque<>();
}
