package HomeWork;

import HomeWork.model.Model;
import HomeWork.presenter.Presenter;
import HomeWork.ui.View;

public class PresenterInitializer {
    public void initialize(View view, Model model) {
        Presenter presenter = new Presenter(view, model);
        view.start();
    }
}
