/**
 * Created by tahirou on 17/11/2016.
 */
public class GreetingControllerImpl implements GreetingController {

    public String sayHello(final String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }
}
