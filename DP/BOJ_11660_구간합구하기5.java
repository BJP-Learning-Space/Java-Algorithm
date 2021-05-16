package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(i == 1){
                    map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
                }else if(j == 1){
                    map[i][j] = map[i - 1][j] + Integer.parseInt(st.nextToken());
                }else{
                    map[i][j] = map[i][j - 1] + map[i - 1][j] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int result = map[y2][x2] - map[y2][x1 - 1] - map[y1 - 1][x2] + map[y1 - 1][x1 - 1];
            sb.append(result + "\n");
        }
        System.out.print(sb.toString());
    }
}
