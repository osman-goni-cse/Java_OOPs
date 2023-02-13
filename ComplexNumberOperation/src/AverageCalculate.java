class Chatro {
    String name;
    double marks[];

    Chatro(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public void displayAverage() {
        System.out.println("Average is "+ totalMarks() / this.marks.length);
    }

    public double totalMarks() {
        double sum = 0.0;
        for (double mark: marks) {
            sum += mark;
        }
        return sum;
    }
}
public class AverageCalculate {
    public static void main(String[] args) {

        Chatro chatro1 = new Chatro("Tahsin", new double[] {85.3, 65.3, 78.0, 54.3, 23.2});

        chatro1.displayAverage();

    }
}
