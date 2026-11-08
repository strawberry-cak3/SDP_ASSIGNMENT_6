package model;

public class Creep implements GameUnit {
    private String type; // например, "Melee", "Ranged"
    private int armor;
    private int netWorth;

    public Creep(String type, int armor, int netWorth) {
        this.type = type;
        this.armor = armor;
        this.netWorth = netWorth;
    }

    public String getType() { return type; }
    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }
    public int getNetWorth() { return netWorth; }

    @Override
    public void accept(GameVisitor visitor) {
        visitor.visitCreep(this); // Двойная диспетчеризация
    }
}