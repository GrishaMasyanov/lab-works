public class App {
    public static void main(String[] args) {
        System.out.println("=== Laboratory work: Employee hierarchy ===\n");
        
        Programmer prog = new Programmer("Anna", 80000, "Java", 2);
        Manager manager = new Manager("Oleg", 120000, 10);
        Admin admin = new Admin("Ivan", 70000, 5);
        
        FrontendDeveloper frontend = new FrontendDeveloper("Elena", 85000, "JavaScript", 3, "React");
        BackendDeveloper backend = new BackendDeveloper("Petr", 90000, "Python", 4, "Django");
        
        System.out.println("\n--- Employee information ---");
        System.out.println(prog.getInfo());
        System.out.println(manager.getInfo());
        System.out.println(admin.getInfo());
        System.out.println(frontend.getInfo());
        System.out.println(backend.getInfo());
        
        System.out.println("\n--- Workflow (first level)---");
        prog.work();
        prog.work("Creating a calculator");
        
        manager.work();
        manager.takeBreak();
        
        admin.work();
        admin.work(3);
        
        System.out.println("\n--- Workflow (second level)---");
        frontend.work();
        frontend.createUI();
        
        backend.work();
        backend.createAPI();
        
        System.out.println("\n--- Statistic ---");
        System.out.println("Number of employees: " + Employee.getCount());
        
        System.out.println("\n--- Default constructors demonstration ---");
        Programmer defaultProg = new Programmer();
        FrontendDeveloper defaultFrontend = new FrontendDeveloper();
        
        System.out.println(defaultProg.getInfo());
        System.out.println(defaultFrontend.getInfo());
    }
}
abstract class Employee {
    private String name;
    private double salary;
    private static int totalEmployees = 0;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        totalEmployees++;
        System.out.println("  [+] Employee created: " + name);
    }
    public Employee() {
        this("Default", 0);
        System.out.println("  [+] Default employee created");
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public static int getCount() { return totalEmployees; }
    
    public abstract void work();
    
    public void takeBreak() {
        System.out.println(name + " resting");
    }
    
    public String getInfo() {
        return name + ", salary: " + salary;
    }
}
class Programmer extends Employee {
    protected String language;
    protected int experience;
    
    public Programmer(String name, double salary, String language, int experience) {
        super(name, salary);
        this.language = language;
        this.experience = experience;
    }
    
    public Programmer() {
        super();
        this.language = "Unknown";
        this.experience = 0;
    }
    
    @Override
    public void work() {
        System.out.println(getName() + " codes on " + language);
    }
    
    public void work(String task) {
        System.out.println(getName() + " codes for: " + task);
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", programmer, language: " + language + ", exp: " + experience + " years";
    }
}
class FrontendDeveloper extends Programmer {
    private String framework;
    
    public FrontendDeveloper(String name, double salary, String language, int experience, String framework) {
        super(name, salary, language, experience);
        this.framework = framework;
    }
    
    public FrontendDeveloper() {
        super();
        this.framework = "Unknown";
    }
    
    @Override
    public void work() {
        System.out.println(getName() + " develops UI with " + framework);
    }
    
    public void createUI() {
        System.out.println(getName() + " creating user interface");
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", frontend, framework: " + framework;
    }
}
class BackendDeveloper extends Programmer {
    private String database;
    
    public BackendDeveloper(String name, double salary, String language, int experience, String database) {
        super(name, salary, language, experience);
        this.database = database;
    }
    
    public BackendDeveloper() {
        super();
        this.database = "Unknown";
    }
    
    @Override
    public void work() {
        System.out.println(getName() + " develops server with " + database);
    }
    
    public void createAPI() {
        System.out.println(getName() + " creating API endpoints");
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", backend, database: " + database;
    }
}
class Manager extends Employee {
    private int teamSize;
    
    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }
    
    public Manager() {
        super();
        this.teamSize = 1;
    }
    
    @Override
    public void work() {
        System.out.println(getName() + " manages team of " + teamSize + " persons");
    }
    
    @Override
    public void takeBreak() {
        System.out.println(getName() + " drinking coffee and discussing plans");
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", manager, team: " + teamSize + " ppl.";
    }
}
class Admin extends Employee {
    private int accessLevel;
    
    public Admin(String name, double salary, int accessLevel) {
        super(name, salary);
        this.accessLevel = accessLevel;
    }
    
    public Admin() {
        super();
        this.accessLevel = 1;
    }
    
    @Override
    public void work() {
        System.out.println(getName() + " administrating systems");
    }
    
    public void work(int priority) {
        System.out.println(getName() + " performs priority task " + priority);
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", admin, access level: " + accessLevel;
    }
}
