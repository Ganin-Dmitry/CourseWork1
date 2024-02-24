public class Employee {
    private String oneName;
    private String twoName;
    private String threeName;
    private int department;
    private int salary;
    private int ID;

    public Employee (String oneName, String twoName, String threeName, int department, int salary, int ID) {
        this.oneName = oneName;
        this.twoName = twoName;
        this.threeName = threeName;
        this.department = department;
        this.salary = salary;
        this.ID = ID;
    }

    public String getOneName () {
        return this.oneName;
    }

    public String getTwoName () {
        return  this.twoName;
    }

    public String getThreeName () {
        return this.threeName;
    }

    public int getDepartment () {
        return this.department;
    }

    public int getSalary () {
        return this.salary;
    }

    public int getID () {
        return this.ID;
    }

    public void setDepartment (int newDepartment) {
        if (newDepartment > 0 && newDepartment < 6) {
            this.department = newDepartment;
            System.out.println("Информация успешно обновлена.");
        } else {
            System.out.println("Такого отдела не существует.");
        }
    }

    public void setSalary (int newSalary) {
        if (newSalary >= 0) {
            this.salary = newSalary;
            System.out.println("Информация успешно обновлена.");
        } else {
            System.out.println("Зарплата не может быть отрицательным числом.");
        }
    }

    @Override
    public String toString () {
        if (this != null) {
            return "Ф.И.О.: " + this.twoName + " " + this.oneName + " " + this.threeName + "\nID: " + this.ID + "\nОтдел: " + this.department + "\nЗарплата: " + this.salary;
        } else {
            return "null";
        }
    }


}
