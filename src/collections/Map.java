package collections;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        HashMap<String, Integer> testMap = new HashMap<>();
        // put 은 값이 없을 경우 null 반환
        String problem = "This is a great Things";
        char[] chars = problem.toCharArray();
        for (char aChar : chars) {
            if (String.valueOf(aChar).equals(" ")) {
                continue;
            }

            if (testMap.containsKey(String.valueOf(aChar))) {
                testMap.put(String.valueOf(aChar), testMap.get(String.valueOf(aChar)) + 1);
            } else {
                testMap.put(String.valueOf(aChar), 1);
            }
        }

        System.out.println(testMap.toString());
    }
}
