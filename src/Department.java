public class Department {
    private int departmentId;
    private String departmentName;
    private int numberOfStaffs;
    public Department(int departmentId, String departmentName, int numberOfStaffs) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfStaffs = numberOfStaffs;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public int getNumberOfStaffs() {
        return numberOfStaffs;
    }
    public void setNumberOfStaffs(int numberOfStaffs) {
        this.numberOfStaffs = numberOfStaffs;
    }

    public String toString() {
        System.out.println("Mã bộ phận: "+departmentId);
        System.out.println("Tên bộ phận: "+departmentName);
        System.out.println("Số lượng nhân viên hiện tại: "+numberOfStaffs);
        System.out.println();
        return null;
    }
}
