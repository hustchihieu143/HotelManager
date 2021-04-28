/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlikhachsan.Model;

/**
 *
 * @author BVKieu
 */
public class service_Model {

    public int service_ID;
    public String service_Name;
    public int service_Price;
    public String service_Note;

    public service_Model() {
    }

    public service_Model(int service_ID, String service_Name, int service_Price, String service_Note) {
        this.service_ID = service_ID;
        this.service_Name = service_Name;
        this.service_Price = service_Price;
        this.service_Note = service_Note;
    }

    public int getService_ID() {
        return service_ID;
    }

    public void setService_ID(int service_ID) {
        this.service_ID = service_ID;
    }

    public String getSerivce_Name() {
        return service_Name;
    }

    public void setSerivce_Name(String serivce_Name) {
        this.service_Name = serivce_Name;
    }

    public int getService_Price() {
        return service_Price;
    }

    public void setService_Price(int service_Price) {
        this.service_Price = service_Price;
    }

    public String getService_Note() {
        return service_Note;
    }

    public void setService_Note(String service_Note) {
        this.service_Note = service_Note;
    }
}
