class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}

abstract class Account {
    private String username;
    private String password;

    public Account(String username, String password) throws InvalidAccountException {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidAccountException("Username or password cannot be null or empty!");
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

    public abstract void login(String inputUser, String inputPass) throws InvalidAccountException;
}

class GoogleAccount extends Account {
    public GoogleAccount(String username, String password) throws InvalidAccountException {
        super(username, password);
    }

    @Override
    public void login(String inputUser, String inputPass) throws InvalidAccountException {
        if (!getUsername().equals(inputUser) || !getPassword().equals(inputPass)) {
            throw new InvalidAccountException("Google login failed: Incorrect credentials!");
        }
        System.out.println("Google account logged in successfully.");
    }
}

class FacebookAccount extends Account {
    public FacebookAccount(String username, String password) throws InvalidAccountException {
        super(username, password);
    }

    @Override
    public void login(String inputUser, String inputPass) throws InvalidAccountException {
        if (!getUsername().equals(inputUser) || !getPassword().equals(inputPass)) {
            throw new InvalidAccountException("Facebook login failed: Incorrect credentials!");
        }
        System.out.println("Facebook account logged in successfully.");
    }
}

class TwitterAccount extends Account {
    public TwitterAccount(String username, String password) throws InvalidAccountException {
        super(username, password);
    }

    @Override
    public void login(String inputUser, String inputPass) throws InvalidAccountException {
        if (!getUsername().equals(inputUser) || !getPassword().equals(inputPass)) {
            throw new InvalidAccountException("Twitter login failed: Incorrect credentials!");
        }
        System.out.println("Twitter account logged in successfully.");
    }
}

public class accountLoginSystem {
    public static void main(String[] args) {
        try {
            Account google = new GoogleAccount("user1@gmail.com", "pass123");
            Account facebook = new FacebookAccount("user2", "fbpass");
            Account twitter = new TwitterAccount("user3", "twpass");

            google.login("user1@gmail.com", "pass123");
            facebook.login("user2", "fbpass");
            twitter.login("user3", "twpass");



        } catch (InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


