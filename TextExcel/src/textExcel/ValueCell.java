package textExcel;

public class ValueCell extends RealCell implements Cell {
	
	private String text;
	private double doubleValue;

	public ValueCell(String value){
		super(value);
		text = super.fullCellText();
		if(text.indexOf(".") >= 0 && text.endsWith("00")){
			while (text.endsWith("00")){
				text = text.substring(0, text.length()-1);
			}
			if(Character.isDigit(text.charAt(text.length()-2))){
			text = text.substring(0, text.length()-1);
			}
		}
		doubleValue = Double.parseDouble(value);
	}
	public String abbreviatedCellText() {
		String abv = text;
		if(abv.length()<=8 && abv.indexOf(".")<0){
			abv = abv + ".0";
		}
		while(abv.length()<10){ // pad
			abv = abv + " ";
		}
		if(abv.length()>10){
			abv = abv.substring(0, 10); // truncate
		}
		return abv;
	}

	public String fullCellText() {
		return (text +"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	


} 
}