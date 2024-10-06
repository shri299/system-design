package proxydesignpattern;

public class Main {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeImplProxy();
        employeeDao.create(new Employee(),"USER");
    }
}
