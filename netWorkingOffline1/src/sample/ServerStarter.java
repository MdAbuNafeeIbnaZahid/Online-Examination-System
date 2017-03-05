package sample;

/**
 * Created by nafee on 3/5/17.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class ServerStarter {
    public static void main(String[] args) {
        Server server = new Server();


    }
}
