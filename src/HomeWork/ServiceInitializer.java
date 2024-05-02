package HomeWork;

import HomeWork.model.IO;
import HomeWork.model.Model;
import HomeWork.model.comporator.Service;

public class ServiceInitializer {
    public void initialize(Model model, IO serialize) {
        Service service = new Service(model, serialize);
    }
}