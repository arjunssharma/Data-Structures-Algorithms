package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_II {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> nodeNeighbors = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    Set<String> dictionary;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        dictionary = new HashSet<>(wordList);
        if(!dictionary.contains(endWord))
            return result;
        
        List<String> solution = new ArrayList<>();
        
        dictionary.add(beginWord);
        bfs(beginWord, endWord);
        dfs(beginWord, endWord, solution);
        
        return result;
    }
    
    public List<String> getNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        char ch[] = current.toCharArray();
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < ch.length; i++) {
                if(ch[i] == c)
                    continue;
                char old_char = ch[i];
                ch[i] = c;
                if(dictionary.contains(String.valueOf(ch)))
                    neighbors.add(String.valueOf(ch));
                ch[i] = old_char;
            }
        }
        
        return neighbors;
    }
    
    public void bfs(String start, String end) {
        for(String str : dictionary)
            nodeNeighbors.put(str, new ArrayList<String>());
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        
        while(!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for(int i = 0; i < count; i++) {
                String current = queue.poll();
                int current_distance = distance.get(current);
                List<String> neighbors = getNeighbors(current);
                
                for(String neighbor : neighbors) {
                    nodeNeighbors.get(current).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, current_distance + 1);
                        if(end.equals(neighbor))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            
            if(foundEnd)
                break;
        }
    }
    
    public void dfs(String current, String end, List<String> solution) {
        solution.add(current);
        if(end.equals(current))
            result.add(new ArrayList<String>(solution));
        else {
            for(String neighbor : nodeNeighbors.get(current)) {
                if(distance.get(neighbor) == distance.get(current) + 1)
                    dfs(neighbor, end, solution);
            }
        }
        solution.remove(solution.size() - 1);
    }
}
