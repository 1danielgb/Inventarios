package com.example.hobo.inventarios.API.HttpPetitions;

import android.os.StrictMode;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Caleb on 1/10/2018.
 */

public class SetContainer {
    public void postMethod(int userId, String nombreContenedor, int[] dimens, String props) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
            URL url = new URL("http://192.168.43.228:3000/api/contenedoresex/createcontenedorex");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String dim = "{" + dimens[0] + ", " + dimens[1] + ", " + dimens[2] + "}";

            String input = "{\"fid_inventario\":" + userId + "," +
                    "\"nombre_ct_externo\":\"" + nombreContenedor + "\"," +
                    "\"dimensiones_ct_externo\":\"" + dim + "\"," +
                    "\"props_ct_externo\":\""+ props + "\"" +
                    "}";
            System.out.println(input);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            /*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }*/

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
