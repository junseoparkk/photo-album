package toy.photoalbum.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.photoalbum.domain.entity.Album;

@Transactional
@SpringBootTest
class AlbumRepositoryTest {
    @Autowired
    AlbumRepository albumRepository;

    @AfterEach
    void afterEach() {
        albumRepository.deleteAll();
    }


    //== 기본 CRUD 기능 테스트 ==//

    @DisplayName("앨범 생성 및 아이디 조회 테스트")
    @Test
    void saveAndFindByIdTest() {
        //given
        Album album = Album.builder()
                .name("testAlbum")
                .build();

        //when
        Album savedAlbum = albumRepository.save(album);
        Album findAlbum = albumRepository.findById(savedAlbum.getId()).get();

        //then
        assertThat(findAlbum.getName()).isEqualTo(savedAlbum.getName());
    }

    @DisplayName("앨범 목록 조회 테스트")
    @Test
    void findAllTest() {
        //given
        Album album1 = Album.builder()
                .name("testAlbum1")
                .build();
        Album album2 = Album.builder()
                .name("testAlbum2")
                .build();

        albumRepository.save(album1);
        albumRepository.save(album2);

        //when
        List<Album> albums = albumRepository.findAll();

        //then
        assertThat(albums.size()).isEqualTo(2);
    }

    @DisplayName("앨범 이름 변경 테스트")
    @Test
    void updateAlbumNameTest() {
        //given
        Album album = Album.builder()
                .name("testAlbum")
                .build();

        Album savedAlbum = albumRepository.save(album);

        //when
        Album findAlbum = albumRepository.findById(savedAlbum.getId()).get();
        findAlbum.changeName("newAlbum");

        //then
        assertThat(savedAlbum.getName()).isEqualTo("newAlbum");
    }

    @DisplayName("앨범 삭제 테스트")
    @Test
    void deleteByIdTest() {
        //given
        Album album = Album.builder()
                .name("testAlbum")
                .build();

        Album savedAlbum = albumRepository.save(album);

        //when
        albumRepository.deleteById(savedAlbum.getId());

        //then
        Optional<Album> findAlbum = albumRepository.findById(savedAlbum.getId());
        assertThat(findAlbum.isEmpty()).isTrue();
    }

    @DisplayName("이름으로 앨범 찾는 기능 테스트")
    @Test
    void findByNameTest() {
        //given
        Album album = new Album("test");
        albumRepository.save(album);

        //when
        Album findAlbum = albumRepository.findByName(album.getName());

        //then
        assertThat(findAlbum.getName()).isEqualTo(album.getName());
    }
}