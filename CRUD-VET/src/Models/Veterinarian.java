package Models;

/**
 * ClientDao class provides CRUD operations for the Client model.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */
public class Veterinarian extends BaseModel{
    private String speciality;

    public Veterinarian(int id, String name, String email, String phone, String specialty) {
        super(id, name, email, phone);
        this.speciality = specialty;
    }

    public Veterinarian(String name, String email, String phone, String specialty) {
        super(name, email, phone);
        this.speciality = specialty;
    }

    public String getSpecialty() {
        return speciality;
    }

    public void setSpecialty(String specialty) {
        this.speciality = specialty;
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
               "\n ID         : " + id +
               "\n Speciality : " + speciality +
               "\n Name       : " + name +
               "\n Email      : " + email +
               "\n Phone      : " + phone +
               "\n==========================";
    }
}
