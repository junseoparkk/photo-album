package toy.photoalbum.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.photoalbum.domain.entity.Album;
import toy.photoalbum.repository.AlbumRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    @Override
    public Album save(Album album) {
        /*
         * TO-BE
         * 검증 로직
         */

        return albumRepository.save(album);
    }

    @Override
    public Album findById(Long albumId) {
        Optional<Album> findAlbum = albumRepository.findById(albumId);
        if (findAlbum.isPresent()) {
            return findAlbum.get();
        }
        throw new EntityNotFoundException(String.format("Could not find by id : %d", albumId));
    }

    @Override
    public List<Album> findAll() {
        return null;
    }

    @Override
    public Long update(Long albumId, Album updateAlbum) {
        return null;
    }

    @Override
    public Long deleteByID(Long albumId) {
        return null;
    }
}
