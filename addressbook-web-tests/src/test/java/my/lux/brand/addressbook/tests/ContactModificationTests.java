package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by Alex on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

   @Test
   public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("Alex", "J.", "Fisher", "SS", "Pumb avenue 134/98", "MorningStar", "+380887776566", null), false);
      app.getContactHelper().submitContactModification();
      app.getNavigationHelper().gotoHomePage();
      
   }
}
