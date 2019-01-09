package ch06;

public class Test06 {
  public static void main(String[] args) {
    int result = plus();
    System.out.println(result);
    
    result = plus(2);
    System.out.println(result);
    result = plus(2,5);
    System.out.println(result);
    result = plus(2,5,7);
    System.out.println(result);
    result = plus(2,9,11,15);
    System.out.println(result);
    
    int[] arr1 = new int[3];
    arr1[0] = 20;
    arr1[1] = 30;
    arr1[2] = 40;
    result = plus(arr1);
    System.out.println(result);

    int[] arr2 = new int[] {10, 20, 30};
    result = plus(arr2);
    System.out.println(result);

    int arr3 = 
        result = plus(arr3);
    System.out.println(result);

    result = plus(new int[] {10, 20, 30});
  }
  static int plus(int... value) {
    int sum = 0;
        for (int i = 0; i<value.length; i++) {
          sum += value[i];
        }
        return sum;
  }

}
