public class BillingInfo {
    private int userId;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String cardNumber;
    private String cardExpiry;
    private String cardCvv;

    // Constructor
    public BillingInfo(int userId, String fullName, String address, String city, String state, String zipCode,
                       String cardNumber, String cardExpiry, String cardCvv) {
        this.userId = userId;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCvv = cardCvv;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public String getCardCvv() {
        return cardCvv;
    }
}
