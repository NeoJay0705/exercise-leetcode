package org.exercise.zother;

public class T {
    private int result;
    public static int solution(String[] strings) {

        return 0;
    }

    public void dfs(String[] strings, int index, String curr) {
        result = Math.max(curr.length(), result);
        for (int i = index; i < strings.length; i++) {
            dfs(strings, i + 1, curr + strings[i]);
        }
    }

    public void check() {
        //
    }
}
