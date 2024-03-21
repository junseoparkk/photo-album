package toy.photoalbum.utils.mapper;

import java.time.LocalDateTime;
import java.util.List;
import toy.photoalbum.domain.dto.request.RequestAlbumDetails;
import toy.photoalbum.domain.dto.response.ResponseAlbumDetails.BasicResponse;
import toy.photoalbum.domain.dto.response.ResponseAlbumDetails.InfoResponse;
import toy.photoalbum.domain.entity.Album;

public class AlbumMapper {
    public static BasicResponse convertToBasicDto(Album album) {
        Long id = album.getId();
        String name = album.getName();
        LocalDateTime createdDate = album.getCreatedDate();
        int photoCount = album.countPhotos();

        return BasicResponse.of(id, name, createdDate, photoCount);
    }

    public static InfoResponse convertToInfoDto(Album album) {
        Long id = album.getId();
        String name = album.getName();
        LocalDateTime createdDate = album.getCreatedDate();
        int photoCount = album.countPhotos();
        List<String> thumbnailUrls = album.getThumbnailUrls();

        return InfoResponse.of(id, name, createdDate, photoCount, thumbnailUrls);
    }

    public static Album convertToAlbum(RequestAlbumDetails request) {
        String name = request.name();
        return new Album(name);
    }
}
