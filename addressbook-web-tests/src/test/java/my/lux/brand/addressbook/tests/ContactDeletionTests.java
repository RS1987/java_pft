package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactDeletionTests extends TestBase{

   @BeforeMethod
   public void ensurePreconditions(){
      app.goTo().homePage();
      if (app.contact().list().size() == 0) {
         app.contact().create(new ContactData()
                 .withFirstname("A")
                 .withMiddlename("J")
                 .withLastname("Fisher")
                 .withNickname("Scout")
                 .withAddress("P avenue 134/98")
                 .withCompany("MorningStar")
                 .withHomephone("+380887776566")
                 .withGroup("newGroup"));
      }
   }

   @Test
   public void testContactDeletion() {

      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      app.contact().delete(index);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(index);
      Assert.assertEquals(before, after);
   }
}