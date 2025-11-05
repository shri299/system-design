package objectpooldesignpattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {

    private final List<DBConnection> freeList = new ArrayList<>(); //free resource pool
    private final List<DBConnection> inUseList = new ArrayList<>();
    private final int MAX_POOL_SIZE = 6;

    private final int INITIAL_POOL_SIZE = 3;

    private static DBConnectionPoolManager dbConnectionPoolManager = null;

    private DBConnectionPoolManager (){
        for (int i=0;i<INITIAL_POOL_SIZE;i++){
            freeList.add(new DBConnection());
        }
    }

    //double locking approach
    public static DBConnectionPoolManager getInstance(){
        if (dbConnectionPoolManager==null){
            synchronized (DBConnectionPoolManager.class){
                if (dbConnectionPoolManager==null){
                    dbConnectionPoolManager = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManager;
    }

    public synchronized DBConnection getDBConnection(){
        if (freeList.isEmpty() && inUseList.size()<MAX_POOL_SIZE){
            //add a new resource to the free pool
            freeList.add(new DBConnection());
        }else if (freeList.isEmpty() && inUseList.size()>=MAX_POOL_SIZE){
            //in use resource count breached
            System.out.println("max limit reached");
            return null;
        }
        DBConnection dbConnection = freeList.remove(freeList.size()-1);
        inUseList.add(dbConnection);
        return dbConnection;
    }

    public synchronized void releaseConnection(DBConnection dbConnection){
        if (dbConnection!=null){
            inUseList.remove(dbConnection);
            freeList.add(dbConnection);
        }
    }
}
