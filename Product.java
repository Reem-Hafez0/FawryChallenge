import java.time.LocalDate;

class Product implements Shippable {
    private String name;
    private double price;
    private int quantity;
    private boolean expirable;
    private LocalDate expiryDate;
    private boolean shippable;
    private double weight; 

    public Product(String name,double price,int quantity,boolean expirable,LocalDate expiryDate,boolean shippable,double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.expiryDate = expiryDate;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getName(){
        return name; 
    }

    public double getPrice(){
        return price; 
    }
    
    public int getQuantity(){
        return quantity; 
    }
    
    //to know if the type of the product Expirable or not
    public boolean isExpirable(){
        return expirable; 
    }
    
    //to know if the Expirable product expired or not
    public boolean isExpired(){
        return expirable && LocalDate.now().isAfter(expiryDate);
    }

    //to know if the product is shippable or not
    public boolean isShippable(){
        return shippable; 
    }

    //to return the weight of the product if shippable and if not return zero
    @Override
    public double getWeight() {
        return shippable ? weight : 0;
    }

    public boolean isAvailable(int requestedQty) {
        return quantity >= requestedQty;
    }

    public void reduceQuantity(int qty) {
        quantity -= qty;
    }
}
