import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Placement Drive Shortlisting & Ranking Engine
 * Scenario: Placement cell shortlisting and ranking engine
 * 
 * Implements method overloading for eligibility criteria and natural ordering
 * via Comparable<Candidate> so Arrays.sort() ranks candidates by composite score.
 */
public class Problem5_PlacementShortlistingEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        private double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            // Composite score calculation: (cgpa * 10) + (codingScore * 0.5)
            this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        @Override
        public int compareTo(Candidate other) {
            // Descending order of composite score
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    /**
     * Overloaded Rule 1: High CGPA alone qualifies for shortlisting.
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Overloaded Rule 2: Borderline CGPA requires strong coding test score.
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Filters eligible candidates, sorts them using Arrays.sort(), and returns ranked string.
     * 
     * @param candidates Array of candidate profiles
     * @return Formatted ranking string "1. Name (Score) | 2. Name (Score) ..."
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleList.add(c);
            }
        }

        Candidate[] shortlisted = eligibleList.toArray(new Candidate[0]);
        // Sorts using Candidate.compareTo() descending
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append((i + 1))
              .append(". ")
              .append(shortlisted[i].getName())
              .append(" (")
              .append(String.format("%.1f", shortlisted[i].getCompositeScore()))
              .append(")");
            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Placement Drive Shortlisting & Ranking Engine ===");
        Candidate[] pool = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String ranking = shortlistAndRank(pool);
        System.out.println("Result: " + ranking);
    }
}
