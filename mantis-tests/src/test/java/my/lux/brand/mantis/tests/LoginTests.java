package my.lux.brand.mantis.tests;

import my.lux.brand.mantis.appmanager.HttpSession;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by Alex on 4/12/2016.
 */
public class LoginTests extends TestBase {

   @Test
   public void testLogin() throws IOException {

      HttpSession session = app.newSession();
      assertTrue(session.login("administrator", "root"));
      assertTrue(session.isLoggedInAs("administrator"));

   }
}
