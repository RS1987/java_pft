package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.GroupData;
import my.lux.brand.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alex on 3/2/2016.
 */
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      if (app.db().groups().size() == 0) {
         app.goTo().groupPage();
         app.group().create(new GroupData()
                 .withName("group1")
                 .withHeader("header1")
                 .withFooter("footer1")
         );
      }
   }

   @Test
   public  void testGroupModification() {

      Groups before = app.db().groups();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
              .withId(modifiedGroup.getId())
              .withName("modifiedGroup")
              .withHeader("modifiedHeader")
              .withFooter("modifiedFooter");
      app.goTo().groupPage();
      app.group().modify(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
   }
}
