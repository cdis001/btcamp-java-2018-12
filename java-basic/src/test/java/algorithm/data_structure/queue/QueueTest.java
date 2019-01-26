package algorithm.data_structure.queue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QueueTest {

  @Test
  void testOffer() {
    Queue q = new Queue();
    q.offer(100);
    q.offer(200);
    q.offer(300);
    
    assertEquals(3, q.size());
  }

  @Test
  void testPoll() {
    Queue q = new Queue();
    q.offer(100);
    q.offer(200);
    q.offer(300);
    
    assertEquals(100, q.poll());
    assertEquals(2, q.size());
    
    assertEquals(200, q.poll());
    assertEquals(1, q.size());
    
    assertEquals(300, q.poll());
    assertEquals(0, q.size());
    
    assertEquals(null, q.poll());
  }

  @Test
  void testEmpty() {
    Queue q = new Queue();
    q.offer(100);
    q.offer(200);
    q.offer(300);
    
    assertEquals(100, q.poll());
    assertFalse(q.empty());
    
    assertEquals(200, q.poll());
    assertFalse(q.empty());
    
    assertEquals(300, q.poll());
    assertTure(q.empty());
  }

}
