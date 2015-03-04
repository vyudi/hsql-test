package app.dal;

import java.util.List;
import app.dal.entities.Users;
 
public interface DataPovider {
    public String loadData();
    public List<Users> getUsers();
}