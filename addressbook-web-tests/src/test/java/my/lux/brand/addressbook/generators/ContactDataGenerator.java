package my.lux.brand.addressbook.generators;

import my.lux.brand.addressbook.model.ContactData;
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
public class ContactDataGenerator {
   public static void main(String [] args) throws IOException {
      int count = Integer.parseInt(args[0]);
      File file = new File(args[1]);

      List<ContactData> contacts = generateContacts(count);
      save(contacts, file);
   }

   private static void save(List<ContactData> contacts, File file) throws IOException {
      System.out.println(new File(".").getAbsolutePath());
      Writer writer = new FileWriter(file);
      for (ContactData contact : contacts){
         writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n",
                 contact.getFirstname(),
                 contact.getMiddlename(),
                 contact.getLastname(),
                 contact.getNickname(),
                 contact.getCompany(),
                 contact.getAddress(),
                 contact.getHomePhone()
         ));}
      writer.close();
   }

   private static List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<ContactData>();
      for (int i = 0; i < count; i++){
         contacts.add(new ContactData()
                 .withFirstname((String.format("Alex %s", i)))
                 .withMiddlename((String.format("J. %s", i)))
                 .withLastname((String.format("Fisher %s", i)))
                 .withNickname((String.format("Scout %s", i)))
                 .withCompany((String.format("MorningStar %s", i)))
                 .withAddress((String.format("P avenue 134/98 %s", i)))
                 .withHomePhone((String.format("+380887776566 %s", i)))
         );}
      return contacts;
   }
}
