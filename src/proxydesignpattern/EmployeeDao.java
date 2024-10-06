package proxydesignpattern;

public interface EmployeeDao {

    void create(Employee employee, String user);
    void delete(String id, String user);
    Employee get(String id, String user);
}
