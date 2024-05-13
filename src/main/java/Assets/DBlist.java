package Assets;

import Config.FactoryUtil;
import Model.Standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DBlist {

    private List<Standard> standardList;
    private static DBlist istanza;



    private DBlist(){
      standardList = new ArrayList<>();
      this.standardList = FactoryUtil.getIstanza().getStandardService().getAll();
    }

    public synchronized static DBlist getIstanza() {

        if (istanza == null) {
            istanza = new DBlist();
        }
        return istanza;
    }


    public List<Standard> getStandardList() {
        return standardList;
    }
}
