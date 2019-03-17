package nl.teamrockstars.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.teamrockstars.artist.Artist;
import nl.teamrockstars.artist.ArtistRepository;
import nl.teamrockstars.song.Song;
import nl.teamrockstars.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    @Autowired
    public DatabaseLoader(final ArtistRepository artists,
            final SongRepository songs) {
        this.artistRepository = artists;
        this.songRepository = songs;
    }

    /**
     * Fills the database with the {@link Artist}'s and {@link Song}'s
     * by reading the JSON files and saving the content.
     *
     * @param args
     */
    @Override
    public void run(final ApplicationArguments args) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Artist>> typeReferenceArtist
                = new TypeReference<List<Artist>>() {};
        TypeReference<List<Song>> typeReferenceSong
                = new TypeReference<List<Song>>() {};
        InputStream inputStreamArtist = TypeReference.class
                .getResourceAsStream("/json/artists.json");

        InputStream inputStreamSong = TypeReference.class
                .getResourceAsStream("/json/songs.json");

        try {
            List<Artist> artists = mapper
                    .readValue(inputStreamArtist, typeReferenceArtist);
            List<Song> songs = mapper
                    .readValue(inputStreamSong, typeReferenceSong);
            artistRepository.save(artists);
            songRepository.save(songs);
            System.out.println("All Artists & Songs are saved!");
        } catch (IOException e) {
            System.out.println("Unable to save data: " + e.getMessage());
        }
    }
}
