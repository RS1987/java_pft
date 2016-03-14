package my.lux.brand.addressbook.model;

public class ContactData {
   private int id;
   private final String firstname;
   private final String middlename;
   private final String lastname;
   private final String nickname;
   private final String address;
   private final String company;
   private final String homephone;
   private String group;

   public ContactData(String firstname, String middlename, String lastname, String nickname, String address, String company, String homephone, String group) {
      this.id = Integer.MAX_VALUE;
      this.firstname = firstname;
      this.middlename = middlename;
      this.lastname = lastname;
      this.nickname = nickname;
      this.address = address;
      this.company = company;
      this.homephone = homephone;
      this.group = group;
   }

   public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String address, String company, String homephone, String group) {
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

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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
              "firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
      return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

   }

   @Override
   public int hashCode() {
      int result = firstname != null ? firstname.hashCode() : 0;
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      return result;
   }
}
