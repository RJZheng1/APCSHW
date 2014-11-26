import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    private Random RNG = new Random();
    ArrayList<String> wordsAdded = new ArrayList<String>();
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid g = new WordGrid(20,20);
	g.loadWordsFromFile("Words.txt",false);
	System.out.println("Find these words:\n" + g.wordsInPuzzle());
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
    public void setSeed(long seed){
	RNG.setSeed(seed);
    }
    /**Set all values in the WordGrid to underscores ' '*/
    private void clear(){
	for(int a = 0;a < data.length;a++){
	    for(int b = 0;b < data[a].length;b++)
		data[a][b] = '_';
	}
    }
    /**Adds a random letter to each underscore in the WordGrid
     */
    public void addRandomLetters(){
	Random RNG = new Random();
	for(int a = 0;a < data.length;a++){
	    for(int b = 0;b < data[a].length;b++){
		if(data[a][b] == '_')
		    data[a][b] = (char)('A' + RNG.nextInt(26));
	    }
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
    public String wordsInPuzzle(){
	String words = "";
	for(int x = 0;x < wordsAdded.size();x++){
	    for(int i = 0;i < 15 - wordsAdded.get(x).length();i++)
		words += " ";
	    words += wordsAdded.get(x);
	    if(x%4 == 3)
		words += "\n";
	}
	return words;
    }
    /**Sets the seed of the Random object.
     *@param seed is the number you want the seed of Random object to be.
     */
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is the word to be added to the WordGrid.
     *@param row is the vertical location that you want the word to start at.
     *@param col is the horizontal location that you want the word to start at.
     *@param dir is the angle you want the word to be added in, in degrees.
     *dir must be divisible by 45. Also, remember that down is positive.
     *@return true when the word is added successfully and false if otherwise.
     */
    public boolean addWord(String word,int row,int col,int dir){
	int xdir = (int)Math.round(Math.cos(dir * Math.PI / 180));
	int ydir = (int)Math.round(Math.sin(dir * Math.PI / 180));
	if(dir %45 != 0 || row + word.length() * ydir < -1 || row + word.length() * ydir> data.length || col + word.length() * xdir < -1 || col + word.length() * xdir> data[0].length)
	    return false;
	for(int x = 0;x < word.length();x++){
	    if(data[row][col] == '_'){
		data[row][col] = word.charAt(x);
		row += ydir;
		col += xdir;
	    }else{
		for(;x > 0;x--){
		    row -= ydir;
		    col -= xdir;
		    data[row][col] = '_';
		}
		return false;
	    }
	}
	return true;
    }
    /**Takes a text file filed with words and puts them into the WordGrid.
     *@param fileName is the name of the file you wish to read.
     *@param fillRandomLetters is used to decide whether or not to add
     *random letters to empty spaces.
     */
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
	ArrayList<String> words = new ArrayList<String>();
	File inFile = new File(fileName);
	Scanner in = new Scanner(inFile);
	while(in.hasNextLine())
	    words.add(in.nextLine());
	for(int x = 0;x < words.size();x++){
	    for(int a = 0;a < 100;a++){
		if(addWord(words.get(x),RNG.nextInt(data.length),RNG.nextInt(data.length),45 * RNG.nextInt(8))){
		    wordsAdded.add(words.get(x));
		    break;
		}
	    }
	}
	if(fillRandomLetters)
	    addRandomLetters();
    }
}
    
