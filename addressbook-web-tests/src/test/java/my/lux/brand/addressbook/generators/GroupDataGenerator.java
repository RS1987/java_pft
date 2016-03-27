package my.lux.brand.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import my.lux.brand.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 3/27/2016.
 */
public class GroupDataGenerator {

   @Parameter(names = "-c", description = "Group count")
   public int count;

   @Parameter(names = "-f", description = "Target file")
   public String file;

   public static void main(String [] args) throws IOException {
      GroupDataGenerator generator = new GroupDataGenerator();
      new JCommander(generator, args);
      generator.run();
   }

   private void run() throws IOException {
      List<GroupData> groups = generateGroups(count);
      save(groups, new File(file));
   }

   private void save(List<GroupData> groups, File file) throws IOException {
      Writer writer = new FileWriter(file);
      for (GroupData group : groups){
         writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
      }
      writer.close();
   }

   private List<GroupData> generateGroups(int count) {
      List<GroupData> groups = new ArrayList<GroupData>();
      for (int i = 0; i < count; i++){
         groups.add(new GroupData()
                 .withName(String.format("gName %s", i))
                 .withHeader(String.format("gHeader %s", i))
                 .withFooter(String.format("gFooter %s", i))
         );}
      return groups;
   }
}