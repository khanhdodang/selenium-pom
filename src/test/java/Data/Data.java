package Data;

import Objects.Account;
import Objects.Product;
import Utils.Constants;
import Utils.Utility;

import java.util.ArrayList;

import static Utils.Utility.convertProductFromString;

public class Data {
    public static Account getDefaultAccount() {
        Account standard_acc = new Account();
        standard_acc.setUsername("standard_user");
        standard_acc.setPassword("secret_sauce");
        return standard_acc;
    }

    public static ArrayList<Product> getProducts() {
        ArrayList<String> arrayList = Utility.readCSV(Constants.PRODUCTS_FILE);
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Sauce Labs Backpack;carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.;$29.99");
//        arrayList.add("Sauce Labs Bike Light;A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.;$9.99");
//        arrayList.add("Sauce Labs Bolt T-Shirt;Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.;$15.99");
//        arrayList.add("Sauce Labs Fleece Jacket;It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.;$49.99");
//        arrayList.add("Sauce Labs Onesie;Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.;$7.99");
//        arrayList.add("Test.allTheThings() T-Shirt (Red);This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.;$15.99");
        ArrayList<Product> productArrayList = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            productArrayList.add(convertProductFromString(arrayList.get(i).toString(), ";"));
            System.out.println(productArrayList.get(i));
        }

        return productArrayList;
    }
}
