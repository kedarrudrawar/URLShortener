package URLShortener.Dao;

import URLShortener.Entity.URL;
import URLShortener.Service.URLService;
import URLShortener.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

import static URLShortener.Controller.URLController.API_ROOT;

@Repository
public class URLDao {
    @Autowired
    URLRepository urlRepository;

    @Autowired
    URLService  urlService;

    public void saveURL(URL url) {
        this.urlRepository.save(url);
    }

    public String getRedirect(String shortenedURL){
        return urlRepository.findByShortenedURL(shortenedURL).getOriginalURl();
    }
}
