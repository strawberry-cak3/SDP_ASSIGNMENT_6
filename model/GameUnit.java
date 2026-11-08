package model;

public interface GameUnit {
    void accept(GameVisitor visitor);
}