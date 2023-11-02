package BE;

public class User {
    private String name;
    private String ntuNetworkId;
    private String password;
    private String faculty;

    public User(String name, String ntuNetworkId, String faculty) {
        this.name = name;
        this.ntuNetworkId = ntuNetworkId;
        this.password = "password";//default password
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNtuNetworkId() {
        return ntuNetworkId;
    }

    public void setNtuNetworkId(String ntuNetworkId) {
        this.ntuNetworkId = ntuNetworkId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static void main(String[] args) {
    }
}
