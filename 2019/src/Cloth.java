public class Cloth {
   private int id;
    private String model;
    private String color;
    private double prise;
    private int quantity;
    private Size size;

    public Cloth(int id, String model, String color, double prise, int quantity, Size size) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.prise = prise;
        this.quantity = quantity;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double totalPrice(){

       double total =  prise * quantity;

       if (quantity>10){
//           double person = 0.02;
//           double x = sum * person;
//           double y = sum - x;
           return total - ( total * 0.02);
       }
       return total;
    }

    public void printCloth (){
        System.out.println("id : "+id+"\n"+"model : "+model+"\n"+"color : "+color+"\n"+"prise : "+prise+"\n"+"quantity : "+quantity+"\n"+"size : "+size+"\n");
    }



}



