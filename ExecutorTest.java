import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Test;


public class ExecutorTest {

	Executor exec = new Executor();
	
	@Test
	public void whenThreeTasksSubmittedAndOneTakesLonger_ThenProcessWaitsUntillAllReturns() {
		Integer result = exec.execute();
		System.out.println(" --> received  result=  : " + result + " at " + new Date(System.currentTimeMillis()));
		assertEquals(6, result.intValue());
	}

}
