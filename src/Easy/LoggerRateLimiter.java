package Easy;

import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String,Integer> hm;
    public LoggerRateLimiter() {
        hm = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!hm.containsKey(message)){
            hm.put(message,timestamp+9);
            return true;
        } else{
            if(hm.get(message) >= timestamp){
                return false;
            } else{
                hm.put(message,timestamp+9);
                return true;
            }
        }
    }
}
