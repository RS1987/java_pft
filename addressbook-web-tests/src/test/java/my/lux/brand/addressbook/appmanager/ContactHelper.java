package my.lux.brand.addressbook.appmanager;

import my.lux.brand.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alex on 3/1/2016.
 */
public class ContactHelper extends HelperBase {

   public ContactHelper(FirefoxDriver wd) {
      super(wd);
   }

   public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
   }

   public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("nickname"),contactData.getNickname());
      type(By.name("address"),contactData.getAddress());
      type(By.name("company"),contactData.getCompany());
      type(By.name("home"),contactData.getHomephone());
   }

   public void deleteSelectedContact() {
      click(By.cssSelector("input[value='Delete']"));
      acceptAlert();
   }

   public void selectContact() {
      click(By.name("selected[]"));
   }

   public void initContactModification() {
      click(By.cssSelector("a[href='edit.php?id=6']"));
   }

   public void submitContactModification() {
      click(By.name("update"));
   }
}
