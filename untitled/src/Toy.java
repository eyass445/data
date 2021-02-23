public class Toy implements Toyface {

    String name;
    String color;
    double price;
    Quality quality;
    public static int numberofobjects=0;

    public Toy(String name, String color, double price, Quality quality) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quality = quality;
        numberofobjects++;
    }

    @Override
    public void display() {
        System.out.println("Name : " + name + " Color : "+color+" Price : "+price+" Quality : "+quality);
    }

    @Override
    public double discount(double a) {
        double x = a/2;
        //System.out.println("Dssdsdsdsd");
        return x;
    }
}
