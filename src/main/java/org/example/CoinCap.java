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

public class CoinCap
{
    public static void CoinCap_converter() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of currency you want to get: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter code of currency: ");
        String currency = scanner.nextLine();

        String url = "https://api.coincap.io/v2/assets";

        HashMap<String, Double> result = new HashMap<>();
        CreateHashMap(result, url);

        double outcome = 0;
        if(result.containsKey(currency))
        {
            outcome = amount * result.get(currency);

            System.out.print("Price of this currency is ");
            System.out.printf("%.2f", outcome);
            System.out.println(" USD");
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

                    JSONObject jsonObject = new JSONObject(ratesJSON);
                    JSONArray data = jsonObject.getJSONArray("data");

                    for (int i = 0; i < data.length(); i++) {
                        JSONObject rate = data.getJSONObject(i);
                        String symbol = rate.getString("symbol");
                        double priceUsd = rate.getDouble("priceUsd");
                        result.put(symbol, priceUsd);
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
