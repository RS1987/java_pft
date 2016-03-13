package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactDeletionTests extends TestBase{

   @Test
   public void testContactDeletion() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("A", "J", "Fisher", "Scout", "P avenue 134/98", "MorningStar", "+380887776566", "newGroup"));
      }
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().selectContact(before - 1);
      app.getContactHelper().deleteSelectedContact();
      app.getContactHelper().returnToHomePage();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before - 1);
   }

}