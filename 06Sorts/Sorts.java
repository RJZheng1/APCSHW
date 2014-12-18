public class Sorts{
    public static void bubble(int[] c){
	for(int i = 1;i < c.length;i++){
	    int swaps = 0;
	    int a;
	    for(int x = 0;x < c.length-i;x++){
		if(c[x] > c[x+1]){
		    a = c[x];
		    c[x] = c[x+1];
		    c[x+1] = a;
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
