package ru.netology.helpers;

import java.net.URI;
import java.net.http.HttpRequest;

public class SQLHelper {
    public static String getEndpoint() {
        return "http://localhost:8080/api/v1/pay";
    }

    public static String getBodyRequestDeclined() {
        return "{\n" +
                "  \"number\": " + UserHelper.getCardNumberDeclined() + ",\n" +
                "  \"year\": \"" + UserHelper.getRandomYear() + "\",\n" +
                "  \"month\": \"" + UserHelper.getRandomMonth() + "\",\n" +
                "  \"holder\": \"Varlamov Ilya\",\n" +
                "  \"cvc\": " + UserHelper.getThreeNumber() + "\n" +
                "}";    }

    public static String getBodyRequestApproved() {
        return "{\n" +
                "  \"number\": " + UserHelper.getCardNumberApproved() + ",\n" +
                "  \"year\": \"" + UserHelper.getRandomYear() + "\",\n" +
                "  \"month\": \"" + UserHelper.getRandomMonth() + "\",\n" +
                "  \"holder\": \"Varlamov Ilya\",\n" +
                "  \"cvc\": " + UserHelper.getThreeNumber() + "\n" +
                "}";
    }

    public static String getBodyRequestInternalServerError() {
        return "{\n" +
                "  \"number\": " + UserHelper.getValidCardNumber() + ",\n" +
                "  \"year\": \"" + UserHelper.getRandomYear() + "\",\n" +
                "  \"month\": \"" + UserHelper.getRandomMonth() + "\",\n" +
                "  \"holder\": \"Varlamov Ilya\",\n" +
                "  \"cvc\": " + UserHelper.getThreeNumber() + "\n" +
                "}";
    }

    public static HttpRequest requestApproved() {
        return HttpRequest.newBuilder()
                .uri(URI.create(SQLHelper.getEndpoint()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(SQLHelper.getBodyRequestApproved()))
                .build();
    }
    public static HttpRequest requestDeclined() {
        return HttpRequest.newBuilder()
                .uri(URI.create(SQLHelper.getEndpoint()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(SQLHelper.getBodyRequestDeclined()))
                .build();
    }
    public static HttpRequest badRequest() {
        return HttpRequest.newBuilder()
                .uri(URI.create(SQLHelper.getEndpoint()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(SQLHelper.getBodyRequestInternalServerError()))
                .build();
    }
}
