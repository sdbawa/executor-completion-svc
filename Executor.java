import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Executor which submits three tasks and waits for all of 3 tasks to complete.
 * During execution it keep polling CompletionService to get results of finsihed Tasks
 * and send those results over to the MessageDelegate.
 * 
 * @author simar
 *
 */
public class Executor {

	MessageDelegator delegator = new MessageDelegator();

	public Integer execute() {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		CompletionService<Integer> executorCompletionService= new ExecutorCompletionService<>(executorService);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

		List<Callable> callables = new ArrayList<>();
		callables.add(new TaksOne());
		callables.add(new TaksTwo());
		callables.add(new TaskThree());

		callables.forEach(k -> futures.add(executorCompletionService.submit(k)));
		System.out.println("Started Executor at : " + new Date(System.currentTimeMillis()));
		
		Integer aggregatedResult = 0;

		for (int i = 0; i < futures.size(); i++) {
			try {
				//take() before get() makes all the difference 
				int response = executorCompletionService.take().get();
				delegator.delegate(response);
				aggregatedResult += response;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();		
			}
		}

		System.out.println("Executor ended at time  : " + new Date(System.currentTimeMillis()));
		System.out.println("Executor returning aggregatedResult=  : " + aggregatedResult);
		return aggregatedResult;
	}
}
