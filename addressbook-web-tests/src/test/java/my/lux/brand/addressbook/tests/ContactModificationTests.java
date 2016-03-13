package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Alex on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

   @Test
   public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("A", "J", "Fisher", "Scout", "P avenue 134/98", "MorningStar", "+380887776566", "newGroup"));
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("Alex", "J.", "Fisher", "SS", "Pumb avenue 134/98", "MorningStar", "+380887776566", null), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());
      
   }
}
