package ru.netology.beckendTest;

import org.testng.annotations.Test;
import ru.netology.helpers.SQLHelper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTest {

    @Test
    public void declined() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(SQLHelper.getEndpoint()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(SQLHelper.getBodyRequestDeclined()))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        assertEquals("{\"status\":\"DECLINED\"}", response.body());
    }

    @Test
    public void approved() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(SQLHelper.getEndpoint()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(SQLHelper.getBodyRequestApproved()))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        assertEquals("{\"status\":\"APPROVED\"}", response.body());
    }

    @Test
    public void internalServerError() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(SQLHelper.getEndpoint()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(SQLHelper.getBodyRequestInternalServerError()))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        assertEquals(500, response.statusCode());
    }
}
