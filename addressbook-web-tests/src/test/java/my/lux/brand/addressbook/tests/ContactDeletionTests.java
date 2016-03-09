package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
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
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteSelectedContact();
      app.getContactHelper().returnToHomePage();
   }

}