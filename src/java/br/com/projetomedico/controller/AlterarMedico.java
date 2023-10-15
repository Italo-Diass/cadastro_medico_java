package br.com.projetomedico.controller;

import br.com.projetomedico.dao.GenericDAO;
import br.com.projetomedico.dao.MedicoDAOImpl;
import br.com.projetomedico.model.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarMedico", urlPatterns = {"/AlterarMedico"})
public class AlterarMedico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Integer idMedico = Integer.parseInt(request.getParameter("idMedico"));
            String nomePessoa = request.getParameter("nomePessoa");
            String enderecoPessoa = request.getParameter("enderecoPessoa");
            Integer crmMedico = Integer.parseInt(request.getParameter("crmMedico"));
            String especialidadeMedico = request.getParameter("especialidadeMedico");

            String mensagem;

            Medico medico = new Medico();

            medico.setIdMedico(idMedico);
            medico.setCrmMedico(crmMedico);
            medico.setEspecialidadeMedico(especialidadeMedico);
                    

            try {
                GenericDAO dao = new MedicoDAOImpl();
                if (dao.alterar(medico)) {
                    mensagem = "Médico alterado com sucesso.";
                } else {
                    mensagem = "Problemas ao alterar médico.";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarMedicos").forward(request, response);

            } catch (Exception e) {
                System.out.println("Problemas na servlet ao alterar médico. Erro: " + e.getMessage());
                e.printStackTrace();
            }
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
