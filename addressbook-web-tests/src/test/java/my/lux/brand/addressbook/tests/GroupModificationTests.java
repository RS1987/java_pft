package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup(before.size() - 1);
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("newGroup", "newHeader", "newFooter"));
      app.getGroupHelper().submitGroupModification();
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

   }
}
