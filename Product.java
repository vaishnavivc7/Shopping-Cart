public class Product {
    private String productName;
    private double unitPrice;
    private int gst;
    private int quantity;
 
     public Product (String productName, double unitPrice, int gst, int quantity){
         this.productName = productName;
         this.unitPrice = unitPrice;
         this.gst = gst;
         this.quantity = quantity;
     }
 
     public String getProductName(){
         return productName;
     }
 
     public double fivePercentDiscountForMoreThan500(){
         if (unitPrice > 500.00){
             double disPrice = (unitPrice * 5/100);
             unitPrice = unitPrice - disPrice;
         }
         return unitPrice;
     }
 
     public double getTotalPriceWithQuantity(double unitPriceWithDiscount){
         double totalPriceWithQuantity = unitPriceWithDiscount * quantity;
         return totalPriceWithQuantity;
     }
 
     public double getProductWithGstPrice(double totalProductPrice){
         if (gst != 0){
         double gstPrice = getGSTValue(totalProductPrice);
         double productPriceWithGST = totalProductPrice + gstPrice;
         return productPriceWithGST;
         }
         return totalProductPrice;
     }
 
     public double getGSTValue(double totalProductPrice){
         double gstPrice = (totalProductPrice * gst/100);
         return gstPrice;
     }
 
 }