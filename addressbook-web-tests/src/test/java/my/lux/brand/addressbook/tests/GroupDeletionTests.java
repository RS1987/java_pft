package my.lux.brand.addressbook.tests;

import my.lux.brand.addressbook.model.GroupData;
import my.lux.brand.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("newGroup")
                    .withHeader("newHeader")
                    .withFooter("newFooter"));
        }
    }

    @Test
    public void testGroupDeletion() {

        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletedGroup)));
    }
}