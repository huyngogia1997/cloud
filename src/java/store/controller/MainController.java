/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogOutController";
    private static final String ADD = "AddProductController";
    private static final String DETAIL = "ProductDetailController";
    private static final String ADDTOCART = "AddToCartController";
    private static final String BACK = "GetProductController";
    private static final String VIEWCART = "cart.jsp";
    private static final String CLEAR = "ClearController";
    private static final String CONTINUTE = "GetProductController";
    private static final String REMOVE = "RemoveController";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("LogOut")) {
                url = LOGOUT;
            } else if (action.equals("Add Product")) {
                url = ADD;
            } else if (action.equals("Details")) {
                url = DETAIL;
            } else if (action.equals("Order Now")) {
                url = ADDTOCART;
            } else if (action.equals("Back")) {
                url = BACK;
            } else if (action.equals("View Cart")) {
                url = VIEWCART;
            } else if (action.equals("Clear Cart")) {
                url = CLEAR;
            } else if (action.equals("Continue Shopping")) {
                url = CONTINUTE;
            } else if (action.equals("Remove")) {
                url = REMOVE;
            }
        } catch (Exception e) {
            log("Error at MainController : " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
