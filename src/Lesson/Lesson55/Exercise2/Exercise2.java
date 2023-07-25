package Lesson.Lesson55.Exercise2;

import Lesson.Lesson55.Exercise2.Sort.SortByPriceAsc;
import Lesson.Lesson55.Exercise2.Sort.SortByPriceDec;
import Lesson.Lesson55.Exercise2.Sort.SortByStartYearAsc;
import Lesson.Lesson55.Exercise2.Sort.SortByWeightAsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        createNewVehicle(vehicles);
        var choice = 0;
        do {
            System.out.println("=====================MENU======================");
            System.out.println("= 1. Thêm mới phương tiện vào danh sách       =");
            System.out.println("= 2. Sắp xếp theo năm sản xuất cũ đến mới     =");
            System.out.println("= 3. Sắp xếp theo giá thành thấp đến cao      =");
            System.out.println("= 4. Sắp xếp theo giá thành cao đến thấp      =");
            System.out.println("= 5. Sắp xếp trọng lượng tăng dần             =");
            System.out.println("= 6. Hiển thị danh sách phương tiện           =");
            System.out.println("= 0. kết thúc chương trình                    =");
            System.out.println("===============================================");
            System.out.println("=============> Xin mời lựa chọn <==============");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("====> Chương trình kết thúc ! <=====");
                    break;
                case 1:
                    var vehicle = createNewVehicle(input);
                    if (vehicle != null) {
                        vehicles.add(vehicle);
                        System.out.println("===> Thêm mới phương tiện thành công <===");
                    } else {
                        System.out.println("===> Thêm mới phương tiện thất bại  <===");
                    }
                    break;
                case 2:
                    if (vehicles.size() > 0) {
                        System.out.println("==> Sắp xếp theo năm sản xuất cũ đến mới <===");
                        Collections.sort(vehicles, new SortByStartYearAsc());
                        showVehicles(vehicles);
                    } else {
                        System.out.println("===> Danh sách phương tiện rỗng <===");
                    }
                    break;
                case 3:
                    if (vehicles.size() > 0) {
                        System.out.println("==> Sắp xếp theo giá thành tăng dần <===");
                        Collections.sort(vehicles, new SortByPriceAsc());
                        showVehicles(vehicles);
                    } else {
                        System.out.println("===> Danh sách phương tiện rỗng <===");
                    }
                    break;
                case 4:
                    if (vehicles.size() > 0) {
                        System.out.println("==> Sắp xếp theo giá thành giảm dần <===");
                        Collections.sort(vehicles, new SortByPriceDec());
                        showVehicles(vehicles);
                    } else {
                        System.out.println("===> Danh sách phương tiện rỗng <===");
                    }
                    break;
                case 5:
                    System.out.println("===> Sắp xếp theo trọng lượng tăng dần <==");
                    Collections.sort(vehicles, new SortByWeightAsc());
                    showVehicles(vehicles);
                    break;
                case 6:
                    if (vehicles.size() > 0) {
                        showVehicles(vehicles);
                    } else {
                        System.out.println("===> Danh sách phương tiện rỗng <===");
                    }
                    break;
                default:
                    System.out.println("====> Sai chức năng ! Vui lòng chọn lại <===");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức hiển thị
     * danh sách phương tiện theo dạng cột
     *
     * @param vehicles danh sách phương tiện gốc
     */
    private static void showVehicles(ArrayList<Vehicle> vehicles) {
        System.out.printf("%-25s%-15s%-15s%-15s\n", "Hãng sản xuất",
                "Năm sản xuất", "Giá bán", "Trọng lượng");
        for (var vehicle : vehicles) {
            System.out.printf("%-25s%-15d%-15.2f%-15.2f\n", vehicle.getBrand(),
                    vehicle.getYear(), vehicle.getPrice(), vehicle.getWeight());
        }
    }

    /**
     * Phương thức tạo mới
     * một phương tiện giao thông
     *
     * @param input đối tượng lớp Scanner
     * @return đối tượng vừa tạo
     */
    private static Vehicle createNewVehicle(Scanner input) {
        System.out.println("Chọn tạo: \n1. Ô tô.\n2. Xe máy.");
        var option = input.nextInt();
        System.out.println("Hãng: ");
        input.nextLine();
        var brand = input.nextLine();
        System.out.println("Năm sản xuất: ");
        var year = Integer.parseInt(input.nextLine());
        System.out.println("Giá bán: ");
        var price = Float.parseFloat(input.nextLine());
        System.out.println("Trọng lượng: ");
        var weight = Float.parseFloat(input.nextLine());
        switch (option) {
            case 1:
                return new Automobile(brand, year, price, weight);
            case 2:
                return new Motobike(brand, year, price, weight);
            default:
                System.out.println("==> Sai chức năng ! Vui lòng chọn lại <===");
                break;
        }
        return null;
    }

    /**
     * phương thức thêm mới
     * hàng loạt phương tiện giao thông
     * nhằm tiết kiệm thời gian chạy chương trình
     *
     * @param vehicles danh sách phương tiện gốc
     */
    private static void createNewVehicle(ArrayList<Vehicle> vehicles) {
        vehicles.add(new Automobile("Mazda", 2017, 1000f, 100.2f));
        vehicles.add(new Automobile("VINFAST", 2017, 1100f, 110.2f));
        vehicles.add(new Automobile("TOYOTA", 2016, 900f, 99.2f));
        vehicles.add(new Automobile("MERCEDES-BENZ", 2018, 1000f, 115.2f));
        vehicles.add(new Motobike("Honda", 2013, 200.2f, 30.2f));
        vehicles.add(new Motobike("Triumph", 2016, 202.2f, 41.2f));
        vehicles.add(new Motobike("Yamaha", 2015, 198.2f, 25.6f));
        vehicles.add(new Motobike("Benelli", 2014, 201.2f, 40.2f));
    }
}

