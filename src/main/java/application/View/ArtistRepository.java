package application.View;

import application.Model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long>
{
    Iterable<Artist> findByScenId(int id);
}
