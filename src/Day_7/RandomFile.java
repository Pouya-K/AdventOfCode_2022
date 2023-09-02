package src.Day_7;

public class RandomFile {
    private String name;
    private int size;

    public RandomFile(String name, int size){
        this.name = name;
        this.size = size;
    }

    public RandomFile(String name){
        this.name = name;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
