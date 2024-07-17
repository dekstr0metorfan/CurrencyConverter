package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.lang.reflect.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class NBP
{
    public static void NBP_converter()
    {
        String url = "http://api.nbp.pl/api/exchangerates/tables/a/";
        try (CloseableHttpClient httpClient = HttpClients.createDefault())
        {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request))
            {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200)
                {
                    HttpEntity entity = response.getEntity();
                    String responseBody = EntityUtils.toString(entity);

                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
                    List<Map<String, Object>> ratesList = gson.fromJson(responseBody, listType);

                    ratesList.forEach(System.out::println);
                }
                else
                {
                    System.err.println("Nieudane żądanie. Kod odpowiedzi: " + statusCode);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
