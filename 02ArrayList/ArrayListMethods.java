import java.util.*;

public class ArrayListMethods{
    public static void main(String[] args){
	ArrayList<Integer> L = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,3,3,4,4,5,5));
	System.out.println(L);
	collapseDuplicates(L);
	System.out.println(L);
	for(int x = 0;x < 10;x++){
	    randomize(L);
	    System.out.println(L);
	}
    }
    public static void collapseDuplicates(ArrayList<Integer> L){
	for(int x = 1;x < L.size();){
	    if(L.get(x) == L.get(x - 1)){
		L.remove(x);
	    }else{
		x++;
	    }
	}
    }
    public static void randomize(ArrayList<Integer> L){
	Random RNG = new Random();
	int size = L.size();
	for(int x = 0;x < size;x++)
	    L.set(x,L.set(RNG.nextInt(size - x) + x,L.get(x)));
    }
}
