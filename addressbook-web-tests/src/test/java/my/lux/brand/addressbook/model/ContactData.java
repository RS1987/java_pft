package my.lux.brand.addressbook.model;

public class ContactData {
   private final String id;
   private final String firstname;
   private final String middlename;
   private final String lastname;
   private final String nickname;
   private final String address;
   private final String company;
   private final String homephone;
   private String group;

   public ContactData(String firstname, String middlename, String lastname, String nickname, String address, String company, String homephone, String group) {
      this.id = null;
      this.firstname = firstname;
      this.middlename = middlename;
      this.lastname = lastname;
      this.nickname = nickname;
      this.address = address;
      this.company = company;
      this.homephone = homephone;
      this.group = group;
   }

   public ContactData(String id, String firstname, String middlename, String lastname, String nickname, String address, String company, String homephone, String group) {
      this.id = id;
      this.firstname = firstname;
      this.middlename = middlename;
      this.lastname = lastname;
      this.nickname = nickname;
      this.address = address;
      this.company = company;
      this.homephone = homephone;
      this.group = group;
   }

   public String getId() {
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

   public String getHomephone() {
      return homephone;
   }

   public String getGroup() {
      return group;
   }

   @Override
   public String toString() {
      return "ContactData{" +
              "id='" + id + '\'' +
              ", firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              ", address='" + address + '\'' +
              ", homephone='" + homephone + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (id != null ? !id.equals(that.id) : that.id != null) return false;
      if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
      if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
      if (address != null ? !address.equals(that.address) : that.address != null) return false;
      return homephone != null ? homephone.equals(that.homephone) : that.homephone == null;

   }

   @Override
   public int hashCode() {
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
      return result;
   }
}
