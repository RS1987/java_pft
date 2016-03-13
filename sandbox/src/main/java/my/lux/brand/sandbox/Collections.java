package my.lux.brand.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 3/13/2016.
 */
public class Collections {

   public static  void main(String[] args){
      String[] langs = {"Java", "C#", "Pyton", "JavaScript"};

      List<String> languages = Arrays.asList("Java", "C#", "Pyton", "JavaScript");

      for (String l : languages){
         System.out.println("I want to learn " + l);
      }
   }
}
