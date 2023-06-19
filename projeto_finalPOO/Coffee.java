public class Coffee {
    private int id;
    private String name_Coffee;
    private String description;
    private double price;
    private String creator;

    public Coffee(String name_Coffee, String description, double price, String creator) {
        this.name_Coffee = name_Coffee;
        this.description = description;
        this.price = price;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_Coffee() {
        return name_Coffee;
    }

    public void setName_Coffee(String name_Coffee) {
        this.name_Coffee = name_Coffee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setName(String string) {
    }

    public String getName() {
        return null;
    }

}