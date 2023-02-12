class ComplexNumber {
    private final double real_part;
    private final double imaginary_part;

    public ComplexNumber(double real_part, double imaginary_part) {
        this.real_part = real_part;
        this.imaginary_part = imaginary_part;
    }

    public ComplexNumber plus(ComplexNumber b) {
        double real = this.real_part + b.real_part;
        double imag = this.imaginary_part + b.imaginary_part;

        return new ComplexNumber(real, imag);
    }

    public ComplexNumber minus(ComplexNumber b) {
        double real = this.real_part - b.real_part;
        double imag = this.imaginary_part - b.imaginary_part;

        return new ComplexNumber(real, imag);
    }

    public String toString() {
        if(imaginary_part == 0) return real_part + "";
        if (real_part == 0) return  imaginary_part + "i";
        if(imaginary_part < 0) return real_part + " - " + (-imaginary_part) + "i";
        return real_part + "+" + imaginary_part + "i ";
    }
}
public class Main {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(5.0, 7.0);
        ComplexNumber b = new ComplexNumber(-3.0, 4.0);

        System.out.println("a\t"+ a);
        System.out.println("b\t"+b);
        System.out.println("a+b = "+a.plus(b));
        System.out.println("a-b = "+a.minus(b));
        System.out.println();
        System.out.println("Hello world!");
    }
}