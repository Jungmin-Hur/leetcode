package acomp;

import common.Acomp;

import java.util.*;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */
@Acomp
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
    private List<Integer> history;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        history = new LinkedList<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        int value = cache.get(key);

        boolean isExist = false;
        if(history.contains(key)) {
            history.remove(key); //중간에서 지워주고
            history.add(key); //끝에 넣어준다.
            //cache는 지울필요 없음. 어짜피 위에서 put하면서 업데이트 되었기 때문에
            System.out.println("get history remove(isExist true) !!! ==>" + key);
            System.out.println("get history add(isExist true) !!! ==>" + key);

        } else {
            if(capacity < cache.size()){
                history.remove(0);
            }
            history.add(key);
            System.out.println("get history add(isExist false) !!! ==>" + key);
        }
        return value;
    }

    public void put(int key, int value) {
        System.out.println("put cache put!!! ==>" + key);
        cache.put(key, value); //캐시에 등록함

        //만약에 캐시안에 같은 키를 가진 값이 존재하면
        //해당키에 대한 히스토리는 최우선으로 변경해주기만 해야 함
        boolean isExist = false;
        if(history.contains(key)) {
            history.remove(key); //중간에서 지워주고
            history.add(key); //끝에 넣어준다.
            //cache는 지울필요 없음. 어짜피 위에서 put하면서 업데이트 되었기 때문에
            System.out.println("put history remove(isExist true) !!! ==>" + key);
            System.out.println("put history add(isExist true) !!! ==>" + key);
        } else {
            if(capacity < cache.size()){
                Integer q = history.get(0);
                cache.remove(q); //제일 처음껄 빼준다.
                history.remove(0);
            }
            history.add(key);
            System.out.println("put history add(isExist false) !!! ==>" + key);
        }
    }

}
