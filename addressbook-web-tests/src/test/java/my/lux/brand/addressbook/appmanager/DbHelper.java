package my.lux.brand.addressbook.appmanager;

import my.lux.brand.addressbook.model.ContactData;
import my.lux.brand.addressbook.model.Contacts;
import my.lux.brand.addressbook.model.GroupData;
import my.lux.brand.addressbook.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Alex on 4/4/2016.
 */
public class DbHelper {

   private final SessionFactory sessionFactory;

   public DbHelper(){
      // A SessionFactory is set up once for an application!
      final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
              .configure() // configures settings from hibernate.cfg.xml
              .build();
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
   }

   public Groups groups(){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      List<GroupData> result = session.createQuery( "from GroupData" ).list();
      session.getTransaction().commit();
      session.close();
      return new Groups(result);
   }

   public Contacts contacts(){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      List<ContactData> result = session.createQuery( "from ContactData" ).list();
      session.getTransaction().commit();
      session.close();
      return new Contacts(result);
   }
}
