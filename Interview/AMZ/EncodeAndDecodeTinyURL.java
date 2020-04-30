package Interview.AMZ;
import java.util.*;

public class EncodeAndDecodeTinyURL {
    
    private final ArrayList<String> list = new ArrayList<String>();
    private int count = 0;
    public String encode(String longUrl) {
        // Encodes a URL to a shortened URL.
        list.add(longUrl);
        return Integer.toString(count++);
    }

    
    public String decode(String shortUrl) {
        // Decodes a shortened URL to its original URL.
        
        String longUrl = list.get(Integer.parseInt(shortUrl));
        return longUrl;
    }
}