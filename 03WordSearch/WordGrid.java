import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    public static void main(String[]args){
	WordGrid g = new WordGrid(20,20);
	g.addWords(readFile("Words.txt"));
	g.addRandomLetters();
	System.out.println(g);
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
		    throw new ArrayIndexOutOfBoundsException();
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    for(;x > 0;x--)
		data[row + x * ydir - ydir][col + x * xdir - xdir] = ' ';
	    return false;
	}
	return true;
    }
    /**Takes a text file filed with words and puts them into an ArrayList of Strings.
     *@param fileName is the name of the file you wish to read.
     *@return an ArrayList of Strings containing all the words.
     */
    public static ArrayList<String> readFile(String fileName){
	ArrayList<String> words = new ArrayList<String>();
	try{
	    File inFile = new File(fileName);
	    Scanner in = new Scanner(inFile);
	    while(in.hasNextLine())
		words.add(in.nextLine());
	}catch(FileNotFoundException e){
	    readFile("Words.txt");
	}
	return words;
    }
    /**Takes an ArrayList of Strings and attempts to add them to the WordGrid.
     *@param words is an ArrayList of Strings containing the words you want to add.
     */
    public void addWords(ArrayList<String> words){
	Random RNG = new Random();
	for(int x = 0;x < words.size();x++){
	    boolean done = false;
	    for(int a = 0;a < 100;a++){
		int row = RNG.nextInt(data.length);
		int col = RNG.nextInt(data.length);
		for(int dir = 0;dir < 360;dir += 45){
		    if(addWord(words.get(x),row,col,dir)){
			done = true;
			break;
		    }
		}
		if(done == true)
		    break;
	    }
	}
    }
    public void addRandomLetters(){
	char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	Random RNG = new Random();
	for(int a = 0;a < data.length;a++){
	    for(int b = 0;b < data[a].length;b++){
		if(data[a][b] == ' ')
		    data[a][b] = letters[RNG.nextInt(26)];
	    }
	}
    }
}
