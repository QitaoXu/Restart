package Interview.PureStorage; 

public class Main {

    public static void main(String args[]) {

        LockUseAnalyzer lockUseAnalyzer = new LockUseAnalyzer(); 
        // String[] rawLogs1 = {"ACQUIRE 364", "ACQUIRE 84", "RELEASE 84", "ACQUIRE 1337", "RELEASE 1337", "RELEASE 364"};
        // String[] rawLogs2 = {"ACQUIRE 364", "ACQUIRE 84", "RELEASE 364", "RELEASE 84"};
        // String[] rawLogs3 = {"ACQUIRE 123", "ACQUIRE 364", "ACQUIRE 84", "RELEASE 84", "RELEASE 364", "ACQUIRE 456"};
        String[] rawLogs4 = {"ACQUIRE 364", "ACQUIRE 84", "ACQUIRE 364", "RELEASE 364"};
        // System.out.println(lockUseAnalyzer.analyze(rawLogs1));
        // System.out.println(lockUseAnalyzer.analyze(rawLogs2));
        System.out.println(lockUseAnalyzer.analyze(rawLogs4));
        //System.out.println("JAVA");
    
    }
}

