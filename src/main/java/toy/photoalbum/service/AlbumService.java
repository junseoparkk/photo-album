package toy.photoalbum.service;

import java.util.List;
import toy.photoalbum.domain.entity.Album;

public interface AlbumService {
    // CRUD
    Album save(Album album);
    Album findById(Long albumId);
    Album findByName(String name);
    List<Album> findAll();
    Long update(Long albumId, Album updateAlbum);
    Long deleteByID(Long albumId);
}
