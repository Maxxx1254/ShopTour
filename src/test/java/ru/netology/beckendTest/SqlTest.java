package ru.netology.beckendTest;

import org.testng.annotations.Test;
import ru.netology.helpers.SQLHelper;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTest {

    @Test
    public void declined() throws IOException, InterruptedException {
        SQLHelper.getBodyRequestDeclined();
        var client = HttpClient.newHttpClient();
        var response = client.send(SQLHelper.requestDeclined(), HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        assertEquals("{\"status\":\"DECLINED\"}", response.body());
    }

    @Test
    public void approved() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var response = client.send(SQLHelper.requestApproved(), HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        assertEquals("{\"status\":\"APPROVED\"}", response.body());
    }

    @Test
    public void internalServerError() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var response = client.send(SQLHelper.badRequest(), HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        assertEquals(500, response.statusCode());
    }
}
