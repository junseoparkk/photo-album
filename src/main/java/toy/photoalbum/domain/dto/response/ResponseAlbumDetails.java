package toy.photoalbum.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ResponseAlbumDetails {
    @Getter @Setter
    public static class BasicResponse {
        private Long id;

        private String name;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        private int photoCount;

        @Builder
        public static BasicResponse of(Long id, String name, LocalDateTime createdDate, int photoCount) {
            return builder()
                    .id(id)
                    .name(name)
                    .createdDate(createdDate)
                    .photoCount(photoCount)
                    .build();
        }
    }

    @Getter @Setter
    public static class InfoResponse {
        private Long id;

        private String name;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        private int photoCount;

        private List<String> thumbnailUrls;

        @Builder
        public static InfoResponse of(Long id, String name, LocalDateTime createdDate, int photoCount, List<String> thumbnailUrls) {
            return builder()
                    .id(id)
                    .name(name)
                    .createdDate(createdDate)
                    .photoCount(photoCount)
                    .thumbnailUrls(thumbnailUrls)
                    .build();
        }
    }
}
