package URLShortener.Controller;

import URLShortener.Entity.URL;
import URLShortener.Service.URLService;
import URLShortener.Dao.URLDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
public class URLController {
    public static final String API_ROOT = "localhost:8080/";

    @Autowired
    URLService urlService;

    @Autowired
    URLDao urlDao;

    @RequestMapping("/")
    public String index(){
        return "This is the home page.";
    }

    @GetMapping("/query")
    public @ResponseBody String convertURL(@RequestParam String longURL) throws IllegalArgumentException{
        System.out.println("LONGURL:" + longURL);
        String cleanedURL = urlService.cleanURL(longURL);
        if(! urlService.isValidURL(cleanedURL))
            throw new IllegalArgumentException("Invalid URL.");

        String hashedURL = urlService.shortenURL(cleanedURL);

        String today = Calendar.getInstance().toString();
        URL url = new URL(API_ROOT + hashedURL, cleanedURL, today, 0);

        urlDao.saveURL(url);

        return url.getShortenedURL();
    }

    @GetMapping("/go")
    public @ResponseBody String redirectURL(@RequestParam String id){
        return urlDao.getRedirect(id);
    }
}
