package WriteFileWithPrint.Test;


import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file = new File("Acc.dat");
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        loadDataFromFile(bankAccounts, file);
        File fileObject = new File("AccBinary.Dat");
        try {
//            FileOutputStream fos = new FileOutputStream(fileObject);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(bankAccounts);
//            oos.close();
            FileInputStream fis = new FileInputStream(fileObject);
            ObjectInputStream ois = new ObjectInputStream(fis);
            var result = ois.readObject();
            ois.close();
            fis.close();
            show((ArrayList<BankAccount>) result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void loadDataFromFile(ArrayList<BankAccount> bankAccounts,
                                         File file) {
        try {
            var readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                var data = readFile.nextLine().split("-");
                bankAccounts.add(readData(data));
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static BankAccount readData(String[] data) {
        var id = data[0];
        var numberAccount = data[1];
        var nameAccount = data[2];
        var type = data[3];
        var surplus = Float.parseFloat(data[4]);
        var nameBank = data[5];
        var start = data[6];
        var end = data[7];
        return new BankAccount(id, numberAccount, nameAccount, type, surplus, nameBank, start, end);
    }

    private static void show(ArrayList<BankAccount> bankAccounts) {
        if (bankAccounts.size() > 0) {
            System.out.printf("%-20s%-20s%-20s%-20s%-15s%-15s%-15s%-15s\n",
                    "Mã TK", "Số TK", "Tên TK",
                    "Loại TK", "Số Dư", "Tên NH", "Ngày KH", "Ngày HH");
            for (var e : bankAccounts) {
                System.out.printf("%-20s%-20s%-20s%-20s%-15.2f%-15s%-15s%-15s\n",
                        e.getId(), e.getNumberAccount(), e.getNameAccount(),
                        e.getTypeAccount(), e.getSurplus(), e.getNameBank(),
                        e.getDateStart(), e.getDateEnd());
            }
        } else {
            System.out.println("==> Danh sách tài khoản rỗng <====");
        }
    }
}
