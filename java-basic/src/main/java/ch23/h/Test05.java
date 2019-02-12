package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test05 {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.naver.com");
    
    URLConnection con = url.openConnection();
    
    con.connect();
    
    InputStream in = con.getInputStream();
    
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));
    
    while(true) {
      String str = in2.readLine();
      if(str == null) {
        break;
      }
      System.out.println(str);
    }
    in2.close();
    in.close();
  }
}
