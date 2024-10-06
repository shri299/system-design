package proxydesignpattern;

public class EmployeeImpl implements EmployeeDao{


    @Override
    public void create(Employee employee, String user) {
        System.out.println("creating new employee");
    }

    @Override
    public void delete(String id, String user) {
        System.out.println("deleting employee with id: "+id);
    }

    @Override
    public Employee get(String id, String user) {
        System.out.println("fetching employee with id: "+id);
        return new Employee();
    }
}
