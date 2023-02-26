package SystemDesign.RateLimiter.TokenBucket;

import java.util.HashMap;
import java.util.Map;

/**
 * 每秒加10个，token最多为10的令牌桶
 *
 */
public class UserBucketCreator {
    Map<Integer, TokenBucket> bucket;

    public UserBucketCreator(int id) {
        bucket = new HashMap<>();
        bucket.put(id, new TokenBucket(10, 10));
    }

    void showCurrentToken(int id){
       int nowTokens =  bucket.get(id).getNowTokens();
        System.out.println("nowTokens: " + nowTokens);
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
