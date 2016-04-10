package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.appmanager.ApplicationManager;
import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import my.lux.brand.addressbook.model.GroupData;
import my.lux.brand.addressbook.model.Groups;
import org.apache.bcel.classfile.Method;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Alex on 2/29/2016.
 */
public class TestBase {

   Logger logger = LoggerFactory.getLogger(TestBase.class);

   protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

   @BeforeSuite
   public void setUp() throws Exception {
      app.init();
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown() {
      app.stop();
   }

  /* @BeforeMethod
   public void logTestStart(Method m, Object[] p) {
      logger.info("Start test " + m.getName() + "with parameters " + Arrays.asList(p));
   }

   @AfterMethod(alwaysRun = true)
   public void logTestFinish(Method m) {
      logger.info("Finish test " + m.getName());
   }*/

   public void verifyGroupListInUI() {

      if(Boolean.getBoolean("verifyUI")){
         Groups dbGroups = app.db().groups();
         Groups uiGroups = app.group().all();
         assertThat(uiGroups, equalTo(dbGroups.stream()
                 .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
                 .collect(Collectors.toSet())));
      }
   }

   public void verifyContactListInUI() {

      if(Boolean.getBoolean("verifyUI")){
         Contacts dbContacts = app.db().contacts();
         Contacts uiContacts = app.contact().all();
         assertThat(uiContacts, equalTo(dbContacts.stream().map((c) -> new ContactData()
                 .withId(c.getId())
                 .withFirstname(c.getFirstname())
                 .withLastname(c.getLastname())
                 .withAddress(c.getAddress())
                 .withHomePhone(c.getHomePhone()))
                 .collect(Collectors.toSet())));
      }
   }
}
