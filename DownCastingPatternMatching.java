class Dog {
    public String getBread() {
        return "Unknown";
    }
}

class Poddle extends Dog {
    @Override
    public String getBread() {
        return "Daisy";
    }

    public String getName() {
        return "Daisy";
    }
}

class Bulldog extends Dog {
    @Override
    public String getBread() {
        return "Bulldog";
    }
}

class Dogwalker {
    public void walk(Dog dog) {
        if (dog instanceof Poddle) { // dog instanceof Poddle poddle
            Poddle poddle = (Poddle) dog;
            System.out.println("Walking : "+ poddle.getName());
        }
        else {
            System.out.println("Walking: "+dog.getBread());
        }
    }
}

public class DownCastingPatternMatching {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Poddle();
        Dog dog3 = new Bulldog();

        Dogwalker dogwalker = new Dogwalker();

        dogwalker.walk(dog1);
        dogwalker.walk(dog3);
        dogwalker.walk(dog2);
    }
}
