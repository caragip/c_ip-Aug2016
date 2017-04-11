package textExcel;

public class RealCell implements Cell {

	private String text;
	private double doubleValue;
	 
	public RealCell(String value){
		text = value; //make decimal value
		if(value.indexOf("(")<0){
			doubleValue = Double.parseDouble(value);
		}
	}
	
	public String abbreviatedCellText() {
		String abv = text;
		while(abv.length()<10){
			abv = abv + " ";
		}
		if(abv.length()>10){
			abv = abv.substring(0, 10);
		}
		return abv;
	}

	public String fullCellText() {
		return text;
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}

}
