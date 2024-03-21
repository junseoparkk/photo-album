package toy.photoalbum.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ResponseAlbumDetails {
    @Getter @Setter
    static class BasicResponse {
        private Long id;

        private String name;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        private int photoCount;

        @Builder
        public BasicResponse of(Long id, String name, LocalDateTime createdDate, int photoCount) {
            return builder()
                    .id(id)
                    .name(name)
                    .createdDate(createdDate)
                    .photoCount(photoCount)
                    .build();
        }
    }

    @Getter @Setter
    static class InfoResponse {
        private Long id;

        private String name;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        private int photoCount;

        private List<String> thumbnailUrls;

        @Builder
        public InfoResponse(Long id, String name, LocalDateTime createdDate, int photoCount, List<String> thumbnailUrls) {
            this.id = id;
            this.name = name;
            this.createdDate = createdDate;
            this.photoCount = photoCount;
            this.thumbnailUrls = thumbnailUrls;
        }
    }
}
