public class WordGrid{
    private char[][]data;
    public static void main(String[]args){
	WordGrid g = new WordGrid(13,13);
	System.out.println(g);
	g.addWord("DUCK",0,0,new int[]{1,0});
	System.out.println(g);
	g.addWord("CHICKEN",0,2,new int[]{0,1});
	System.out.println(g);
	g.addWord("TURKEY",1,3,new int[]{1,1});
	System.out.println(g);
	g.addWord("TURDUCKEN",0,13,new int[]{1,1});
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
     *@return true when the word is added successfully and false if otherwise.
     */
    public boolean addWord(String word,int row,int col,int[]dir){
	if(dir == null || dir.length != 2 || dir[0] < -1 || dir[0] > 1 || dir[1] < -1 || dir[1] > 1 || (dir[0] == 0 && dir[1] == 0))
	    return false;
	if(row + word.length() * dir[1] >= 0 && row + word.length() * dir[1] < data.length && col + word.length() * dir[0] >= 0 && col + word.length() * dir[0] < data[0].length){
	    for(int x = 0;x < word.length();x++){
		if(data[row + x * dir[1]][col + x * dir[0]] == ' ')
		    data[row + x * dir[1]][col + x * dir[0]] = word.charAt(x);
		else if(data[row + x * dir[1]][col + x * dir[0]] != word.charAt(x)){
		    for(;x > 0;x--)
			data[row - x * dir[1]][col - x * dir[0]] = ' ';
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
}
