package Mine.Entities;

import Mine.Entities.Furniture;

import java.util.ArrayList;
import java.util.List;

//класс который содержит информацию которая была в документе
public class Root {
    protected String name;
    protected List<Furniture> furnitureList;

    public void setName(String name) {
        this.name = name;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public Root() {
        name = "empty";
        furnitureList = new ArrayList<>();
    }

    public Root(String name, List<Furniture> furnitureList) {
        this.name = name;
        this.furnitureList = furnitureList;
    }

    public String getName() {
        return name;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    @Override
    public String toString() {
        StringBuilder resStr = new StringBuilder("Название документа=" + name + '\n' +
                "Список мебели:\n");
        for (var item : furnitureList) {
            resStr.append(item.toString());
        }
        return resStr.toString();
    }
}
