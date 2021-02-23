import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Cloth cloth1 =new Cloth(1,"modelx","red",10,20,Size.medium);
        Cloth cloth2 =new Cloth(2,"modelx","red",22,5,Size.large);
        Cloth cloth3 =new Cloth(3,"modelx","red",17,50,Size.small);
        double x1 = cloth1.totalPrice();
        double x2 = cloth2.totalPrice();
        double x3 = cloth3.totalPrice();
        System.out.println(x1+"  ////   "+x2+"  ////   "+x3);


        ArrayList<Cloth> cloths = new ArrayList<>();
        cloths.add(cloth1);
        cloths.add(cloth2);
        cloths.add(cloth3);
        Cart cart = new Cart(cloths);
        double y = cart.totalPriceValue();
        System.out.println(y+" $");
        cart.printAllInCart();





    }
}
