package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTest() {

        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("A")
                .withMiddlename("J")
                .withLastname("Fisher")
                .withNickname("Scout")
                .withAddress("P avenue 134/98")
                .withCompany("MorningStar")
                .withHomephone("+380887776566")
                .withGroup("newGroup");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }
}