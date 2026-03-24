/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaempleados;

/**
 *
 * @author framir02
 */
public class Developer extends Empleado {
    private double bonusProject;

    public Developer(String name, int age, double salaryBase, double bonus) {
        super(name, age, salaryBase);
        this.bonusProject = bonus;
    }
    
    public double getBonusProject() {
        return bonusProject;
    }

    public void setBonusProject(double bonusProject) {
        if(bonusProject < 0){
            System.out.println("El bonus tiene que ser mayor a cero");
            return;
        }
        this.bonusProject = bonusProject;
    }

    @Override
    public double calculateSalaryFinal() {
        return getSalaryBase() + bonusProject;
    }
    
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Bonus: " + getBonusProject());
    }
}