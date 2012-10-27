package server;

public class BaseHandlerService {
	public String handle(String operation){
		System.out.println("the method start!");
        return "hello "+operation;
    }
}
