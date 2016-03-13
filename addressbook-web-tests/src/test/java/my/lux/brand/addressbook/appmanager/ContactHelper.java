package my.lux.brand.addressbook.appmanager;

import my.lux.brand.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

   public void initContactModification() {
      click(By.cssSelector("img[alt='Edit']"));
   }

   public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("nickname"),contactData.getNickname());
      type(By.name("address"),contactData.getAddress());
      type(By.name("company"),contactData.getCompany());
      type(By.name("home"),contactData.getHomephone());

      if (creation) {
         new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
         Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
   }

   public void submitContactCreation() {
      click(By.name("submit"));
   }

   public void selectContact(int index) {
      wd.findElements(By.name("selected[]")).get(index).click();
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

   public void createContact(ContactData contact) {
      initContactCreation();
      fillContactForm(contact, true);
      submitContactCreation();
      returnToHomePage();
   }

   public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
   }

   public int getContactCount() {
      return wd.findElements(By.name("selected[]")).size();
   }
}
