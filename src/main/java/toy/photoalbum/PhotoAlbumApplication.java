package toy.photoalbum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PhotoAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAlbumApplication.class, args);
	}

}
