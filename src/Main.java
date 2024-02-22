import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee [] workers = new Employee[20];
        int employee = 0;
        int index = -1;
        int ID = 0;
        int department;
        int salary;
        workers[0] = new Employee("Андрей", "Сатыпов", "Генадиевич", 1, 390500, 1);
        workers[1] = new Employee("Ирина", "Евстегнеева", "Николаевна", 2, 98400, 2);
        workers[2] = new Employee("Илья", "Кубинских", "Алексеевич", 3, 99700, 3);
        workers[3] = new Employee("Иван", "Курьянов", "Генадиевич", 4, 75400, 4);
        workers[4] = new Employee("Роман", "Шапырин", "Акакиевич", 5, 30200, 5);
        employee = 5;
        while (true) {
            System.out.println("===============================================================");
            System.out.println("Выберите действие:\n1.[Добавить сотрудника]\n2.[Удалить сотрудника]\n3.[Вывести информацию]\n4.[Выйти]");
            Scanner in = new Scanner(System.in);
            int firstAction = in.nextInt();
            System.out.println("===============================================================");
            if (firstAction == 4) {
                break;
            }
            switch (firstAction) {
                case 1:
                    System.out.println("===============================================================");
                    System.out.println("Введите имя: ");
                    String oneName = in.nextLine();
                    System.out.println("Введите фамилию: ");
                    String surname = in.nextLine();
                    System.out.println("Введите отчество: ");
                    String patronymic = in.nextLine();
                    System.out.println("Введите отдел: ");
                    department = in.nextInt();
                    System.out.println("Введите зарплату: ");
                    salary = in.nextInt();
                    employee++;
                    for (int i = 0; i < 20; i++) {
                        if (workers[i] == null) {
                            index = i;
                            break;
                        }
                    }
                    if (index != -1) {
                        workers[index] = new Employee(oneName, surname, patronymic, department, salary, employee);
                        index = -1;
                        System.out.println("Информация успешно обновлена.");
                    } else {
                        System.out.println("В базе данных закончилось место.");
                    }
                    System.out.println("===============================================================");
                    break;
                case 2:
                    System.out.println("===============================================================");
                    System.out.println("Введите ID сотрудника: ");
                    ID = in.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (workers[i] != null) {
                            if (workers[i].getID() == ID) {
                                workers[i] = null;
                                System.out.println("Информация успешно обновлена.");
                                break;
                            }
                        }
                    }
                    System.out.println("===============================================================");
                    break;
                case 3:
                    System.out.println("===============================================================");
                    System.out.println("Выберите действие:\n1.[Вывести информацию о всех сотрудниках]\n2.[Вывести информацию о сотруднике по ID]\n3.[Статистика]\n4.[Выйти]");
                    int secondAction = in.nextInt();
                    System.out.println("===============================================================");
                    if (secondAction == 4) {
                        break;
                    }
                    switch (secondAction) {
                        case 1:
                            for (int i = 0; i < 20; i++) {
                                if (workers[i] != null) {
                                    System.out.println("===============================================================");
                                    System.out.println(workers[i].toString());
                                    System.out.println("===============================================================");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("===============================================================");
                            System.out.println("Введите ID: ");
                            ID = in.nextInt();
                            for (int i = 0; i < 20; i++) {
                                if (workers[i] != null) {
                                    if (workers[i].getID() == ID) {
                                        index = i;
                                        break;
                                    }
                                }
                            }
                            if (index != -1) {
                                System.out.println(workers[index].toString());
                            }
                            System.out.println("Выберите действие:\n1.[Изменить номер отдела]\n2.[Изменить значение зарплаты]\n3.[Выйти]");
                            int threeAction = in.nextInt();
                            System.out.println("===============================================================");
                            if (threeAction == 3) {
                                index = -1;
                                break;
                            }
                            switch (threeAction) {
                                case 1:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите номер отдела: ");
                                    department = in.nextInt();
                                    workers[index].setDepartment(department);
                                    System.out.println("Информация успешно обновлена.");
                                    System.out.println("===============================================================");
                                    break;
                                case 2:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите новую зарплату: ");
                                    salary = in.nextInt();
                                    workers[index].setSalary(salary);
                                    System.out.println("Информация успешно обновлена.");
                                    System.out.println("===============================================================");
                                    break;
                                default:
                                    System.out.println("Нет такого действия");
                            }
                            index = -1;
                            break;
                        case 3:
                            int sum = 0;
                            int maxSalary = 0;
                            int minSalary = 999999999;
                            int maxSalaryIndex = -1;
                            int minSalaryIndex = -1;
                            int numberOfWorkers = 0;
                            float averageValue = 0f;
                            for (int i = 0; i < 20; i++) {
                                if (workers[i] != null) {
                                    sum = sum + workers[i].getSalary();
                                    if (maxSalary < workers[i].getSalary()) {
                                        maxSalary = workers[i].getSalary();
                                        maxSalaryIndex = i;
                                    }
                                    if (minSalary > workers[i].getSalary()) {
                                        minSalary = workers[i].getSalary();
                                        minSalaryIndex = i;
                                    }
                                    numberOfWorkers++;
                                }
                            }
                            averageValue = (float) sum / numberOfWorkers;
                            System.out.println("Всего на зарплату в месяц уходит " + sum + " рублей.");
                            System.out.println("Самая большая зарплата у сотрудника с ID:" + workers[maxSalaryIndex].getID() + ".");
                            System.out.println("Самая маленькая зарплата у сотрудника с ID:" + workers[minSalaryIndex].getID() + ".");
                            System.out.println("Средний показатель зарплаты равен " + averageValue + " рублей.");
                            break;
                        default:
                            System.out.println("Нет такого действия");
                    }
                    break;
                default:
                    System.out.println("Нет такого действия");
            }
        }

    }
}