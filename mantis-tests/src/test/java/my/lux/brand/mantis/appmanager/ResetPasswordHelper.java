package my.lux.brand.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Alex on 4/18/2016.
 */
public class ResetPasswordHelper extends HelperBase {

   public ResetPasswordHelper(ApplicationManager app) {
      super(app);
   }

   public void goToManageUsersPage(String username, String password) {

      wd.get(app.getProperty("web.baseUrl") + "manage_user_page.php");
      type(By.name("username"), username);
      type(By.name("password"), password);
   }

   public void initResettingPassword(int id) {

      click(By.cssSelector("a[innerText='scout']"));
      click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']",id)));
      click(By.cssSelector("input[value='Reset Password']"));

   }

   public void finishReset(String confirmationLink, String password) {
      wd.get(confirmationLink);
      type(By.name("password"), password);
      type(By.name("password_confirm"), password);
      click(By.cssSelector("input[value='Update User']"));
   }
}
