/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Daos.CursoDao;
import Daos.DisciplinaDao;
import Daos.ProfessorDao;
import beans.Curso;
import beans.Disciplina;
import beans.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josimar
 */
@WebServlet(name = "PersistenceManager", urlPatterns = {"/admin/PersistenceManager"})
public class PersistenceManager extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersistenceManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersistenceManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        String ok = request.getParameter("ok");
        if (ok != null) {
            if (ok.equals("cadastra_professor")) {
                String nome = request.getParameter("nome").trim();
                String email = request.getParameter("email").trim();
                if (!nome.equals("") && !email.equals("")) {
                    new ProfessorDao().persistir(new Professor(nome, email));
                    response.sendRedirect("index.jsp");
                }
            } else if (ok.equals("cadastra_curso")) {
                String nome = request.getParameter("nome").trim();
                if (!nome.equals("")) {
                    new CursoDao().persistir(new Curso(nome));
                    response.sendRedirect("index.jsp");
                }

            } else if (ok.equals("cadastra_disciplina")) {
                String nome = request.getParameter("nome").trim();
                String curso = request.getParameter("curso_id").trim();
                String Professor = request.getParameter("professor_id").trim();
                if (!nome.equals("")) {
                    Curso c = new CursoDao().obterPorId(Integer.parseInt(curso));
                    Disciplina d = new Disciplina();
                    d.setNome(nome);
                    d.setCurso(c);
                    d.setEmenta(request.getParameter("ementa").trim());
                    if (!Professor.equals("0")) {
                        Professor p = new ProfessorDao().obterPorId(Integer.parseInt(Professor));
                        d.setProfessor(p);
                    }
                   new DisciplinaDao().persistir(d);
                    response.sendRedirect("index.jsp");
                }
            }
        }
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
