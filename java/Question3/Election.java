package Question3;
import java.util.*;

public class Election {
    private HashMap<String, Integer> voteCount = new HashMap<>();
    private int totalVotes = 0;
    private int maxVotes = 0;
    private List<String> candidateList = new ArrayList<>();

    public void initializeCandidates(LinkedList<String> candidates) {
        for (String candidate : candidates) {
            voteCount.put(candidate, 0);
            candidateList.add(candidate);
        }
    }

    public void setMaxVotes(int p) {
        this.maxVotes = p;
    }

    public void castVote(String candidate) {
        if (totalVotes < maxVotes && voteCount.containsKey(candidate)) {
            voteCount.put(candidate, voteCount.get(candidate) + 1);
            totalVotes++;
        }
    }

    public void castRandomVote() {
        if (totalVotes < maxVotes) {
            Random rand = new Random();
            String candidate = candidateList.get(rand.nextInt(candidateList.size()));
            castVote(candidate);
        }
    }

    public void rigElection(String winner) {
        for (String c : voteCount.keySet()) {
            voteCount.put(c, 0);
        }
        voteCount.put(winner, maxVotes);
        totalVotes = maxVotes;
    }

    public List<String> getTopKCandidates(int k) {
        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(voteCount.entrySet());

        List<String> topK = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            topK.add(maxHeap.poll().getKey());
        }
        return topK;
    }

    public void auditElection() {
        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(voteCount.entrySet());

        while (!maxHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = maxHeap.poll();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
