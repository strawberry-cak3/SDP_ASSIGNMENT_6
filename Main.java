import model.*;
import structure.*;
import visitor.*;

public class Main {
    public static void main(String[] args) {
        DotaBattlefield battlefield = new DotaBattlefield();

        battlefield.addUnit(new Hero("Anti-Mage", 6, 12500));
        battlefield.addUnit(new Hero("Juggernaut", 8, 11000));
        battlefield.addUnit(new Creep("Melee Creep", 2, 40));
        battlefield.addUnit(new Creep("Ranged Creep", 0, 50));

        System.out.println("--- Applying Armor Reduction (e.g., Desolator / Blight Stone) ---");
        GameVisitor armorVisitor = new ArmorReductionVisitor(3);
        battlefield.accept(armorVisitor);

        System.out.println("\n--- Calculating Total Team/Map Net Worth ---");
        NetWorthCalculationVisitor netWorthVisitor = new NetWorthCalculationVisitor();
        battlefield.accept(netWorthVisitor);
        System.out.println("Total Net Worth on field: " + netWorthVisitor.getTotalNetWorth());
    }
}
