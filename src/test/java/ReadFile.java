import Objects.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        ArrayList<String> arr = readCSV("src/main/resources/products.csv");
        getProducts(arr);
    }

    public static ArrayList<Product> getProducts(ArrayList arrayList) {
        ArrayList<Product> productArrayList = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            productArrayList.add(convertProductFromString(arrayList.get(i).toString(), ";"));
            System.out.println(productArrayList.get(i));
        }

        return arrayList;
    }

    public static ArrayList<String> readCSV(String filePath) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            // create a new file object
            File file = new File(filePath);

            // create an object of Scanner
            // associated with the file
            Scanner sc = new Scanner(file);

            // read each line from file and print it
            System.out.println("Reading File Using Scanner:");
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                arrayList.add(str);
            }

            // close scanner
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return arrayList;
    }

    public static Product convertProductFromString(String str, String delimiter) {
        String[] arr = str.split(delimiter);
        Product product = new Product();
        product.setTitle(arr[0]);
        product.setDesc(arr[1]);
        product.setPrice(arr[2]);
        return product;
    }
}
