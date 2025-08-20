class InvalidCredentialException extends Exception {
    public InvalidCredentialException(String message) {
        super(message);
    }
}

abstract class User {
    private String username;
    private String password;

    public User(String username, String password) throws InvalidCredentialException {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidCredentialException("Username or Password cannot be null or empty!");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract void login(String inputUser, String inputPass) throws InvalidCredentialException;
}

class Admin extends User {
    public Admin(String username, String password) throws InvalidCredentialException {
        super(username, password);
    }

    @Override
    public void login(String inputUser, String inputPass) throws InvalidCredentialException {
        if (!getUsername().equals(inputUser) || !getPassword().equals(inputPass)) {
            throw new InvalidCredentialException("Admin login failed: Incorrect credentials!");
        }
        System.out.println("Admin logged in successfully.");
    }
}

class Editor extends User {
    public Editor(String username, String password) throws InvalidCredentialException {
        super(username, password);
    }

    @Override
    public void login(String inputUser, String inputPass) throws InvalidCredentialException {
        if (!getUsername().equals(inputUser) || !getPassword().equals(inputPass)) {
            throw new InvalidCredentialException("Editor login failed: Incorrect credentials!");
        }
        System.out.println("Editor logged in successfully.");
    }
}

class Viewer extends User {
    public Viewer(String username, String password) throws InvalidCredentialException {
        super(username, password);
    }

    @Override
    public void login(String inputUser, String inputPass) throws InvalidCredentialException {
        if (!getUsername().equals(inputUser) || !getPassword().equals(inputPass)) {
            throw new InvalidCredentialException("Viewer login failed: Incorrect credentials!");
        }
        System.out.println("Viewer logged in successfully.");
    }
}

public class userLoginSystem {
    public static void main(String[] args) {
        try {
            User admin = new Admin("adminUser", "admin123");
            User editor = new Editor("editUser", "edit123");
            User viewer = new Viewer("viewUser", "view123");

            admin.login("adminUser", "admcin123");
            editor.login("editUser", "edit123");
            viewer.login("viewUser", "view123");



        } catch (InvalidCredentialException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}





