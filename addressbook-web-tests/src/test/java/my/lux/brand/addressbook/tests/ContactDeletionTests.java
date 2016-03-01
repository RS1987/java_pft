package my.lux.brand.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactDeletionTests extends TestBase{

   @Test
   public void testContactDeletion() {

      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteSelectedContact();
      app.getNavigationHelper().gotoHomePage();
   }

}