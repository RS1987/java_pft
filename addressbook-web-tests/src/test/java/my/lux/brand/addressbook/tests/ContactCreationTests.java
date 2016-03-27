package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTest() {

        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/Penguine.jpg");
        ContactData contact = new ContactData()
                .withFirstname("A")
                .withMiddlename("J")
                .withLastname("Fisher")
                .withNickname("Scout")
                .withPhoto(photo)
                .withAddress("P avenue 134/98")
                .withCompany("MorningStar")
                .withHomePhone("+380887776566")
                .withGroup("newGroup");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withNewContact(
                contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}