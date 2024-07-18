package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class NBP
{
    public static void NBP_converter() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of currency you want to get: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter code of currency (according to ISO 4217): ");
        String currency = scanner.nextLine();

        String url = "https://api.nbp.pl/api/exchangerates/tables/a/";
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

                    HashMap<String, Double> result = new HashMap<>();
                    for (int i = 0; i < rates.length(); i++) {
                        JSONObject rate = rates.getJSONObject(i);
                        String code = rate.getString("code");
                        double mid = rate.getDouble("mid");
                        result.put(code, mid);
                    }

                    double outcome = 0;
                    if(result.containsKey(currency))
                    {
                        outcome = amount * result.get(currency);

                        System.out.print("Price of this currency is ");
                        System.out.printf("%.2f", outcome);
                        System.out.println(" PLN");
                    }
                    else
                    {
                        System.out.println("Wrong currency code!");
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
