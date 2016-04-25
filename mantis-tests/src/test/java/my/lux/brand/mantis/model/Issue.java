package my.lux.brand.mantis.model;

/**
 * Created by Alex on 4/19/2016.
 */
public class Issue {

   private int id;
   private String name;
   private String summary;
   private String description;
   private String status;
   private Project project;

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getSummary() {
      return summary;
   }

   public String getDescription() {
      return description;
   }

   public String getStatus() {
      return status;
   }

   public Project getProject() {
      return project;
   }

   public Issue withId(int id) {
      this.id = id;
      return this;
   }

   public Issue withName(String name) {
      this.name = name;
      return  this;
   }

   public Issue withSummary(String summary) {
      this.summary = summary;
      return this;
   }

   public Issue withDescription(String description) {
      this.description = description;
      return  this;
   }

   public Issue withStatus(String status) {
      this.status = status;
      return this;
   }

   public Issue withProject(Project project) {
      this.project = project;
      return this;
   }
}
