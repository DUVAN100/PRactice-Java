package Library;

public class User {
    private String name;
    private String cardId;
    private String lastName;

    public User(String name, String cardId, String lastName) {
        this.name = name;
        this.cardId = cardId;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
