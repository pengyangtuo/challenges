import java.util.*;

public class One{

    public static void swap(int[] a, int[] b, int ia, int ib){
        int temp = a[ia];
        a[ia] = b[ib];
        b[ib] = temp;
    }

    public static void merge(int[] a, int[] b){
        int ia = 0;

        while(ia < a.length-1 && a[ia] != -1){
            int ib = 0;
            if(a[ia] > b[ib]){
                // swap and check
                swap(a, b, ia, ib);
                ib = 1;
                while(b[ib]<b[0] && ib < b.length){
                    swap(a, b, ia+1, ib);
                    ib++;
                    ia++;
                }
            }
            ia++;
        }

        // copy rest of b to a
        for(int i=0; i<b.length; i++){
            if(b[i] == -1){
                continue;
            }
            if(ia >= a.length){
                break;
            }
            a[ia]=b[i];
            ia++;
        }
    }

    public static void printArray(int[] a){
        System.out.print("["+a[0]);
        for(int i=1; i<a.length; i++){
            System.out.print(", "+a[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] a = new int[7];
        int[] b = {2,4,9};
        Arrays.fill(a, -1);
        a[0] = 3;
        a[1] = 7;
        a[2] = 8;
        a[3] = 9;

        printArray(a);
        printArray(b);

        merge(a, b);
        printArray(a);
    }
}