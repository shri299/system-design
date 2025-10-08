package proxydesignpattern;

public class Main {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeImplProxy();
        employeeDao.create(new Employee(),"USER");
    }

    //refer:
    //https://medium.com/nerd-for-tech/5-design-pattern-proxy-ea1a40a014ec
    //https://refactoring.guru/design-patterns/proxy
}
