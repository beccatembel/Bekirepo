package pojo;

import java.util.List;
import java.util.Map;

public class PetPojo {
    int id;
    Map<String ,Object> category;
    String name;
    List<String> photoUrls;
    List<Map<String,Object>>tags;
    String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
