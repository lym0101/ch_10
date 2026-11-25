import java.util.Scanner;
class Fraction {
    // Instance Variable(attributes, fields)

    private int numerator, denominator;

    // Constructor
    public Fraction() { // default
        numerator = 1;
        denominator = 1;
        setNum(1);
        setDenom(1);
    }

    public Fraction(String s) {
        int index = s.indexOf("/") + 1;
        setNum(Integer.parseInt(s.substring(0, index)));
        setDenom(Integer.parseInt(s.substring(index + 1)));
        System.out.println("Fraction Created: " + numerator + "/" + denominator);
    }

    public Fraction(Fraction f) {
        numerator = (int) Math.random() * 9 + 1;
        denominator = (int) Math.random() * 9 + 1;
    }

    public Fraction(int n, int d) { // parameterized constructor
        numerator = n;
        if (d != 0)
            denominator = d;
        else {
            denominator = 1;
            System.out.println("Error: Denominator can't be zero");
        }
    }

    // Behaviour methods(accessor,mutator, helper)
    public int getNum() {
        return numerator;
    }
    public int getDenom() {
        return denominator;
    }
    public String toString() {
        return numerator + "/" + denominator;
    }
    public double toDouble() {
        return (double) numerator / denominator;
    }

    // mutator methods
    public void setNum(int n) {
        numerator = n;
    }
    public void setDenom(int d) {
        if (d != 0)
            denominator = d;
        else {
            denominator = 1;
            System.out.println("Error: Denominator can't be zero");
        }
    }

    public static Fraction mult(Fraction a, Fraction b) {
        int n = a.getNum() * b.getNum();
        int d = a.getDenom() * b.getDenom();
        return new Fraction(n, d);
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        // (a/b) ÷ (c/d) = (a*d) / (b*c) - multiply by the reciprocal
        int num = f1.numerator * f2.denominator;
        int den = f1.denominator * f2.numerator;
        Fraction result = new Fraction(num, den);
        result.reduce();
        return result;
    }
    public static Fraction add(Fraction f1, Fraction f2) {
        // (a/b) + (c/d) = (a*d + c*b) / (b*d)
        int num = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int den = f1.denominator * f2.denominator;
        Fraction result = new Fraction(num, den);
        result.reduce();
        return result;
    }
    public static Fraction subtract(Fraction f1, Fraction f2) {
        // (a/b) − (c/d) = (a*d − c*b) / (b*d)
        int num = f1.numerator * f2.denominator - f2.numerator * f1.denominator;
        int den = f1.denominator * f2.denominator;
        Fraction result = new Fraction(num, den);
        result.reduce();
        return result;
    }

    // helper method
    public int GCF(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public void reduce() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;

        if (gcd != 0) {
            numerator /= gcd;
            denominator /= gcd;
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
}

public class FractionQuiz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int correct = 0;
        int incorrect = 0;
        char[] op = {'+', '-', '*', '/'};
        System.out.println(
            "Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
        while (true) {
            Fraction fr1 = new Fraction((int)(Math.random() + 9 + 1));
            Fraction fr2 = new Fraction((int)(Math.random() + 9 + 1));
            int ops = (int) (Math.random() * 4);
            System.out.println(fr1.toString() + " " + op[ops] + " " + fr2.toString());
            Fraction ans = null;
            if (op[ops] == '+') {
				ans = Fraction.add(fr1,fr2);
			}
			if (op[ops] == '-') {
				ans = Fraction.subtract(fr1,fr2);
			}
			if (op[ops] == '*') {
				ans= Fraction.mult(fr1,fr2);
			}
			if (op[ops] == '/') {
				ans = Fraction.divide(fr1,fr2);
			}
			String inputString = in.nextLine();
        }
    }
}
