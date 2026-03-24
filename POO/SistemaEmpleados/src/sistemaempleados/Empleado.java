/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaempleados;

/**
 *
 * @author framir02 - Ibero
 */
public abstract class Empleado { 
    
    private String name;
    private int age;
    private double salaryBase;
    
    public Empleado(String name, int age, double salaryBase) {
        this.name = name;
        this.age = age;
        this.salaryBase = salaryBase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18){
            System.out.println("El empleado tiene que ser mayor a 18 años");
            return;
        }    
        this.age = age;  
    }

    public double getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(double salaryBase) {
        if(salaryBase < 0){
            System.out.println("El salario debe ser mayor a cero");
            return;
        }
        this.salaryBase = salaryBase;
    }
    
    public void showInfo(){
        System.out.println("Nombre: " + getName());
        System.out.println("Edad: " + getAge());
        System.out.println("Salario: " + getSalaryBase());
    }
    
    public abstract double calculateSalaryFinal();
    
}
