package URLShortener;

import URLShortener.Entity.URL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<URL, String> {
    public URL findByShortenedURL(String shortenedURL);
}
