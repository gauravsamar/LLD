import java.util.concurrent.locks.ReentrantLock;

interface RateLimiter 
{
    boolean canProcessRequest();   
}
class SlidingWindowRateLimiter implements RateLimiter
{
    private final int capacity;
    private final long windowSize;
    private int previousCount;
    private int currentCount;
    private long windowStart;
    private final ReentrantLock lock = new ReentrantLock();
    public SlidingWindowRateLimiter(int capacity,long window)
    {
        this.capacity = capacity;
        this.currentCount = 0;
        this.previousCount = 0;
        this.windowSize = window;
        this.windowStart = System.currentTimeMillis();
    }
    private void rotateWindow()
    {
        long now = System.currentTimeMillis();
        long elapsedTime = now - windowStart;
        if(elapsedTime>=windowSize)
        {
            previousCount = currentCount;
            currentCount = 0;
            windowStart = now;
        }
    }
    @Override
    public boolean canProcessRequest()
    {
        lock.lock();
        try
        {
            rotateWindow(); // check position as new request arises
            long now = System.currentTimeMillis();
            double elapsedRatio = (double) (now-windowStart)/windowSize;
            double effectiveCount = currentCount + (1-elapsedRatio)*previousCount;
            if(effectiveCount<capacity)
            {
                currentCount++;
                return true;
            }
            else
            return false;
        }
        finally
        {
            lock.unlock();
        }
    }
}
public class RateLimiterDemo 
{   
    public static void main(String[] args) throws InterruptedException
    {   
        RateLimiter limiter = new SlidingWindowRateLimiter(2,1000);
        for(int i=0;i<50;i++)
        {
            System.out.println("Try to acquire request " + i + ": "+limiter.canProcessRequest());
            Thread.sleep(400);
        }
    }
}
