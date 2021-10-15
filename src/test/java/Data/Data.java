package Data;

import Objects.Account;

public class Data {
    public static Account getDefaultAccount() {
        Account standard_acc = new Account();
        standard_acc.setUsername("standard_user");
        standard_acc.setPassword("secret_sauce");
        return standard_acc;
    }
}
