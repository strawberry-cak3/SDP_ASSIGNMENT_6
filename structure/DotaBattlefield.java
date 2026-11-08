import java.util.ArrayList;
import java.util.List;

public class DotaBattlefield {
    private List<GameUnit> units = new ArrayList<>();

    public void addUnit(GameUnit unit) {
        units.add(unit);
    }

    // Обход коллекции (Object Structure traversal)
    public void accept(GameVisitor visitor) {
        for (GameUnit unit : units) {
            unit.accept(visitor);
        }
    }
}
