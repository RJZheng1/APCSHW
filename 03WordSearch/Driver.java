public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	try{
	    if(args != null && args.length > 1){
		WordGrid g = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		if(args.length > 2)
		    g.setSeed(Long.parseLong(args[2]));
		if(args.length > 3 && Integer.parseInt(args[3]) == 1)
		    g.loadWordsFromFile("Words.txt",false);
		else
		    g.loadWordsFromFile("Words.txt",true);
		System.out.println("Find these words:\n" + g.wordsInPuzzle());
		System.out.println(g);
	    }else
		throw new NumberFormatException();
	}catch(NumberFormatException e){
	    System.out.println("Please format your command line in this way:\njava Driver rows cols [randomSeed [answers]]");
	}
    }
}
