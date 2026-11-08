public class NetWorthCalculationVisitor implements GameVisitor {
    private int totalNetWorth = 0;

    @Override
    public void visitHero(Hero hero) {
        totalNetWorth += hero.getNetWorth();
        System.out.println("[NetWorthVisitor] Added hero " + hero.getName() + " net worth: " + hero.getNetWorth());
    }

    @Override
    public void visitCreep(Creep creep) {
        totalNetWorth += creep.getNetWorth();
        System.out.println("[NetWorthVisitor] Added creep (" + creep.getType() + ") net worth: " + creep.getNetWorth());
    }

    public int getTotalNetWorth() {
        return totalNetWorth;
    }
}
