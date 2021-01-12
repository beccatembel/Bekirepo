package serilization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IntroSerilize {
@Test
    public void carsTest() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
       Cars carObject = new Cars("BMW","X7",2021,100000);
       carObject.setMilage(10);
       carObject.setColor("black");
       carObject.setYear(2020);



       File jsonFile=new File("src/test/java/serilization/cars.json");
       objectMapper.writeValue(jsonFile,carObject);
    }
}
