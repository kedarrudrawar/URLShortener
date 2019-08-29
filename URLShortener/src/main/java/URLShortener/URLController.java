package URLShortener;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

    @RequestMapping("/")
    public String index(){
        return "This is the home page.";
    }
}
