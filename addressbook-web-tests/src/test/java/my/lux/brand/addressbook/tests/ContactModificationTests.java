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
   public void testContactModification() {

      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      ContactData contact = new ContactData()
              .withId(before.get(index).getId())
              .withFirstname("Alex")
              .withMiddlename("J.")
              .withLastname("Fisher")
              .withNickname("SS")
              .withAddress("Pumb avenue 134/98")
              .withCompany("MorningStar")
              .withHomephone("+380887776566");
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