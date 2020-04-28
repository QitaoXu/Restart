package Interview.PureStorage;

import java.util.*;

class Log {

    String operation;
    int timestamp; 
    int index; 

    public Log(String rawLog, int index) {
        int indexOfWhiteSpace = rawLog.indexOf(" ");
        this.operation = rawLog.substring(0, indexOfWhiteSpace);
        this.timestamp = Integer.parseInt(rawLog.substring(indexOfWhiteSpace + 1, rawLog.length()));
        this.index = index;
    }
}

public class LockUseAnalyzer {

    Stack<Integer> stack;
    Set<Integer> set; 

    public LockUseAnalyzer () {
        this.stack = new Stack<Integer>();
        this.set = new HashSet<Integer>();
    }

    public int analyze (String[] rawLogs) {

        List<Log> logs = new ArrayList<Log>();

        for (int index = 0; index < rawLogs.length; index++) {
            Log log = new Log(rawLogs[index], index + 1);
            logs.add(log);
        }

        for (Log log : logs) {

            if (log.operation.equals("ACQUIRE")) {

                if (set.contains(log.timestamp)) {
                    System.out.println("Not allowed to accuire a hold lock");
                    return log.index;

                }

                stack.push(log.timestamp);
                set.add(log.timestamp);
            }

            if (log.operation.equals("RELEASE")) {

                if (!set.contains(log.timestamp))
                    return log.index;

                if (stack.peek() != log.timestamp)
                    return log.index;

                stack.pop();
                set.remove(log.timestamp);
            }

        }

        return stack.size() == 0 && set.size() == 0 ? 0 : logs.size() + 1;
    }
}