package flip;

import common.Flip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Flip
public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] str = path.split(" ");
            for(int i=1; i<str.length; i++) {
                String[] file = str[i].split("\\(");
                String filename = str[0] + "/" + file[0];
                String content = file[1];

                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(filename);
                map.put(content, list);
            }
        }
        List<List<String>> retVal = new ArrayList<>();
        for(String content : map.keySet()) {
            List<String> list = map.get(content);
            if(list.size() > 1) {
                retVal.add(map.get(content));
            }
        }

        return retVal;
    }
}
