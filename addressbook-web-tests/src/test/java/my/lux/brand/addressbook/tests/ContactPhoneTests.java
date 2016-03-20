package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/20/2016.
 */
public class ContactPhoneTests extends TestBase {

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
                 .withHomePhone("+380887776566")
                 .withGroup("newGroup"));
      }
   }

   @Test
   public void testContactPhones(){

      app.goTo().homePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
      assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
      assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
   }

   public  String cleaned(String phone){

      return  phone.replaceAll("\\s", "").replaceAll("[-()]","");
   }
}
