public class Sorts{
    public static void main(String[] args){
	int[] a = new int[] {6,3,61,7,37,6,43,85};
	selection(a);
	for(int x:a)
	    System.out.println(x);
    }
    public static void bubble(int[] c){
	for(int i = 1;i < c.length;i++){
	    int swaps = 0;
	    for(int x = i;x < c.length-i;x++){
		if(c[x-1] > c[x]){
		    int a = c[x-1];
		    c[x-1] = c[x];
		    c[x] = a;
		    swaps++;
		}
	    }
	    if(swaps == 0)
		break;
	}
    }
    public static void insertion(int[] c){
	for(int x = 1;x < c.length;x++){
	    if(c[x] < c[x-1]){
		int i = x-1;
		int temp = c[x];
		for(;i >= 0 && temp < c[i];i--)
		    c[i+1] = c[i];
		c[i+1] = temp;
	    }
	}
    }
    public static void selection(int[] c){
	for(int i = 0;i < c.length;i++){
	    int min = i;
	    for(int x = i+1;x < c.length;x++){
		if(c[x] < c[min])
		    min = x;
	    }
	    int a = c[i];
	    c[i] = c[min];
	    c[min] = a;
	}
    }
}
