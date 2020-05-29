package Interview.MS;

import java.util.*; 

class HtmlParser {

    public List<String> getUrls(String url) {

        List<String> urls = new ArrayList<String>();

        return urls;
    }
}

public class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        List<String> res = new ArrayList<String>();
        int hostEndIndex = 0; 
        
        for (int i = 7; i < startUrl.length(); i++) {
            
            if (startUrl.charAt(i) == '/') {
                hostEndIndex = i;
                break;
            }
            else {
                hostEndIndex = startUrl.length();
            }
        }
        
        String baseHostName = startUrl.substring(0, hostEndIndex);
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> seen = new HashSet<String>();
        
        queue.offer(startUrl);
        seen.add(startUrl);
        
        while (!queue.isEmpty()) {
            
            String node = queue.poll();
            res.add(node); 
            
            for (String neighbor : htmlParser.getUrls(node)) {
                
                if (!neighbor.startsWith(baseHostName))
                    continue;
                
                if (seen.contains(neighbor))
                    continue;
                
                queue.offer(neighbor);
                seen.add(neighbor);
            }
        }
        
        return res;
    }
}