package system.model;

public class Product {
    private String id;
    private String name;
    private String price;
    private String weight;

    public Product() {
    }

    public Product(String id, String name, String price, String weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
