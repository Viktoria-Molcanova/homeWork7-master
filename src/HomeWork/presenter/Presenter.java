package HomeWork.presenter;

import HomeWork.model.Human;
import HomeWork.model.Model;
import HomeWork.ui.View;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String surname, String middlename, String sex, LocalDate age) {
        model.addHuman(name, surname, middlename, sex, age);
        view.print("Новый человек добавлен");
    }

    public void familyPrint() {
        model.loadFamilyTree();
        String family = model.getFamilyTree().toString();
        view.print(family);
    }

    public void humanSearch(String name) {
        Human human = model.getHumanByName(name);
        if (human == null)
            view.print("Человек не найден");
        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }

    public void saveFamily() {
        model.saveFamilyTree();
        view.print("Семейное древо сохранено");
    }

    public void loadFamily() {
        model.loadFamilyTree();
    }

    public void sortFamilyName() {
        model.sortFamilyByName();
        view.print("Сортировка по имени завершена");
        view.print(model.getFamilyTree().toString());
    }

    public void sortFamilyAge() {
        model.sortFamilyByAge();
        view.print("Сортировка по возрасту завершена");
        view.print(model.getFamilyTree().toString());
    }
}