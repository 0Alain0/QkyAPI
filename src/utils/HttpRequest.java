package utils;

import model.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

    public static String request(String api) throws IOException {
        URL myUrl = new URL(api);
        HttpURLConnection myConnection = (HttpURLConnection) myUrl.openConnection();
        int myCode = myConnection.getResponseCode();
        if (200 <= myCode && myCode <= 299) {
            InputStream myInputStream = myConnection.getInputStream();
            BufferedReader myBufferedRerader = new BufferedReader(new InputStreamReader(myInputStream));
            StringBuilder result = new StringBuilder();
            String currtenLine;
            while((currtenLine = myBufferedRerader.readLine()) != null){
                result.append(currtenLine);
            }
            return result.toString();
        }else{
            System.out.println("网络连接错误！");
        }
        return null;
    }
}
