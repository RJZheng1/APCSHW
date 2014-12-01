public class SuperArray{
    Object[] data;
    int elements = 0;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int size){
	data = new Object[size];
    }
    public String toString(){
	String a = " [ ";
	for(int i = 0;i < size();i++)
	    a = a + data[i] + " ";
	return a + "]";
    }
    public void add(Object o){
	if(size() == data.length)
	    resize(data.length * 2);
	data[size()] = o;
	elements++;;
    }
    public void add(int index, Object o){
	if(index < 0 || index > size())
	    throw new ArrayIndexOutOfBoundsException();
	if(size() == data.length)
	    resize(data.length * 2);
	for(int i = size() - 1;i >= index;i--)
	    data[i + 1] = data[i];
	data[index] = o;
	elements++;
    }
    public int size(){
	return elements;
    }
    public void resize(int newCapacity){
	Object[] newArray = new Object[newCapacity];
	int end = Math.min(newCapacity,size());
	for(int i = 0;i < end;i++)
	    newArray[i] = data[i];
	data = newArray;
    }
    public void clear(){
	elements = 0;
    }
    public Object get(int index){
	if(index < 0 && index > size())
	    throw new ArrayIndexOutOfBoundsException();
	return data[index];
    }
    public Object set(int index, Object o){
	if(index < 0 && index > size())
	    throw new ArrayIndexOutOfBoundsException();
	Object old = data[index];
	data[index] = o;
	return old;
    }
    public Object remove(int index){
	if(index < 0 && index > size())
	    throw new ArrayIndexOutOfBoundsException();
	Object old = data[index];
	for(int i = index;i < size();i++)
	    data[i] = data[i + 1];
	elements--;
    	if(data.length >= size() * 4)
	    resize(data.length / 2);
	return old;
    }
}
