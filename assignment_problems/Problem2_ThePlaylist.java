import java.util.Arrays;

/**
 * Problem 2: The Playlist
 * Category C - Week 7 Assignment Problem
 *
 * Requirements:
 * - Store song titles in a private array (fixed maximum size).
 * - Provide a method to add a song, and one that returns all songs added so far as a copy, not the original array.
 * - Changing the array returned by that method must not affect the playlist's real contents (defensive copy).
 * - Provide a read-only count of how many songs are in the playlist.
 */
public class Problem2_ThePlaylist {

    public static class Playlist {
        private final String[] songs;
        private int count;

        public Playlist(int capacity) {
            this.songs = new String[capacity];
            this.count = 0;
        }

        public boolean addSong(String title) {
            if (title == null || title.trim().isEmpty()) {
                return false;
            }
            if (count >= songs.length) {
                System.out.println("Playlist is full. Cannot add: " + title);
                return false;
            }
            songs[count++] = title.trim();
            return true;
        }

        public int getSongCount() {
            return count;
        }

        // Returns a safe defensive copy containing only added songs
        public String[] getSongs() {
            String[] safeCopy = new String[count];
            System.arraycopy(songs, 0, safeCopy, 0, count);
            return safeCopy;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Playlist ===");
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs returned: " + Arrays.toString(copy));

        // Attempt malicious external mutation
        copy[0] = "Hacked";
        System.out.println("Mutated external copy[0] to: " + copy[0]);
        System.out.println("Playlist real p.getSongs()[0] is still: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
