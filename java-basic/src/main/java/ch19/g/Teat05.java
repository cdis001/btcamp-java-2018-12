package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Teat05 {
  
  public static void main(String[] args) {
    
   File dir = new File("./");
    
   FilenameFilter filter = new FilenameFilter(){
     
     @Override
     public boolean accept(File dir, String name) {
       System.out.println("필터 확인중: " + name);
       if (name.endsWith(".txt"))
         return true;
       else
         return false;
     }
   };
   
   String[] names = dir.list(filter);
       
   for (String name : names) {
     System.out.println(name);
   }
}
}
