package serilization;

public class Cars {
    String model;
    String make;
    String color;
    int year;
    long price;
    int milage;



    public Cars(String model, String make, int year, long price){
        this.model=model;
        this.make=make;
        this.year=year;
        this.price=price;


    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }


    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }


    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
