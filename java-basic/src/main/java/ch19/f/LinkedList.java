package ch19.f;

public class LinkedList {
  
  public static final int FORWARD = 0;
  public static final int REVERCE = 1;
  
  protected Node head;
  protected Node tail;
  protected int size;
  
  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }
  
  public void add(Object value) {
    tail.value = value; //받아온 value값을 저장
    Node node = new Node(); //노드 새로 생성
    tail.next = node; //새롭게 생성한 노드에 이전 노드의 주소 저장
    node.prev = tail; //받아온 value값을 현재 노드(새로 생성X)에 저장
    tail = node; //새롭게 생성된 노드로 이동
    size++;
  }
    
    public int size() { //현 size값 리턴
      return size;
    }
    
    public Object get(int index) {
      if (index < 0 || index >= size) {
        return null;
      }
      Node cursor = head;
      for (int i = 1; i <= index; i++) {
        cursor = cursor.next;
      }
      return cursor.value;
    }
    
    public Object[] toArray(int direction) { //node값을 배열에 복사
     
      Array helper = new Array(); 
      // ->같은 인스턴스 맴버이기 때문에 생성자에서 인스턴스 주소를 받을 필요 없음
      
      if (direction == FORWARD) {
        return helper.copy();
      } else {
        return helper.reverseCopy();
      }
    }
    
    public Object set(int index, Object value) {
      if(index < 0 || index >= size) {
        return null;
        }
      Node cursor = head;
      for (int i = 0; i <= index; i++) {
        cursor = cursor.next;
      }//교체할 값이 있는 노드로 이등
      Object old = cursor.value;
      cursor.value = value;
      return old;
    }
    
    public int insert(int index, Object value) {
      if (index < 0 || index >= size)
        return -1; //인덱스값 유효성 검사
      Node node = new Node(value);
      Node cursor = head;
      for (int i = 1; i<= index; i++) {
        cursor = cursor.next;
      }
      node.next = cursor;
      node.prev = cursor.prev;
      cursor.prev = node;
      if (node.prev != null) {
        node.prev.next = node;
      } else {
        head = node;
      }
      size++;
      return 0;
    }
    
    public Object remove(int index) {
      if(index < 0 || index >= size) {
        return null;
        }
      Node cursor = head;
      for(int i = 1; i <= index; i++) {
        cursor = cursor.next;
      }
      if (cursor.prev != null) {
      cursor.prev.next = cursor.next;//찾은 노드의 이전 노드가 다음 노드를 가리킴
      } else {
        head = cursor.next;
      }
      cursor.next.prev = cursor.prev;//찾은 노드의 다음 노드가 이전 노드를 가리킴
      Object old = cursor;
      cursor.value = null;
      cursor.prev = null;
      cursor.next = null; //찾은 노드의 V, P, N값을 null값으로 변경; 가비지컬렉터를 돕기 위해
      size--;
      return old;//필요하면 쓰기 위해 지운 값을 리턴
    }
    
    
    public class Array {
//      LinkedList list;
      
      /*public Array (LinkedList list) {
        this.list = list;
      }*/
      
      public Object[] copy() { //노드값을 배열에 복사; 입력된 순서대로 배열을 만듦
        Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
          arr[i] = get(i);
        }
        return arr;
      }
      
      public Object[] reverseCopy() { //노드값을 배열에 복사; 입력된 순서의 반대로 배열을 만듦
        Object[] arr = new Object[size()];
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
          arr[j] = get(i);
        }
        return arr;
      }
    }
}
