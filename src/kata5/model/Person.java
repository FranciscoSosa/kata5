package kata5.model;

public class Person {
    private String name;
    private String address;
    private Mail email;

    public Person(String name, String address, Mail email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Mail getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(Mail email) {
        this.email = email;
    }
    
    
}
