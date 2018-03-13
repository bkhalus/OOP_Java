public class ShellSort {

    public static void main(String[] args) {
        int[] array = {30, 2, 10, 4, 6};
        int length = array.length;
        
        int inner, outer;
        int temp;
        
        int h = 1;
        while(h <= length / 3) {
            h = h * 3 + 1;
        }
        while(h > 0) {
            for (outer = h; outer < length; outer++) {
                temp = array[outer];
                inner = outer;
                
                while(inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h-1) / 3;
           }
        
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}     