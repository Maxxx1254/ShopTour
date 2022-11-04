package ru.netology.beckendTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.annotations.Test;
import ru.netology.helpers.UserHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTest {

    @Test
    public void declined() throws IOException, InterruptedException {
        String postEndpoint = "http://localhost:8080/api/v1/pay";
        String inputJson = "{\n" +
                "  \"number\": \"5555 6666 7777 8888\",\n" +
                "  \"year\": \"23\",\n" +
                "  \"month\": \"12\",\n" +
                "  \"holder\": \"dsdsffdg\",\n" +
                "  \"cvc\": " + UserHelper.getCardCode() + "\n" +
                "}";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        assertEquals("{\"status\":\"DECLINED\"}", response.body());
    }

    @Test
    public void approved() throws IOException, InterruptedException {
        String postEndpoint = "http://localhost:8080/api/v1/pay";
        String inputJson = "{\n" +
                "  \"number\": \"1111 2222 3333 4444\",\n" +
                "  \"year\": \"23\",\n" +
                "  \"month\": \"12\",\n" +
                "  \"holder\": \"dsdsffdg\",\n" +
                "  \"cvc\": " + UserHelper.getCardCode() + "\n" +
                "}";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        assertEquals("{\"status\":\"APPROVED\"}", response.body());
    }

    @Test
    public void internalServerError() throws IOException, InterruptedException {
        String postEndpoint = "http://localhost:8080/api/v1/pay";
        String inputJson = "{\n" +
                "  \"number\": " + UserHelper.getValidCardNumber() + ",\n" +
                "  \"year\": \"23\",\n" +
                "  \"month\": \"12\",\n" +
                "  \"holder\": \"dsdsffdg\",\n" +
                "  \"cvc\": " + UserHelper.getCardCode() + "\n" +
                "}";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(500, response.statusCode());
    }


}
