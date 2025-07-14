package com.autobots.streamAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiLesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Badam", "Adila", "Bella", "Alex");

//        for (String name:names){
//            if (name.startsWith("A")) {
//                System.out.println(name);
//            }
//        }
        List<String> result = names.stream().
                filter(name -> name.startsWith("A"))
                .map(String::toUpperCase).
                sorted().
                collect(Collectors.toList());
        System.out.println(result);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
        System.out.println("___________________-");

        int totalSum = numbers.stream().
                mapToInt(num -> num)
                .sum();
        System.out.println(totalSum);

        int totalElements = (int) numbers.stream().count();
        System.out.println(totalElements);

        numbers.stream().min(Integer::compareTo).ifPresent(System.out::println);

        List<String> list = List.of("one", "two", "three", "hello", "four", "five");

        list.stream().filter(s -> s.length() > 3).
                findFirst().ifPresent(System.out::println);


        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );

        List<Employee> itEmployees = employees.stream().
                filter(s -> s.getDepartment().equals("IT")).
                collect(Collectors.toList());

        System.out.println(itEmployees);
        System.out.println("________________");

        List<Employee> itEmployees1 = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase("IT")) {
                itEmployees1.add(employee);
            }
        }
        System.out.println(itEmployees1);


        Map<String, List<Employee>> employeesByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));


        employeesByDepartment.forEach((department, list1) -> {
            System.out.println("Otdel " + department);
            list1.forEach(System.out::println);
        });

        System.out.println("___________________!");

        Map<String, List<Employee>> employeesByDepartment1 = new HashMap<>();
        for (Employee employee : employees) {
            employeesByDepartment1.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment1.get(employee.getDepartment()).add(employee);
        }
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment1.entrySet()) {
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
        System.out.println(employeesByDepartment1);

    }
}
