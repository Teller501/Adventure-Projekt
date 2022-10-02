import java.util.ArrayList;

public class Item {

    private String name;
    private String description;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
