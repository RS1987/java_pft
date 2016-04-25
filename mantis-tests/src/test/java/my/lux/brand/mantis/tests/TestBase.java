package my.lux.brand.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import my.lux.brand.mantis.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Created by Alex on 2/29/2016.
 */
public class TestBase {

   protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

   @BeforeSuite
   public void setUp() throws Exception {
      app.init();
      //app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
   }

   @BeforeTest
   public boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {

      MantisConnectPortType mcp = new MantisConnectLocator().getMantisConnectPort(new URL(app.getProperty("web.mantisConnectUrl")));
      return mcp.mc_issue_checkin("administrator", "root", BigInteger.valueOf(issueId), "Checkin issue opening", true);


   }

   public void skipIfNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException {
      if (isIssueOpen(issueId) == true) {
         throw new SkipException("Ignored because of issue " + issueId);
      }
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown() throws IOException {
      //app.ftp().restore("config_inc.php.bak", "config_inc.php");
      app.stop();
   }

}
