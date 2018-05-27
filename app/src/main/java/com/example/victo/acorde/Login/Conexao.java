package com.example.victo.acorde.Login;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conexao{
    public static String Data(String urlRequest, String userData){
        URL url;
        HttpURLConnection connection = null;

        try{
            url = new URL(urlRequest);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Lenght", "" + Integer.toString(userData.getBytes().length));
            connection.setRequestProperty("Content-Language", "pt-BR");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            DataOutputStream saida = new DataOutputStream(connection.getOutputStream());
            saida.writeBytes(userData);
            saida.flush();
            saida.close();

            InputStream entrada = connection.getInputStream();
            BufferedReader leituraBuffer = new BufferedReader( new InputStreamReader(entrada, "UTF-8"));
            String linha;
            StringBuffer resposta = new StringBuffer();

            /*FIX LINE
            while((linha = entrada.readLine()) != null){
                resposta.append(linha);
                resposta.append('\r');
            }
            */

            leituraBuffer.close();

            return resposta.toString();

        }catch (Exception error){
            return null;
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }
}