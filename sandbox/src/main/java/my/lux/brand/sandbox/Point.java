package my.lux.brand.sandbox;

/**
 * Created by Alex on 2/25/2016.
 */
public class Point {

   double x1;
   double y1;
   double x2;
   double y2;

   public Point(double x1, double y1, double x2, double y2){
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
   }

   public double distance(){

      double p1 = Math.pow(this.x2 - this.x1, 2);
      double p2 = Math.pow(this.y2 - this.y1, 2);

      return Math.sqrt(p1 + p2);
   }
}
