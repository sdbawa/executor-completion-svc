

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * This is the fastest Task.
 * @author simar
 *
 */
public class TaksOne implements Callable {

	@Override
	public Integer call() throws Exception {
		System.out.println("Executed Task 1. Completion Time =  " + new Date(System.currentTimeMillis()));
		return new Integer(1);
	}	

}
