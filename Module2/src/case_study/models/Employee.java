package case_study.models;

public class Employee extends Person{
    private String employeeNumber;
    private String academicLevel;
    private String position;
    private String salary;

    public Employee(String employeeNumber,String name,String dateOfBirth,String gender,String idNumber,  String phoneNumber,String email,String academicLevel,String position,String salary ){
    super(name,dateOfBirth,gender,idNumber,phoneNumber,email);
    this.employeeNumber = employeeNumber;
    this.academicLevel = academicLevel;
    this.position = position;
    this.salary = salary;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", academicLevel='" + academicLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public String getInfoEmployee(){
        return super.getInfo()+','+this.employeeNumber+','+this.academicLevel+','+this.position+','+this.salary;

    }
}
