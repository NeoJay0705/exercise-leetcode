package org.exercise;

import java.util.HashMap;
import java.util.Map;

public class DayofweekthatisKdayslater {
    private enum DayOfWeek {MON();}
    public static String solution(String dayOfWeek, int k) {
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int daysUnenoughWeek = k % 7;

        int index = -1;
        for (int i = 0; i < days.length; i++) {
            if (days[i] == dayOfWeek) {
                index = i;
                break;
            }
        }

        return days[(index + daysUnenoughWeek) % 7];
    }
}
