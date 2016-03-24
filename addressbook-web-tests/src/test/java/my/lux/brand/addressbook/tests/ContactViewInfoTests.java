package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/22/2016.
 */
public class ContactViewInfoTests extends TestBase {

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
                 .withEmail("buggi@wuggi")
                 .withHomePhone("+380887776566")
                 .withWorkPhone("77 77 77")
         );}
   }

   @Test
   public void testContactEmails(){

      app.goTo().homePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);

      assertThat(contactInfoFromEditForm, equalTo(contactInfoFromViewForm));
   }

}
