package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/22/2016.
 */
public class ContactEmailTests extends TestBase{

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
                 .withEmail2("buggi@wuggi")
                 .withHomePhone("+380887776566")
                 .withGroup("newGroup"));
      }
   }

   @Test
   public void testContactEmails(){

      app.goTo().homePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
   }

   private String mergeEmails(ContactData contact) {

      return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
              .stream().filter((e) -> ! e.equals(""))
              .map(ContactEmailTests::cleaned)
              .collect(Collectors.joining("\n"));
   }

   public static String cleaned(String email){

      return  email.replaceAll("\\s", "").replaceAll("[-#%&()]","");
   }
}
