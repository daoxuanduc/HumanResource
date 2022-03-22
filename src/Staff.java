abstract class Staff {
    private int id;
    private String name;
    private int age;
    private double coefficientsSalary;
    private String startingDate;
    private String department;
    private int numberOfDayOff;
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getCoefficientsSalary() {
        return this.coefficientsSalary;
    }
    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
    public String getStartingDate() {
        return this.startingDate;
    }
    public void setId(String startingDate) {
        this.startingDate = startingDate;
    }
    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getNumberOfDayOff() {
        return this.numberOfDayOff;
    }
    public void setNumberOfDayOff(int numberOfDayOff) {
        this.numberOfDayOff = numberOfDayOff;
    }
    public Staff(int id, String name, int age, double coefficientsSalary, String startingDate, String department, int numberOfDayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientsSalary = coefficientsSalary;
        this.startingDate = startingDate;
        this.department = department;
        this.numberOfDayOff = numberOfDayOff;
    }
    public abstract void displayInformation();
    public abstract double calculateSalary();
}
