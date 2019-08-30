package URLShortener.Dao;

import URLShortener.Entity.Url;
import URLShortener.Service.URLService;
import URLShortener.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class URLDao {
    @Autowired
    URLRepository urlRepository;

    @Autowired
    URLService  urlService;

    public void saveURL(Url url) {
        this.urlRepository.save(url);
    }

    public String getRedirect(String shortenedURL){
        String orig = urlRepository.findByShortenedURL(shortenedURL).getOriginalURl();
        System.out.println("found:" + orig);
        return orig;
    }
}
