public class ThreadSafeSingletonExample {
    public static void main(String args[]){
        EmpThreadSafe e = EmpThreadSafe.getThreadSafeInstancepart(5,"eeee",9999.99);
        System.out.println("Emp Id "+e.getEmpnumber());
        e = EmpThreadSafe.getThreadSafeInstance(1,"aaa",5000.00);
        System.out.println("Emp Id "+e.getEmpnumber());
        e = EmpThreadSafe.getThreadSafeInstance(2,"bbb",6000.00);
        System.out.println("Emp Id "+e.getEmpnumber());
        e = EmpThreadSafe.getThreadSafeInstance(3,"ccc",7000.00);
    }
}
class EmpThreadSafe{
    public int getEmpnumber() {
        return empnumber;
    }

    public String getEname() {
        return ename;
    }

    public Double getSal() {
        return sal;
    }

    private int empnumber;
    private String ename;
    private Double sal;
    public static volatile EmpThreadSafe e;

    private EmpThreadSafe(int id,String name,Double s){
        this.empnumber = id;
        this.ename = name;
        this.sal = s;
    }

    public static  synchronized EmpThreadSafe getThreadSafeInstance(
            int id,String name,Double s){
        e = EmpThreadSafe.e;
        if(e == null){
          e = new EmpThreadSafe(id,name,s);
        }
        return e;
    }
    //  no need to synchronize the full method
    //next step
    // Emp e =Emp.e;
    //        if(e == null){
    //            e = new Emp(id,name,s);
    //        }
    //        return e;
    public static  EmpThreadSafe getThreadSafeInstancepart(int id,String name,Double
            s){
        e = EmpThreadSafe.e;
        if(e == null){
            synchronized (EmpThreadSafe.class){
            e = new EmpThreadSafe(id,name,s);
        }
        }
        return e;
    }
}
