package Lesson.Lesson67.Exercise4;

import Lesson.Lesson67.Exercise4.Sort.*;

import java.util.*;

public class Exercise4 {
    public static void main(String[] args) throws InValidbBrandNameException {
        List<Phone> phones = new LinkedList<>();
        var input = new Scanner(System.in);
        createNewPhone(phones);
        var choice = 0;
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
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("===========> Chương trình kết thúc <============");
                    break;
                case 1:
                    var phone = createNewPhone(input);
                    if (phone != null) {
                        phones.add(phone);
                        System.out.println("=====> Thêm mới thiết bị thành công <=====");
                    } else {
                        System.out.println("=====> Thêm mới thiết bị thất bại <=====");
                    }
                    break;
                case 2:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByBrandAsc());
                        System.out.println("===> Danh sách thiết bị theo hãng tăng dần a-z <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 3:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByNameAsc());
                        System.out.println("===> Danh sách thiết bị theo tên tăng dần a-z   <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 4:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByBrandDec());
                        System.out.println("===> Danh sách thiết bị theo hãng giảm dần z-a   <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 5:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByPriceDec());
                        System.out.println("===> Danh sách thiết bị theo giá bán giảm dần    <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 6:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByPriceAsc());
                        System.out.println("===> Danh sách thiết bị theo giá bán tăng dần    <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 7:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByStartYearAsc());
                        System.out.println("===> Danh sách thiết bị theo năm sản xuất cũ đến mới     <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 8:
                    if (phones.size() > 0) {
                        Collections.sort(phones, new SortPhoneByStartYearDec());
                        System.out.println("===> Danh sách thiết bị theo năm sản xuất mới đến cũ     <===");
                        showPhones(phones);
                    } else {
                        System.out.println("=====> Danh sách thiết bị rỗng <=====");
                    }
                    break;
                case 9:
                    if (phones.size() > 0) {
                        showPhones(phones);
                    } else {
                        System.out.println("====> Danh sách thiết bị rỗng <====");
                    }
                    break;
                default:
                    System.out.println("===> Sai chức năng ! Vui lòng chọn lại <====");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức hiển thị danh sách thiết bị
     * theo dạng cột
     *
     * @param phones danh sách thiết bị
     */
    private static void showPhones(List<Phone> phones) {
        System.out.printf("%-20s%-20s%-20s%-15s%-15s%-15s\n", "Mã Máy", "Thương Hiệu",
                "Tên Máy", "Giá Bán", "Năm SX", "Kích Cỡ");
        for (var e : phones) {
            System.out.printf("%-20s%-20s%-20s%-15.2f%-15d%-15.2f\n", e.getIdDevice(),
                    e.getBrand(), e.getNameDevice(), e.getPrice(), e.getStartYear(),
                    e.getSizeScreen());
        }
    }

    /**
     * phương thức thêm mới thiết bị
     * hãng nhập phải hợp lệ
     *
     * @param input đối tượng lớp scanner
     * @return đối tượng vừa tạo
     */
    private static Phone createNewPhone(Scanner input) {
        Phone phone = new Phone();
        System.out.println("Nhập mã thiết bị : ");
        input.nextLine();
        var idDevice = input.nextLine();
        System.out.println("Nhập tên thiết bị : ");
        var nameDevice = input.nextLine();
        System.out.println("Nhập giá bán : ");
        var price = Float.parseFloat(input.nextLine());
        System.out.println("Nhập năm sản xuất : ");
        var startYear = Integer.parseInt(input.nextLine());
        System.out.println("Nhập kích cỡ màn hình : ");
        var sizeScreen = Float.parseFloat(input.nextLine());
        System.out.println("Nhập tên hãng : ");
        var brand = input.nextLine();
        try {
            phone.setBrand(brand);
            return new Phone(idDevice, brand,
                    nameDevice, price, startYear, sizeScreen);
        } catch (InValidbBrandNameException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * phương thức thêm mới hàng loạt thiết bị
     * nhằm tiết kiệm thời gian chạy chương trình
     *
     * @param phones danh sách thiết bị
     * @throws InValidbBrandNameException xử lý ngoại lệ
     */
    private static void createNewPhone(List<Phone> phones) throws InValidbBrandNameException {
        phones.add(new Phone("DT1001", "samsung", "Samsung1001",
                9900.54f, 2018, 5.4f));
        phones.add(new Phone("DT1002", "huawei", "Huawei1001",
                15500.99f, 2018, 7.8f));
        phones.add(new Phone("DT1003", "apple", "Apple1001",
                19000.500f, 2017, 6.09f));
        phones.add(new Phone("DT1004", "apple", "Appple1002",
                22000.55f, 2016, 5.12f));
        phones.add(new Phone("DT1004", "xiaomi", "Xiaomi1001",
                18900.00f, 2020, 6.97f));
        phones.add(new Phone("DT1005", "vsmart", "Vsmart1001",
                11200.99f, 2015, 5.67f));
    }
}
