package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alex on 3/2/2016.
 */
public class GroupModificationTests extends TestBase {

   @Test
   public  void testGroupModification() {

      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
         app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      }
      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("newGroup", "newHeader", "newFooter"));
      app.getGroupHelper().submitGroupModification();
      app.getNavigationHelper().gotoGroupPage();
      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after, before);

   }
}
