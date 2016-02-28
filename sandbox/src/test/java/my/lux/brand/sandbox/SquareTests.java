package my.lux.brand.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alex on 2/28/2016.
 */
public class SquareTests {

   @Test
   public void testArea(){

      Square s = new Square(7);
      Assert.assertEquals(s.area(), 49.0);
   }
}
