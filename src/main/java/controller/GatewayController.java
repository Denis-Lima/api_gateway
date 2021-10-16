package controller;

import Model.Gateway;
import Model.GatewayDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Denis Lima
 */

@WebServlet(urlPatterns = "/gateway/*")
public class GatewayController extends HttpServlet {
    List<Gateway> avaliableGateways = GatewayDAO.getInstance().findAll();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            String operacao = req.getPathInfo();

            for (Gateway gate: avaliableGateways) {
                System.out.println(gate.getRota() + " - " + operacao);
                if (gate.getRota().equals(operacao)) {
                    String fullUrl = gate.getUrl() + "?" + req.getQueryString();
                    System.out.println("FULL " + fullUrl);
                    URL url = new URL(fullUrl);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("POST");

                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    in.close();

                    System.out.println("resp " + response);
                    resp.getWriter().write(response.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Ocorreu um erro na requisição");
        }
    }
}
