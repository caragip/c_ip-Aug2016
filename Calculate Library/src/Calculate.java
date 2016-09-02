public class Calculate {
	

	public static int square(int number) {
		int answer;
		answer = number * number;
		return answer;
	}
	public static int cube(int number) {
		int answer;
		answer = number * number * number;
		return answer;			
	}
	public static double average(double num1, double num2) {
		double answer;
		answer = (num1 * num2 ) / 2;
		return answer;	
	}
	public static double average2(double num1, double num2, double num3) {
		double answer;
		answer = (num1 * num2 * num3 ) / 3;
		return answer;
	}
	public static double toDegrees(double number) {
		double answer;
		answer = ((number * 180) / 3.14159);
		return answer;
	}
	
	public static double toRadians(double number) {
		double answer;
		answer = ((number * 3.14159) / 180);
		return answer;
	}
	public static double discriminant (double a, double b, double c) {
		double answer;
		answer = ((b * b) - (4 * a * c));
		return answer;
	}

	public static String toImproperFrac(int a, int b, int c){
		int numerator = a * b + c;
		return (numerator + "/" + c);
	}
	public static String toMixedNum(int a, int b) {
		int num = a / b;
		int num2 = a % b;
		return (num + "_" + num2 + "/" + b);		
	}
	public static String foil (int a, int b, int c, int d, String n) {
		String answer = (a * c + n + "^2" + " + " + ((a *d) +(b*c)) + n + " + " + (b*d));	
		return answer;
	}
	public static boolean isDivisibleBy(int a, int b) {
		if (a % b == 0) {
			return true;
		} else { 
			return false;
		}
	}
	public double absValue (double num){
		if (num < 0) {
			return(Math.abs(num));
		} else {
			return num;
		}
	}
	public static int max(int a, int b) {
		if (a < b) {
			return b;
		} else {
			return a;
		}
	}
	public static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
	public static int max3(int a, int b, int c) {
		if (a > b && a > c) {
			return a;
		} else if (b > a &&  b> c) {
			return b;
		} else {
			return c;
		}
	}
}

