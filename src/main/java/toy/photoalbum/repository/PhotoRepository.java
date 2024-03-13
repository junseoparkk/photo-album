package toy.photoalbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.photoalbum.domain.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
