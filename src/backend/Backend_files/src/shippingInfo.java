public class shippingInfo {
    private int shippingId;
    private int userId;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    // Corrected constructor
    public shippingInfo(int shippingId, int userId, String fullName, 
                      String address, String city, String state, String zipCode) {
        this.shippingId = shippingId;
        this.userId = userId;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters
    public int getShippingId() { return shippingId; }
    public int getUserId() { return userId; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
}