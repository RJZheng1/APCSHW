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
	super.add(o);
	for(int x = 0;x < data.length;x++){
	    if(data[x].compareTo(o) >= 0){
		for(int i = x;i < data.length - 1;i++)
		    data[i] = data[i - 1];
		data[x] = o;
		break;
	    }
	}
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
