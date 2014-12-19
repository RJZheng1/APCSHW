import java.util.Random;

public class Driver{
    public static void main(String[]args){
	long start,end;
	Random RNG = new Random();
	int[] a = new int[10000];
	int[] b = new int[10000];
	int[] c = new int[10000];
	int[] d = new int[10000];
	for(int x = 0;x < 10000;x++){
	    int n = RNG.nextInt(Integer.MAX_VALUE);
	    a[x] = n;
	    b[x] = n;
	    c[x] = n;
	    d[x] = n;
	}
	start = System.currentTimeMillis();
	Sorts.bubble(a);
	end = System.currentTimeMillis();
	System.out.println("bubble\n" + (end-start));
	start = System.currentTimeMillis();
	Sorts.insertion(b);
	end = System.currentTimeMillis();
	System.out.println("insertion\n" + (end-start));
	start = System.currentTimeMillis();
	Sorts.selection(c);
	end = System.currentTimeMillis();
	System.out.println("selection\n" + (end-start));
	start = System.currentTimeMillis();
	Sorts.radix(d);
	end = System.currentTimeMillis();
	System.out.println("radix\n" + (end-start));
    }
}
