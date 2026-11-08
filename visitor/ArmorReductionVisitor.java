// Посетитель 1: Уменьшает бронь всем на фиксированное значение (например, минус броня от Desolator / Спрея)
public class ArmorReductionVisitor implements GameVisitor {
    private int reductionAmount;

    public ArmorReductionVisitor(int reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    @Override
    public void visitHero(Hero hero) {
        int newArmor = Math.max(0, hero.getArmor() - reductionAmount);
        hero.setArmor(newArmor);
        System.out.println("[ArmorVisitor] Hero " + hero.getName() + " armor reduced to " + newArmor);
    }

    @Override
    public void visitCreep(Creep creep) {
        int newArmor = Math.max(0, creep.getArmor() - reductionAmount);
        creep.setArmor(newArmor);
        System.out.println("[ArmorVisitor] Creep (" + creep.getType() + ") armor reduced to " + newArmor);
    }
}