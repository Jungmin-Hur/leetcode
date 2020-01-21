import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String args[]) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> dic = convertTargetToMap(t);
        Map<Character, Integer> refer = convertTargetToMap(t); //refer에서 값을 빼주는 방식. refer size가 0이면 find 했다고 판단

        int startPoint = findNext(s, 0, dic);
        int endPoint = startPoint;
        if(startPoint == -1) return "";

        int minStartPoint = -1, minEndPoint = -1;
        int minWindows = Integer.MAX_VALUE;

        deleteRefer(s.charAt(startPoint), refer, dic);

        while(true) {
            if(startPoint == -1) break;
            boolean find = false;
            if(isFind(refer)) {
                find = true;
                int localSize = endPoint-startPoint+1;
                if(localSize < minWindows) {
                    minWindows = localSize;
                    minStartPoint = startPoint;
                    minEndPoint = endPoint;
                }
            }
            if(find) {
                addRefer(s.charAt(startPoint), refer, 1);
                startPoint = findNext(s, startPoint+1, dic);
            } else {
                if(endPoint != -1) {
                    endPoint = findNext(s, endPoint+1, dic);
                }
                if(endPoint != -1) {
                    if(refer.containsKey(s.charAt(endPoint))) {
                        deleteRefer(s.charAt(endPoint), refer, dic);
                    } else {
                        addRefer(s.charAt(endPoint), refer, -1);
                    }
                } else {
                    addRefer(s.charAt(startPoint), refer, 1);
                    startPoint = findNext(s, startPoint+1, dic);
                }
            }
        }
        return minStartPoint==-1? "" : s.substring(minStartPoint, minEndPoint+1);
    }

    public static boolean isFind(Map<Character, Integer> refer) {
        for(Character c : refer.keySet()) {
            if(refer.get(c) > 0 ) return false;
        }
        return true;
    }

    public static void deleteRefer(char c, Map<Character, Integer> refer, Map<Character, Integer> dic) {
        if(refer.getOrDefault(c,1) == 1) {
            refer.remove(c);
        } else {
            refer.put(c, refer.getOrDefault(c,1)-1);
        }
    }

    public static void addRefer(char c, Map<Character, Integer> refer, int count) {
        refer.put(c, refer.getOrDefault(c, 0) + count);
    }

    public static int findNext(String s, int startPoint, Map<Character, Integer> dic) {
        int sLength = s.length();
        for(int i = startPoint; i < sLength; i++) {
            if(dic.containsKey(s.charAt(i))) return i;
        }
        return -1; //not found
    }

    private static Map<Character, Integer> convertTargetToMap(String t) {
        int tLength = t.length();
        Map<Character, Integer> dic = new HashMap<>();
        for(int i=0; i<tLength; i++) {
            dic.put(t.charAt(i), dic.getOrDefault(t.charAt(i), 0) + 1);
        }
        return dic;
    }
}
