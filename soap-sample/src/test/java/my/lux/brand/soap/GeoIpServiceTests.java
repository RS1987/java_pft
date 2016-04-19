package my.lux.brand.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alex on 4/19/2016.
 */
public class GeoIpServiceTests {

   @Test
   public void testMyIp() {
      GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("46.98.9.191");
      assertEquals(geoIP.getCountryCode(), "UKR");
   }

   @Test
   public void testInvalidIp() {
      GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("46.98.9.xxx");
      assertEquals(geoIP.getReturnCodeDetails(), "Invalid IP address");
   }
}
