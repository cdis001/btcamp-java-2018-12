package algorithm.data_structure.linkedlist3;

public class LinkedList<E> {
  protected Node<E> head; 
  protected Node<E> tail; 
  protected int size;
  
  public LinkedList() {
    head = new Node<>();
    tail = head;
    size = 0;
  }
  
  public void add(E value) {
    tail.value = value; //받아온 value값을 저장
    
    Node<E> node = new Node(); //노드 새로 생성
    
    tail.next = node; //새롭게 생성한 노드에 이전 노드의 주소 저장
    
    node.prev = tail; //받아온 value값을 현재 노드(새로 생성X)에 저장
    
    tail = node; //새롭게 생성된 노드로 이동
    
    size++;
  }
    
    public int size() { //현 size값 리턴
      return size;
    }
    
    public E get(int index) {
      if (index < 0 || index >= size) {
        return null;
      }
      Node<E> cursor = head;
      
      for (int i = 1; i <= index; i++) {
        cursor = cursor.next;
      }
      
      return cursor.value;
    }
    
    public Object[] toArray() {
      Object[] arr = new Object[size()];
      
      Node<E> cursor = head;
      
      int i = 0;
      while (cursor != tail) { //tail == head 의 경우, 현재 찾고 있는 node의 값 
        arr[i++] = cursor.value;
        cursor = cursor.next;
      } //cursor == tail이 될 때까지 돌아감
      
      return arr;
    }
    
    public E set(int index, E value) {
      if(index < 0 || index >= size) {
        return null;
        }
      
      Node<E> cursor = head;
      
      for (int i = 0; i <= index; i++) {
        cursor = cursor.next;
      }//교체할 값이 있는 노드로 이등
      
      E old = cursor.value;
      
      cursor.value = value;
      
      return old;
    }
    
    public int insert(int index, E value) {
      if (index < 0 || index >= size)
        return -1; //인덱스값 유효성 검사
      
      Node<E> node = new Node<E>(value);
      Node<E> cursor = head;
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
    
    public E remove(int index) {
      if(index < 0 || index >= size) {
        return null;
        }
      
      Node<E> cursor = head;
      for(int i = 1; i <= index; i++) {
        cursor = cursor.next;
      }
      if (cursor.prev != null) {
      cursor.prev.next = cursor.next;//찾은 노드의 이전 노드가 다음 노드를 가리킴
      } else {
        head = cursor.next;
      }
      
      cursor.next.prev = cursor.prev;//찾은 노드의 다음 노드가 이전 노드를 가리킴
      
      
      E old = cursor;
      cursor.value = null;
      cursor.prev = null;
      cursor.next = null; //찾은 노드의 V, P, N값을 null값으로 변경; 가비지컬렉터를 돕기 위해
      
      size--;
      return old;//필요하면 쓰기 위해 지운 값을 리턴
    }
    private static class Node<E> {
      E value;
      Node<E> prev;
      Node<E> next;
      
      Node() {
      }

      public Node(E value) {
        this.value = value;
      }
      
    }
}
