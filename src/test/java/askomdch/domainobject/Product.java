package askomdch.domainobject;

public class Product {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        setName(name);
    }

    private String  name;

}
