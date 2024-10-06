package proxydesignpattern;

public class EmployeeImplProxy implements EmployeeDao{

    EmployeeDao employeeDao;

    EmployeeImplProxy (){
        this.employeeDao = new EmployeeImpl();
    }

    @Override
    public void create(Employee employee, String user) {
        if ("ADMIN".equals(user)){
            employeeDao.create(new Employee(),user);
        }else {
            System.out.println("Create request not allowed");
        }
    }

    @Override
    public void delete(String id, String user) {
        if ("ADMIN".equals(user)){
            employeeDao.delete(id,user);
        }else {
            System.out.println("delete request not allowed");
        }
    }

    @Override
    public Employee get(String id, String user) {
        if ("ADMIN".equals(user)){
            return employeeDao.get(id,user);
        }
        System.out.println("get request not allowed");
        return null;
    }
}
