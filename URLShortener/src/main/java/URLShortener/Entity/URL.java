package URLShortener.Entity;
import org.springframework.data.annotation.Id;

public class URL {
    @Id
    private String shortenedURL;
    private String originalURl;
    private String creationDate;
    private int userID;

    public URL(){
        this.shortenedURL = "";
        this.originalURl = "";
        this.creationDate = "";
        this.userID = 0;
    }

    public URL(String shortenedURL, String originalURl){
        this.shortenedURL = shortenedURL;
        this.originalURl = originalURl;
        this.creationDate = "";
        this.userID = 0;
    }

    public URL(String shortenedURL, String originalURl, String creationDate) {
        this.shortenedURL = shortenedURL;
        this.originalURl = originalURl;
        this.creationDate = creationDate;
    }

    public URL(String shortenedURL, String originalURl, String creationDate, int userID) {
        this.shortenedURL = shortenedURL;
        this.originalURl = originalURl;
        this.creationDate = creationDate;
        this.userID = userID;
    }

    public String getShortenedURL() {
        return shortenedURL;
    }

    public void setShortenedURL(String shortenedURL) {
        this.shortenedURL = shortenedURL;
    }

    public String getOriginalURl() {
        return originalURl;
    }

    public void setOriginalURl(String originalURl) {
        this.originalURl = originalURl;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return String.format(
                "URL[id=%s, originalURL='%s', creationDate='%s', userID='%s']",
                this.shortenedURL, this.originalURl, this.creationDate, this.userID);
    }
}
