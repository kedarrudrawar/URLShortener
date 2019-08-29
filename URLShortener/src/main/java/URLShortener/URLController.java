package URLShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class URLController {
    @Autowired
    URLService urlService;

    @RequestMapping("/")
    public String index(){
        return "This is the home page.";
    }

    @GetMapping("/query")
    public @ResponseBody String convertURL(@RequestParam String longURL) throws IllegalArgumentException{
        System.out.println("LONGURL:" + longURL);
        if(! urlService.isValidURL(longURL))
            throw new IllegalArgumentException("Invalid URL.");
        return longURL;
    }
}
