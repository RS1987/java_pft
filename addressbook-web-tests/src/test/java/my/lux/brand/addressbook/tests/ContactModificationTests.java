package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions(){
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
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

      Contacts before = app.contact().all();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData()
              .withId(modifiedContact.getId())
              .withFirstname("Alex")
              .withMiddlename("J.")
              .withLastname("Fisher")
              .withNickname("SS")
              .withAddress("Pumb avenue 134/98")
              .withCompany("MorningStar")
              .withHomephone("+380887776566");
      app.contact().modify(contact);
      Contacts after = app.contact().all();
      assertThat(after.size(), equalTo(before.size()));
      assertThat(after, equalTo(before.withModifiedContact(modifiedContact)));
   }
}