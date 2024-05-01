import java.util.ArrayList;
import java.util.List;

interface SongService{
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}

class Song{
    private Integer id;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(Integer id, String title, String artist, String album, int duration){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }
}

class SongServiceClass implements SongService{
    private List<Song> songList;

    public SongServiceClass(){
        songList = new ArrayList<>();

        songList.add(new Song(1, "Song 1", "Artist 1", "Album 1", 180));
        songList.add(new Song(2, "Song 2", "Artist 2", "Album 2", 180));
        songList.add(new Song(3, "Song 3", "Artist 3", "Album 3", 180));
        songList.add(new Song(4, "Song 4", "Artist 4", "Album 4", 180));
        songList.add(new Song(5, "Song 5", "Artist 5", "Album 5", 180));

    }

    @Override
    public List<Song> searchByTitle(String title){
        List<Song> searchedSong = new ArrayList<>();
        for(Song song : songList){
            if(song.getTitle().equals(title))
            {
                searchedSong.add(song);
            }
        }
        simulateServerDelay();
        return searchedSong;
    }
    public Song searchById(Integer id){
        for (Song song: songList){
            if(song.getId().equals(id)){
                return song;
            }
        }
        return null;
    }

    public List<Song> searchByAlbum(String album){
        List<Song> searchedAlbum = new ArrayList<>();
        for(Song song: songList){
            if(song.getAlbum().equals((album)))
            {
                searchedAlbum.add(song);
            }
        }
        simulateServerDelay();
        return searchedAlbum;
    }

    private void simulateServerDelay() {
        try {
            Thread.sleep(1000); // Simulate server delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Proxy implements SongService{
    private SongServiceClass songServiceClass;
    private Song cacheSongMeta;

    public Proxy(){
        songServiceClass = new SongServiceClass();
        cacheSongMeta = null;
    }

    public Song searchById(Integer songIO){
        if(cacheSongMeta != null && cacheSongMeta.getId().equals(songIO))
        {
            return cacheSongMeta;
        }
        else{
            Song song = songServiceClass.searchById(songIO);
            cacheSongMeta = song;
            return song;
        }
    }


    public List<Song> searchByTitle(String title){
        return songServiceClass.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album){
        return songServiceClass.searchByAlbum(album);
    }
}

public class ProxyAssignment {
    public static void main(String[] args) {
        SongService songService = new Proxy();

        Song song1 = songService.searchById(1);
        Song song2 = songService.searchById(2);
        Song song3 = songService.searchById(3);
        Song song4 = songService.searchById(4);
        Song song5 = songService.searchById(5);

        if (song1 != null) {
            System.out.println("Song 1: " + song1.getTitle() + " - " + song1.getArtist() + " - " + song1.getAlbum() + " - " + song1.getDuration());
        } else {
            System.out.println("Song 1 not found.");
        }
        if (song2 != null) {
            System.out.println("Song 2: " + song2.getTitle() + " - " + song2.getArtist() + " - " + song2.getAlbum() + " - " + song2.getDuration());
        } else {
            System.out.println("Song 2 not found.");
        }
        if (song3 != null) {
            System.out.println("Song 3: " + song3.getTitle() + " - " + song3.getArtist() + " - " + song3.getAlbum() + " - " + song3.getDuration());
        } else {
            System.out.println("Song 3 not found.");
        }
        if (song4 != null) {
            System.out.println("Song 4: " + song4.getTitle() + " - " + song4.getArtist() + " - " + song4.getAlbum() + " - " + song4.getDuration());
        } else {
            System.out.println("Song 4 not found.");
        }
        if (song5 != null) {
            System.out.println("Song 5: " + song5.getTitle() + " - " + song5.getArtist() + " - " + song5.getAlbum() + " - " + song5.getDuration());
        } else {
            System.out.println("Song 5 not found.");
        }
    }
}
