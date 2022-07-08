import java.util.*;

class Solution {
	int[][] map;
	TilePair[] tiles = new TilePair[26];

	class TilePair {
		int r1, r2, c1, c2;
		boolean deleted = false;
	}

	public String solution(int m, int n, String[] board) {
		String answer = "";
		map = new int[m][n];
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			String input = board[i];
			for (int j = 0; j < n; j++) {
				char tile = input.charAt(j);
				if (tile == '.')
					map[i][j] = -1;// 빈 칸
				else if (tile == '*')
					map[i][j] = -2;// 막힌 칸
				else {
					int tileNum = tile - 'A';
					map[i][j] = tileNum;
					if (tiles[tileNum] == null) {
						tiles[tileNum] = new TilePair();
						tiles[tileNum].r1 = i;
						tiles[tileNum].c1 = j;
						cnt++;
					} else {
						tiles[tileNum].r2 = i;
						tiles[tileNum].c2 = j;
					}
				}
			}
		}
		for (int i = 0; i < 26; i++) {
            if( tiles[i] != null && tiles[i].deleted) continue;
			if (tiles[i] != null && check(i)) {
				answer += (char) ('A' + i);
				tiles[i].deleted = true;
				i = -1;
			}
		}
        if(answer.length() != cnt) answer = "IMPOSSIBLE";
		return answer;
	}

	boolean check(int tileNum) {
		boolean flag = true;
		TilePair curr = tiles[tileNum];
		if (curr.r1 == curr.r2) {
			if (curr.c1 < curr.c2) {
				for (int i = curr.c1 + 1; i < curr.c2; i++) {
					if (map[curr.r1][i] == -2 || (map[curr.r1][i] != -1 && !tiles[map[curr.r1][i]].deleted)) {
						flag = false;
					}
				}
			}
			if (curr.c2 < curr.c1) {
				for (int i = curr.c2 + 1; i < curr.c1; i++) {
					if (map[curr.r1][i] == -2 || (map[curr.r1][i] != -1 && !tiles[map[curr.r1][i]].deleted)) {
						flag = false;
					}
				}
			}
		} else if (curr.c1 == curr.c2) {
			if (curr.r1 < curr.r2) {
				for (int i = curr.r1 + 1; i < curr.r2; i++) {
					if (map[i][curr.c1] == -2 || (map[i][curr.c1] != -1 && !tiles[map[i][curr.c1]].deleted)) {
						flag = false;
					}
				}
			}
			if (curr.r2 < curr.r1) {
				for (int i = curr.r2 + 1; i < curr.r1; i++) {
					if (map[i][curr.c1] == -2 || (map[i][curr.c1] != -1 && !tiles[map[i][curr.c1]].deleted)) {
						flag = false;
					}
				}
			}
		} else {
			if (curr.r1 < curr.r2) {
				if (curr.c1 < curr.c2) {
					for (int i = curr.r1 + 1; i < curr.r2; i++) {
						int mapInfo = map[i][curr.c1];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.c1; i < curr.c2; i++) {
							int mapInfo = map[curr.r2][i];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					}
					if (flag)
						return true;
					flag = true;
					for (int i = curr.c1 + 1; i < curr.c2; i++) {
						int mapInfo = map[curr.r1][i];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.r1; i < curr.r2; i++) {
							int mapInfo = map[i][curr.c2];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					} if (flag)
						return true;
				} else {
					for (int i = curr.r1 + 1; i < curr.r2; i++) {
						int mapInfo = map[i][curr.c1];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.c1; i > curr.c2; i--) {
							int mapInfo = map[curr.r2][i];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					}
					if (flag)
						return true;
					flag = true;
					for (int i = curr.r2 - 1; i > curr.r1; i--) {
						int mapInfo = map[i][curr.c2];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.c2; i < curr.c1; i++) {
							int mapInfo = map[curr.r1][i];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					}
					if (flag)
						return true;
				}
			} else {
				if (curr.c2 < curr.c1) {
					for (int i = curr.r2 + 1; i < curr.r1; i++) {
						int mapInfo = map[i][curr.c2];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.c2; i < curr.c1; i++) {
							int mapInfo = map[curr.r1][i];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					}
					if (flag)
						return true;
					flag = true;
					for (int i = curr.c2 + 1; i < curr.c1; i++) {
						int mapInfo = map[curr.r2][i];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.r2; i < curr.r1; i++) {
							int mapInfo = map[i][curr.c1];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					} if (flag)
						return true;
				} else {
					for (int i = curr.r1 - 1; i > curr.r2; i--) {
						int mapInfo = map[i][curr.c1];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.c1; i < curr.c2; i++) {
							int mapInfo = map[curr.r1][i];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					}
					if (flag)
						return true;
					flag = true;

					for (int i = curr.c1 + 1; i < curr.c2; i++) {
						int mapInfo = map[curr.r1][i];
						if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
							flag = false;
						}
					}
					if (flag) {
						for (int i = curr.r1; i > curr.r2; i--) {
							int mapInfo = map[i][curr.c2];
							if (mapInfo == -2 || (mapInfo != -1 && !tiles[mapInfo].deleted)) {
								flag = false;
							}
						}
					} if (flag)
						return true;
				}
			}

		}
		return flag;
	}
}