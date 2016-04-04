package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactDeletionTests extends TestBase{

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
   public void testContactDeletion() {

      Contacts before = app.db().contacts();
      ContactData deletedContact = before.iterator().next();
      app.goTo().homePage();
      app.contact().delete(deletedContact);
      assertThat(app.contact().count(), equalTo(before.size() - 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.withoutNewContact(deletedContact)));
   }
}