package SystemDesign.RateLimiter.TokenBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i=0;i<12;i++){
            executors.execute(() -> userBucketCreator.accessApplication(1));
            TimeUnit.SECONDS.sleep(1);

        }
        executors.shutdown();
        userBucketCreator.showCurrentToken(1);
    }
}
