package algorithm.data_structure.linkedlist;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {

  @Test
  public void testAdd() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(6, list.size());
  }
  
  @Test
  public void testGet() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(100, list.get(0));
    assertEquals(300, list.get(2));
    assertEquals(600, list.get(5));
    
    assertNull(list.get(-1));
    assertNull(list.get(6));
  }

  @Test
  public void testToArray() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    Object[] arr = list.toArray();
    
    assertEquals(6, arr.length);
    assertEquals(new int[] {100, 200, 300, 400, 500, 600}, arr);
  }
  
  @Test
  public void testSet() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.set(2, 55));
    assertEquals(55, list.get(2));
  }
  
  @Test
  public void testInsert() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(-1, list.insert(6, 55));
    assertEquals(-1, list.insert(-1, 55));
    
    assertEquals(0, list.insert(2, 55));
    assertArrayEquals(new Object[] {100, 200, 55, 300, 400, 500, 600},
        list.toArray());
    
    assertEquals(0, list.insert(0, 55));
    assertArrayEquals(
        new Object[] {55, 100, 200, 55, 300, 400, 500, 600}, list.toArray());
    assertEquals(0, list.insert(7, 55));
    assertArrayEquals(
        new Object[] {55, 100, 200, 55, 300, 400, 500, 55, 600}, list.toArray());
  }
  
  @Test
  public void testRemove() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.remove(2));
    assertEquals(-1, list.remove(2));
    
    assertArrayEquals(new Object[] {100, 200, 400, 500, 600},
        list.toArray());
  }
}