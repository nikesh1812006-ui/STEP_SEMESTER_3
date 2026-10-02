import java.util.Arrays;

/**
 * Problem 2: Duplicate Player Pick Checker
 * Scenario: Cricket fantasy app lineup screening
 * 
 * Compares player names using plain nested loops without Collections,
 * returning the first repeated player or indicating no duplicates exist.
 */
public class Problem2_DuplicatePlayerPickChecker {

    /**
     * Finds any duplicate player pick in the submitted lineup.
     * 
     * @param playerNames Array of player names (up to 11 players)
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Duplicate Player Pick Checker ===");
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.printf("%s -> \"%s\"%n", Arrays.toString(lineup1), findDuplicatePick(lineup1));

        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.printf("%s -> \"%s\"%n", Arrays.toString(lineup2), findDuplicatePick(lineup2));
    }
}
