package Utils;

import Objects.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {

    /**
     * get data from CSV file, the location can be defined in the path
     * @param filePath the location file
     * @return
     */
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

    /**
     * Convert a string to a Product object
     * @param str
     * @param delimiter
     * @return
     */
    public static Product convertProductFromString(String str, String delimiter) {
        String[] arr = str.split(delimiter);
        Product product = new Product();
        product.setTitle(arr[0]);
        product.setDesc(arr[1]);
        product.setPrice(arr[2]);
        return product;
    }
}
