package my.lux.brand.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 3/20/2016.
 */
public class Contacts extends ForwardingSet<ContactData> {

   private Set<ContactData> delegate;

   public Contacts(Contacts contacts) {
      this.delegate = new HashSet<ContactData>(contacts.delegate());
   }

   public Contacts() {
      this.delegate = new HashSet<ContactData>();
   }

   public Contacts(Collection<ContactData> contacts) {
      this.delegate = new HashSet<ContactData>(contacts);
   }

   public Contacts withNewContact(ContactData contact){

      Contacts contacts = new Contacts(this);
      contacts.add(contact);
      return contacts;
   }

   public Contacts withoutNewContact(ContactData contact){

      Contacts contacts = new Contacts(this);
      contacts.remove(contact);
      return contacts;
   }

   public Contacts withModifiedContact (ContactData contact){

      Contacts contacts = new Contacts(this);
      contacts.remove(contact);
      contacts.add(contact);
      return contacts;
   }

   @Override
   protected Set delegate() {
      return delegate;
   }
}
