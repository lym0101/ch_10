public class FractionDriver {
	public static void main (String[] args) {
		Fraction f1 = new Fraction(1,4);
		Fraction f2 = new Fraction(1,2);
		
		System.out.println(f1);
		System.out.println(Fraction.mult(f1, f2));

		System.out.println(Fraction.add(f1, f2));
		System.out.println(Fraction.divide(f1, f2));
		System.out.println(Fraction.subtract(f1, f2));
	}
}
