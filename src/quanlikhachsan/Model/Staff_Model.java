
package quanlikhachsan.Model;

public class Staff_Model {
    public String Name;
    public String userName;
    public String password;

    public Staff_Model() {
    }

    public Staff_Model(String Name, String userName, String password) {
        this.Name = Name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
