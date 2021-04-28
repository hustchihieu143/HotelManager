
package quanlikhachsan.Model;

import java.sql.Date;

public class BookRoom_Model {
    public int bookRoom_ID;
    public int Customer_ID;
    public String dateStart;
    public String dateEnd;
    public int dayCount;
    public int personCount;
    public int roomCount;
    public int prepay;
    public String note;

    public BookRoom_Model(int bookRoom_ID, int Customer_ID, String dateStart, String dateEnd, int dayCount, int personCount, int roomCount, int prepay, String note) {
        this.bookRoom_ID = bookRoom_ID;
        this.Customer_ID = Customer_ID;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.dayCount = dayCount;
        this.personCount = personCount;
        this.roomCount = roomCount;
        this.prepay = prepay;
        this.note = note;
    }

    public BookRoom_Model() {
    }
    
}
