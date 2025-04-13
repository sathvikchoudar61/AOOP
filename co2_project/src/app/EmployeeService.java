package app;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    public List<Employee> filterHighSalaryEmployees(List<Employee> employees, double threshold) {
        return employees.stream()
                .filter(emp -> emp.getSalary() > threshold)
                .collect(Collectors.toList());
    }
    public Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    public List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }
    public Map<String, Optional<Employee>> highestPaidEmployeeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
    }
    public Map<String, Double> totalSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
    }
    public Map<Boolean, List<Employee>> partitionBySalary(List<Employee> employees, double threshold) {
        return employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > threshold));
    }
    public Set<String> getDistinctDepartments(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }
}
