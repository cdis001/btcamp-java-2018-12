package design_pattren.iterator;

public class Test01 {
  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");
    list1.add("fff");
    
    Iterator<String> iterator = list1.iterator();
    
    while(iterator.hasnext()) {
      System.out.print(iterator.next() + ", ");
    }
    System.out.println();
    System.out.println("-----------------");
    
    LinkedList<String> list2 = new LinkedList<>();
    list2.add("aaa2");
    list2.add("bbb2");
    list2.add("ccc2");
    list2.add("ddd2");
    list2.add("fff2");
    
    iterator = list2.iterator();
    
    while(iterator.hasnext()) {
      System.out.print(iterator.next() + ", ");
    }
    System.out.println();
    System.out.println("-----------------");
    
    Stack<String> list3 = new Stack<>();
    list3.push("aaa3");
    list3.push("bbb3");
    list3.push("ccc3");
    list3.push("ddd3");
    list3.push("fff3");
    
    iterator = list3.iterator();
    
    while(iterator.hasnext()) {
      System.out.print(iterator.next() + ", ");
    }
    System.out.println();
    System.out.println("-----------------");
    
    Queue<String> list4 = new Queue<>();
    list4.add("aaa4");
    list4.add("bbb4");
    list4.add("ccc4");
    list4.add("ddd4");
    list4.add("fff4");
    
    iterator = list4.iterator();
    
    while(iterator.hasnext()) {
      System.out.print(iterator.next() + ", ");
    }
  }
}
