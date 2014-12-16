public class Sorts{
    public static void main(String[] args){
	int[] a = new int[] {6,3,61,7,37,43,85};
	bubble(a);
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
    public void insertion(int[] c){
	for(int x = 1;x < c.length;x++){
	    if(c[x] > c[x-1]){
		int i = x-1;
		int temp = c[x];
		for(;i >= 0 && temp < c[i];i--)
		    c[i+1] = c[i];
		c[i+1] = temp;
	    }
	}
    }
    public void selection(int[] c){
	for(int i = 0;i < c.length;i++){
	    int min = c[i];
	    int j = i;
	    for(int x = i;x < c.length;x++){
		if(c[x] < min){
		    min = c[x];
		    j = x;
		}
	    }
	    int a = c[x-1];
	    c[x-1] = c[x];
	    c[x] = a;
	}
    }
}