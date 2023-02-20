import java.util.ArrayList;

class Client {
    private final String name;
    private final int hoursWorked;

    Client(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
}

//class PayCalculator {
//    private static final double HOURLY_RATE = 70;
//    private static final double FIXED_PAY = 550;
//
//    public double getPay(Client client, String method) {
//        return switch (method) {
//            case "HOURLY" -> client.getHoursWorked() * HOURLY_RATE;
//            case "FIXED" -> FIXED_PAY;
//            default ->  throw new IllegalArgumentException(
//                    "Unknown method: "+method
//            );
//        };
//    }
//}
abstract class PayCalculator {
    public abstract double getPay(Client client);
}

class HourlyPayCalculator extends PayCalculator {
    private final double hourlyRate;

    public HourlyPayCalculator(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double getPay(Client client) {
        return hourlyRate * client.getHoursWorked();
    }
}

class FixedPayCalculator extends PayCalculator {
    private double fixedPay;

    public FixedPayCalculator(double fixedPay) {
        this.fixedPay = fixedPay;
    }

    @Override
    public double getPay(Client client) {
        return fixedPay;
    }
}

class HrManager {
    private ArrayList<Client> clients = new ArrayList<>();
    private PayCalculator payCalculator;
    public HrManager(PayCalculator payCalculator) {
        this.payCalculator = payCalculator;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public double getTotalPay() {
        double total = 0.0;
        for(Client client: clients) {
            total += payCalculator.getPay(client);
        }
        return total;
    }
}

public class ClientPayment {
    public static void main(String[] args) {
        System.out.println("Pay Calculator for Client");

        PayCalculator hourlyCalculator = new HourlyPayCalculator(75);
        PayCalculator fixedCalculator = new FixedPayCalculator(625);

        HrManager hrManager = new HrManager(hourlyCalculator);
        HrManager hrManager1 = new HrManager(fixedCalculator);

        Client client0 = new Client("DSi", 15);
        Client client1 = new Client("Therap", 23);

        hrManager.addClient(client0);
        hrManager.addClient(client1);

        hrManager1.addClient(client0);
        hrManager1.addClient(client1);

        double hourlyTotalPay = hrManager.getTotalPay();
        double fixedtotalPay = hrManager1.getTotalPay();
//        double hourlyTotalPay = hrManager.getTotalPay();
        System.out.println("Total Fixed Pay: "+fixedtotalPay);
        System.out.println("Total Hourly Pay: "+hourlyTotalPay);
    }
}
