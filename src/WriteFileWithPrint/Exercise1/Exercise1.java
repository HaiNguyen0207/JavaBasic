package WriteFileWithPrint.Exercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var fileName = "emp.dat";
        File file = new File(fileName);
        ArrayList<Employee> employees = new ArrayList<>();
        var choice = 0;
        loadData(employees, file); // load toàn bộ dữ liệu trong file
        var maxId = findMaxEmpId(employees);
        new Employee().setNextId(maxId);
        do {
            System.out.println("====================> Menu <======================");
            System.out.println("=> 1. Thêm mới một nhân viên vào danh sách      <=");
            System.out.println("=> 2. Hiển thị danh sách nhân viên              <=");
            System.out.println("=> 3. Tìm nhân viên theo tên                    <=");
            System.out.println("=> 4. Xóa nhân viên theo mã cho trước           <=");
            System.out.println("=> 5. Ghi danh sách nhân viên vô file           <=");
            System.out.println("=> 0. Kết thúc chương trình                     <=");
            System.out.println("==================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("=====> Chương trình kết thúc <======");
                    break;
                case 1:
                    var emp = addEmp(input);
                    employees.add(emp);
                    System.out.println("===> Thêm nhân viên thành công <===");
                    break;
                case 2:
                    showEmps(employees);
                    break;
                case 3:
                    findEmpByName(employees, input);
                    break;
                case 4:
                    removeEmpById(employees, input);
                    break;
                case 5:
                    writeFile(employees, file);
                default:
                    System.out.println("==> Sai chức năng ! Vui lòng nhập lại <===");
                    break;
            }
        } while (choice != 0);
    }

    private static void writeFile(ArrayList<Employee> employees, File file) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (var e : employees) {
                printWriter.printf("%s-%s-%s-%d-%s-%f-%d\n", e.getId(), e.getFullName(),
                        e.getAddress(), e.getAge(), e.getPhoneNumber(), e.getSalaray(), e.getExp());
            }
            printWriter.close();
            System.out.println("===> Ghi File hoàn tất <===");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void removeEmpById(ArrayList<Employee> employees, Scanner input) {
        System.out.println("Nhập mã nhân viên cần xóa : ");
        input.nextLine();
        var id = input.nextLine();
        var emp = findEmpById(employees, id);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Đã xóa ID : " + id + " thành công !");
        } else {
            System.out.printf("ID : " + id + " cần xóa không tồn tại !");
        }
    }

    private static Employee findEmpById(ArrayList<Employee> employees, String id) {
        for (var e : employees) {
            if (e.getId().compareTo(id) == 0) {
                return e;
            }
        }
        return null;
    }

    private static void findEmpByName(ArrayList<Employee> employees, Scanner input) {
        System.out.println("Nhập tên cần tìm kiếm : ");
        input.nextLine();
        var name = input.nextLine();
        var emp = findEmp(employees, name);
        if (emp != null) {
            showEmps(employees);
        } else {
            System.out.println("==> Tên tìm kiếm không hợp lệ <===");
        }
    }

    private static ArrayList<Employee> findEmp(ArrayList<Employee> employees, String name) {
        ArrayList<Employee> result = new ArrayList<>();
        for (var e : employees) {
            if (e.getFullName().substring(e.getFullName().split(" ").length - 1).compareTo(name) == 0) {
                result.add(e);
            }
        }
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    private static void showEmps(ArrayList<Employee> employees) {
        if (employees.size() > 0) {
            System.out.printf("%-15s%-20s%-20s%-10s%-20s%-15s%-10s\n", "ID", "Họ Tên", "Địa Chỉ", "Tuổi",
                    "Số ĐT", "Mức Lương", "Kinh Nghiệm");
            for (var e : employees) {
                System.out.printf("%-15s%-20s%-20s%-10d%-20s%-15.2f%-10d\n", e.getId(), e.getFullName(),
                        e.getAddress(), e.getAge(), e.getPhoneNumber(), e.getSalaray(), e.getExp());
            }
        } else {
            System.out.printf("==> Danh sách nhân viên rỗng <===\n");
        }
    }

    private static Employee addEmp(Scanner input) {
        System.out.println("Nhập họ tên nhân viên : ");
        input.nextLine();
        var name = input.nextLine();
        System.out.println("Nhập địa chỉ : ");
        var address = input.nextLine();
        System.out.println("Nhập tuổi : ");
        var age = Integer.parseInt(input.nextLine());
        System.out.println("Nhập số điện thoại : ");
        var phone = input.nextLine();
        System.out.println("Nhập mức lương : ");
        var surplus = Float.parseFloat(input.nextLine());
        System.out.println("Nhập năm kinh nghiệm : ");
        var exp = Integer.parseInt(input.nextLine());
        return new Employee(name, address, age, phone, surplus, exp);
    }

    private static int findMaxEmpId(ArrayList<Employee> employees) {
        var maxId = 1001;
        for (var e : employees) {
            var maxCurrent = Integer.parseInt(e.getId().substring(3));
            if (maxCurrent > maxId) {
                maxId = maxCurrent;
            }
        }
        return maxId + 1;
    }

    private static void loadData(ArrayList<Employee> employees, File file) {
        try {
            var readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                var data = readFile.nextLine().split("-");
                employees.add(readEmp(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Employee readEmp(String[] data) {
        var id = data[0];
        var name = data[1];
        var address = data[2];
        var age = Integer.parseInt(data[3]);
        var phone = data[4];
        var salary = Float.parseFloat(data[5]);
        var exp = Integer.parseInt(data[6]);
        return new Employee(id, name, address, age, phone, salary, exp);
    }
}
