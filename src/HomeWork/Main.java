package HomeWork;

import java.io.IOException;
import java.time.LocalDate;

import HomeWork.model.FamilyTree;
import HomeWork.model.Human;
import HomeWork.model.IO;
import HomeWork.model.Model;
import HomeWork.model.comporator.HumanComparatorByAge;
import HomeWork.model.comporator.HumanComparatorByName;
import HomeWork.ui.Console;
import HomeWork.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Human> familyTree = new FamilyTree<>("TreeFamily.data");
        Human mother = new Human("Анна", "Иванова", "Петровна", "жен", LocalDate.of(1975, 5, 15));
        Human father = new Human("Иван", "Иванов", "Иванович", "муж", LocalDate.of(1970, 10, 20));
        Human child1 = new Human("Мария", "Иванова", "Ивановна", "жен", LocalDate.of(1995, 3, 25));
        Human child2 = new Human("Алексей", "Иванов", "Иванович", "муж", LocalDate.of(2000, 8, 10));

        mother.addChild(child1);
        father.addChild(child1);
        mother.addChild(child2);
        father.addChild(child2);

        familyTree.addFamilyTree(mother);
        familyTree.addFamilyTree(father);
        familyTree.addFamilyTree(child1);
        familyTree.addFamilyTree(child2);
        System.out.println(familyTree);

        Model model = new Model(familyTree, new IO(), new HumanComparatorByAge(), new HumanComparatorByName(), "TreeFamily.data");
        View view = new Console();
        AppInitializer appInitializer = new AppInitializer(view, new IO(), model);
        appInitializer.initialize();
    }
}