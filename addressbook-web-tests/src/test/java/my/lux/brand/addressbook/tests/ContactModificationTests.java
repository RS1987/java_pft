package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Alex on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions(){
      app.goTo().homePage();
      if (app.contact().list().size() == 0) {
         app.contact().create(new ContactData("A", "J", "Fisher", "Scout", "P avenue 134/98", "MorningStar", "+380887776566", "newGroup"));
      }
   }

   @Test
   public void testContactModification() {

      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      ContactData contact = new ContactData(before.get(index).getId(), "Alex", "J.", "Fisher", "SS", "Pumb avenue 134/98", "MorningStar", "+380887776566", null);
      app.contact().modify(index, contact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before,after);
   }
}