package toy.photoalbum.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseAlbumDetails {
    private Long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    int photoCount;

    List<String> thumbnailUrls;

    @Builder
    public ResponseAlbumDetails(Long id, String name, LocalDateTime createdDate, int photoCount, List<String> thumbnailUrls) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.photoCount = photoCount;
        this.thumbnailUrls = thumbnailUrls;
    }

    @Builder
    public static ResponseAlbumDetails of(Long id, String name, LocalDateTime createdDate, int photoCount) {
        return builder()
                .id(id)
                .name(name)
                .createdDate(createdDate)
                .photoCount(photoCount)
                .build();
    }
}
