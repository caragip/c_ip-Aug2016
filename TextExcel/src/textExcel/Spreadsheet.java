package textExcel;


public class Spreadsheet implements Grid
{
	
	private Cell [] [] textexcel;
	public Spreadsheet () {
		textexcel = new Cell [12] [20];
		for (int i = 0; i < 12; i++){
			for (int j = 0; j< 20; j++){
				textexcel [i][j] = new EmptyCell();
			}
		}
		
	}
	
	
	public String processCommand(String command) {
		
		if (command.length()==0){
			return "";
		}
		
		String [] input = command.split(" ",3);

		if (input[0].toLowerCase().equals("clear")){
			// clear cell
			clearCell(input);
			return getGridText();
		}
		
		else if (input.length > 2){
			//assign value
			checkCell(input);
			return getGridText();
		}
		
		else {
			//inspect cell
			SpreadsheetLocation place = new SpreadsheetLocation(input[0].toUpperCase());
			return getCell(place).fullCellText();
		}
	}
		

	
	
	public int getRows()
	{
		return 20;
	}


	public int getCols()
	{
		return 12;
	}

	public Cell getCell(Location loc)
	{
		return textexcel [loc.getCol()] [loc.getRow()];
		
	}

	public String getGridText()
	{		
		String topline = "   ";
		for (char i = 'A'; i <= 'L'; i++){
			topline += "|" + i + "         ";	
		}
		topline += "|";
		
		String full = "\n";
		
		for (int j = 0; j < 20; j++ ){
			full += ((j+1) + "   ").substring(0, 3);
			full += "|";
			for (int k = 0; k < 12; k++){
				full += textexcel[k][j].abbreviatedCellText() + "|";
			}			
			full += "\n";
		}
		return topline+full;
	}
	
	public void clearCell (String [] input){
		if (input.length > 1){
			SpreadsheetLocation place = new SpreadsheetLocation(input[1].toUpperCase());
			textexcel [place.getCol()] [place.getRow()] = new EmptyCell ();
		}
		else {
			for (int j = 0; j < 20; j++ ){
				for (int k = 0; k < 12; k++){
					textexcel[k][j] = new EmptyCell();
				}			
			}
		}

	}
	
	public void checkCell (String [] input){
		String userInput = input[2]; 
		SpreadsheetLocation placeholder = new SpreadsheetLocation(input[0].toUpperCase());
		if (userInput.charAt(0) == 34){ //if a text cell, take the string between the quotes and fill the array element with a text cell
			String words = input[2].substring(1, (input[2].length()-1));
			textexcel [placeholder.getCol()] [placeholder.getRow()] = new TextCell (words);
		}
		else if (userInput.substring(userInput.length()-1).equals("%")){ //if a percent cell
			textexcel [placeholder.getCol()] [placeholder.getRow()] = new PercentCell (userInput);	
		}
		else if (userInput.substring(userInput.length()-1).equals(")")){ //if a formula cell
			textexcel [placeholder.getCol()] [placeholder.getRow()] = new FormulaCell (userInput);	
		}
		else { // if a value cell
			textexcel [placeholder.getCol()] [placeholder.getRow()] = new ValueCell (userInput);	
		}
}
}
