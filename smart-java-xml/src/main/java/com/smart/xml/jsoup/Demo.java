package com.smart.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/2417:46
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        String path = Demo.class.getClassLoader().getResource("User.xml").getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");

        Elements elements = document.getElementsByTag("Name");

        System.out.println(elements.size());

        System.out.println(elements.get(0).text());
    }
}
