public class Manager extends Staff implements ICalculator {
    private String position;
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Manager(int id, String name, int age, double coefficientsSalary, String startingDate, String department,
                   int numberOfDayOff, String position) {
        super(id, name, age, coefficientsSalary,startingDate,department,numberOfDayOff);
        this.position = position;
    }

    public double calculateSalary() {
        double _salary = 0;
        if (position.equals("Business Leader")) _salary = 8000000;
        else if (position.equals("Project Leader")) _salary = 5000000;
        else if (position.equals("Technical Leader")) _salary = 6000000;
        return super.getCoefficientsSalary()*5000000 + _salary;
    }
    public void displayInformation() {
        System.out.println("Mã nhân viên: "+super.getId());
        System.out.println("Tên nhân viên: "+super.getName());
        System.out.println("Tuổi nhân viên: "+super.getAge());
        System.out.println("Hệ số lương: "+super.getCoefficientsSalary());
        System.out.println("Ngày vào làm: "+super.getStartingDate());
        System.out.println("Bộ phận làm việc: "+super.getDepartment());
        System.out.println("Số ngày nghỉ phép: "+super.getNumberOfDayOff());
        System.out.println("Chức danh: "+position);
        System.out.println();
    }
}
