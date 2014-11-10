public class SuperArray{
    Object[] data;
    int elements = 0;
    public SuperArray(){
	data = new Object[10];
    }
    public SuperArray(int size){
	data = new Object[size];
    }
    public String toString(){
	String a = " [ ";
	for(int i = 0;i < elements;i++)
	    a = a + data[i] + " ";
	return a + "]";
    }
    public void add(Object o){
	add(elements,o);
    }
    public void add(int index, Object o){
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
	Object[] newArray = new Object[newCapacity];
	for(int i = 0;i < elements;i++)
	    newArray[i] = data[i];
    }
    public void clear(){
	for(int i = 0;i< elements;i++)
	    data[i] = null;
	elements = 0;
    }
    public Object get(int index){
	if(index >= 0 && index < size())
	    return data[index];
	else{
	    System.out.println("Error, index out of range.");
	    return null;
	}
    }
    public Object set(int index, Object e){
	if(index >= 0 && index < size()){
	    Object old = data[index];
	    data[index] = e;
	    return old;
	}else{
	    System.out.println("Error, index out of range.");
	    return null;
	}
    }
    public Object remove(int index){
    	if(data.length >= elements * 4){
    		resize(data.length / 2)
    	}
	if(index >= 0 && index < size()){
	    Object old = data[index];
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
}
