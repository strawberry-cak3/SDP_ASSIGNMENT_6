# Assignment #6 — Visitor Pattern (Dota 2 Domain)

**Course:** Software Design Patterns  
**Type:** Individual Assignment  
**Student Group:** SE-2513  
**Name:** Murodyan Mansur
---

## 📌 Project Overview
This project implements the **Visitor** behavioral design pattern in Java, using a **Dota 2** themed domain model.

The Visitor pattern allows adding new operations (such as armor reduction calculations or net worth aggregation) to existing game unit structures (`Hero`, `Creep`) **without modifying their source code**.

---

## 🏗️ Architecture & Pattern Components

The implementation strictly follows the technical requirements:
1. **Element Interface (`GameUnit`):** Declares the `accept(GameVisitor visitor)` method.
2. **Concrete Elements (`Hero`, `Creep`):** Implement `accept()` by performing a **double-dispatch** step (`visitor.visitX(this)`).
3. **Visitor Interface (`GameVisitor`):** Declares a `visitX()` method for each concrete element type.
4. **Concrete Visitors:**
    * `ArmorReductionVisitor`: Applies armor debuffs (e.g., simulating item or skill effects like Desolator) across all units.
    * `NetWorthCalculationVisitor`: Traverses the battlefield to accumulate the total net worth of all entities.
5. **Object Structure (`DotaBattlefield`):** Manages a collection of game units and handles client traversal.

---

## 📂 Project Structure

```text
src/
│
├── model/                  # Element Interface & Concrete Elements
│   ├── GameUnit.java
│   ├── Hero.java
│   └── Creep.java
│
├── visitor/                # Visitor Interface & Concrete Visitors
│   ├── GameVisitor.java
│   ├── ArmorReductionVisitor.java
│   └── NetWorthCalculationVisitor.java
│
├── structure/              # Object Structure Container
│   └── DotaBattlefield.java
│
└── Main.java               # Client code demonstration
```

## How to run

- Make sure you have Java 17+ installed.
- Clone the repository and compile the source files:
```bash
javac Main.java model/*.java visitor/*.java structure/*.java
```
- Run the application:
```bash
java Main 
```

## ✨ Clean Code & Design Principles Justification
1. Meaningful Names: Clear separation of responsibilities between Elements (Hero, Creep) and Visitors (ArmorReductionVisitor, etc.), utilizing distinct Dota 2 domain naming.
2. No instanceof / Type-Checking Chains: Fully eliminated through polymorphism and double-dispatch, allowing Java to resolve the correct method signature at runtime.
3. Single Responsibility Principle (SRP): Each Concrete Visitor is encapsulated within its own class and handles strictly one operation across all elements. Elements are solely responsible for holding game state.
4. Minimal & Well-Justified Encapsulation Trade-offs: To let visitors compute statistics, units expose standard getters and setters (getArmor(), setArmor(), etc.). This is a recognized trade-off of the Visitor pattern, balancing information-hiding against open-closed extensibility.
5. Demonstrated Extensibility: Introducing a new operation (e.g., an AuraEffectVisitor) requires creating a brand-new visitor class without modifying existing element or battlefield classes.
