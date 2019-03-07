package ch26.g;

import java.util.HashMap;

public class MapTest {
  public static void main(String[] args) {
    HashMap<String,Object> map = new HashMap<>();
    map.put("b", "baab");
    map.put("d", "ddvd");
    map.put("a", "aaaf");
    map.put("c", "cacc");
    
    System.out.println(map);
  }
}
