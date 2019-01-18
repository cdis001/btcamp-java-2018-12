package ch15;

import java.util.HashMap;
class Key2 {
  String contents;
  
  public Key2(String contents) {
    this.contents = contents;
  }

  @Override
  public String toString() {
    return "Key2 [contents=" + contents + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Key2 other = (Key2) obj;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    return true;
  }
  
}

public class Test11 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    Key2 k1 = new Key2("OK");
    Key2 k2 = new Key2("no");
    Key2 k3 = new Key2("haha");
    Key2 k4 = new Key2("ohora");
    Key2 k5 = new Key2("뭐드라");
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2,new Student("임꺽정", 30, true));
    map.put(k3,new Student("유관순", 17, true));
    map.put(103,new Student("안중근", 24, true));
    map.put(104,new Student("윤봉길", 22, false));
    
    System.out.println(map.get(k3));
    
    Key2 k6 = new Key2("haha");
    
    System.out.println(k3 == k6); //인스턴스값
    System.out.println(k3.hashCode()); //k3 해시코드값
    System.out.println(k6.hashCode()); //k6 해시코드값
    System.out.println(k3.equals(k6)); //equals 비교 결과값
    
    System.out.println(map.get(k6));
    //인스턴스는 달라도 상관 없지만 hash code 값과 equals값이 같아야 같은 key로 인식됨
    
    String k7 = new String("Haha");
    System.out.println(map.get(k7));
        
}
}
