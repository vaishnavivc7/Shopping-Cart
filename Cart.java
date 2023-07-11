import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest {

    List<Product> listOfProducts = new ArrayList<Product>();

    @BeforeTest
    public void addProductsToCart(){
        Product product1 = new Product("Leather wallet", 1100.00, 18, 1);
        Product product2 = new Product("Umbrella", 900.00, 12, 2);
        Product product3 = new Product("Cigarette", 200.00, 28, 3);
        Product product4 = new Product("Honey", 100.00, 0, 4);

        listOfProducts.add(product1);
        listOfProducts.add(product2);
        listOfProducts.add(product3);
        listOfProducts.add(product4);
    }

    @Test
    public void calculateTotalAmount(){

        Basket basket1 = new Basket(listOfProducts);

        Assert.assertEquals(basket1.totalCartPrice() , 4316.3);
    }

    @Test
    public void maxGstProduct(){

        Basket basket2 = new Basket(listOfProducts);

        Assert.assertEquals(basket2.getMaxGstProduct(), "Umbrella");
    }
}
