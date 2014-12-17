import java.lang.*;
import java.util.*;

public class SuperArray{
    String[] data;
    int elements;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int size){
	data = new String[size];
	elements = 0;
    }
    public String toString(){
	String a = " [ ";
	for(int i = 0;i < size();i++)
	    a = a + data[i] + " ";
	return a + "]";
    }
    public void add(String o){
	if(size() == data.length)
	    resize(data.length * 2);
	data[size()] = o;
	elements++;;
    }
    public void add(int index, String o){
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
	String[] newArray = new String[newCapacity];
	int end = Math.min(newCapacity,size());
	for(int i = 0;i < end;i++)
	    newArray[i] = data[i];
	data = newArray;
    }
    public void clear(){
	elements = 0;
    }
    public String get(int index){
	if(index < 0 && index > size())
	    throw new ArrayIndexOutOfBoundsException();
	return data[index];
    }
    public String set(int index, String o){
	if(index < 0 && index > size())
	    throw new ArrayIndexOutOfBoundsException();
	String old = data[index];
	data[index] = o;
	return old;
    }
    public String remove(int index){
	if(index < 0 && index > size())
	    throw new ArrayIndexOutOfBoundsException();
	String old = data[index];
	for(int i = index;i < size();i++)
	    data[i] = data[i + 1];
	elements--;
    	if(data.length >= size() * 4)
	    resize(data.length / 2);
	return old;
    }
    public void insertionSort(){
	for(int x = 1;x < size();x++){
	    if(data[x].compareTo(data[x-1]) < 0){
		int i = x - 1;
		String temp = data[x];
		for(;i >= 0 && temp.compareTo(data[i]) < 0;i--)
		    data[i+1] = data[i];
		data[i+1] = temp;
	    }
	}
    }
    public void selectionSort(){
	for(int i = 0;i < size();i++){
	    String min = i
	    for(int x = i+1;x < size();x++){
		if(data[x].compareTo(data[min]) < 0)
		    min = x;
	    }
	    set(min,set(i,data[min]));
	}
    }
    public void arraySort(){
	Arrays.sort(data,0,size());
    }
    public int find(String target){
	int i = 0;
	for(;i < size();i++){
	    if(data[size()].equals(target))
	       break;
	}
	if(i == size())
	    return -1;
	return i;
    }
}
