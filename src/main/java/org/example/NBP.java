package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class NBP
{
    public static void NBP_converter(double amount, String code) throws Exception {
        HashMap<String, Double> result = new HashMap<>();

        String url1 = "https://api.nbp.pl/api/exchangerates/tables/a/";
        String url2 = "https://api.nbp.pl/api/exchangerates/tables/b/";
        CreateHashMap(result, url1);
        CreateHashMap(result, url2);

        double outcome;
        if(result.containsKey(code))
        {
            outcome = amount * result.get(code);

            System.out.print("Price of this currency is ");
            System.out.printf("%.2f", outcome);
            System.out.println(" PLN");
            System.out.println();
        }
        else
        {
            System.out.println("Wrong currency code!");
        }
    }

    private static void CreateHashMap(HashMap<String, Double> result, String url) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault())
        {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request))
            {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200)
                {
                    HttpEntity entity = response.getEntity();
                    String ratesJSON = EntityUtils.toString(entity);

                    JSONArray jsonArray = new JSONArray(ratesJSON);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    JSONArray rates = jsonObject.getJSONArray("rates");

                    for (int i = 0; i < rates.length(); i++) {
                        JSONObject rate = rates.getJSONObject(i);
                        String code = rate.getString("code");
                        double mid = rate.getDouble("mid");
                        result.put(code, mid);
                    }
                }
                else
                {
                    System.err.println("Error code: " + statusCode);
                }
            }
        }
    }
}