package nl.teamrockstars.artist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 */
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    /**
     * Returns a instance of type {@link Artist} with the given name.
     *
     * @param name the given name.
     * @return the {@link Artist} with the given name.
     */
    Artist findByName(@Param("name") String name);
}
