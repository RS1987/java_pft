package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactDeletionTests extends TestBase{

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
   public void testContactDeletion() {

      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      assertThat(app.group().count(), equalTo(before.size() - 1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(before.withoutNewContact(deletedContact)));
   }
}