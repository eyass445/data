import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Department> departments ;

    public Company(String name, ArrayList<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void printAllSalaryComp(){
        for (Department i : departments ) {
            double res = i.totalSalaryInDep();
            System.out.println(res+"");
        }
    }
}
