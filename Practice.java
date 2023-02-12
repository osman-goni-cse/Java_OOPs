import java.util.Scanner;
import java.util.Arrays;

class Practice {
  public static void main(String[] args) {
    int[] primeNumbers = new int[30];
    int index = 0;

    for(int i = 3; i < 100; i+=2) {
      boolean chk = true;
      for(int j = 2; j*j <= i; j++) {
        if(i%j == 0) {
          chk = false;
        }
      }
      if(chk) {
        primeNumbers[index++] = i;
      }
    }

    System.out.println(Arrays.toString(primeNumbers));
    
  }
}