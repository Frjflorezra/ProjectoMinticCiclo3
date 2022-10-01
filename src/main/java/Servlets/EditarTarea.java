/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datos.TareaDao;
import Modelo.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FELIPE
 */
@WebServlet(name = "EditarTarea", urlPatterns = {"/html/EditarTarea"})
public class EditarTarea extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarTarea</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarTarea at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("tituloE");
        int prioridad = Integer.parseInt(request.getParameter("prioridadE"));
        int id = Integer.parseInt( request.getParameter("inId") );
        Tarea editada = new Tarea(titulo, prioridad, id);
        TareaDao.editarTarea(editada);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/taskList.jsp");
        dispatcher.forward(request, response);
        /*if(prioridadValida(prioridad)){
            int prioridad_real = Integer.parseInt(prioridad);
            Tarea tarea = new Tarea(titulo , prioridad_real, idOwner);

            if( TareaDao.agregarTarea(tarea) ){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/html/taskList.jsp");
                dispatcher.forward(request, response);
            }
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html/taskList.jsp");
            dispatcher.forward(request, response);
        }
        System.out.println("DATA RECIBIDA DE LA TAREA --> " + request.getParameter("tituloE") + " " + request.getParameter("prioridadE") + " ID:" + request.getParameter("inId"));*/
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
