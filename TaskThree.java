import java.util.Date;
import java.util.concurrent.Callable;


/**
 * This is second fastest Task and it is made to wait for 3 secs.
 * @author simar
 *
 */
public class TaskThree implements Callable {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		System.out.println("Executed Task 3. Completion Time =  " + new Date(System.currentTimeMillis()));
		return new Integer(3);
	}

}
