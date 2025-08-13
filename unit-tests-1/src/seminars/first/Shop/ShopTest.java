package seminars.first.Shop;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("морковь", 3000));
        products.add(new Product("яблоко", 6000));
        products.add(new Product("банан", 1000));
        products.add(new Product("колабаса", 2000));
        Shop shop = new Shop(products);

        System.out.println(shop.sortProductsByPrice());
        Product mostExp = new Product("яблоко", 6000);
        assertThat(shop.getMostExpensiveProduct().getTitle()).isEqualTo(mostExp.getTitle());
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(mostExp.getCost());
        System.out.println(shop.getMostExpensiveProduct());
         /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */


    }


}