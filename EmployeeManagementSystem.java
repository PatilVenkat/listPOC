// POC 2: Implementing a Custom Collection (Employee Management System)
// 📌 Problem Statement:

// Build an Employee Management System where employees are stored in a List, and functionalities include adding, removing, sorting, 
// and searching employees.
// 📌 Requirements:

// Define an Employee class with id, name, designation, and salary.
// Store employees in an ArrayList<Employee>.
// Implement methods to:
// Add a new employee.
// Remove an employee by ID.
// Sort employees by salary.
// Search for an employee by name.

// • •Use Comparator for sorting.
import java.util.*;

class EmployeeDetails {
  private  int id;
    private String name;
  private  String designation;
   private int salary;
   
public EmployeeDetails(int id, String name, String designation, int salary) {
    this.id = id;
    this.name = name;
    this.designation = designation;
    this.salary = salary;
}


@Override
public String toString() {
    return "EmployeeDetails [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary + "]";
}


public int getId() {
    return id;
}

public String getName() {
    return name;
}

public String getDesignation() {
    return designation;
}

public int getSalary() {
    return salary;
}
}
public class EmployeeManagementSystem{
   static  List<EmployeeDetails> employees = new ArrayList<>();
   static  Scanner sc=new Scanner(System.in);
    public static void addEmployee(){
        System.out.println("Enter Employee ID");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Employee name");
        String name=sc.next();
        System.out.println("Enter Designation");
        String designation=sc.next();
        System.out.println("Enter Salary");
        int salary =sc.nextInt();
        employees.add(new EmployeeDetails(id, name, designation, salary));

    }
     public static void removeEmployee() {
        System.out.print("Enter Employee ID to Remove: ");
        int id = sc.nextInt();
        Iterator<EmployeeDetails> iterator = employees.iterator();
while (iterator.hasNext()) {
    if (iterator.next().getId() == id) {
        iterator.remove(); // Safe removal
    }
}

        System.out.println("Employee Removed");
     }
     public static void searchEmployee(){
        System.out.println("Enter name to search");
        String name=sc.next();
        for (EmployeeDetails emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {

                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee Not found");
     }
     public static void sortEmployeesBySalary() {
        employees.sort(Comparator.comparingDouble(EmployeeDetails::getSalary));
        System.out.println("Employees sorted by salary.");
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (EmployeeDetails emp : employees) {
                System.out.println(emp);
            }
        }
    }
    
    public static void main(String[] args) {
        while(true){
            System.out.println("\n 1. Add Employee\n 2. Remove Employee\n 3. Search Employee\n 4. Sort Employees by Salary\n 5. Display Employees\n 6. Exit");

            System.out.println("Enter an Option");
      int choice = sc.nextInt();

      switch (choice) {
          case 1 -> addEmployee();
          case 2 -> removeEmployee();
          case 3 -> searchEmployee();
          case 4 -> sortEmployeesBySalary();
          case 5 -> displayEmployees();
          case 6 -> {
            System.out.println("Exiting...");
            return;
        }
        default -> System.out.println("Invalid choice, try again.");
    }

      
        }
    }

}
