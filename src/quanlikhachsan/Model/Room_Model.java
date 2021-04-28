
package quanlikhachsan.Model;

public class Room_Model {
    public String roomID;
    public String type_Room; //loai phong
    public String kind_Room; //kieuphong
    public int price_Room;
    public String status_Room;
    public String note_Room;

    public Room_Model() {
    }

    public Room_Model(String roomID, String type_Room, String kind_Room, int price_Room, String status_Room, String note_Room) {
        this.roomID = roomID;
        this.type_Room = type_Room;
        this.kind_Room = kind_Room;
        this.price_Room = price_Room;
        this.status_Room = status_Room;
        this.note_Room = note_Room;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getType_Room() {
        return type_Room;
    }

    public void setType_Room(String type_Room) {
        this.type_Room = type_Room;
    }

    public String getKind_Room() {
        return kind_Room;
    }

    public void setKind_Room(String kind_Room) {
        this.kind_Room = kind_Room;
    }

    public int getPrice_Room() {
        return price_Room;
    }

    public void setPrice_Room(int price_Room) {
        this.price_Room = price_Room;
    }

    public String getStatus_Room() {
        return status_Room;
    }

    public void setStatus_Room(String status_Room) {
        this.status_Room = status_Room;
    }

    public String getNote_Room() {
        return note_Room;
    }

    public void setNote_Room(String note_Room) {
        this.note_Room = note_Room;
    }
    
    
}
