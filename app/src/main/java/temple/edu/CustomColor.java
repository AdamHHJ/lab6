package temple.edu;


import java.io.Serializable;

public class CustomColor implements Serializable {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CustomColor(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
