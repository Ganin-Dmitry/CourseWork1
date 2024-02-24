/*Программа предназначена для интерактивной работы в терминале.
Для работы с программой необходимо вводить данные в терминал (согласно типам данных).
В коментариях предлагается код с добавлением работников для проверки работоспособности программы.
Если необходимо исправить код для того чтобы он строго соответствовал техническим требованиям задания, то сложности это не составит.*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numEmployee = 20;
        Scanner in = new Scanner(System.in);
        Employee [] worker = new Employee [numEmployee];
        EmployeeBook workers = new EmployeeBook(worker);
        int action;
        int ID;
        int salary;
        int department;
        String text;
        while (true) {
            System.out.println("===============================================================");
            System.out.println("Выберите действие:\n1.[Добавить сотрудника]\n2.[Удалить сотрудника]\n3.[Вывести информацию]\n4.[Проиндексировать зарплату]\n5.[Выйти]");
            action = in.nextInt();
            text = in.nextLine();
            if (action == 5) {
                break;
            }
            System.out.println("===============================================================");
            switch (action) {
                case 1:
                    System.out.println("===============================================================");
                    System.out.println("Введите имя:");
                    String oneName = in.nextLine();
                    System.out.println("Введите фамилию:");
                    String surname = in.nextLine();
                    System.out.println("Введите отчество:");
                    String threeName = in.nextLine();
                    while (true) {
                        System.out.println("Введите номер отдела:");
                        department = in.nextInt();
                        if (department > 0 && department < 6) {
                            break;
                        } else {
                            System.out.println("Такого отдела не существует.");
                        }
                    }
                    while (true) {
                        System.out.println("Введите зарплату:");
                        salary = in.nextInt();
                        if (salary >= 0) {
                            break;
                        } else {
                            System.out.println("Зарплата не может быть отрицательным числом.");
                        }
                    }
                    workers.addWorker(oneName, surname, threeName, department, salary);
                    System.out.println("Информация успешно обновлена.");
                    System.out.println("===============================================================");
                    break;
                case 2:
                    System.out.println("===============================================================");
                    System.out.println("Введите ID сотрудника:");
                    ID = in.nextInt();
                    workers.delWorker(workers.getWorker(ID));
                    System.out.println("Информация успешно обновлена.");
                    System.out.println("===============================================================");
                    break;
                case 3:
                    System.out.println("===============================================================");
                    System.out.println("Выберите действие:\n1.[Вывести информацию о всех сотрудниках]\n2.[Вывести информацию о сотруднике по ID]\n3.[Вывести список сотрудников]\n4.[Статистика]\n5.[Информация по отделу]\n6.[Информация по зарплате]\n7.[Назад]");
                    action = in.nextInt();
                    if (action == 7) {
                        break;
                    }
                    System.out.println("===============================================================");
                    switch (action) {
                        case 1:
                            System.out.println("===============================================================");
                            workers.allEmployees();
                            System.out.println("===============================================================");
                            break;
                        case 2:
                            System.out.println("===============================================================");
                            System.out.println("Введите ID работника:");
                            ID = in.nextInt();
                            System.out.println(workers.getWorker(ID).toString());
                            System.out.println("Выберите действие:\n1.[Изменить отдел]\n2.[Изменить зарплату]\n3.[Назад]");
                            action = in.nextInt();
                            if (action == 3) {
                                break;
                            }
                            System.out.println("===============================================================");
                            switch (action) {
                                case 1:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите новый номер отдела:");
                                    department = in.nextInt();
                                    workers.getWorker(ID).setDepartment(department);
                                    System.out.println("Информация успешно обновлена.");
                                    System.out.println("===============================================================");
                                    break;
                                case 2:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите новую зарплату:");
                                    salary = in.nextInt();
                                    workers.getWorker(ID).setSalary(salary);
                                    System.out.println("Информация успешно обновлена.");
                                    System.out.println("===============================================================");
                                    break;
                                default:
                                    System.out.println("Нет такого действия");
                            }
                            System.out.println("===============================================================");
                            break;
                        case 3:
                            System.out.println("===============================================================");
                            workers.listOfEmployees();
                            System.out.println("===============================================================");
                            break;
                        case 4:
                            System.out.println("===============================================================");
                            System.out.println("Введите номер отдела:");
                            department = in.nextInt();
                            System.out.println("===============================================================");
                            System.out.println("В месяц на зарплату сотрудникам уходит " + workers.sumSalary() + " рублей");
                            System.out.println("Средний показатель зарплаты равен " + workers.averageSalary() + " рублей");
                            System.out.println("Самая высокая зарплата у работника с ID:" + workers.maxSalary() + ".");
                            System.out.println("Самая низкая зарплата у работника с ID:" + workers.minSalary() + ".");
                            System.out.println("===============================================================");
                            System.out.println("В месяц на зарплату сотрудникам отдела №" + department + " уходит " + workers.sumSalaryDepartment(department) + " рублей");
                            System.out.println("Средний показатель зарплаты отдела №" + department + " равен " + workers.averageSalaryDepartment(department) + " рублей");
                            System.out.println("===============================================================");
                            break;
                        case 5:
                            System.out.println("===============================================================");
                            System.out.println("Введите номер отдела:");
                            department = in.nextInt();
                            System.out.println("===============================================================");
                            workers.allEmployeeDepartment(department);
                            System.out.println("===============================================================");
                            break;
                        case 6:
                            System.out.println("===============================================================");
                            System.out.println("Выберите действие:\n1.[Вывести информацию о сотрудниках с зарплатой выше указанной]\n2.[Вывести информацию о сотрудниках с зарплатой ниже указанной]");
                            action = in.nextInt();
                            System.out.println("===============================================================");
                            switch (action) {
                                case 1:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите значение зарплаты:");
                                    salary = in.nextInt();
                                    workers.allSalaryHigher(salary);
                                    System.out.println("===============================================================");
                                    break;
                                case 2:
                                    System.out.println("===============================================================");
                                    System.out.println("Введите значение зарплаты:");
                                    salary = in.nextInt();
                                    workers.allSalaryLess(salary);
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
                    System.out.println("===============================================================");
                    break;
                case 4:
                    System.out.println("===============================================================");
                    System.out.println("Введите индекс заработной платы:");
                    int index = in.nextInt();
                    workers.indexationSalary(index);
                    System.out.println("===============================================================");
                    break;
                default:
                    System.out.println("Нет такого действия");
            }
        }
    }
}