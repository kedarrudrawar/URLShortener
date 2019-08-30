package URLShortener;

import URLShortener.Entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<Url, String> {
    public Url findByShortenedURL(String shortenedURL);
}
