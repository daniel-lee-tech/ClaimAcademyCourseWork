package org.danlee;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student();
        Employee e1 = new Employee();

        System.out.println("Telephone bills below for 4 objects");

        System.out.println(
                "s1: " + s1.calculateTelephoneBill(120.5)
        );

        System.out.println(
                "e1: " + e1.calculateTelephoneBill(200)
        );

        Person p1 = new Student();
        Person p2 = new Employee();

        System.out.println(
                "p1: " + p1.calculateTelephoneBill(222)
        );

        System.out.println(
                "p2: " + p2.calculateTelephoneBill(323)
        );

        s1.firstName = "dan";
        s1.lastName = "lee";

        e1.firstName = "brandon";
        e1.lastName = "owens";

        p1.firstName = "alex";
        p2.firstName = "edwin";

        System.out.println("taxes below for 50 bucks for 2 persons object");

        System.out.println("p1: " + p1.taxes(50));
        System.out.println("p2: " + p2.taxes(50));


        School school = new School();

        List<Student> students = Arrays.asList(s1, (Student)p1);
        List<Employee> employees = Arrays.asList(e1, (Employee)p2);

        school.students.addAll(students);
        school.employees.addAll(employees);

    }
}
