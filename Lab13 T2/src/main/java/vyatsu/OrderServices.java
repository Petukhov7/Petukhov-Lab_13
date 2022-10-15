package vyatsu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServices {

    @Autowired
    Card card;

    @Autowired
    ProductService productService;

    public void createOrder()
    {
        int Price = 0;
        System.out.println("\nВаш заказ из корзины");
        for(Product x : card.card)
        {
            try {
                Price += x.getPrice();
                System.out.println(x.title);
            }catch (NullPointerException e){
                throw new RuntimeException("Такого товара не существует");
            }
        }
        System.out.println("Общая цена " + Price);
    }

    public void fastOrder(String... products)
    {
        int cost = 0;
        for (String product : products) {
            System.out.println(productService.findByTitle(product));
            cost+=productService.findByTitle(product).getPrice();
        }
        System.out.println("\nОбщая цена " + cost);
    }
}
