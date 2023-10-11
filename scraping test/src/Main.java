import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        String word = "";
        for(int id=1000;id<2000;id++) {
            String tword=getRandomWord(id);
            if(tword=="")
            {

            }
            else {
                word=word+"\n"+tword;
            }
            System.out.println("scraping... "+id+"/2000");
        }
        System.out.println(word);
    }
    public static String getRandomWord(int lineid)  {
        long startTime = System.nanoTime();
        Random rd = new Random();

        URL webpage = null;
        HttpsURLConnection conn = null;
        InputStreamReader reader = null;

        try {

            webpage = new URL("https://en.wikipedia.org/wiki/Walmart");

            conn = (HttpsURLConnection) webpage.openConnection();
            conn.setRequestProperty ( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0" );

            reader = new InputStreamReader(conn.getInputStream(), "UTF8");
        }catch (Exception ex){
            System.out.println("failed to find website");
            return "defaultrandomword";
        }
        long endTime = System.nanoTime();
        //System.out.println("http request time: " + (startTime-endTime));
        startTime = System.nanoTime();
        //int randomLine = rd.nextInt(0, 10000); // WORD LIST 1
        //randomLine = rd.nextInt(0, 58111); // WORD LIST 2
        int randomLine;

        randomLine = lineid;



        BufferedReader buffer = new BufferedReader(reader);

        int count = 0;
        String line = "";



        //System.out.println("This code is being run hehe");

        while (count < randomLine){
            try {
                line = buffer.readLine();
                count++;
            }
            catch (Exception ex){
                //System.out.println("buffer failed");
            }

        }

        if (line == null){
            //System.out.println("line is null!");
            return "";
        }

        if (line.contains("'") || line.contains("-")){
            //System.out.println("line had a syntax");
            //return getRandomWord(lineid+1);
        }
        //System.out.println(line);
        // Removes nonsense
        line = line.replaceAll("<[^>]*>", "");
        //line = line.replaceAll(" ", "");
        line = line.replaceAll("\t", "");
        //line = line.replaceAll("[^a-zA-Z0-9]", "");

        //line = line.toLowerCase();

        // Word length is at least one
        if (line.length() < 1){
            //System.out.println("THIS LINE IS TOO SHORT >:( " + line + " " + line.length());
            //return getRandomWord(lineid+1);
        }
        endTime = System.nanoTime();
        //System.out.println("other time: " + (startTime-endTime));
        return line;


    }
}