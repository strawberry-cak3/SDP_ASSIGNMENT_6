package model;

public class Hero implements GameUnit {
    private String name;
    private int armor;
    private int netWorth;

    public Hero(String name, int armor, int netWorth) {
        this.name = name;
        this.armor = armor;
        this.netWorth = netWorth;
    }

    public String getName() { return name; }
    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }
    public int getNetWorth() { return netWorth; }

    @Override
    public void accept(GameVisitor visitor) {
        visitor.visitHero(this); // Двойная диспетчеризация
    }
}
