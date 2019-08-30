package URLShortener;

import URLShortener.Entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private URLRepository urlRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        urlRepository.deleteAll();

        urlRepository.save(new Url("urlShort", "urlLONG"));
        for(Url url : urlRepository.findAll()){
            System.out.println(url.toString());
        }
    }
}
