package textExcel;

public class ValueCell extends RealCell implements Cell {
	
	private String text;
	
	public ValueCell (String text){ 
		super (text);
		this.text = text;
	}
	
	public String abbreviatedCellText() {

		String abv = getValue(text)+"";
		abv += "          ";
		return abv.substring(0,10);
		
	}

	public String fullCellText() { // integer to double
		if (text.indexOf(".")<0){ 
			return text;
		}
		return getValue(text)+"";
	}
	
	public double getValue(String text){
		return super.getDoubleValue(text);
	}
	


}