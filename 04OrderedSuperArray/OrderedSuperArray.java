public class OrderedSuperArray extends SuperArray{
    String[] data;
    int elements = 0;
    public OrderedSuperArray(){
	data = new String[10];
    }
    public OrderedSuperArray(int size){
	data = new String[size];
    }
    public void add(String o){
	super.add(o);
	for(int x = 0;x < data.length;x++){
	    if(data[x].compareTo(o) >= 0){
		for(int i = x;i < data.length - 1;i++)
		    data[i + 1] = data[i];
		data[x] = o;
		break;
	    }
	}
    }
    public void add(int index, String o){
	add(o);
    }
    public void resize(int newCapacity){
	String[] newArray = new String[newCapacity];
	for(int i = 0;i < elements;i++)
	    newArray[i] = data[i];
    }
    public String set(int index, String o){
	String e = super.remove(index);
	add(o);
	return e;
    }
}
