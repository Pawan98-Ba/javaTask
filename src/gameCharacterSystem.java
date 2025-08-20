class InvalidCharacterException extends Exception {
    public InvalidCharacterException(String message) {
        super(message);
    }
}

abstract class Character {
    private String name;
    private int health;
    private String weapon;

    public Character(String name, int health, String weapon) throws InvalidCharacterException {
        if (health <= 0) {
            throw new InvalidCharacterException("Health must be greater than zero!");
        }
        if (weapon == null || weapon.isEmpty()) {
            throw new InvalidCharacterException("Weapon cannot be null or empty!");
        }
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }

    public abstract void attack();
}

class Warrior extends Character {
    public Warrior(String name, int health, String weapon) throws InvalidCharacterException {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " swings a " + getWeapon() + " with brute force!");
    }
}

class Mage extends Character {
    public Mage(String name, int health, String weapon) throws InvalidCharacterException {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " casts a spell with a " + getWeapon() + "!");
    }
}

class Archer extends Character {
    public Archer(String name, int health, String weapon) throws InvalidCharacterException {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " shoots an arrow with a " + getWeapon() + "!");
    }
}

public class gameCharacterSystem {
    public static void main(String[] args) {
        try {
            Character w = new Warrior("Thor", 100, "Sword");
            Character m = new Mage("Gandalf", 80, "Staff");
            Character a = new Archer("Legolas", 90, "Bow");

            w.attack();
            m.attack();
            a.attack();


        } catch (InvalidCharacterException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


