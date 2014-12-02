public class SuperArrayCopy{
    String[] data;
    int elements = 0;
    public SuperArrayCopy(){
	data = new String[10];
    }
    public SuperArrayCopy(int size){
	data = new String[size];
    }
    public String toString(){
	String a = " [ ";
	for(int i = 0;i < elements;i++)
	    a = a + data[i] + " ";
	return a + "]";
    }
    public void add(String o){
	add(elements,o);
    }
    public void add(int index, String o){
	if(elements == data.length)
	    resize(data.length * 2);
	for(int i = elements - 1;i >= index;i--)
	    data[i + 1] = data[i];
	data[index] = o;
	elements++;
    }
    public int size(){
	return elements;
    }
    public void resize(int newCapacity){
	String[] newArray = new String[newCapacity];
	for(int i = 0;i < elements;i++)
	    newArray[i] = data[i];
    }
    public void clear(){
	for(int i = 0;i< elements;i++)
	    data[i] = null;
	elements = 0;
    }
    public String get(int index){
	if(index >= 0 && index < size())
	    return data[index];
	else{
	    System.out.println("Error, index out of range.");
	    return null;
	}
    }
    public String set(int index, String o){
	if(index >= 0 && index < size()){
	    String old = data[index];
	    data[index] = o;
	    return old;
	}else{
	    System.out.println("Error, index out of range.");
	    return null;
	}
    }
    public String remove(int index){
    	if(data.length >= elements * 4){
    		resize(data.length / 2);
    	}
	if(index >= 0 && index < size()){
	    String old = data[index];
	    data[index] = null;
	    for(int i = index;i < elements;i++)
		data[i] = data[i + 1];
	    elements--;
	    return old;
	}else{
	    System.out.println("Error, index out of range.");
	    return null;
	}
    }
    public void insertionSort(){
	for(int x = 1;x < data.length;x++){
	    if(data[x].compareTo(data[x-1]) <= 0){
		int i = x;
		String temp = data[x];
		for(;data[i].compareTo(temp) <= 0;i--)
		    data[i] = data[i-1];
		data[i] = temp;
	    }
	}
    }
}
