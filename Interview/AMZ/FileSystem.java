package Interview.AMZ;
import java.util.*;

class File {
    boolean isFile = false;
    HashMap<String, File> files = new HashMap<>();
    String content = "";
}

public class FileSystem {
    
    File root;

    public FileSystem() {
        this.root = new File();
    }
    
    public List<String> ls(String path) {
        File f = this.root; 
        List<String> fileNames = new ArrayList<String>(); 
        
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                f = f.files.get(d[i]);
            }
            
            if (f.isFile) {
                fileNames.add(d[d.length - 1]);
                return fileNames;
            }
        }
        
        fileNames = new ArrayList<String>(f.files.keySet());
        Collections.sort(fileNames);
        return fileNames;
    }
    
    public void mkdir(String path) {
        
        File f = root;
        String[] d = path.split("/");
        
        for (int i = 1; i < d.length; i++) {
            
            if (!f.files.containsKey(d[i])) 
                f.files.put(d[i], new File());
            
            f = f.files.get(d[i]);
        }
        
    }
    
    public void addContentToFile(String filePath, String content) {
        File f = root;
        String[] d = filePath.split("/");
        
        for (int i = 1; i < d.length - 1; i++) {
            f = f.files.get(d[i]);
        }
        
        if (!f.files.containsKey(d[d.length - 1])) {
            f.files.put(d[d.length - 1], new File());
        }
        
        f = f.files.get(d[d.length - 1]);
        f.isFile = true;
        f.content = f.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        File f = root; 
        
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length; i++) {
            f = f.files.get(d[i]);
        }
        
        return f.content;
    }
}