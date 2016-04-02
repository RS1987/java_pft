package my.lux.brand.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;

@XStreamAliasType("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
   @XStreamOmitField
   private int id = Integer.MAX_VALUE;
   @Expose private String firstname;
   @Expose private String middlename;
   @Expose private String lastname;
   @Expose private String nickname;
   @Expose private String address;
   @Expose private String company;
   private String allEmails;
   private String email;
   @Expose private String email2;
   @Expose private String email3;
   private String allPhones;
   @Expose private String homephone;
   @Expose private String mobilephone;
   @Expose private String workphone;
   private String group;
   private File photo;

   public int getId() {
      return id;
   }

   public String getFirstname() {
      return firstname;
   }

   public String getMiddlename() {
      return middlename;
   }

   public String getLastname() {
      return lastname;
   }

   public String getNickname() {
      return nickname;
   }

   public String getAddress() {
      return address;
   }

   public String getCompany() {
      return company;
   }

   public String getAllEmails() {
      return allEmails;
   }

   public String getEmail() {
      return email;
   }

   public String getEmail2() {
      return email2;
   }

   public String getEmail3() {
      return email3;
   }

   public String getAllPhones() {
      return allPhones;
   }

   public String getHomePhone() {
      return homephone;
   }

   public String getMobilePhone() {
      return mobilephone;
   }

   public String getWorkPhone() {
      return workphone;
   }

   public String getGroup() {
      return group;
   }

   public File getPhoto() {
      return photo;
   }

   public ContactData withId(int id) {
      this.id = id;
      return this;
   }

   public ContactData withFirstname(String firstname) {
      this.firstname = firstname;
      return this;
   }

   public ContactData withMiddlename(String middlename) {
      this.middlename = middlename;
      return this;
   }

   public ContactData withLastname(String lastname) {
      this.lastname = lastname;
      return this;
   }

   public ContactData withNickname(String nickname) {
      this.nickname = nickname;
      return this;
   }

   public ContactData withAddress(String address) {
      this.address = address;
      return this;
   }

   public ContactData withCompany(String company) {
      this.company = company;
      return this;
   }

   public ContactData withAllEmails(String allEmails) {
      this.allEmails = allEmails;
      return this;
   }

   public ContactData withEmail(String email) {
      this.email = email;
      return this;
   }

   public ContactData withEmail2(String email2) {
      this.email2 = email2;
      return this;
   }

   public ContactData withEmail3(String email3) {
      this.email3 = email3;
      return this;
   }

   public ContactData withAllPhones(String allPhones) {
      this.allPhones = allPhones;
      return this;
   }

   public ContactData withHomePhone(String homephone) {
      this.homephone = homephone;
      return this;
   }

   public ContactData withMobilePhone(String mobilephone) {
      this.mobilephone = mobilephone;
      return this;
   }

   public ContactData withWorkPhone(String workphone) {
      this.workphone = workphone;
      return this;
   }

   public ContactData withGroup(String group) {
      this.group = group;
      return this;
   }

   public ContactData withPhoto(File photo) {
      this.photo = photo;
      return this;
   }

   @Override
   public String toString() {
      return "ContactData{" +
              "id=" + id +
              ", firstname='" + firstname + '\'' +
              ", middlename='" + middlename + '\'' +
              ", lastname='" + lastname + '\'' +
              ", nickname='" + nickname + '\'' +
              ", address='" + address + '\'' +
              ", company='" + company + '\'' +
              ", email='" + email + '\'' +
              ", email2='" + email2 + '\'' +
              ", email3='" + email3 + '\'' +
              ", homephone='" + homephone + '\'' +
              ", mobilephone='" + mobilephone + '\'' +
              ", workphone='" + workphone + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (id != that.id) return false;
      if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
      if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
      return address != null ? address.equals(that.address) : that.address == null;

   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      return result;
   }
}
