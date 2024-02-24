public class EmployeeBook {
    private Employee [] workers;
    private int ID = 0;

    public EmployeeBook (Employee [] workers) {
        this.workers = workers;
    }

    public void addWorker (String oneName, String twoName, String threeName, int department, int salary) {
        ID++;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] == null) {
                this.workers[i] = new Employee(oneName, twoName, threeName, department, salary, ID);
                break;
            }
        }
    }

    public void delWorker (Employee worker) {
        worker = null;
    }

    public Employee getWorker (int ID) {
        int index = -1;
        boolean availability = false;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i].getID() == ID) {
                availability = true;
                index = i;
                break;
            }
        }
        if (availability) {
            return this.workers[index];
        } else {
            return null;
        }
    }

    public Employee [] getWorkers () {
        return workers;
    }

    public void allEmployees () {
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null) {
                System.out.println("===============================================================");
                System.out.println(this.workers[i].toString());
                System.out.println("===============================================================");
            }
        }
    }
    public void allEmployeeDepartment (int department) {
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null && this.workers[i].getDepartment() == department) {
                System.out.println("===============================================================");
                System.out.println("Ф.И.О.: " + this.workers[i].getTwoName() + " " + this.workers[i].getOneName() + " " + this.workers[i].getThreeName() + "\nID: " + this.workers[i].getID() + "\nЗарплата: " + this.workers[i].getSalary());
                System.out.println("===============================================================");
            }
        }
    }

    public int maxSalary () {
        int maxSalary = 0;
        int maxSalaryID = -1;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null) {
                if (maxSalary < this.workers[i].getSalary()) {
                    maxSalary = this.workers[i].getSalary();
                    maxSalaryID = this.workers[i].getID();
                }
            }
        }
        return maxSalaryID;
    }

    public int minSalary () {
        int minSalary = 999999999;
        int minSalaryID = -1;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null) {
                if (minSalary > this.workers[i].getSalary()) {
                    minSalary = this.workers[i].getSalary();
                    minSalaryID = this.workers[i].getID();
                }
            }
        }
        return minSalaryID;
    }

    public int sumSalary () {
        int sumSalary = 0;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null) {
                sumSalary = sumSalary + this.workers[i].getSalary();
            }
        }
        return sumSalary;
    }

    public int numberOfWorkers () {
        int numberOfWorkers = 0;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null) {
                numberOfWorkers++;
            }
        }
        return numberOfWorkers;
    }

    public void listOfEmployees () {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                System.out.println(this.workers[i].getTwoName() + " " + this.workers[i].getOneName() + " " + this.workers[i].getThreeName());
            }
        }
    }

    public float averageSalary () {
        return (float)sumSalary()/numberOfWorkers();
    }

    public void indexationSalary (int index) {
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null) {
                this.workers[i].setSalary(this.workers[i].getSalary() + this.workers[i].getSalary()/100*index);
            }
        }
    }

    public int sumSalaryDepartment (int department) {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null && this.workers[i].getDepartment() == department) {
                sum = sum + this.workers[i].getSalary();
            }
        }
        return sum;
    }

    public int numbersEmployeeDepartment (int department) {
        int number = 0;
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null && this.workers[i].getDepartment() == department) {
                number++;
            }
        }
        return number;
    }

    public float averageSalaryDepartment (int department) {
        return (float)sumSalaryDepartment(department) / numbersEmployeeDepartment(department);
    }



    public void allSalaryLess (int salary) {
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null && this.workers[i].getSalary() < salary) {
                System.out.println("===============================================================");
                System.out.println("Ф.И.О.: " + this.workers[i].getTwoName() + " " + this.workers[i].getOneName() + " " + this.workers[i].getThreeName() + "\nID: " + this.workers[i].getID() + "\nЗарплата: " + this.workers[i].getSalary());
                System.out.println("===============================================================");
            }
        }
    }

    public void allSalaryHigher (int salary) {
        for (int i = 0; i < 20; i++) {
            if (this.workers[i] != null && this.workers[i].getSalary() >= salary) {
                System.out.println("===============================================================");
                System.out.println("Ф.И.О.: " + this.workers[i].getTwoName() + " " + this.workers[i].getOneName() + " " + this.workers[i].getThreeName() + "\nID: " + this.workers[i].getID() + "\nЗарплата: " + this.workers[i].getSalary());
                System.out.println("===============================================================");
            }
        }
    }
}
