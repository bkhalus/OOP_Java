
public class demo {
public static void main(String args[]) {
        System.out.println("asd".hashCode());	
}
public static int test(){
    try {
              return 1;
    } catch (RuntimeException re){
              return 2;
    } finally {
              return 3;
    }
  }
 }