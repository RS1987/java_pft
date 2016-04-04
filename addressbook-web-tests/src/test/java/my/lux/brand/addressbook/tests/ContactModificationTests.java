package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions(){

      if (app.db().contacts().size() == 0) {
         app.goTo().homePage();
         app.contact().create(new ContactData()
                 .withFirstname("A")
                 .withMiddlename("J")
                 .withLastname("Fisher")
                 .withNickname("Scout")
                 .withAddress("P avenue 134/98")
                 .withCompany("MorningStar")
                 .withHomePhone("+380887776566")
         );}
   }

   @Test
   public void testContactModification() {

      Contacts before = app.db().contacts();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData()
              .withId(modifiedContact.getId())
              .withFirstname("Alex")
              .withMiddlename("J.")
              .withLastname("Fisher")
              .withNickname("SS")
              .withAddress("Pumb avenue 134/98")
              .withCompany("MorningStar")
              .withHomePhone("+380887776566");
      app.goTo().homePage();
      app.contact().modify(contact);
      assertThat(app.contact().count(), equalTo(before.size()));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.withModifiedContact(modifiedContact)));
   }
}