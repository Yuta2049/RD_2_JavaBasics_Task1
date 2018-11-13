import demoService.DemoService;
import demoService.IDemoService;

public class Starter {

    public static void main(String[] args) {
        IDemoService demoService = new DemoService();
        demoService.showDemo();
    }
}
