import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
        ArrayList<Staff> listStaff = new ArrayList<Staff>();
        ArrayList<Department> listDepartment = new ArrayList<Department>();
        do {
            System.out.println("Bạn muốn làm gì? Hãy nhập số tương ứng stt.");
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty:");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
            System.out.println("9. Thoát");
            int n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    listStaff(listStaff);
                    break;
                case 2:
                    listDepartment(listDepartment);
                    break;
                case 3:
                    listStaffByDepartment(sc,listStaff);
                    break;
                case 4:
                    listStaff = addStaff(sc, listStaff);
                    listDepartment = addDepartment(listStaff.get(listStaff.size()-1).getDepartment(),listDepartment);
                    break;
                case 5:
                    searchStaff(sc,listStaff);
                    break;
                case 6:
                    listSalary(listStaff);
                    break;
                case 7:
                    listSalaryIncrease(listStaff);
                    break;
                case 8:
                    listSalaryDecrease(listStaff);
                    break;
                case 9:
                    isContinue = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
            }
            pressEnterKeyToContinue();
        }
        while (isContinue);
    }
    public static void pressEnterKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
    // liet ke danh sach nhan vien
    public static void listStaff(ArrayList<Staff> list) {
        for (int i=0; i<list.size(); i++) {
            list.get(i).displayInformation();
        }
    }
    //liet ke danh sach phong ban
    public static void listDepartment(ArrayList<Department> list) {
        for (int i=0; i<list.size(); i++) {
            list.get(i).toString();
        }
    }
    //liet ke danh sach nha vien theo phong ban
    public static void listStaffByDepartment(Scanner sc, ArrayList<Staff> list) {
        System.out.print("Nhập tên bộ phận: ");
        String department = sc.nextLine();
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).getDepartment().equals(department)) {
                list.get(i).displayInformation();
            }
        }
    }
    //them nhan vien
    public static ArrayList<Staff> addStaff(Scanner sc, ArrayList<Staff> list) {
        System.out.println("Chọn loại nhân viên");
        System.out.println("1. Nhân viên thông thường");
        System.out.println("2. Nhân viên cấp quản lý");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập mã nhân viên: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập hệ số lương: ");
        double coefficientsSalary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập ngày vào làm: ");
        String startingDate = sc.nextLine();
        System.out.print("Nhập bộ phận làm việc: ");
        String department = sc.nextLine();
        System.out.print("Nhập số ngày nghỉ phép: ");
        int numberOfDayoffs = sc.nextInt();
        sc.nextLine();

        int overtime = 0;
        String position = "";
        if (n == 1) {
            System.out.print("Nhập số giờ làm thêm: ");
            overtime = sc.nextInt();
            sc.nextLine();
            Employee e = new Employee(id, name, age, coefficientsSalary, startingDate, department, numberOfDayoffs,
                    overtime);
            list.add(e);
        }
        else {
            System.out.println("Chọn chức danh: ");
            System.out.println("1. Business Leader");
            System.out.println("2. Project Leader");
            System.out.println("3. Technical Leader");
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 1:
                    position = "Business Leader";
                    break;
                case 2:
                    position = "Project Leader";
                    break;
                case 3:
                    position = "Technical Leader";
                    break;
            }
            Manager m = new Manager(id, name, age, coefficientsSalary, startingDate, department, numberOfDayoffs,
                    position);
            list.add(m);
        }
        return list;
    }

    public static void searchStaff(Scanner sc, ArrayList<Staff> list) {
        System.out.print("Nhập tên nhân viên hoặc mã nhân viên: ");
        String keyword = sc.nextLine();
        boolean isFound = false;
        for (int i = 0; i<list.size();i++) {
            String s = list.get(i).getId()+"";
            if (s.equals(keyword)) {
                isFound = true;
                list.get(i).displayInformation();
            }
        }
        if (!isFound) {
            for (int i = 0; i<list.size();i++) {
                if (list.get(i).getName().equals(keyword)) {
                    isFound = true;
                    list.get(i).displayInformation();
                }
            }
        }
        if (!isFound) {
            System.out.println("Không tìm thấy nhân viên.");
        }
    }
    public static ArrayList<Department> addDepartment(String departmentName,ArrayList<Department> list) {
        boolean exist = false;
        for (int i = 0;i< list.size();i++) {
            if (list.get(i).getDepartmentName().equals(departmentName)) {
                list.get(i).setNumberOfStaffs(list.get(i).getNumberOfStaffs()+1);
                exist = true;
            }
        }
        if (exist == false) {
            int s = 0;
            if (list.size()==0) {
                Department d1 = new Department(1,departmentName,1);
                list.add(d1);
            }
            else {
                Department d1 = new Department(list.get(list.size() - 1).getDepartmentId() + 1, departmentName, 1);
                list.add(d1);
            }
        }
        return list;
    }
    public static void listSalary(ArrayList<Staff> list) {
        DecimalFormat df = new DecimalFormat("0");
        for (int i=0;i<list.size();i++) {
            System.out.println("Mã nhân viên: "+list.get(i).getId());
            System.out.println("Tên nhân viên: "+list.get(i).getName());
            System.out.println("Lương nhân viên: "+df.format(list.get(i).calculateSalary()));
            System.out.println();
        }
    }
    public static void listSalaryIncrease(ArrayList<Staff> list) {
        DecimalFormat df = new DecimalFormat("0");
        for (int i=0;i<list.size()-1;i++) {
            for (int j=0;j<list.size()-i-1;j++) {
                if (list.get(j).calculateSalary()>list.get(j+1).calculateSalary()) {
                    Staff e = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,e);
                }
            }
        }

        for (int i=0;i<list.size();i++) {
            System.out.println("Mã nhân viên: "+list.get(i).getId());
            System.out.println("Tên nhân viên: "+list.get(i).getName());
            System.out.println("Lương nhân viên: "+df.format(list.get(i).calculateSalary()));
            System.out.println();
        }
    }
    public static void listSalaryDecrease(ArrayList<Staff> list) {
        DecimalFormat df = new DecimalFormat("0");
        for (int i=0;i<list.size()-1;i++) {
            for (int j=0;j<list.size()-i-1;j++) {
                if (list.get(j).calculateSalary()<list.get(j+1).calculateSalary()) {
                    Staff e = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,e);
                }
            }
        }
        for (int i=0;i<list.size();i++) {
            System.out.println("Mã nhân viên: "+list.get(i).getId());
            System.out.println("Tên nhân viên: "+list.get(i).getName());
            System.out.println("Lương nhân viên: "+df.format(list.get(i).calculateSalary()));
            System.out.println();
        }
    }
}
