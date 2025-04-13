package app;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice", "HR", 90000),
            new Employee(102, "Bob", "IT", 120000),
            new Employee(103, "Charlie", "Finance", 110000),
            new Employee(104, "David", "IT", 130000),
            new Employee(105, "Eve", "HR", 105000),
            new Employee(106, "Frank", "Finance", 98000),
            new Employee(107, "Grace", "IT", 150000),
            new Employee(108, "Hannah", "Finance", 125000),
            new Employee(109, "Ivy", "Marketing", 89000)
        );

        EmployeeService service = new EmployeeService();
        System.out.println("Employees with Salary > 100K:");
        service.filterHighSalaryEmployees(employees, 100000).forEach(System.out::println);
        System.out.println("\nEmployees Grouped by Department:");
        service.groupByDepartment(employees).forEach((dept, empList) ->
            System.out.println(dept + ": " + empList));
        System.out.println("\nEmployees Sorted by Salary (Descending):");
        service.sortEmployeesBySalary(employees).forEach(System.out::println);
        System.out.println("\nHighest Paid Employee in Each Department:");
        service.highestPaidEmployeeByDepartment(employees).forEach((dept, emp) ->
            System.out.println(dept + ": " + emp.orElse(null)));
        System.out.println("\nTotal Salary by Department:");
        service.totalSalaryByDepartment(employees).forEach((dept, totalSalary) ->
            System.out.println(dept + ": " + totalSalary));
        System.out.println("\nPartitioned Employees:");
        service.partitionBySalary(employees, 100000).forEach((isHighEarner, empList) ->
            System.out.println((isHighEarner ? "High Earners" : "Others") + ": " + empList));
        System.out.println("\nDistinct Departments: " + service.getDistinctDepartments(employees));
    }
}
