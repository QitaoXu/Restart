package Interview.ByteDance;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        
        int n = Math.max(levels1.length, levels2.length);
        
        for (int i = 0; i < n; i++) {
            
            int num1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0; 
            int num2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            
            if (num1 < num2)
                return -1;
            
            if (num1 > num2)
                return 1;
        }
        
        return 0;
        
    }
}