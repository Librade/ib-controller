package ibcontroller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Tomas Fecko
 */
public class IBTest {

    @Test
    public void test() throws Exception {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String saturday = currentDate.getDisplayName(Calendar.DAY_OF_WEEK , Calendar.LONG, Locale.getDefault());


        System.setProperty("ClosedownAt", saturday + " 23:00");
        System.setProperty("IbDir", "/tmp/tws-" + System.currentTimeMillis());
        IBGatewayController gw = new IBGatewayController();
        gw.main(new String[]{"libResources/IBController.ini", "edemo", "demouser"});
        Thread.sleep(SECONDS.toMillis(30));
    }
}




