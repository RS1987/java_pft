package my.lux.brand.addressbook.model;

public class ContactData {
   private int id = Integer.MAX_VALUE;
   private String firstname;
   private String middlename;
   private String lastname;
   private String nickname;
   private String address;
   private String company;
   private String allEmails;
   private String email;
   private String email2;
   private String email3;
   private String allPhones;
   private String homephone;
   private String mobilephone;
   private String workphone;
   private String group;

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
              ", homephone='" + homephone + '\'' +
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
      if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
      return workphone != null ? workphone.equals(that.workphone) : that.workphone == null;

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
      result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
      result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
      return result;
   }
}
