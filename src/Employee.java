public class Employee extends Staff implements ICalculator {
    private int overtime;
    public int getOvertime() {
        return overtime;
    }
    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public Employee(int id, String name, int age, double coefficientsSalary, String startingDate, String department,
                    int numberOfDayOff, int overtime) {
        super(id, name, age, coefficientsSalary,startingDate,department,numberOfDayOff);
        this.overtime = overtime;
    }

    public double calculateSalary() {
        return 3000000*super.getCoefficientsSalary()+overtime*200000;
    }
    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: "+super.getId());
        System.out.println("Tên nhân viên: "+super.getName());
        System.out.println("Tuổi nhân viên: "+super.getAge());
        System.out.println("Hệ số lương: "+super.getCoefficientsSalary());
        System.out.println("Ngày vào làm: "+super.getStartingDate());
        System.out.println("Bộ phận làm việc: "+super.getDepartment());
        System.out.println("Số ngày nghỉ phép: "+super.getNumberOfDayOff());
        System.out.println("Số giờ làm thêm: "+overtime);
        System.out.println();
    }
}
