package textExcel;

public class PercentCell implements Cell {

private String text;
	
	public PercentCell (String text){
		this.text = text;
	}
	
	public String abbreviatedCellText() {
		String abrv = "";
		if (text.indexOf(".")>0){ // checks for decimal for percent cell
			abrv = text.substring(0, text.indexOf(".")); 
		}
		abrv += "%         "; // pads
		return abrv.substring(0,10);
	}

	public String fullCellText() { 

		return GetValue(text)+"";
	}
	
	public double GetValue (String text){
		return Double.parseDouble(text.substring(0, text.length()-1))/100; //change into decimal 
		
	}

}