public class OrderedSuperArray extends SuperArray{  
    public OrderedSuperArray(){
        this(10);
    }
    public OrderedSuperArray(int size){
	super(size);
	elements = 0;
    }
    public void add(String o){
	int x = 0;
	while(x < size() && data[x].compareTo(o) < 0)
	    x++;
	super.add(x,o);
    }
    public void add(int index, String o){
	add(o);
    }
    public String set(int index, String o){
	if(size() == 0)
	    throw new IndexOutOfBoundsException();
	String e = super.remove(index);
	add(o);
	return e;
    }
    public int find(String target){
	int i = size()/2;
	for(double x = size()/4;x % 1 == 0;x/=2){
	    if(data[i].equals(target))
	        break;
	    else if(data[i].compareTo(target) > 0)
		i -= x;
	    else
		i += x;
	}
	if(!data[i].equals(target))
	   return -1;
	for(;i > 0;i--){
	    if(!data[i-1].equals(target))
		break;
	}
	return i;
    }
}
