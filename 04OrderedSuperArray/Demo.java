public class Demo{
    public static void main(String[] args){
	SuperArray supes = new SuperArray();
	for(int i = 0;i < 100000;i++)
	    supes.add("" + i);
	if(args[0].equals("select"))
	    supes.selectionSort();
	else if(args[0].equals("insert"))
	    supes.insertionSort();
	else
	    supes.arraySort();
    }
}
