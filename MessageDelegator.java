
import java.util.Date;

public class MessageDelegator {
	
	public void delegate(int num){
		System.out.println("Message received at delegator " + num + " time " + new Date(System.currentTimeMillis()));
	}

}
