package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Alex on 3/2/2016.
 */
public class GroupModificationTests extends TestBase {

   @Test
   public  void testGroupModification() {

      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("newGroup", "newHeader", "newFooter"));
      app.getGroupHelper().submitGroupModification();
      app.getNavigationHelper().gotoGroupPage();

   }
}
