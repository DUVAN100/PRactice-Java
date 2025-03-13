
package Models;

/**
 * ClientDao class provides CRUD operations for the Client model.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */

public class Client extends BaseModel{
    private String adress;

    public Client(int id, String name, String email, String phone, String adress) {
        super(id, name, email, phone);
        this.adress = adress;
    }

    public Client(String name, String email, String phone, String adress) {
        super(name, email, phone);
        this.adress = adress;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
