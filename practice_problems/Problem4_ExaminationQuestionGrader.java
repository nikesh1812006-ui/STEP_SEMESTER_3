import java.util.Scanner;

/**
 * Problem 4: Examination Question Grader
 * Category C - Week 8 Practice Problem
 *
 * Demonstrates polymorphic answer evaluation for:
 * - Multiple Choice Questions (MCQ): full points on exact match
 * - True/False Questions (TF): full points on exact match
 * - Essay Questions (ESSAY): keyword matching (>=2 keywords -> 75%, 1 keyword -> 50%, else 0)
 */
public class Problem4_ExaminationQuestionGrader {

    public abstract static class Question {
        protected String type;
        protected String questionText;
        protected String correctAnswer;
        protected int points;

        public Question(String type, String questionText, String correctAnswer, int points) {
            this.type = type;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.points = points;
        }

        public String getType() {
            return type;
        }

        public abstract double grade(String studentAnswer);
    }

    public static class MCQQuestion extends Question {
        public MCQQuestion(String questionText, String correctAnswer, int points) {
            super("MCQ", questionText, correctAnswer, points);
        }

        @Override
        public double grade(String studentAnswer) {
            if (studentAnswer != null && studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
                return points;
            }
            return 0.0;
        }
    }

    public static class TFQuestion extends Question {
        public TFQuestion(String questionText, String correctAnswer, int points) {
            super("TF", questionText, correctAnswer, points);
        }

        @Override
        public double grade(String studentAnswer) {
            if (studentAnswer != null && studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
                return points;
            }
            return 0.0;
        }
    }

    public static class EssayQuestion extends Question {
        public EssayQuestion(String questionText, String commaSeparatedKeywords, int points) {
            super("ESSAY", questionText, commaSeparatedKeywords, points);
        }

        @Override
        public double grade(String studentAnswer) {
            if (studentAnswer == null || studentAnswer.trim().isEmpty()) {
                return 0.0;
            }
            String[] keywords = correctAnswer.split(",");
            int matched = 0;
            String lowerAnswer = studentAnswer.toLowerCase();
            for (String kw : keywords) {
                String cleanKw = kw.trim().toLowerCase();
                if (!cleanKw.isEmpty() && lowerAnswer.contains(cleanKw)) {
                    matched++;
                }
            }

            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            } else {
                return 0.0;
            }
        }
    }

    public static class AnswerSubmission {
        Question question;
        String studentAnswer;

        public AnswerSubmission(Question question, String studentAnswer) {
            this.question = question;
            this.studentAnswer = studentAnswer;
        }
    }

    public static void gradeSubmissions(AnswerSubmission[] submissions) {
        double overallScore = 0.0;
        for (AnswerSubmission sub : submissions) {
            double score = sub.question.grade(sub.studentAnswer);
            System.out.printf("%s: %.2f%n", sub.question.getType(), score);
            overallScore += score;
        }
        System.out.printf("Total Score: %.2f%n", overallScore);
    }

    public static void main(String[] args) {
        System.out.println("=== Examination Question Grader ===");
        AnswerSubmission[] submissions = new AnswerSubmission[] {
            new AnswerSubmission(new MCQQuestion("What is the capital of France?", "Paris", 10), "Paris"),
            new AnswerSubmission(new TFQuestion("The Earth is flat?", "False", 5), "True"),
            new AnswerSubmission(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", 20), "Polymorphism is one."),
            new AnswerSubmission(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", 15), "I talked about abstraction.")
        };

        gradeSubmissions(submissions);
    }
}
