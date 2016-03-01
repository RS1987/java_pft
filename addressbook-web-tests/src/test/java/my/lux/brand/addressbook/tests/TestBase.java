package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Alex on 2/29/2016.
 */
public class TestBase {


   protected final ApplicationManager app = new ApplicationManager();

   @BeforeMethod
   public void setUp() throws Exception {
      app.init();
   }

   @AfterMethod
   public void tearDown() {
      app.stop();
   }

}