package cms.reinhcam.vocabhelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main
{
    static String string;
    public static void main(String[] args) throws Exception
    {

        URL oracle = new URL("https://simple.wikipedia.org/wiki/Government");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
            try
            {
                if (inputLine.charAt(0) == '<' && inputLine.charAt(1) == 'p' && inputLine.charAt(2) == '>')
                {
                    replace(inputLine);
                    string = inputLine;
                    System.out.println(inputLine);
                }
            }catch(Exception e){}
        }
        in.close();
    }
    public static String replace(String string)
    {
        string = string.replaceAll("<p>","");
        string = string.replaceAll("<b>","");
        string = string.replaceAll("</b>","");
        string = string.replaceAll("<a href=\"/wiki/","");
        string = string.replaceAll("title=\"","");
        string = string.replaceAll("</a>","");
        string = string.replaceAll("</p>","");
        string = string.replaceAll(" ","");

        return string;
    }
}