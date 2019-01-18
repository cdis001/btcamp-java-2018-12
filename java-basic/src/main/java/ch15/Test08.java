package ch15;

import java.util.HashMap;

public class Test08 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    Integer k1 = new Integer(100);
    Integer k2 = new Integer(101);
    Integer k3 = new Integer(102);
    Integer k4 = new Integer(103);
    Integer k5 = new Integer(104);
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2,new Student("임꺽정", 30, true));
    map.put(k3,new Student("유관순", 17, true));
    map.put(103,new Student("안중근", 24, true));
    map.put(104,new Student("윤봉길", 22, false));
    
    Integer k6 = new Integer(102);
    
    System.out.println(k3 == k6); //'인스턴스는 다르지만'? 해시코드는 같음
    System.out.println(k3.hashCode());
    System.out.println(k6.hashCode());
    System.out.println(k3.equals(k6)); //
    
    System.out.println(map.get(k6));
    
    Integer k7 = new Integer(200);
    System.out.println(map.get(k7));
        
}
}
