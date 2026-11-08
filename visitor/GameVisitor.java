public interface GameVisitor {
    void visitHero(Hero hero);
    void visitCreep(Creep creep);
}