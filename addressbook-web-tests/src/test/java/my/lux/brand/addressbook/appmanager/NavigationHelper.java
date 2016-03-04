package my.lux.brand.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alex on 3/1/2016.
 */
public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoGroupPage() {
      click(By.linkText("groups"));
   }

   public void gotoContactPage() {
      click(By.linkText("add new"));
   }

   public void gotoHomePage() {
      click(By.linkText("home"));
   }
}
