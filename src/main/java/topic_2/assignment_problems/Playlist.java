package topic_2.assignment_problems;

public class Playlist {
    private static final int MAX_SONGS = 100;
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        songs = new String[Math.min(capacity, MAX_SONGS)];
    }

    public void addSong(String song) {
        if (songCount == songs.length) {
            throw new IllegalStateException("Playlist is full");
        }
        songs[songCount++] = song;
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];
        System.arraycopy(songs, 0, copy, 0, songCount);
        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}
