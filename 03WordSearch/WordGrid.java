import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    public static void main(String[]args){
	WordGrid g = new WordGrid(13,13);
	System.out.println(g);
	g.addWord("DUCK",0,0,0);
	System.out.println(g);
	g.addWord("CHICKEN",0,2,90);
	System.out.println(g);
	g.addWord("TURKEY",1,3,45);
	System.out.println(g);
	g.addWord("TURDUCKEN",0,13,315);
    }
    /**Initializes a grid of the specified size and fills all of the positions 
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    private void clear(){
	for(int a = 0;a < data.length;a++){
	    for(int b = 0;b < data[a].length;b++)
		data[a][b] = ' ';
	}
    }
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces and each row
     *separated by new lines.
     */
    public String toString(){
	String output = "";
	for(int a = 0;a < data.length;a++){
	    for(int b = 0;b < data[a].length;b++)
		output = output + data[a][b] + " ";
	    output += "\n";
	}
	return output;
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any word to be added to the WordGrid.
     *@param row is the vertical location that you want the word to start at.
     *@param col is the horizontal location that you want the word to start at.
     *@param dir is the angle you want the word to be added in, in degrees.
     *dir must be divisible by 45. Also, remember that down is positive.
     *@return true when the word is added successfully and false if otherwise.
     */
    public boolean addWord(String word,int row,int col,int dir){
	if(dir %45 != 0)
	    return false;
	int xdir = (int)Math.round(Math.cos(dir * Math.PI / 180));
	int ydir = (int)Math.round(Math.sin(dir * Math.PI / 180));
	int x = 0;
	try{
	    for(;x < word.length();x++){
		if(data[row + x * ydir][col + x * xdir] == ' ')
		    data[row + x * ydir][col + x * xdir] = word.charAt(x);
		else
		    throw new IndexOutOfBoundsException();
	    }
	}catch(IndexOutOfBoundsException e){
	    for(;x > 0;x--)
		data[row - x * ydir][col - x * xdir] = ' ';
	    return false;
	}
	return true;
    }
    public static ArrayList<String> readFile(String fileAddress){
	ArrayList words = new ArrayList();
	try{
	    File inFile = new File(fileAddress);
	    Scanner in = new Scanner(inFile);
	    while(in.hasNextLine())
		words.add(in.nextLine());
	}catch(FileNotFoundException e){
	    readFile("Words.txt");
	}
	return words;
    }
}
