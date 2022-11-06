package ru.netology.beckendTest;

import org.testng.annotations.Test;
import ru.netology.helpers.UserHelper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTest {

    @Test
    public void declined() throws IOException, InterruptedException {
        String postEndpoint = "http://localhost:8080/api/v1/pay";
        String inputJson = "{\n" +
                "  \"number\": " + UserHelper.getCardNumberDeclined() + ",\n" +
                "  \"year\": \"" + UserHelper.getRandomYear() + "\",\n" +
                "  \"month\": \"" + UserHelper.getRandomMonth() + "\",\n" +
                "  \"holder\": \"VARLAMOV ILYA\",\n" +
                "  \"cvc\": " + UserHelper.getThreeNumber() + "\n" +
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
                "  \"number\": " + UserHelper.getCardNumberApproved() + ",\n" +
                "  \"year\": \"" + UserHelper.getRandomYear() + "\",\n" +
                "  \"month\": \"" + UserHelper.getRandomMonth() + "\",\n" +
                "  \"holder\": \"Varlamov Ilya\",\n" +
                "  \"cvc\": " + UserHelper.getThreeNumber() + "\n" +
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
                "  \"number\": \"" + UserHelper.getValidCardNumber() + "\",\n" +
                "  \"year\": \"" + UserHelper.getRandomYear() + "\",\n" +
                "  \"month\": \"" + UserHelper.getRandomMonth() + "\",\n" +
                "  \"holder\": \"Varlamov Ilya\",\n" +
                "  \"cvc\": " + UserHelper.getThreeNumber() + "\n" +
                "}";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        assertEquals(500, response.statusCode());
    }
}
