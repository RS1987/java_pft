package my.lux.brand.mantis.tests;

import my.lux.brand.mantis.model.MailMessage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Alex on 4/18/2016.
 */
public class ResetPasswordTests extends TestBase {

   @BeforeMethod
   public void startMailServer() {
      app.mail().start();
   }

   @Test
   public void testResettingPassword() throws IOException, MessagingException {

      String user = "scout";
      String password = "password";
      String email = "scout7@mail.ru";
      app.reset().goToManageUsersPage(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
      app.reset().initResettingPassword(2);

      List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
      String confirmationLink = findConfirmationLink(mailMessages, email);
      app.reset().finishReset(confirmationLink, password);

      assertTrue(app.newSession().login(user, password));

   }

   private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
      MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      return regex.getText(mailMessage.text);
   }

   @AfterMethod(alwaysRun = true)
   public void stopMailServer() {
      app.mail().stop();
   }
}
