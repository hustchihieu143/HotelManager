package quanlikhachsan.Model;

public class Customer_Model {

    public int customer_ID;
    public String customer_Name;
    public String customer_IDCard;
    public String customer_Sex;
    public String customer_Address;
    public String customer_PhoneNumber;
    public String customer_Nationality;
    public String customer_Email;
    public String customer_Note;

    public Customer_Model() {
    }

    public Customer_Model(int customer_ID, String customer_Name, String customer_IDCard, String customer_Sex, String customer_Address, String customer_PhoneNumber, String customer_Nationality, String customer_Email, String cusString_Note) {
        this.customer_ID = customer_ID;
        this.customer_Name = customer_Name;
        this.customer_IDCard = customer_IDCard;
        this.customer_Sex = customer_Sex;
        this.customer_Address = customer_Address;
        this.customer_PhoneNumber = customer_PhoneNumber;
        this.customer_Nationality = customer_Nationality;
        this.customer_Email = customer_Email;
        this.customer_Note = cusString_Note;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCustomer_IDCard() {
        return customer_IDCard;
    }

    public void setCustomer_IDCard(String customer_IDCard) {
        this.customer_IDCard = customer_IDCard;
    }

    public String getCustomer_Sex() {
        return customer_Sex;
    }

    public void setCustomer_Sex(String customer_Sex) {
        this.customer_Sex = customer_Sex;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    public String getCustomer_PhoneNumber() {
        return customer_PhoneNumber;
    }

    public void setCustomer_PhoneNumber(String customer_PhoneNumber) {
        this.customer_PhoneNumber = customer_PhoneNumber;
    }

    public String getCustomer_Nationality() {
        return customer_Nationality;
    }

    public void setCustomer_Nationality(String customer_Nationality) {
        this.customer_Nationality = customer_Nationality;
    }

    public String getCustomer_Email() {
        return customer_Email;
    }

    public void setCustomer_Email(String customer_Email) {
        this.customer_Email = customer_Email;
    }

    public String getCusString_Note() {
        return customer_Note;
    }

    public void setCusString_Note(String cusString_Note) {
        this.customer_Note = cusString_Note;
    }
    

}
