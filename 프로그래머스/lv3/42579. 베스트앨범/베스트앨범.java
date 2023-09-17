import java.util.*;

class Solution {
    static class Song implements Comparable<Song>{
        int num, plays;
        String genre;
        public Song(int num, int plays, String genre) {
            this.num = num;
            this.genre = genre;
            this.plays = plays;
        }
        public int compareTo(Song o) {
            if(this.plays != o.plays) return o.plays - this.plays;
            else return this.num - o.num;
        }
    }
    
    static class Genre implements Comparable<Genre> {
        String genre;
        int cnt;
        public Genre(int num, String genre) {
            this.cnt = num;
            this.genre = genre;
        }
        public int compareTo(Genre o) {
            return this.cnt - o.cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        PriorityQueue<Genre> genreRank = new PriorityQueue<>(Collections.reverseOrder());
        Map<String, PriorityQueue<Song>> rank = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();
        
        for(int i = 0; i < genres.length ; i++) {
            cnt.put(genres[i], cnt.getOrDefault(genres[i], 0) + plays[i]);
            Song song = new Song(i, plays[i], genres[i]);
            rank.put(genres[i], rank.getOrDefault(genres[i], new PriorityQueue<>()));
            rank.get(genres[i]).add(song);
        }
        
        for(String key: cnt.keySet()) genreRank.add(new Genre(cnt.get(key), key));
        List<Integer> ans = new ArrayList<>();
        while(!genreRank.isEmpty()) {
            String genre = genreRank.poll().genre;
            for(int i = 0; i < 2; i++) {
                if(!rank.get(genre).isEmpty()) ans.add(rank.get(genre).poll().num);
            }
        }
        System.out.println(ans);
        int[] realAns = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            realAns[i] = ans.get(i);
        }
        return realAns;
    }
}