public class OrderedSuperArray extends SuperArray{
    String[] data;
    int elements = 0;
    public OrderedSuperArray(){
        this(10);
    }
    public OrderedSuperArray(int size){
	super(size);
    }
    public void add(String o){
	int x = 0;
	while(data[x].compareTo(o) < 0)
	    x ++;
	super.add(x,o);
    }
    public void add(int index, String o){
	add(o);
    }
    public String set(int index, String o){
	String e = super.remove(index);
	add(o);
	return e;
    }
}
