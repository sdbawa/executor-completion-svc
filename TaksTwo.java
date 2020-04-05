

import java.util.Date;
import java.util.concurrent.Callable;

/**
 *  This is the slowest Task and it is made to wait for 5 secs.
 * @author simar
 *
 */
public class TaksTwo implements Callable {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		System.out.println("Executed Task 2 With Sleep of 5 sec. Completion Time = " + new Date(System.currentTimeMillis()));
		return new Integer(2);
	}
	
	

}
