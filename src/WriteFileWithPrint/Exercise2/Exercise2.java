package WriteFileWithPrint.Exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        File file = new File("Acc.dat");
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        loadDataFromFile(bankAccounts, file);
        BankAccount.setNextId(findMaxId(bankAccounts));
        var chocie = 0;
        do {
            System.out.println("=========================> Menu <=========================");
            System.out.println("= 1. Thêm mới một tài khoản                              =");
            System.out.println("= 2. Hiển thị danh sách tài khoản                        =");
            System.out.println("= 3. Nạp tiền vào mã tài khoản cho trước                 =");
            System.out.println("= 4. Rút tiền khỏi mã tài khoản cho trước                =");
            System.out.println("= 5. Chuyển tiền từ TK A -> TK B theo số tài khoản       =");
            System.out.println("= 6. Tìm tài khoản theo tên tài khoản                    =");
            System.out.println("= 7. Tìm tài khoản theo mã tài khoản                     =");
            System.out.println("= 8. Tìm tài khoản có số dư > X                          =");
            System.out.println("= 9. Xóa một tài khoản theo mã cho trước                 =");
            System.out.println("=10. Ghi danh sách tài khoản vô file                     =");
            System.out.println("= 0. Kết thúc chương trình                               =");
            System.out.println("==========================================================");
            chocie = input.nextInt();
            switch (chocie) {
                case 0:
                    System.out.println("==> Kết thúc chương trình <====");
                    break;
                case 1:
                    bankAccounts.add(addNewAccount(input));
                    System.out.println("==> Thêm mới tài khoản thành công <===");
                    break;
                case 2:
                    showBankAccounts(bankAccounts);
                    break;
                case 3:
                    deposit(bankAccounts, input);
                    break;
                case 4:
                    withdraw(bankAccounts, input);
                    break;
                case 5:
                    transfer(bankAccounts, input);
                    break;
                case 6:
                    findBankAccountByName(bankAccounts, input);
                    break;
                case 7:
                    findBankAccountById(bankAccounts, input);
                    break;
                case 8:
                    findBankAccountBySurplus(bankAccounts, input);
                    break;
                case 9:
                    removeBankAccountById(bankAccounts, input);
                    break;
                case 10:
                    writeFile(bankAccounts, file);
                    break;
                default:
                    System.out.println("===> Sai chức năng ! Vui lòng xem lại <==");
                    break;
            }
        } while (chocie != 0);
    }

    private static void writeFile(ArrayList<BankAccount> bankAccounts, File file) {
        if (bankAccounts.size() > 0) {
            try {
                PrintWriter printWriter = new PrintWriter(file);
                for (var e : bankAccounts) {
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s\n", e.getId(),
                            e.getNumberAccount(), e.getNameAccount(), e.getTypeAccount(),
                            e.getSurplus(), e.getNameBank(), e.getDateStart(),
                            e.getDateEnd());
                }
                printWriter.close();
                System.out.println("==> Ghi file thành công <===");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("===> Danh sách rỗng ! Không thể ghi file <===");
        }
    }

    private static void removeBankAccountById(ArrayList<BankAccount> bankAccounts,
                                              Scanner input) {
        System.out.println("Nhập mã tài khoản cần xóa : ");
        input.nextLine();
        var id = input.nextLine();
        var acc = findAccountById(bankAccounts, id);
        if (acc != null) {
            bankAccounts.remove(acc);
            System.out.println("==> Đã xóa mã TK : " + id + " thành công <===");
        } else {
            System.out.println("==> Tài khoản cần xóa : " + id + " không hợp lệ <===");
        }
    }

    private static void findBankAccountBySurplus(ArrayList<BankAccount> bankAccounts,
                                                 Scanner input) {
        System.out.println("Nhập số dư cần tìm kiếm : ");
        input.nextLine();
        var surplus = Float.parseFloat(input.nextLine());
        ArrayList<BankAccount> result = new ArrayList<>();
        for (var e : bankAccounts) {
            if (e.getSurplus() >= surplus) {
                result.add(e);
            }
        }
        if (result.size() > 0) {
            System.out.println("==> Kết quả tìm kiếm <===");
            showBankAccounts(result);
        } else {
            System.out.println("==> Số dư tìm kiếm : " + surplus + " không khả thi ! <===");
        }
    }

    private static void findBankAccountByName(ArrayList<BankAccount> bankAccounts,
                                              Scanner input) {
        System.out.println("Nhập tên tài khoản cần tìm kiếm : ");
        input.nextLine();
        var name = input.nextLine();
        ArrayList<BankAccount> result = new ArrayList<>();
        for (var e : bankAccounts) {
            var firstName = e.getNameAccount().split(" ");
            if (firstName[firstName.length - 1].equals(name)) {
                result.add(e);
            }
        }
        if (result.size() > 0) {
            System.out.println("==> Kết quả tìm kiếm <===");
            showBankAccounts(result);
        } else {
            System.out.println("==> Tên tài khoản : " + name + " không khả thi ! <===");
        }
    }

    private static void findBankAccountById(ArrayList<BankAccount> bankAccounts, Scanner input) {
        System.out.println("Nhập mã tài khoản cần tìm kiếm : ");
        input.nextLine();
        var id = input.nextLine();
        ArrayList<BankAccount> result = new ArrayList<>();
        for (var e : bankAccounts) {
            if (e.getId().equals(id)) {
                result.add(e);
            }
        }
        if (result.size() > 0) {
            System.out.println("==> Kết quả tìm kiếm <===");
            showBankAccounts(result);
        } else {
            System.out.println("==> Mã tài khoản : " + id + " không khả thi ! <===");
        }
    }

    private static void transfer(ArrayList<BankAccount> bankAccounts, Scanner input) {
        System.out.printf("Nhập số tài khoản chuyển : ");
        input.nextLine();
        var numberGive = input.nextLine();
        System.out.printf("Nhập số tài khoản nhận : ");
        var numberTake = input.nextLine();
        var accountGive = findAccountbyNumber(bankAccounts, numberGive);
        var accountTake = findAccountbyNumber(bankAccounts, numberTake);
        if (accountGive != null && accountTake != null) {
            System.out.println("Nhập số tiền chuyển : ");
            var surplus = Float.parseFloat(input.nextLine());
            if (accountGive.transfer(accountTake, surplus)) {
                System.out.println("STK " + numberGive + " đã chuyển " + surplus + " đến STK "
                        + numberTake + " thành công ");
            } else {
                System.out.println("Số tiền giao dịch không hợp lệ ! Vui lòng xem lại ");
            }
        } else {
            System.out.println("STK chuyển " + numberGive + "hoặc STK Nhận " + numberTake +
                    " không đúng ! Vui lòng xem lại ");
        }

    }

    private static BankAccount findAccountbyNumber(ArrayList<BankAccount> bankAccounts,
                                                   String numberGive) {
        for (var e : bankAccounts) {
            if (e.getNumberAccount().equals(numberGive)) {
                return e;
            }
        }
        return null;
    }

    private static void withdraw(ArrayList<BankAccount> bankAccounts, Scanner input) {
        System.out.printf("Nhập mã tài khoản cần rút tiền : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập số tiền rút nạp : ");
        var surplus = Float.parseFloat(input.nextLine());
        var account = findAccountById(bankAccounts, id);
        if (account != null) {
            if (!account.withdraw(account, surplus)) {
                System.out.println("==> Số tiền rút không hợp lệ !" +
                        " Vui lòng xem lại <==");
            } else {
                System.out.println("==> Đã rút " + surplus + " khỏi mã tài khoản " +
                        "" + id + " thành công <====");
            }
        } else {
            System.out.println("==> Mã tài khoản " + id + " không hợp lệ ! Vui lòng xem lại <==");
        }
    }

    private static void deposit(ArrayList<BankAccount> bankAccounts, Scanner input) {
        System.out.printf("Nhập mã tài khoản cần nạp tiền : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập số tiền cần nạp : ");
        var surplus = Float.parseFloat(input.nextLine());
        var account = findAccountById(bankAccounts, id);
        if (account != null) {
            if (!account.deposit(account, surplus)) {
                System.out.println("==> Số tiền nạp không hợp lệ !" +
                        " Vui lòng xem lại <==");
            } else {
                System.out.println("==> Đã nạp " + surplus + " vào mã tài khoản " +
                        "" + id + " thành công <====");
            }
        } else {
            System.out.println("==> Mã tài khoản " + id + " không hợp lệ ! Vui lòng xem lại <==");
        }
    }

    private static BankAccount findAccountById(ArrayList<BankAccount> bankAccounts, String id) {
        for (var e : bankAccounts) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private static void showBankAccounts(ArrayList<BankAccount> bankAccounts) {
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

    private static BankAccount addNewAccount(Scanner input) {
        System.out.println("Nhập số tài khoản : ");
        input.nextLine();
        var numberAccount = input.nextLine();
        System.out.println("Nhập tên tài khoản : ");
        var nameAccount = input.nextLine();
        System.out.println("Nhập loại tài khoản : ");
        var type = input.nextLine();
        System.out.println("Nhập số dư : ");
        var surplus = Float.parseFloat(input.nextLine());
        System.out.println("Nhập tên ngân hàng : ");
        var nameBank = input.nextLine();
        System.out.println("Nhập ngày kích hoạt : ");
        var start = input.nextLine();
        System.out.println("Nhập ngày hết hạn : ");
        var end = input.nextLine();
        return new BankAccount(numberAccount, nameAccount, type, surplus, nameBank, start, end);
    }

    private static int findMaxId(ArrayList<BankAccount> bankAccounts) {
        var maxId = 100000;
        for (var e : bankAccounts) {
            var maxCurrent = Integer.parseInt(e.getId().substring(3));
            if (maxCurrent > maxId) {
                maxId = maxCurrent;
            }
        }
        return maxId + 1;
    }

    private static void loadDataFromFile(ArrayList<BankAccount> bankAccounts, File file) {
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
}
