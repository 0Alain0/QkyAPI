package app;

import model.Response;
import service.QkyRobotService;
import service.RobotService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static RobotService myRobot = new QkyRobotService();
    private static Response myResponse = new Response();

    public static void main(String arg[]) throws IOException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入小助手的名字:");
        String name = myScanner.nextLine();
        while(true){
            System.out.println("老板你好，我是你的小助手：" + name + ",有什么要求直接输入命令");
            String msg = myScanner.nextLine();
            if ("886".equalsIgnoreCase(msg)) {
                System.out.println("老板再见");
                break;
            }else{
                myResponse = myRobot.qa(msg);
                System.out.println(new String(myResponse.getContent().getBytes(),"UTF-8"));
            }
        }
    }
}
