/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Daos.AlunoDao;
import beans.Aluno;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userLDAP.LoginLDAP;
import userLDAP.UserLDAP;

/**
 *
 * @author josimar
 */
public class LoginManager extends HttpServlet {

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
    LoginLDAP ldap = new LoginLDAP();

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
            out.println("<title>Servlet LoginManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginManager at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);
        String ok = request.getParameter("ok");
        if (ok.equals("logout")) {
            request.getSession().removeAttribute("aluno");
        }
        response.sendRedirect("index.jsp");
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
        if (ok.equals("login")) {
            String login = request.getParameter("login").trim();
            String senha = request.getParameter("senha").trim();
                    HttpSession session = request.getSession();
            if (ldap.logarNoLDAP(login, senha) != null) {
                    Usuario usuario = ldap.logarNoLDAP(login, senha);
                    session.setAttribute("aluno", usuario);
                    
                    //(!ad.alunoExiste(login)) {
                   // ad.persistir(usuario);
                    //  }               
            }else{
                    Usuario u = new UserLDAP();
                    u.setNome(login);
                    session.setAttribute("aluno", u);
                
            }
        }
        response.sendRedirect("index.jsp");
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
