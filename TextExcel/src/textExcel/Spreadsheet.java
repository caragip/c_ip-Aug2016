package textExcel;
import java.io.*;
import java.util.*;

public class Spreadsheet implements Grid
{
	
	private Cell [] [] textexcel;
	public Spreadsheet () {
		textexcel = new Cell [12] [20];
		for (int i = 0; i < 12; i++){
			for (int j = 0; j< 20; j++){
				textexcel [i][j] = new EmptyCell(); // creates the 12x20 spreadsheet and fills with empty cells
			}
		}
		
	}
	
	
	public String processCommand(String command) {

		if (command.length() == 0){
			return "";
		}
		String [] words = command.split(" ",3);
	//clear cells
		if(words[0].equalsIgnoreCase("clear")){
			clearCell(words);
			return getGridText();
		}
	//set cell values
		if (words.length>2){
			if (words[1].equals("=")){
				setCell(words);
				return getGridText();
			}
		}
	//save files
		if(words[0].equalsIgnoreCase("save")){
				return save(words[1]);		
		}
	//open files
		if(words[0].equalsIgnoreCase("open")){
			return open(words[1]);
		}
	//inspect cells
		SpreadsheetLocation inspectIt = new SpreadsheetLocation(words[0]);
		return getCell(inspectIt).fullCellText();
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

	public String getGridText() // creates spreadsheet with characters
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
	
	public void clearCell(String[] clear){
		if(clear.length == 2){
			SpreadsheetLocation clearcell = new SpreadsheetLocation(clear[1]);
			textexcel[clearcell.getCol()][clearcell.getRow()] = new EmptyCell();
		}
		else{
			for(int i = 0; i < 12; i++){
				for (int j = 0; j < 20; j++){
					textexcel[i][j] = new EmptyCell();
				}
			}
		}
		return;
	}

	
	public void setCell(String[] values){
		SpreadsheetLocation cell = new SpreadsheetLocation(values[0]);
		String cellValue;
		cellValue = values[2];
		if(values[1].equals("PercentCell")){
			double value = Double.parseDouble(cellValue)*100.0;
			cellValue = value + "%";
		}
		if(cellValue.indexOf("\"")>=0){		
			cellValue = cellValue.substring(1, cellValue.length()-1);
			textexcel[cell.getCol()][cell.getRow()] = new TextCell(cellValue);
		}
		else if(cellValue.indexOf("%")>=0){
			textexcel[cell.getCol()][cell.getRow()] = new PercentCell(cellValue.substring(0,cellValue.length()-1));
		}
		else if(cellValue.indexOf("(")>=0){
			textexcel[cell.getCol()][cell.getRow()] = new FormulaCell(cellValue, textexcel);
		}
		else{
			textexcel[cell.getCol()][cell.getRow()] = new ValueCell(cellValue);
		}
		return;
	}
	
	private String save(String filename){
		PrintStream outputFile;
		try {
		outputFile = new PrintStream(new File(filename));
		}
		catch (FileNotFoundException e) {
		return "File not found: " + filename;
		}
			for(int i = 0; i < 12; i++){
				for (int j = 0; j < 20; j++){
					if(!(textexcel[i][j] instanceof EmptyCell)){
						char letter = (char) ('A' + i);
						outputFile.print(letter+""+(j+1)+",");
						if(textexcel[i][j] instanceof PercentCell){
							outputFile.println("PercentCell,"+ textexcel[i][j].fullCellText());
						}
						else if(textexcel[i][j] instanceof ValueCell){
							outputFile.println("ValueCell,"+ textexcel[i][j].fullCellText());
						}
						else if(textexcel[i][j] instanceof TextCell){
							outputFile.println("TextCell,"+ textexcel[i][j].fullCellText());
						}
						else if(textexcel[i][j] instanceof FormulaCell){
							outputFile.println("FormulaCell,"+ textexcel[i][j].fullCellText());
						}
					}
				}
			}	
		outputFile.close();
		return getGridText();
	}
	private String open(String filename){
	     Scanner inputFile;
	     try {
	        inputFile = new Scanner(new File(filename));
	     }
	     catch (FileNotFoundException e) {
	            return "File not found: " + filename;
	     }
	     String[] values;
	     while(inputFile.hasNextLine()){
	    	 String stuff = inputFile.nextLine();
	    	 values = stuff.split(",");
	    	 setCell(values);
	     }
	     inputFile.close();

	     return getGridText();

	}

}


