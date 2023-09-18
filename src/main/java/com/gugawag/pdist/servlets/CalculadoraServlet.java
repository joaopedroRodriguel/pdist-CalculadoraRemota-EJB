package com.gugawag.pdist.servlets;

import br.edu.ifpb.pdist.CalculadoraIF;
import com.gugawag.pdist.ejb.session.UsuarioService;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraServlet {

    @EJB(lookup="java:global/calculadoraejb/calculadoraService")
    private CalculadoraIF calculadora;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("oper");
        PrintWriter resposta = resp.getWriter();
        switch (operacao) {
            case "somar": { // inserir
                int num1 = Integer.parseInt(req.getParameter("num1"));
                int num2 = Integer.parseInt(req.getParameter("num2"));
                resposta.println(calculadora.somar(num1, num2));
            }

        }
    }
}
