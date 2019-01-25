package design_pattren.iterator;

public class StackIterator<E> implements Iterator<E> {

  Stack<E> stack;
  int index = 0;
  
  public StackIterator(Stack<E> stack) {
    this.stack = stack;
  }
  
  @Override
  public boolean hasnext() {
      return index < stack.size();
  }

  @SuppressWarnings("unchecked")
  @Override
  public E next() {
    int lastIndex = stack.size - 1;
    return (E) stack.list[lastIndex - (index++)];
  }

}
