package ch10;

import java.text.DecimalFormat;

public class DecimalFormatEx1 {
    public static void main(String[] args) {
        double number = 12234567.89;
        String[] pattern = {
                "0",
                "#",
                "0.0",
                "#.#",
                "0000000000.0000",
                "##########.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "#,####.##",
                "#,##,###.##"};

        for (String s : pattern) {
            DecimalFormat df = new DecimalFormat(s);
            System.out.printf("%3s : %s \n", s, df.format(number));
        }
    }
}


