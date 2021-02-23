import java.util.ArrayList;

public class Cart {
    private ArrayList<Cloth> cloths;

    public Cart(ArrayList<Cloth> cloths) {
        this.cloths = cloths;
    }

    public double totalPriceValue(){
        double price = 0.0;
        for (Cloth i : cloths){
            price = price+i.totalPrice();
        }
        return price;
    }

    public void printAllInCart(){
        for (Cloth i : cloths){
            i.printCloth();
        }
    }

    public void addtoCart(Cloth c){
        cloths.add(c);
    }


    public int count(){
       return cloths.size();
    }

    public boolean removeFromCart(int id){
        boolean x = false;
        for(int i=0 ; i<cloths.size() ; i++){
            if (id == cloths.get(i).getId()){
                cloths.remove(i);
                x = true;
            }else {
                x = false;
            }
        }
        return x;
    }




}
