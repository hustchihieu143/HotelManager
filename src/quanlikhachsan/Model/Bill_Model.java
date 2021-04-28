
package quanlikhachsan.Model;

public class Bill_Model {
    public int billID;
    public int registeredID;
    public String date;
    public String staff;
    public int total;
    public int vat;
    public int total_vat;

    public Bill_Model(int billID, int registeredID, String date, String staff, int total, int vat, int total_vat) {
        this.billID = billID;
        this.registeredID = registeredID;
        this.date = date;
        this.staff = staff;
        this.total = total;
        this.vat = vat;
        this.total_vat = total_vat;
    }

    public Bill_Model() {
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getRegisteredID() {
        return registeredID;
    }

    public void setRegisteredID(int registeredID) {
        this.registeredID = registeredID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getTotal_vat() {
        return total_vat;
    }

    public void setTotal_vat(int total_vat) {
        this.total_vat = total_vat;
    }
    
    
}
