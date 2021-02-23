import java.util.ArrayList;

public class Department {

     private  String name;
     //private  Employee[] employees;
     private ArrayList<Employee> employees;

    public Department(String name, ArrayList<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public double totalSalaryInDep(){
        double salary = 0.0;
        for (Employee i : employees ) {
            salary = salary+i.getPrise();
        }
        return salary;
    }


    public void printAllEmp(){
        for (Employee i : employees ) {
            i.printlnForm();
        }
    }



    public void addEmployee(Employee e){

        employees.add(e);
    }

    public void removeEmployee(int id){

        for(int i=0 ; i<employees.size() ; i++){
            if(id == employees.get(i).getId()){
                employees.remove(i);
            }else {
                System.out.println("dont remove employee");
            }
        }
    }








}
