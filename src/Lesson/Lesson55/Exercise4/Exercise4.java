package Lesson.Lesson55.Exercise4;

import Lesson.Lesson55.Exercise4.Sort.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        ArrayList<Phone> phones = new ArrayList<>();
        createNewPhone(phones);
        var chocie = 0;
        do {
            System.out.println("===============================MENU================================");
            System.out.println("= 1. Thêm mới thiết bị vào danh sách                              =");
            System.out.println("= 2. Sắp xếp danh sách thiết bị theo hãng tăng dần a-z            =");
            System.out.println("= 3. Sắp xếp danh sách thiết bị theo tên tăng dần a-z             =");
            System.out.println("= 4. Sắp xếp danh sách thiết bị theo hãng giảm dần z-a            =");
            System.out.println("= 5. Sắp xếp danh sách thiết bị theo giá bán giảm dần             =");
            System.out.println("= 6. Sắp xếp danh sách thiết bị theo giá bán tăng dần             =");
            System.out.println("= 7. Sắp xếp danh sách thiết bị theo năm sản xuất cũ đến mới      =");
            System.out.println("= 8. Sắp xếp danh sách thiết bị theo năm sản xuất mới đến cũ      =");
            System.out.println("= 9. Hiển thị danh sách theo hàng cột                             =");
            System.out.println("= 0. Kết thúc chương trình                                        =");
            System.out.println("===================================================================");
            System.out.println("=====================> Xin mời lựa chọn ! <========================");
            chocie = input.nextInt();
            switch (chocie) {
                case 0:
                    System.out.println("======> Chương trình đã kết thúc <======");
                    break;
                case 1:
                    var phone = createNewPhone(input);
                    phones.add(phone);
                    System.out.println("=====> Thêm mới thiết bị vào danh sách thành công <=====");
                    break;
                case 2:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SoryPhoneByBrandAsc());
                        System.out.println("====> Danh sách thiết bị theo hãng tăng dần a-z <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 3:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByNameAsc());
                        System.out.println("====> Danh sách thiết bị theo tên tăng dần a-z <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 4:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByBrandDec());
                        System.out.println("====> Danh sách thiết bị theo hãng giảm dần a-z <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 5:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByPriceDec());
                        System.out.println("====> Danh sách thiết bị theo giá bán giảm dần <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 6:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByPriceAsc());
                        System.out.println("====> Danh sách thiết bị theo giá bán tăng dần <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 7:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByStartYearAsc());
                        System.out.println("====> Danh sách thiết bị theo năm sản xuất tăng dần <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 8:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByStartYearDec());
                        System.out.println("====> Danh sách thiết bị theo năm sản xuất giảm dần <==== ");
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                case 9:
                    if (phones.size() > 0) {
                        showPhones(phones);
                    } else {
                        System.out.println("===> Danh sách thiết bị rỗng ! Vui lòng thêm <====");
                    }
                    break;
                default:
                    System.out.println("========> Sai chức năng ! Vui lòng chọn lại <=========");
                    break;

            }
        } while (chocie != 0);
    }

    /**
     * phương thức hiển thị
     * danh sách thiết bị theo dạng cột
     *
     * @param phones danh sách thiết bị gốc
     */
    private static void showPhones(ArrayList<Phone> phones) {
        System.out.println("========> Danh sách thiết bị <=========");
        System.out.printf("%-20s%-20s%-20s%-15s%-15s%-15s\n", "Mã TB", "Thương hiệu",
                "Tên TB", "Giá bán", "Năm SX", "Kích cỡ");
        for (var item : phones) {
            System.out.printf("%-20s%-20s%-20s%-15.2f%-15d%-15.2f\n", item.getId(), item.getBrand(),
                    item.getName(), item.getPrice(), item.getStartYear(), item.getSizeScreen());
        }
    }

    /**
     * phương thức thêm mới 1 thiết bị
     *
     * @param input đối tượng lớp Sanner
     * @return đối tượng vừa tạo
     */
    private static Phone createNewPhone(Scanner input) {
        System.out.println("Nhập mã thiết bị : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập hãng sản xuất : ");
        var brand = input.nextLine();
        System.out.println("Nhập tên thiết bị : ");
        var name = input.nextLine();
        System.out.println("Nhập giá : ");
        var price = Float.parseFloat(input.nextLine());
        System.out.println("Nhập năm sản xuất : ");
        var startYear = Integer.parseInt(input.nextLine());
        System.out.println("Nhập kích thước màn hình : ");
        var sizeScreen = Float.parseFloat(input.nextLine());
        return new Phone(id, brand, name, price, startYear, sizeScreen);
    }

    /**
     * phương thức thêm mới
     * hàng loạt thiết bị
     * tiết kiệm time chạy chương trình
     *
     * @param phones danh sách gốc
     */
    private static void createNewPhone(ArrayList<Phone> phones) {
        phones.add(new Phone("IP1001", "Iphone", "Iphone11", 11.200f, 2016, 4.6f));
        phones.add(new Phone("OP1001", "OPPO", "OPPO2", 9.800f, 2015, 5.5f));
        phones.add(new Phone("SS1001", "SAMSUNG", "Samsung7", 15.760f, 2019, 5.7f));
        phones.add(new Phone("NO1001", "NOKIA", "Nokia1", 3.200f, 2013, 2.4f));
        phones.add(new Phone("IP1002", "Iphone", "Iphone13", 29.200f, 2020, 9.6f));
    }
}

