package votingsystem;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VotingSystem {

    //used volatile here, as new object creation is multiple step process
    private static volatile VotingSystem instance;
    private final Map<String, Voter> voters;
    private final Map<String, Candidate> candidates;
    private final Map<String, AtomicInteger> voteCount;
    private final Set<String> votedVoters;
    private final ReadWriteLock votingLock; //common lock object to shared across all threads
    private volatile boolean isVotingOpen;
    private final BlockingQueue<Vote> voteAuditLog; //Thread-safe queue

    private VotingSystem (){
        //used concurrent hashmap to make the put operation thread-safe and synchronized
        this.voters = new ConcurrentHashMap<>();
        this.candidates = new ConcurrentHashMap<>();
        this.voteCount = new ConcurrentHashMap<>();
        this.votedVoters = ConcurrentHashMap.newKeySet();
        this.votingLock = new ReentrantReadWriteLock();
        this.voteAuditLog = new LinkedBlockingQueue<>();
        this.isVotingOpen = false;
    }

    //Used double locking here
    //More efficient than synchronized, as once instance becomes not null, no threads get blocked due to locking.
    public static VotingSystem getInstance() {
        if (instance == null) {
            synchronized (VotingSystem.class) {
                if (instance == null) {
                    instance =  new VotingSystem();
                }
            }
        }
        return instance;
    }


    public void registerCandidates(String name, String Id){
        if (candidates.containsKey(Id)) System.out.println("Candidate already exists");
        candidates.put(Id, new Candidate(name, Id));
    }

    public void registerVoters(String name, String Id){
        if (voters.containsKey(Id)) System.out.println("Voter already exists");
        voters.put(Id, new Voter(name, Id));
    }

    public void startVoting() {
        votingLock.writeLock().lock();
        try {
            isVotingOpen = true;
            System.out.println("Voting has started!");
        } finally {
            votingLock.writeLock().unlock();
        }
    }


    public void castVote(String voterId, String candidateId){
        votingLock.readLock().lock();
        try{
            if (voterId==null || voterId.isEmpty() || !voters.containsKey(voterId)){
                System.out.println("Voter id not valid");
                return;
            }
            if (candidateId==null || candidateId.isEmpty() || !candidates.containsKey(candidateId)){
                System.out.println("Candidate id not valid");
                return;
            }

            if (isVotingOpen){
                voteCount.get(candidateId).incrementAndGet();
                voteAuditLog.offer(new Vote(voterId, candidateId, new Date()));
            }
        }finally {
            votingLock.readLock().unlock();
            System.out.println("Read lock released");
        }
    }

    public Map<String, Integer> getCurrentResults() {
        Map<String, Integer> results = new HashMap<>();
        votingLock.readLock().lock();
        try {
            for (Map.Entry<String, AtomicInteger> entry : voteCount.entrySet()) {
                results.put(candidates.get(entry.getKey()).getName(),
                        entry.getValue().get());
            }
            return results;
        } finally {
            votingLock.readLock().unlock();
        }
    }

    public List<Vote> getAuditLog() {
        return new ArrayList<>(voteAuditLog);
    }

    public void endVoting() {
        votingLock.writeLock().lock();
        try {
            isVotingOpen = false;
            System.out.println("Voting has ended!");
        } finally {
            votingLock.writeLock().unlock();
        }
    }
}
