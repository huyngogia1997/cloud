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
import store.dao.ProductDAO;
import store.dto.ProductDTO;

/**
 *
 * @author DELL
 */
public class AddProductController extends HttpServlet {

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
        try {
            String productName = request.getParameter("txtProductName");
            String priceStr = request.getParameter("txtUnitPrice");
            String quantityStr = request.getParameter("txtUnitsInStock");
            String description = request.getParameter("txtDescription");
            String manufacturer = request.getParameter("txtManufacturer");
            String category = request.getParameter("txtCategory");
            String condition = request.getParameter("txtCondition");
            String imageStr = request.getParameter("txtImage");
            ProductDAO dao = new ProductDAO();
            String productID = dao.getProductID();
            int price = Integer.parseInt(priceStr);
            int quantity = Integer.parseInt(quantityStr);
            int index = imageStr.lastIndexOf("\\");
            String image = imageStr.substring(index + 1);
            ProductDTO product = new ProductDTO(productID, productName, description, manufacturer, condition, category, image, price, quantity);
            boolean result = dao.addProduct(product);
            if (result == true) {
                request.setAttribute("RESULT", "Add Successed");
            } else {
                request.setAttribute("RESULT", "Add Failed");
            }
        } catch (Exception e) {
            log("Error at AddProductController : " + e.toString());
        } finally {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
