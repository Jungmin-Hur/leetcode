/**
 * 1192. Critical Connections in a Network
 * https://leetcode.com/problems/critical-connections-in-a-network/
 */
package acomp;

import common.Acomp;

import java.util.*;

//reference blog
//https://kks227.blog.me/220802519976


@Acomp
public class CriticalConnectionsInANetwork {

    /**
     * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
     * Output: [[1,3]]
     * Explanation: [[3,1]] is also accepted.
     */
    public static void main(String args[]) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(0);
        l1.add(1);
        l2.add(1);
        l2.add(2);
        l3.add(2);
        l3.add(0);
        l4.add(1);
        l4.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<List<Integer>> result = criticalConnections(4, list);

        for(List<Integer> i : result) {
            System.out.println(i.get(0) + "," + i.get(1));
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        //build graph
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(List<Integer> connection :connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        int[] lowestVertex = new int[n]; //lowest vertext from current vertex u
        int[] discoveredTime = new int[n]; //discovered time
        Arrays.fill(discoveredTime, -1);

        List<List<Integer>> ans = new ArrayList<>();

        for(int u=0; u < n; u++) {
            if(discoveredTime[u] != -1) {
                dfs(u, u, lowestVertex, discoveredTime, graph, ans);
            }
        }
        return ans;
    }

    static int time = 0;

    //not working.. how???
    public static void dfs(int current, int preCurrent, int[] lowestVertex, int[] discoveredTime, List<Integer>[] graph, List<List<Integer>> ans) {
        time++;
        lowestVertex[current] = time;
        discoveredTime[current] = time;

        for(int adjacent : graph[current]) {
            if(adjacent == preCurrent) continue;

            if(discoveredTime[adjacent] < 0) { //if it doesn't discovered
                dfs(adjacent, current, lowestVertex, discoveredTime, graph, ans);
                lowestVertex[current] = Math.min(lowestVertex[current], lowestVertex[adjacent]);

                if(lowestVertex[adjacent] > discoveredTime[current]) {
                    ans.add(Arrays.asList(current, adjacent));
                }
            } else {
                lowestVertex[current] = Math.min(lowestVertex[current], discoveredTime[adjacent]);
            }
        }
    }

    /**
     * idea
     * dfs search를 하면서.. 순서를 저장해놓는다 d[]
     * 해당 노드에서 search할 수 있는 가장 작은 값을 저장해 둔다 l[]
     * l[현재노드] > d[부모노드] 인 경우 critical connection 지점이고, 결과에 저장해 둔다.
     *
     * dfs를 하는 것은 어떻게???
     * 해당 노드에서 search가능한 가장 작은 값을 어떻게 찾는지?
     */

    /**
     * 1st solution
     * https://leetcode.com/problems/critical-connections-in-a-network/discuss/399827/Java-DFS-Solution-similar-to-Tarjan-maybe-easier-to-understand
     */
    //TODO dfs 만들어보기 not using recursive (only use stack!!)

    static int T = 1;
    public static List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
        // use a timestamp, for each node, check the samllest timestamp that can reach from the node
        // construct the graph first
        List[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1)); //양방향을 모두 저장해 줌??
            graph[conn.get(1)].add(conn.get(0));
        }

        int[] timestamp = new int[n]; // an array to save the timestamp that we meet a certain node

        // for each node, we need to run dfs for it, and return the smallest timestamp in all its children except its parent
        List<List<Integer>> criticalConns = new ArrayList<>();
        dfs1(n, graph, timestamp, 0, -1, criticalConns);
        return criticalConns;
    }

    // return the minimum timestamp it ever visited in all the neighbors
    private static int dfs1(int n, List[] graph, int[] timestamp, int i, int parent, List<List<Integer>> criticalConns) {
        if (timestamp[i] != 0) return timestamp[i]; //timestamp means.. 노드 방문 순서
        timestamp[i] = T++;

        int minTimestamp = Integer.MAX_VALUE;
        for (int neighbor : (List<Integer>) graph[i]) { //그래프에 존재하는 모든 정점을 확인한다.
            if (neighbor == parent) continue; // no need to check the parent
            int neighborTimestamp = dfs1(n, graph, timestamp, neighbor, i, criticalConns); //dfs를 실행...
            minTimestamp = Math.min(minTimestamp, neighborTimestamp);
        }

        if (minTimestamp >= timestamp[i]) {
            if (parent >= 0) criticalConns.add(Arrays.asList(parent, i));
        }
        return Math.min(timestamp[i], minTimestamp);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 2nd solution
     * https://leetcode.com/problems/critical-connections-in-a-network/discuss/426522/Java-solution-with-Tarjan
     */
    public static void tarjan(int u,int parent){
        low[u] = step;
        dfn[u] = step;
        step++;
        for (Integer v:graph.get(u)){
            if(dfn[v]==0){ //아직 검색하지 않은 것을 검색
                tarjan(v,u);
                low[u] = Math.min(low[u],low[v]);
                if(low[v]>dfn[u]){
                    ArrayList<Integer> temp = new ArrayList<>();
                    if(u<v){
                        temp.add(u);
                        temp.add(v);
                    }
                    else{
                        temp.add(v);
                        temp.add(u);
                    }
                    res.add(temp);
                }
            }
            else if(v!=parent){
                low[u] = Math.min(low[u],dfn[v]);
            }
        }
    }

    static int[] dfn;
    static int[] low;
    static int step = 1;
    static List<List<Integer>> graph  = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
        dfn = new int[n];
        low = new int[n];

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>()); //그래프 노드 초기화
        }
        for(List l:connections){
            int x = (int)l.get(0);
            int y = (int)l.get(1);
            graph.get(x).add(y); //양방향 그래프를 저장해 둠
            graph.get(y).add(x);
        }

        for(int i=0;i<n;i++){
            if(dfn[i]==0){
                tarjan(i,-1); //각 점에서 dfs를 돌림
            }

        }
        return res;
    }
}
