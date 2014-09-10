package org.civmmo.logparser;

import java.time.Duration;
import java.util.function.Consumer;

/**
 *
 * @author Mattysek
 */
public class DurationAverager implements Consumer<Duration>{
    
    private Duration total = Duration.ZERO;
    private long count = 0;
        
    public Duration average() {
        return count > 0 ? total.dividedBy(count) : Duration.ZERO;
    }
    
    public Duration total() {
        return total;
    }
        
    public void accept(Duration duration) {
        total = total.plus(duration); 
        count++; 
    }
    
    public void combine(DurationAverager other) {
        total.plus(other.total);
        count += other.count;
    }
}
