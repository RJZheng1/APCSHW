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
    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while(this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
    public int find(String target){
	int i = 0;
	for(;i < size();i++){
	    if(data[size()].equals(target))
	       break;
	}
	if(i == data.length)
	    return -1;
	return i;
    }
    /* 
       public static void main(String[] args){
       Test of insertionSort()
       SuperArray a = new SuperArray();
       for(String i:new String[] {"Orange","Waffle","Blue","Red","Yellow","Potato","Banana"})
       a.add(i);
       System.out.println(a);
	  a.insertionSort();
	  System.out.println(a);
	  Random RNG = new Random();
	  for(int b = 1;b < 21;b++){
	  System.out.println("Trial " + b);
	  SuperArray supes1 = new SuperArray();
	  SuperArray supes2 = new SuperArray();
	  String[] rand = new String[10000];
	    for(int w = 0;w < 10000;w++){
	    String word = "";
	    for(int c = 0;c < 10;c++)
	    word = word + (char)('a' + RNG.nextInt(26));
	    rand[w] = word;
	    }
	    for(String s:rand ){
		supes1.add(s);
		supes2.add(s);
	    }
	    long start1 = System.currentTimeMillis();
	    supes1.insertionSort();
	    long end1 = System.currentTimeMillis();
	    long time1 = end1 - start1;
	    System.out.println("Test 1: " + time1);
	    long start2 = System.currentTimeMillis();
	    supes2.badInsertionSort();
	    long end2 = System.currentTimeMillis();
	    long time2 = end2 - start2;
	    System.out.println("Test 2: " + time2);
	    System.out.println("Takes " + (100*Math.abs(time2 - time1)/time2) + "% less time");
	    }
	    }
    */
}
