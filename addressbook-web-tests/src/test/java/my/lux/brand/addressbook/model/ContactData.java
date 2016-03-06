package my.lux.brand.addressbook.model;

public class ContactData {
   private final String firstname;
   private final String middlename;
   private final String lastname;
   private final String nickname;
   private final String address;
   private final String company;
   private final String homephone;
   private String group;

   public ContactData(String firstname, String middlename, String lastname, String nickname, String address, String company, String homephone, String group) {
      this.firstname = firstname;
      this.middlename = middlename;
      this.lastname = lastname;
      this.nickname = nickname;
      this.address = address;
      this.company = company;
      this.homephone = homephone;
      this.group = group;
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
}
