package Models;

/**
 *
 * @author Duvan Y
 */
public abstract class BaseModel {
    protected int id;
    protected String name;
    protected String email;
    protected String phone;

    public BaseModel(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public BaseModel(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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
    
    @Override
    public String toString() {
        return "\n==========================" +
               "\n ID       : " + id +
               "\n Name     : " + name +
               "\n Email    : " + email +
               "\n Phone    : " + phone +
               "\n==========================";
    }
}
