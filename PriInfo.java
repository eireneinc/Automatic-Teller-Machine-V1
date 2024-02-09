package atm.inheritance;

public class PriInfo {
    private double balance = 20000.36;
    private String[] accountNumbers = {"125870", "789456", "996687", "225588", "335574"};
    private String[] idNumbers = {"SA125870", "SA789456", "SA996687", "SA225588", "SA335574"};

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber(int index) {
        return accountNumbers[index];
    }

    public String getIdNumber(int index) {
        return idNumbers[index];
    }
}
