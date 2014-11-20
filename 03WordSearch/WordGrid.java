public class WordGrid{
    private char[][]data;
    public static void main(String[]args){
	WordGrid g = new WordGrid(13,13);
	System.out.println(g);
	g.addWordHorizontal("DUCK",0,0);
	System.out.println(g);
	g.addWordVertical("CHICKEN",0,2);
	System.out.println(g);
	g.addWordDiagonal("TURKEY",2,2);
	System.out.println(g);
	g.addWordHorizontal("TURDUCKEN",0,13);
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
    /**Sets all the values in the WordGrid to spaces.*/
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
     *@return true when the word is added successfully and false if otherwise.
     */
    public boolean addWordHorizontal(String word,int row,int col){
	if(row >= 0 && row < data.length && col >= 0 && col + word.length() < data[0].length){
	    for(int x = 0;x < word.length();x++){
		if(data[row][col + x] == ' ')
		    data[row][col + x] = word.charAt(x);
		else if(data[row][col + x] != word.charAt(x)){
		    for(;x > 0;x--)
			data[row][col + x - 1] = ' ';
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any word to be added to the WordGrid.
     *@param row is the vertical location that you want the word to start at.
     *@param col is the horizontal location that you want the word to start at.
     *@return true when the word is added successfully and false if otherwise.
     */
    public boolean addWordVertical(String word,int row,int col){
	if(row >= 0 && row + word.length() < data.length && col >= 0 && col < data.length){
	    for(int x = 0;x < word.length();x++){
		if(data[row + x][col] == ' ')
		    data[row + x][col] = word.charAt(x);
		else if(data[row + x][col] != word.charAt(x)){
		    for(;x > 0;x--)
			data[row][col + x - 1] = ' ';
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }	   
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any word to be added to the WordGrid.
     *@param row is the vertical location that you want the word to start at.
     *@param col is the horizontal location that you want the word to start at.
     *@return true when the word is added successfully and false if otherwise.
     */
    public boolean addWordDiagonal(String word,int row,int col){
	if(row >= 0 && row + word.length() < data.length && col >= 0 && col + word.length() < data[0].length){
	    for(int x = 0;x < word.length();x++){
		if(data[row + x][col + x] == ' ')
		   data[row + x][col + x] = word.charAt(x);
		else if(data[row + x][col + x] != word.charAt(x)){
		    for(;x > 0;x--)
			data[row + x - 1][col + x - 1] = ' ';
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
}
