package nl.teamrockstars.song;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 */
public interface SongRepository extends CrudRepository<Song, Long> {
    /**
     * Returns all instances of type {@link Song} with the given genre.
     *
     * @param genre the given genre.
     * @return a {@link List} of {@link Song}'s with the given genre.
     */
    List<Song> findByGenre(@Param("genre") String genre);

    /**
     * Returns all instances of type {@link Song} with the given genre that are before given year.
     *
     * @param genre the given genre.
     * @param year  the given year.
     * @return a {@link List} of {@link Song}'s with the given genre and year.
     */
    List<Song> findByGenreAndYearBefore(@Param("genre") String genre,
            @Param("year") int year);
}
