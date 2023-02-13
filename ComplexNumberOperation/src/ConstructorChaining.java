class Person {
    private String name;
    private String email;
    private int age;

    Person(String name) {
        this.name = name;
    }
    Person(String name, String email) {
//        this.name = name;
//        To remove code duplication we can do this
        this(name);
        this.email = email;
    }
    Person(String name, String email, int age) {
//        this.name = name;
//        this.email =
        this(name, email);
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public int getAge() {
        return this.age;
    }

    public void printInfo() {
        System.out.printf("Name: %s Email: %s Age: %d\n", this.name, this.email, this.age);
    }
}

class Student extends Person {
    String program;
    Student(String name) {
        super(name);
        this.program = "1st Year";
    }
    Student(String name, String email) {
        super(name, email);
        this.program = "Final Year";
    }

    public void printStudentInfo() {
        System.out.printf("Name: %s Email: %s Age: %d Program: %s\n", super.getName(),
                super.getEmail(),
                super.getAge(),
                this.program);
    }
}
public class ConstructorChaining {
    public static void main(String[] args) {
        Person person1 = new Person("Osman");
        Person person2 = new Person("Osman Goni", "abc@gmail.com");
        Person person3 = new Person("Mohammed Osman Goni", "goni@dsi.com", 33);

        person1.printInfo();
        person2.printInfo();
        person3.printInfo();

        Student student1 = new Student("Ahsan Habib");
        Student student2 = new Student("Sohag Alam", "sohag@ka.com");

        student1.printStudentInfo();
        student2.printStudentInfo();
    }
}
