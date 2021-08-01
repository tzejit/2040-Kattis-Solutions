import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//java -cp jsoup-1.14.1.jar Markdown.java
public class Markdown {
  public static String googleQ = "http://www.google.com/search?q=";
  public static void main(String[] args) {
    File folder = new File("codes");
    ArrayList<String> names = new ArrayList<>();
    for (File fileEntry : folder.listFiles()) {
        names.add(fileEntry.getName());
        }
    try {
      FileWriter w = new FileWriter("md.txt");
      for (String s : names) {
        String parse = s.replaceAll("([A-Z])", " $1");
        if (Character.isDigit(parse.charAt(0))) {
          parse = parse.substring(0,parse.length()-5);
        } else {
          parse = parse.substring(1,parse.length()-5);
        }
        Document linksDoc = null; 
        String url = "null statistics";
        linksDoc = Jsoup.connect( googleQ + parse + "+site%3Aopen.kattis.com").get();
        Element link = linksDoc.select("div#search a").first();
        if (link != null)
          url = link.attr("href");
        w.write("[" + parse + "](../master/Code/" + s + ")|[Link](" + url.substring(0, url.length()-11) + ")" +"\n");
      }
      w.close();
      System.out.println("Done!");
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}