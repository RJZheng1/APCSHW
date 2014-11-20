public class WordGrid{
    private char[][] data;
    /**Initializes a grid of the specified size and fills all of the positions 
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
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
}
