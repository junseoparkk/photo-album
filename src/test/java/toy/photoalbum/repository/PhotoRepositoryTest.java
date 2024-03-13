package toy.photoalbum.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.photoalbum.domain.entity.Album;
import toy.photoalbum.domain.entity.Photo;

@Transactional
@SpringBootTest
class PhotoRepositoryTest {
    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    AlbumRepository albumRepository;

    @AfterEach
    void afterEach() {
        photoRepository.deleteAll();
    }

    //== 기본 CRUD 기능 테스트 ==//

    @DisplayName("사진 생성 및 아이디 조회 테스트")
    @Test
    void saveAndFindByIdTest() {
        //given
        Album album = Album.builder()
                .name("testAlbum")
                .build();
        Album savedAlbum = albumRepository.save(album);

        Photo photo = createPhoto(0, savedAlbum);
        Photo savedPhoto = photoRepository.save(photo);

        //when
        Photo findPhoto = photoRepository.findById(savedPhoto.getId()).get();

        //then
        assertThat(findPhoto.getFileName()).isEqualTo(savedPhoto.getFileName());
        assertThat(findPhoto.getFileSize()).isEqualTo(savedPhoto.getFileSize());
        assertThat(findPhoto.getThumbnailUrl()).isEqualTo(savedPhoto.getThumbnailUrl());
        assertThat(findPhoto.getOriginalUrl()).isEqualTo(savedPhoto.getOriginalUrl());
        assertThat(findPhoto.getAlbum().getId()).isEqualTo(savedPhoto.getAlbum().getId());
    }

    @DisplayName("사진 여러 장 생성 테스트")
    @Test
    void savePhotosTest() {
        //given
        Album album = Album.builder()
                .name("testAlbum")
                .build();
        Album savedAlbum = albumRepository.save(album);

        Photo photo1 = createPhoto(1, savedAlbum);
        Photo photo2 = createPhoto(2, savedAlbum);

        Photo savedPhoto1 = photoRepository.save(photo1);
        Photo savedPhoto2 = photoRepository.save(photo2);

        savedAlbum.addPhoto(photo1);
        savedAlbum.addPhoto(photo2);

        //when
        List<Photo> photos = photoRepository.findAll();
        int photoCount = savedAlbum.countPhotos();

        //then
        assertThat(photoCount).isEqualTo(photos.size());

    }

    private Photo createPhoto(Integer sequence, Album album) {
        return Photo.builder()
                .fileName("testPhoto")
                .fileSize(sequence + 10)
                .thumbnailUrl("thumbUrl" + sequence)
                .originalUrl("originUrl" + sequence)
                .album(album)
                .build();
    }
}