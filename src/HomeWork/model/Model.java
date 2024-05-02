package HomeWork.model;
import java.time.LocalDate;
import java.util.Comparator;

public class Model {
    private FamilyTree<Human> familyTree;
    private final IO serialize;
    private final Comparator<Human> sortAge;
    private final Comparator<Human> sortName;
    private final String filePath;

    public Model(FamilyTree<Human> familyTree, IO serialize, Comparator<Human> sortAge, Comparator<Human> sortName, String filePath) {
        this.familyTree = familyTree;
        this.serialize = serialize;
        this.sortAge = sortAge;
        this.sortName = sortName;
        this.filePath = filePath;
    }

    public void addHuman(String name, String surname, String middlename, String sex, LocalDate age) {
        familyTree.addFamilyTree(new Human(name, surname, middlename, sex, age));
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public Human getHumanByName(String name) {
        return familyTree.getByName(name);
    }

    public void saveFamilyTree() {
        familyTree.saveObj(serialize, filePath);
    }

    public void loadFamilyTree() {
        familyTree = (FamilyTree<Human>) serialize.load(filePath);
    }

    public void sortFamilyByName() {
        familyTree.sort(sortName);
    }

    public void sortFamilyByAge() {
        familyTree.sort(sortAge);
    }
}