package objectpooldesignpattern;

public class Main {

    public static void main(String[] args) {
        DBConnectionPoolManager dbConnectionPoolManager = DBConnectionPoolManager.getInstance();
        dbConnectionPoolManager.getDBConnection();
        dbConnectionPoolManager.getDBConnection();
        dbConnectionPoolManager.getDBConnection();

        dbConnectionPoolManager.getDBConnection();
        dbConnectionPoolManager.getDBConnection();
        dbConnectionPoolManager.getDBConnection();

        dbConnectionPoolManager.getDBConnection();

    }
}
