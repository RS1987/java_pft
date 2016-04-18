package my.lux.brand.mantis.model;

/**
 * Created by Alex on 4/18/2016.
 */
public class MailMessage {

   public String to;
   public String text;

   public MailMessage (String to, String text) {
      this.to = to;
      this.text = text;
   }
}
