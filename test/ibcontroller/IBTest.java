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
        // IB controller properties
        System.setProperty("LogToConsole", "yes");
        System.setProperty("FIX", "no");
        System.setProperty("IbLoginId", "edemo");
        System.setProperty("IbPassword", "demouser");
        System.setProperty("PasswordEncrypted", "no");
        System.setProperty("FIXLoginId", "");
        System.setProperty("FIXPassword", "");
        System.setProperty("FIXPasswordEncrypted", "yes");
        System.setProperty("StoreSettingsOnServer", "no");
        System.setProperty("MinimizeMainWindow", "yes");
        System.setProperty("ExistingSessionDetectedAction", "primary");
        System.setProperty("AcceptIncomingConnectionAction", "reject");
        System.setProperty("ShowAllTrades", "no");
        System.setProperty("ForceTwsApiPort", "");
        System.setProperty("IbAutoClosedown", "no");
        System.setProperty("AllowBlindTrading", "yes");
        System.setProperty("DismissPasswordExpiryWarning", "yes");
        System.setProperty("DismissNSEComplianceNotice", "yes");
        System.setProperty("SaveTwsSettingsAt", "");
        System.setProperty("IbControllerPort", "7462");
        System.setProperty("IbControlFrom", "");
        System.setProperty("IbBindAddress", "");
        System.setProperty("CommandPrompt", "");
        System.setProperty("SuppressInfoMessages", "yes");
        // close at saturday
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String saturday = currentDate.getDisplayName(Calendar.DAY_OF_WEEK , Calendar.LONG, Locale.getDefault());
        System.setProperty("ClosedownAt", saturday + " 23:00");
        System.setProperty("IbDir", "/tmp/tws-" + System.currentTimeMillis());


        IBGatewayController gw = new IBGatewayController();
        gw.main(new String[]{"", "edemo", "demouser"});
        Thread.sleep(SECONDS.toMillis(30));
    }
}




