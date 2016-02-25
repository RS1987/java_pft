package my.lux.brand.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Alex on 2/25/2016.
 */
public class CalculateDistance {

   public static void main(String[] args){

      Point d = new Point(4.457,6.324,25.784,45.097);

      System.out.println("Расстояние между точками p1(" + d.x1 + "," + d.y1 + ") и p2(" + d.x2 + "," + d.y2 + ") = " + d.distance());

   }
}