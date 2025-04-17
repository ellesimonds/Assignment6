package Question3;
import java.util.*;

public class ElectionSystem {
    public static void main(String[] args) {
        Election election = new Election();

        //randomize number of candidates between 3 and 7
        int candidateCount = new Random().nextInt(5) + 3;

        //sample names to choose from
        List<String> possibleNames = Arrays.asList(
                "Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train",
                "Anya Stroud", "Queen Myrrah", "General RAAM", "Tai Kaliso"
        );

        //shuffle and pick random candidates
        Collections.shuffle(possibleNames);
        LinkedList<String> candidates = new LinkedList<>(possibleNames.subList(0, candidateCount));

        //randomize number of votes between 5 and 20
        int p = new Random().nextInt(16) + 5;

        System.out.println("Randomized Candidates: " + candidates);
        System.out.println("Total Electorate Votes: " + p);

        election.initializeCandidates(candidates);
        election.setMaxVotes(p);

        //randomly cast p votes
        for (int i = 0; i < p; i++) {
            election.castRandomVote();
        }

        System.out.println("Top 3 candidates after voting: " + election.getTopKCandidates(3));

        //rig the election for a random candidate
        String winner = candidates.get(new Random().nextInt(candidates.size()));
        election.rigElection(winner);
        System.out.println("Top 3 candidates after rigging the election: " + election.getTopKCandidates(3));

        System.out.println("Audit Election:");
        election.auditElection();
    }
}
