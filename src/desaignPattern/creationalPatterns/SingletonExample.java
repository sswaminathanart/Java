package desaignPattern.creationalPatterns;

public class SingletonExample {
    public static void main(String args[]){

        Emp e = Emp.createEmp(1,"aaa",5000.29);
        System.out.println("Emp Id "+e.getEmpid());
        System.out.println("Emp Name "+e.getEname());
        System.out.println("Emp Sal "+e.getSal());
        e.createEmp(2,"ddd",6000.29);
        System.out.println("Emp Id "+e.getEmpid());
        System.out.println("Emp Name "+e.getEname());
        System.out.println("Emp Sal "+e.getSal());
        e.createEmp(3,"ccc",7000.29);
        System.out.println("Emp Id "+e.getEmpid());
        System.out.println("Emp Name "+e.getEname());
        System.out.println("Emp Sal "+e.getSal());
    }
}
class Emp{
    private int empid;
    private String ename;
    private Double sal;
    public static Emp e;

    public int getEmpid() {
        return empid;
    }

    public String getEname() {
        return ename;
    }

    public Double getSal() {
        return sal;
    }

    private Emp(int id, String name, Double s){
        empid = id;
        ename = name;
        sal = s;

    }
    public static Emp createEmp(int id, String name, Double s){
        Emp e = Emp.e;
        if(e == null){
            e = new Emp(id,name,s);
        }
        return e;
    }
}
