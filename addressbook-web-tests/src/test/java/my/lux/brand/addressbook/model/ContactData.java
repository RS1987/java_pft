package my.lux.brand.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAliasType("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
   @XStreamOmitField
   @Id
   @Column(name = "id")
   private int id = Integer.MAX_VALUE;

   @Expose
   @Column(name = "firstname")
   private String firstname;

   @Expose
   @Column(name = "middlename")
   private String middlename;

   @Expose
   @Column(name = "lastname")
   private String lastname;

   @Expose
   @Column(name = "nickname")
   private String nickname;

   @Expose
   @Column(name = "address")
   @Type(type = "text")
   private String address;

   @Expose
   @Column(name = "company")
   private String company;

   @Expose
   @Column(name = "email")
   @Type(type = "text")
   private String email;

   @Expose
   @Column(name = "email2")
   @Type(type = "text")
   private String email2;

   @Expose
   @Column(name = "email3")
   @Type(type = "text")
   private String email3;

   @Expose
   @Column(name = "home")
   @Type(type = "text")
   private String homephone;

   @Expose
   @Column(name = "mobile")
   @Type(type = "text")
   private String mobilephone;

   @Expose
   @Column(name = "work")
   @Type(type = "text")
   private String workphone;

   @Transient
   private String group;

   @Transient
   private String allPhones;

   @Transient
   private String allEmails;

   @Expose
   @Column(name = "photo")
   @Type(type = "text")
   private String photo;

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
      return new File(photo);
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
      this.photo = photo.getPath();
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
      if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
      if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
      if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
      if (address != null ? !address.equals(that.address) : that.address != null) return false;
      if (company != null ? !company.equals(that.company) : that.company != null) return false;
      if (email != null ? !email.equals(that.email) : that.email != null) return false;
      if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
      if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
      if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
      if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
      if (workphone != null ? !workphone.equals(that.workphone) : that.workphone != null) return false;
      return photo != null ? photo.equals(that.photo) : that.photo == null;

   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
      result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      result = 31 * result + (company != null ? company.hashCode() : 0);
      result = 31 * result + (email != null ? email.hashCode() : 0);
      result = 31 * result + (email2 != null ? email2.hashCode() : 0);
      result = 31 * result + (email3 != null ? email3.hashCode() : 0);
      result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
      result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
      result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
      result = 31 * result + (photo != null ? photo.hashCode() : 0);
      return result;
   }
}
