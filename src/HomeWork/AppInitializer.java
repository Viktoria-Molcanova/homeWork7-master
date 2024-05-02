package HomeWork;

import HomeWork.model.IO;
import HomeWork.model.Model;
import HomeWork.model.comporator.HumanComparatorByAge;
import HomeWork.model.comporator.HumanComparatorByName;
import HomeWork.ui.View;

public class AppInitializer {
    private View view;
    private IO serialize;
    private Model model;

    public AppInitializer(View view, IO serialize, Model model) {
        this.view = view;
        this.serialize = serialize;
        this.model = model;
    }

    public void initialize() {
        ServiceInitializer serviceInitializer = new ServiceInitializer();
        PresenterInitializer presenterInitializer = new PresenterInitializer();
        serviceInitializer.initialize(model, serialize);
        presenterInitializer.initialize(view, model);
    }
}