package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class NBP
{
    public static void NBP_converter()
    {
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

                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < rates.length(); i++) {
                        JSONObject rate = rates.getJSONObject(i);
                        String code = rate.getString("code");
                        double mid = rate.getDouble("mid");
                        result.append(code).append(" : ").append(mid).append("\n");
                    }

                    System.out.println(result);
                }
                else
                {
                    System.err.println("Error code: " + statusCode);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
