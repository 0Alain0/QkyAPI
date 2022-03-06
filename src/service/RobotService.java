package service;

import model.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface RobotService {
    Response qa(String msg) throws IOException;
}
