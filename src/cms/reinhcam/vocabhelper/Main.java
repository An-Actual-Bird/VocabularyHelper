package cms.reinhcam.vocabhelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main
{
    static String end = "";

    public static void main(String[] args) throws Exception
    {

        URL wikipedia = new URL("https://simple.wikipedia.org/wiki/Congress");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(wikipedia.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
            try
            {
                if (inputLine.charAt(0) == '<' && inputLine.charAt(1) == 'p' && inputLine.charAt(2) == '>')
                {
                    replace(inputLine);
                    break;
                }
            } catch (Exception e)
            {
            }
        }
        in.close();
    }

    public static void replace(String string)
    {
        string = string.replaceAll("<p>", "");
        string = string.replaceAll("<b>", "");
        string = string.replaceAll("</b>", "");
        string = string.replaceAll("<a href=\"/wiki/", "");
        string = string.replaceAll("title=\"", "");
        string = string.replaceAll("</a>", "");
        string = string.replaceAll("</p>", "");
        string = string.replaceAll(">", " ");

        String[] trim = string.split(" ");
        for (int i = 0; i < trim.length; i++)
        {
            if (i < trim.length - 1)
            {
                if (trim[i].equals(trim[i + 1]))
                {
                    trim[i] = "";
                    trim[i + 1] = "";

                    i++;
                }
            }
            end = end + (trim[i] + " ");
        }
        System.out.println(end);
    }
}