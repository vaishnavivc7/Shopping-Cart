import java.util.List;

public class Basket {
    private List<Product> productList;

    public Basket(List<Product> productList){
        this.productList = productList;
    }

    public double totalCartPrice(){
        double totalPriceWithGST, unitPriceWithDiscount, totalProductPriceWithoutGSt, TotalCartPrice=0;
        for (Product products : productList){
            unitPriceWithDiscount = products.fivePercentDiscountForMoreThan500();
            totalProductPriceWithoutGSt = products.getTotalPriceWithQuantity(unitPriceWithDiscount);
            totalPriceWithGST = products.getProductWithGstPrice(totalProductPriceWithoutGSt);
            TotalCartPrice = totalPriceWithGST + TotalCartPrice;
        }
        return TotalCartPrice;
    }

    public String getMaxGstProduct(){
        double getGstValue, unitPriceWithDiscount, totalProductPriceWithoutGSt, getMaxGSTValue=0;
        String getMaxGSTProduct = "";
        for (Product products : productList){
            unitPriceWithDiscount = products.fivePercentDiscountForMoreThan500();
            totalProductPriceWithoutGSt = products.getTotalPriceWithQuantity(unitPriceWithDiscount);
            getGstValue = products.getGSTValue(totalProductPriceWithoutGSt);
            if (getGstValue > getMaxGSTValue){
                getMaxGSTValue = getGstValue;
                getMaxGSTProduct = products.getProductName();
            }
        }
        return getMaxGSTProduct;
    }
}
