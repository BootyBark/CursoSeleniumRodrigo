package Examen;

import Shopify.ShopifyTest;
import org.testng.annotations.Factory;

public class Mailchimp_Factory {
    @Factory
    public Object[] ShopifyFactoryTest() {
        return new Object[]{
                new prueba_mailchimp( 0 ),
                new prueba_mailchimp( 1 ),
        };
    }
}
