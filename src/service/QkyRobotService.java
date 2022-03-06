package service;

import com.google.gson.Gson;
import model.Response;
import utils.HttpRequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QkyRobotService  implements RobotService{

    private static final String APItpl = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=%s";
    Gson gson = new Gson();

    public Response qa(String msg) throws IOException {
        String api = String.format(APItpl, URLEncoder.encode(msg,"UTF-8"));
        String myResult = HttpRequest.request(api);
        return  gson.fromJson(myResult,Response.class);
    }
}
