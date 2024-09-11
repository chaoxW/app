package base;

import org.testng.annotations.Test;
import utils.services.AppiumService;


public class StopServer {


    @Test
    public void stopServerTest() {
        AppiumService.stop();
    }

}
