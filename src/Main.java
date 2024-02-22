/*Программа предназначена для интерактивной работы в терминале.
Для работы с программой необходимо вводить данные в терминал (согласно типам данных).
В коментариях предлагается код с добавлением работников для проверки работоспособности программы.
Если необходимо исправить код для того чтобы он строго соответствовал техническим требованиям задания, то сложности это не составит.*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Employee [] workers = new Employee[20];
        int employee = 0;
        int index = -1;
        int ID = 0;
        int department;
        int salary;
        /*workers[0] = new Employee("Андрей", "Сатыпов", "Генадиевич", 1, 390500, 1);
        workers[1] = new Employee("Алёша", "Алёшов", "Алёшевич", 1, 195300, 2);
        workers[2] = new Employee("Светлана", "Миронова", "Григорьевна", 2, 96800, 3);
        workers[3] = new Employee("Ирина", "Евстегнеева", "Николаевна", 2, 98400, 4);
        workers[4] = new Employee("Станислав", "Михайлов", "Ерефемович", 3, 122700, 5);
        workers[5] = new Employee("Илья", "Кубинских", "Алексеевич", 3, 99700, 6);
        workers[6] = new Employee("Арина", "Ганина", "Сергеевна", 4, 81400, 7);
        workers[7] = new Employee("Алиса", "Турова", "Алексеевна", 4, 50050, 8);
        workers[8] = new Employee("Роман", "Шапырин", "Акакиевич", 5, 49200, 9);
        workers[9] = new Employee("Андрей", "Щукин", "Мариванович", 5, 47300, 10);
        workers[10] = new Employee("Алип", "Стружков", "Сверлович", 5, 30200, 11);
        workers[11] = new Employee("Дмитрий", "Ганин", "Сергеевич", 5, 32100, 12);
        workers[12] = new Employee("Иван", "Разборов", "Полётович", 5, 30000, 13);
        workers[13] = new Employee("Неиван", "Сборов", "Посадкович", 5, 29999, 14);
        workers[14] = new Employee("Иоан", "Рюриков", "Грознович", 5, 39000, 15);
        workers[15] = new Employee("Лена", "Головач", "Эфиопецовна", 5, 52200, 16);
        workers[16] = new Employee("Диман", "Диванов", "Матрасович", 5, 50900, 17);
        employee = 17;*/
        while (true) {
            System.out.println("===============================================================");
            System.out.println("Выберите действие:\n1.[Добавить сотрудника]\n2.[Удалить сотрудника]\n3.[Вывести информацию]\n4.[Проиндексировать зарплату]\n5.[Выйти]");
            Scanner in = new Scanner(System.in);
            int firstAction = in.nextInt();
            in.nextLine();
            System.out.println("===============================================================");
            if (firstAction == 5) {
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
                    while (true) {
                        System.out.println("Введите отдел: ");
                        department = in.nextInt();
                        if (department > 0 && department < 6) {
                            break;
                        } else {
                            System.out.println("Такого отдела не существует.");
                        }
                    }
                    while (true) {
                        System.out.println("Введите зарплату: ");
                        salary = in.nextInt();
                        if (salary >= 0) {
                            break;
                        } else {
                            System.out.println("Зарплата не может быть отрицательным числом.");
                        }
                    }
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
                    System.out.println("Выберите действие:\n1.[Вывести информацию о всех сотрудниках]\n2.[Вывести информацию о сотруднике по ID]\n3.[Вывести список сотрудников]\n4.[Статистика]\n5.[Информация по отделу]\n6.[Информация по зарплате]\n7.[Выйти]");
                    int secondAction = in.nextInt();
                    System.out.println("===============================================================");
                    if (secondAction == 7) {
                        break;
                    }
                    switch (secondAction) {
                        case 1:
                            allEmployees(workers);
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
                                    while (true) {
                                        System.out.println("Введите отдел: ");
                                        department = in.nextInt();
                                        if (department > 0 && department < 6) {
                                            break;
                                        } else {
                                            System.out.println("Такого отдела не существует.");
                                        }
                                    }
                                    workers[index].setDepartment(department);
                                    System.out.println("Информация успешно обновлена.");
                                    System.out.println("===============================================================");
                                    break;
                                case 2:
                                    System.out.println("===============================================================");
                                    while (true) {
                                        System.out.println("Введите зарплату: ");
                                        salary = in.nextInt();
                                        if (salary >= 0) {
                                            break;
                                        } else {
                                            System.out.println("Зарплата не может быть отрицательным числом.");
                                        }
                                    }
                                    workers[index].setSalary(salary);
                                    System.out.println("Информация успешно обновлена.");
                                    System.out.println("===============================================================");
                                    break;
                                default:
                                    System.out.println("Нет такого действия");
                            }
                            index = -1;
                            System.out.println("===============================================================");
                            break;
                        case 3:
                            System.out.println("===============================================================");
                            listOfEmployees(workers);
                            System.out.println("===============================================================");
                            break;
                        case 4:
                            System.out.println("===============================================================");
                            while (true) {
                                System.out.println("Введите отдел: ");
                                department = in.nextInt();
                                if (department > 0 && department < 6) {
                                    break;
                                } else {
                                    System.out.println("Такого отдела не существует.");
                                }
                            }
                            System.out.println("Всего на зарплату в месяц уходит " + sumSalary(workers) + " рублей.");
                            System.out.println("Самая большая зарплата у сотрудника с ID:" + workers[maxSalary(workers)].getID() + ".");
                            System.out.println("Самая маленькая зарплата у сотрудника с ID:" + workers[minSalary(workers)].getID() + ".");
                            System.out.println("Средний показатель зарплаты равен " + averageValue(workers) + " рублей.");
                            System.out.println("===============================================================");
                            System.out.println("Всего на зарплату на отдел №" + department + " в месяц уходит " + sumSalaryDepartment(workers, department) + " рублей.");
                            System.out.println("Средний показатель зарплаты на отдел №" + department + " равен " + averageSalaryDepartment(workers, department) + " рублей.");
                            System.out.println("===============================================================");
                            break;
                        case 5:
                            System.out.println("===============================================================");
                            System.out.println("Введите номер отдела:");
                            department = in.nextInt();
                            allEmployeeDepartment(workers, department);
                            System.out.println("===============================================================");
                            break;
                        case 6:
                            System.out.println("===============================================================");
                            System.out.println("Выберите действие:\n1.[Вывести работников с заработком выше указаного]\n2.[Вывести работников с заработком ниже указаного]\n3.[Выйти]");
                            department = in.nextInt();
                            if (department == 3) {
                                break;
                            }
                            switch (department) {
                                case 1:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите значение зарплаты: ");
                                    salary = in.nextInt();
                                    allSalaryHigher(workers, salary);
                                    System.out.println("===============================================================");
                                    break;
                                case 2:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите значение зарплаты: ");
                                    salary = in.nextInt();
                                    allSalaryLess(workers, salary);
                                    System.out.println("===============================================================");
                                    break;
                                default:
                                    System.out.println("Нет такого действия");
                            }
                            System.out.println("===============================================================");
                            break;
                        default:
                            System.out.println("Нет такого действия");
                    }
                    break;
                case 4:
                    System.out.println("===============================================================");
                    System.out.println("Введите индекс зарплаты: ");
                    index = in.nextInt();
                    indexationSalary(workers, index);
                    System.out.println("Информация обновлена успешна.");
                    System.out.println("===============================================================");
                    break;
                default:
                    System.out.println("Нет такого действия");
            }
        }

    }
    public static void allEmployees(Employee [] workers) {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                System.out.println("===============================================================");
                System.out.println(workers[i].toString());
                System.out.println("===============================================================");
            }
        }
    }
    public static int maxSalary (Employee [] workers) {
        int maxSalary = 0;
        int maxSalaryIndex = -1;
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                if (maxSalary < workers[i].getSalary()) {
                    maxSalary = workers[i].getSalary();
                    maxSalaryIndex = i;
                }
            }
        }
        return maxSalaryIndex;
    }
    public static int minSalary (Employee [] workers) {
        int minSalary = 999999999;
        int minSalaryIndex = -1;
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                if (minSalary > workers[i].getSalary()) {
                    minSalary = workers[i].getSalary();
                    minSalaryIndex = i;
                }
            }
        }
        return minSalaryIndex;
    }
    public static int sumSalary (Employee [] workers) {
        int sumSalary = 0;
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                sumSalary = sumSalary + workers[i].getSalary();
            }
        }
        return sumSalary;
    }
    public static int numberOfWorkers (Employee [] workers) {
        int numberOfWorkers = 0;
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                numberOfWorkers++;
            }
        }
        return numberOfWorkers;
    }
    public static void listOfEmployees (Employee [] workers) {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                System.out.println(workers[i].getTwoName() + " " + workers[i].getOneName() + " " + workers[i].getThreeName());
            }
        }
    }
    public static float averageValue (Employee [] workers) {
        return (float)sumSalary(workers)/numberOfWorkers(workers);
    }
    public static void indexationSalary (Employee [] workers, int index) {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null) {
                workers[i].setSalary(workers[i].getSalary() + workers[i].getSalary()/100*index);
            }
        }
    }
    public static int sumSalaryDepartment (Employee [] workers, int department) {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                sum = sum + workers[i].getSalary();
            }
        }
        return sum;
    }
    public static int numbersEmployeeDepartment (Employee [] workers, int department) {
        int number = 0;
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                number++;
            }
        }
        return number;
    }
    public static float averageSalaryDepartment (Employee [] workers, int department) {
        return (float)sumSalaryDepartment(workers, department) / numbersEmployeeDepartment(workers, department);
    }
    public static void allEmployeeDepartment (Employee [] workers, int department) {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                System.out.println("===============================================================");
                System.out.println("Ф.И.О.: " + workers[i].getTwoName() + " " + workers[i].getOneName() + " " + workers[i].getThreeName() + "\nID: " + workers[i].getID() + "\nЗарплата: " + workers[i].getSalary());
                System.out.println("===============================================================");
            }
        }
    }
    public static void allSalaryLess (Employee [] workers, int salary) {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null && workers[i].getSalary() < salary) {
                System.out.println("===============================================================");
                System.out.println("Ф.И.О.: " + workers[i].getTwoName() + " " + workers[i].getOneName() + " " + workers[i].getThreeName() + "\nID: " + workers[i].getID() + "\nЗарплата: " + workers[i].getSalary());
                System.out.println("===============================================================");
            }
        }
    }
    public static void allSalaryHigher (Employee [] workers, int salary) {
        for (int i = 0; i < 20; i++) {
            if (workers[i] != null && workers[i].getSalary() >= salary) {
                System.out.println("===============================================================");
                System.out.println("Ф.И.О.: " + workers[i].getTwoName() + " " + workers[i].getOneName() + " " + workers[i].getThreeName() + "\nID: " + workers[i].getID() + "\nЗарплата: " + workers[i].getSalary());
                System.out.println("===============================================================");
            }
        }
    }
}