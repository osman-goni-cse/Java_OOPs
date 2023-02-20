
interface Payment {
    double getAmount();
}

class PaymentEngine {
    public void accept(Payment payment) {
        System.out.println("Accepting Payment: "+payment.getAmount());
    }
}

class BkashPayment implements Payment {
    private final double amount;
    public BkashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        System.out.println("Taking Bkash Payment");
        return amount;
    }

}

class CashPayment implements Payment {
    private final double amount;


    public CashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        System.out.println("Taking Cash Payment");
        return amount;
    }
}
public class PaymentIntegration {
    public static void main(String[] args) {
        PaymentEngine paymentEngine = new PaymentEngine();

        BkashPayment bkashPayment = new BkashPayment(100);
        paymentEngine.accept(bkashPayment);

        CashPayment cashPayment = new CashPayment(150);
        paymentEngine.accept(cashPayment);


    }
}
