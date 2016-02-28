package my.lux.brand.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Alex on 2/28/2016.
 */
public class PointDistanceTests {

   @Test
   public void testDistance(){
      Point d = new Point(4.457,6.324,25.784,45.097);
      Assert.assertEquals(d.distance(), 44.251400633200305);
   }
}
