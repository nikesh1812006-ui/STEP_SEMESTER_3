/**
 * Problem 3: The Nickname Tag
 * Category C - Week 7 Practice Problem
 *
 * Requirements:
 * - Take one full name string in the constructor (e.g., "Maria Gomez") and split it into first and last name.
 * - Store whatever you keep as final fields — nothing about the name should be changeable after creation.
 * - Provide a method that returns the nickname (e.g., "Maria G."), built from the stored parts.
 * - Assume the full name always has exactly one first name and one last name, separated by a single space.
 */
public class Problem3_TheNicknameTag {

    public static final class NameTag {
        private final String firstName;
        private final String lastName;
        private final String nickname;

        public NameTag(String fullName) {
            String[] parts = fullName.trim().split("\\s+");
            if (parts.length >= 2) {
                this.firstName = parts[0];
                this.lastName = parts[1];
                this.nickname = this.firstName + " " + this.lastName.charAt(0) + ".";
            } else if (parts.length == 1) {
                this.firstName = parts[0];
                this.lastName = "";
                this.nickname = this.firstName;
            } else {
                this.firstName = "";
                this.lastName = "";
                this.nickname = "";
            }
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getNickname() {
            return nickname;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Nickname Tag ===");
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Full Name: " + tag.getFirstName() + " " + tag.getLastName());
        System.out.println("Nickname: " + tag.getNickname());

        NameTag tag2 = new NameTag("Alexander Hamilton");
        System.out.println("Nickname 2: " + tag2.getNickname());
    }
}
