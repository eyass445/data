public class main {
    public static void main(String[] args) {
        Toy t1 = new Toy("eyas","Red",100.00,Quality.High);
        t1.display();
        double discount =  t1.discount(t1.price);
        System.out.println(discount);

        Toy t2 = new Toy("osama","blue",323.60,Quality.Medium);
        t2.display();
        double discount2 =  t2.discount(t2.price);
        System.out.println(discount2);
        System.out.println(Toy.numberofobjects);





    }
}
