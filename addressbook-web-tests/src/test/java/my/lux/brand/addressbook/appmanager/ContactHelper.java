package my.lux.brand.addressbook.appmanager;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactHelper extends HelperBase {

   public ContactHelper(WebDriver wd) {
      super(wd);
   }

   public void initContactCreation() {
      click(By.linkText("add new"));
   }

   public void initContactModificationById(int id) {

      wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
   }

   public void openContactInfo(int id) {
      wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']",id))).click();
   }

   public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("nickname"),contactData.getNickname());
      attach(By.name("photo"),contactData.getPhoto());
      type(By.name("address"),contactData.getAddress());
      type(By.name("company"),contactData.getCompany());
      type(By.name("home"),contactData.getHomePhone());
   }

   public void submitContactCreation() {
      click(By.name("submit"));
   }

   public void selectContactById(int id) {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
   }

   public void submitContactModification() {
      click(By.name("update"));
   }

   public void deleteSelectedContact() {
      click(By.cssSelector("input[value='Delete']"));
      acceptAlert();
   }

   public void returnToHomePage() {
      click(By.linkText("home"));
   }

   public void create(ContactData contact) {
      initContactCreation();
      fillContactForm(contact);
      submitContactCreation();
      contactCache = null;
      returnToHomePage();
   }

   public void modify(ContactData contact) {
      selectContactById(contact.getId());
      initContactModificationById(contact.getId());
      fillContactForm(contact);
      submitContactModification();
      contactCache = null;
      returnToHomePage();
   }

   public void delete(ContactData contact) {
      selectContactById(contact.getId());
      deleteSelectedContact();
      contactCache = null;
      returnToHomePage();
   }

   public int count() {
      return wd.findElements(By.name("selected[]")).size();
   }

   private Contacts contactCache = null;

   public Contacts all() {
      if(contactCache != null){
         return new Contacts(contactCache);
      }
      contactCache = new Contacts();
      List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
      for (WebElement element : elements) {
         String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
         int id = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(1) > input")).getAttribute("value"));
         String surname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
         String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
         String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
         String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
         ContactData contact = new ContactData()
                 .withId(id)
                 .withFirstname(name)
                 .withLastname(surname)
                 .withAddress(address)
                 .withAllEmails(allEmails)
                 .withAllPhones(allPhones);

         contactCache.add(contact);
      }
      return new Contacts(contactCache);
   }

   public ContactData infoFromViewForm(ContactData contact) {

      openContactInfo(contact.getId());
      String [] name = wd.findElement(By.cssSelector("#content > b")).getText().split(" ");
      String [] additionalInfo = wd.findElement(By.id("content")).getText().split("\n");
      String homephone = additionalInfo[5].replaceAll("[A-Z,:]", "").replaceAll("^\\s", "");
      String workphone = additionalInfo[6].replaceAll("[A-Z,:]", "").replaceAll("^\\s", "");
      String [] mail = additionalInfo[8].split(" ");
      returnToHomePage();
      return new ContactData()
              .withId(contact.getId())
              .withFirstname(name[0])
              .withMiddlename(name[1])
              .withLastname(name[2])
              .withNickname(additionalInfo[1])
              .withCompany(additionalInfo[2])
              .withAddress(additionalInfo[3])
              .withEmail(mail[0])
              .withHomePhone(homephone)
              .withWorkPhone(workphone);
   }

   public ContactData infoFromEditForm(ContactData contact) {

      initContactModificationById(contact.getId());
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
      String company = wd.findElement(By.name("company")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      String email = wd.findElement(By.name("email")).getAttribute("value");
      String email2 = wd.findElement(By.name("email2")).getAttribute("value");
      String email3 = wd.findElement(By.name("email3")).getAttribute("value");
      String home = wd.findElement(By.name("home")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String work = wd.findElement(By.name("work")).getAttribute("value");
      returnToHomePage();
      return new ContactData()
              .withId(contact.getId())
              .withFirstname(firstname)
              .withMiddlename(middlename)
              .withLastname(lastname)
              .withNickname(nickname)
              .withCompany(company)
              .withAddress(address)
              .withEmail(email)
              .withEmail2(email2)
              .withEmail3(email3)
              .withHomePhone(home)
              .withMobilePhone(mobile)
              .withWorkPhone(work);
   }
}
