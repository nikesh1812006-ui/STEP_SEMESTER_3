import java.util.Arrays;

/**
 * Problem 2: Duplicate Team Registration Checker
 * Scenario: Hackathon registration portal screening for duplicate team names
 * 
 * Uses plain nested loops without Collections to identify duplicate entries,
 * checking only forward pairs (i vs j where j > i) to optimize execution.
 */
public class Problem2_DuplicateTeamChecker {

    /**
     * Scans the array and reports the first duplicate team found.
     * 
     * @param teamNames Array of registered team names
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Duplicate Team Registration Checker ===");
        String[] batch1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.printf("%s -> \"%s\"%n", Arrays.toString(batch1), findDuplicateTeam(batch1));

        String[] batch2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.printf("%s -> \"%s\"%n", Arrays.toString(batch2), findDuplicateTeam(batch2));
    }
}
