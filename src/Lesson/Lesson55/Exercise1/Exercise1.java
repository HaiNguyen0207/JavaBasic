package Lesson.Lesson55.Exercise1;


import Lesson.Lesson55.Exercise1.Sort.SortByHeight;
import Lesson.Lesson55.Exercise1.Sort.SortByName;
import Lesson.Lesson55.Exercise1.Sort.SortByWeightAsc;
import Lesson.Lesson55.Exercise1.Sort.SortByWeightDec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();
        createNewAnimal(animals);
        var choice = 0;
        do {
            System.out.println("===========================MENU===========================");
            System.out.println("= 1. Thêm mới động vật vào danh sách                     =");
            System.out.println("= 2. Hiển thị danh sách động vật                         =");
            System.out.println("= 3. Sắp xếp danh sách động vật theo tên a -z            =");
            System.out.println("= 4. Sắp xếp động vật theo chiều cao giảm dần            =");
            System.out.println("= 5. Sắp xếp động vật theo cân nặng giảm dần             =");
            System.out.println("= 6. Sắp xếp động vật theo cân nặng tăng dần             =");
            System.out.println("= 0. kết thúc chương trình                               =");
            System.out.println("==========================================================");
            System.out.println("==================> Xin mời lựa chọn <====================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("===========> Chương trình kết thúc <============");
                    break;
                case 1:
                    var animal = createNewAnimal(input);
                    if (animal == null) {
                        System.out.println("=====> Thêm mới động vật thất bại <====");
                    } else {
                        animals.add(animal);
                        System.out.println("=====> Thêm mới động vật thành công <====");
                    }
                    break;
                case 2:
                    if (animals.size() > 0) {
                        showAnimals(animals);
                    } else {
                        System.out.println("=====> Danh sách động vật rõng <======");
                    }
                    break;
                case 3:
                    if (animals.size() > 0) {
                        System.out.println("===> Danh sách động vật theo tên A - Z <===");
                        Collections.sort(animals, new SortByName());
                        showAnimals(animals);
                    } else {
                        System.out.println("=====> Danh sách động vật rõng <======");
                    }
                    break;
                case 4:
                    if (animals.size() > 0) {
                        System.out.println("===> Danh sách động vật theo chiều cao giảm dần <===");
                        Collections.sort(animals, new SortByHeight());
                        showAnimals(animals);
                    } else {
                        System.out.println("=====> Danh sách động vật rõng <======");
                    }
                    break;
                case 5:
                    if (animals.size() > 0) {
                        System.out.println("===> Danh sách động vật theo cân nặng giảm dần <===");
                        Collections.sort(animals, new SortByWeightDec());
                        showAnimals(animals);
                    } else {
                        System.out.println("=====> Danh sách động vật rõng <======");
                    }
                    break;
                case 6:
                    if (animals.size() > 0) {
                        System.out.println("===> Danh sách động vật theo cân nặng tăng dần <===");
                        Collections.sort(animals, new SortByWeightAsc());
                        showAnimals(animals);
                    } else {
                        System.out.println("=====> Danh sách động vật rõng <======");
                    }
                    break;
                default:
                    System.out.println("====> Sai chức năng ! Vui lòng nhập lại <====");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức hiển thị
     * danh sách động vật theo dạng cột
     *
     * @param animals danh sách động vật gốc
     */
    private static void showAnimals(ArrayList<Animal> animals) {
        System.out.printf("%-25s%-20s%-15s%-15s\n", "Tên động vật",
                "Loài động vật", "Chiều cao", "Cân nặng");
        for (var animal : animals) {
            System.out.printf("%-25s%-20s%-15.2f%-15.2f\n", animal.getName(),
                    animal.getSpecies(), animal.getHeight(), animal.getWeight());
        }
    }

    /**
     * phương thức thêm mới
     * loài động vật
     *
     * @param input đối tượng lớp Scanner
     * @return đối tượng vừa tạo
     */
    private static Animal createNewAnimal(Scanner input) {
        System.out.println("Chọn loài: \n1. Cá.\n2. Chim.\n3. Động vật có vú");
        input.nextLine();
        var option = input.nextInt();
        System.out.println("Nhập tên động vật : ");
        input.nextLine();
        var name = input.nextLine();
        System.out.println("Nhập loài : ");
        var species = input.nextLine();
        System.out.println("Nhập chiều cao : ");
        var height = Float.parseFloat(input.nextLine());
        System.out.println("Nhập cân nặng : ");
        var weight = Float.parseFloat(input.nextLine());
        switch (option) {
            case 1:
                return new Fish(name, species, height, weight);
            case 2:
                return new Bird(name, species, height, weight);
            case 3:
                return new Mammal(name, species, height, weight);
            default:
                System.out.println("===> Sai lựa chọn ! Vui lòng nhập lại <==");
                break;
        }
        return null;
    }

    /**
     * phương thức tạo ra loạt động vật
     * tiết kiệm thời gian
     *
     * @param animals danh sách động vật gốc
     */
    private static void createNewAnimal(ArrayList<Animal> animals) {
        animals.add(new Bird("Đại bàng", "Chim", 0.91f, 23.66f));
        animals.add(new Bird("Chim ưng", "Chim", 0.66f, 26.28f));
        animals.add(new Bird("Tu hú", "Chim", 0.34f, 11.09f));
        animals.add(new Fish("Cá vàng", "Cá", 0.26f, 14.35f));
        animals.add(new Fish("Cá chép", "Cá", 0.82f, 19.22f));
        animals.add(new Fish("Cá rô", "Cá", 0.24f, 5.22f));
        animals.add(new Mammal("Hổ", "Động vật có vú", 1.21f, 80.9f));
        animals.add(new Mammal("Sư tử", "Động vật có vú", 1.35f, 92.9f));
        animals.add(new Mammal("Bò", "Động vật có vú", 1.72f, 82.5f));
    }

}
