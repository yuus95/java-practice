package main.effective;

import java.io.*;

public class Item9 {


    public static void main(String[] args) {

    }

    static void copy(String src, String dst) {

        //try resource 를 활용하면 다수의 예외를 한번에 처리할수 있다.
        try (
                InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[128];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        } catch (IOException i) {
            System.out.println("IOException");
        }
    }
}
