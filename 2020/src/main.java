import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"EYAS SEYAM" , "IOS",1000.0,10);
        //e1.printlnForm();

        //System.out.println("/////////////////////");
        //System.out.println(e1.salaryInYear());
        //e1.printlnForm();

        //System.out.println("/////////////////////");
        //System.out.println(e1.salaryAllowance());
        //e1.printlnForm();

        Employee e2 = new Employee(2,"ahmad radi" , "android",5000.0,27);
        Employee e3 = new Employee(2,"osama radi" , "php",3000.0,12);
        Employee e4 = new Employee(2,"eyad radi" , "swift",10000.0,1);

        //Employee[] emp = {e1,e2};

        ArrayList<Employee> emp = new ArrayList<>();
//        emp.add(e1);
//        emp.add(e2);

        Department d1 = new Department("ios",emp);
        d1.addEmployee(e1);
        d1.addEmployee(e2);
        //d1.printAllEmp();
        //System.out.println(d1.totalSalaryInDep());
        //d1.removeEmployee(1);
        //d1.printAllEmp();

        ArrayList<Employee> emp2 = new ArrayList<>();

        Department d2 = new Department("ios",emp2);
        d2.addEmployee(e3);
        d2.addEmployee(e4);



        ArrayList<Department> dep = new ArrayList<>();
        dep.add(d1);
        dep.add(d2);

        System.out.println("/////////////////////////");
        Company company = new Company("eyas",dep);
        company.printAllSalaryComp();







    }
}
