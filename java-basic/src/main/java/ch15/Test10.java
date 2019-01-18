//사용자가 만든 클래스를 key로 사용
package ch15;

import java.util.HashMap;
class Key {
  String contents;
  
  public Key(String contents) {
    this.contents = contents;
  }

  @Override
  public String toString() {
    return "Key [contents=" + contents + "]";
  }
  
}

public class Test10 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    Key k1 = new Key("OK");
    Key k2 = new Key("no");
    Key k3 = new Key("haha");
    Key k4 = new Key("ohora");
    Key k5 = new Key("뭐드라");
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2,new Student("임꺽정", 30, true));
    map.put(k3,new Student("유관순", 17, true));
    map.put(103,new Student("안중근", 24, true));
    map.put(104,new Student("윤봉길", 22, false));
    
    System.out.println(map.get(k3));
    
    Key k6 = new Key("haha");
    
    System.out.println(k3 == k6); //인스턴스 다름
    System.out.println(k3.hashCode());
    System.out.println(k6.hashCode());
    System.out.println(k3.equals(k6)); //
    
    System.out.println(map.get(k6));
    //인스턴스도 다르고 hash code도 다르기 때문에 꺼내지지 않음
    //hash code가 다른 이유?? ->key 값을 사용자가 정의한것으로 사용했기 때문 ->????
    //사용자가 정의한 것으로 사용할 경우, 같은 값을 가지더라도 인스턴스 자체가 새로운 인스턴스 값을 가지기 때문??? 
    //패키징을 두 번 했기 때문?!????
    
    String k7 = new String("Haha");
    System.out.println(map.get(k7));
        
}
}
