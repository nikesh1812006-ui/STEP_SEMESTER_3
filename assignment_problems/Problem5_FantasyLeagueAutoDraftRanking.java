import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Scenario: Auto-draft qualifying and ranking system
 * 
 * Uses method overloading for draft eligibility rules and Comparable<Player>
 * so that Arrays.sort() ranks draftable players descending by batting average.
 */
public class Problem5_FantasyLeagueAutoDraftRanking {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            // Rank descending by batting average
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    /**
     * Overloaded Rule 1: Established player qualifying on experience alone (matches >= 10).
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded Rule 2: Combined matches and current fitness rule.
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        if (isDraftable(matchesPlayed)) {
            return true;
        }
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters draftable players, sorts them using Arrays.sort(), and prints ranks.
     * 
     * @param players Array of players
     * @return Formatted ranking string "1. Name | 2. Name | 3. Name"
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        // Sorts using Player.compareTo() descending
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append((i + 1)).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Fantasy League Auto-Draft Ranking Engine ===");
        Player[] lineup = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String rankings = draftAndRank(lineup);
        System.out.println("Draft Leaderboard: " + rankings);
    }
}
