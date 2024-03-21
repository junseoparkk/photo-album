package toy.photoalbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.photoalbum.domain.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByName(String name);
}
