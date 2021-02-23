public class Employee {
    private int id;
    private String fullName;
    private String jobName;
    private double prise;
    private int childrenNum;

    public Employee(int id, String fullName, String jobName, double prise, int childrenNum) {
        this.id = id;
        this.fullName = fullName;
        this.jobName = jobName;
        this.prise = prise;
        this.childrenNum = childrenNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public int getChildrenNum() {
        return childrenNum;
    }

    public void setChildrenNum(int childrenNum) {
        this.childrenNum = childrenNum;
    }

    public double salaryInYear(){
        double x = prise*12;
        return x;
    }


    public double salaryAllowance(){
        double x = childrenNum*10;
        prise = prise + x;
        return prise;
    }

    public void printlnForm() {
        System.out.println("Name : " + fullName + " job Name : "+jobName+" Price : "+prise+" children Num : "+childrenNum+"\n");
    }




}
