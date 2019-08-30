package URLShortener.Service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.common.hash.HashCode;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.hibernate.validator.internal.constraintvalidators.hv.URLValidator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;


@Service
public class URLService {
    private static final String HTTPS = "https://";
    private static final String HTTP = "http://";
    private static final String hashAlgorithm = "MD5";

    public String cleanURL(String url){
        if (!(url.startsWith(HTTPS) || url.startsWith(HTTP))) {
            url = HTTPS + url;
        }
        return url;
    }

    public boolean isValidURL(String url) {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }



//    Taken from https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

    /**
     * Generate MD5 Hash of input URL
     * return first 6 characters as new URL
     * @param longURl inputURL to be shortened
     * @return shortened URL
     */
    public String shortenURL(String longURl){
        String shortened = null;
        int maxURLlength = 6;
        try{
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
            md.update(longURl.getBytes());

            byte[] bytes = md.digest();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < maxURLlength - 3; i++){      // maxLength - 3 is to account for initial 3 letters from first append
//                & 0xFF returns bytes[i] as value between 0-255
//                + 0x100 adds 256 to result - ensure value is 3 digits
//                radix of 16 - convert int to string using hexadecimal
//                substring(1) removes first character
                builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            shortened = builder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return shortened;
    }
}
