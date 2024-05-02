package HomeWork.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import HomeWork.model.comporator.Iterator;

public class FamilyTree<T extends Description> implements Iterable<T>, Serializable {
    private List<T> familyTree;
    private String filePath;

    public FamilyTree(String filePath) {
        familyTree = new ArrayList<>();
        this.filePath = filePath;
    }

    public void addFamilyTree(T human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
        saveObj(new IO(), filePath);
    }


    @Override
    public String toString() {
        String res = "\nСемья состоит из " + familyTree.size() + " человек:\n";
        for (int i = 0; i < familyTree.size(); i++) {
            res += (i + 1) + ") " + familyTree.get(i).toString() + "\n";
        }
        return res;
    }

    public T getByName(String humanName) {
        for (T human : familyTree) {
            if (human.getName().equalsIgnoreCase(humanName)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<T>(familyTree);
    }

    public void saveObj(IO save, String filePath) {
        save.save(filePath, this);
    }

    public void sort(Comparator<T> comparator) {
        familyTree.sort(comparator);
    }

}
