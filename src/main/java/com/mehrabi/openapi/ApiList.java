package com.mehrabi.openapi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ApiList",
        urlPatterns = {"/ApiList"}
)
public class ApiList extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            response.sendRedirect("http://localhost:8080/openapi-1.0-SNAPSHOT/homepage.html?url=http://localhost:8080/openapi-1.0-SNAPSHOT/api/openapi");
        }catch (IOException  e){
            e.printStackTrace();
        }

    }
}