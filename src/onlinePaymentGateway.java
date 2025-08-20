class InvalidCurrencyException extends Exception {
    InvalidCurrencyException(String msg) {
        super(msg);
    }
}
abstract class Payment{
    private long amount;

    public void setAmount(long amount) throws InvalidCurrencyException{
        if(amount<=0){
            throw new InvalidCurrencyException("Currency amount invalid");
        }
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
    public Payment(long amount) throws InvalidCurrencyException{
        setAmount(amount);
    }
    abstract void processPayment();
}
class CreditCard extends Payment{
    public CreditCard(long amount) throws InvalidCurrencyException{
        super(amount);
        if(amount<2){
            throw new InvalidCurrencyException("Sum is too small for Credit card");
        }
    }
    void processPayment(){
        System.out.println("Money transfered after service from Creditcard : "+(getAmount()-1.5)+"RS");
    }
}
class UPI extends Payment{
    public UPI(long amount) throws InvalidCurrencyException{
        super(amount);
        if(amount<6){
            throw new InvalidCurrencyException("Sum is too small for UPI");
        }
    }
    void processPayment(){
        System.out.println("Money transfered after service from UPI : "+(getAmount()-5)+"RS");
    }
}
class NetBanking extends Payment{
    public NetBanking(long amount) throws InvalidCurrencyException{
        super(amount);
        if(amount<11){
            throw new InvalidCurrencyException("Sum is too small for Net Banking");
        }
    }
    void processPayment(){
        System.out.println("Money transfered after service : "+(getAmount()-10)+"RS");
    }
}



public class onlinePaymentGateway {
    public static void main(String[] args) {
        try{
            Payment p = new UPI(24);
            p.processPayment();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
