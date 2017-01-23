package org.isen.dame.webapp;

import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

/**
 * Created by Sandrine on 16/01/2017.
 */
@WebServlet("/totoAdress/*")
public class ShowServlet extends HttpServlet {

    private static final long serialVersionUID = 4590295895653754427L;

    @Inject
    DameBean game;

    private static final Log LOG = LogFactory.getLog(ShowServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = getTokenFromRequest(req);


        if (StringUtils.isEmpty(token)) {
            LOG.debug("Empty token, creating a new game");
            game.createNewGame();
            redirectToGameRoot(resp, req);
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Found token " + game.getToken() + " in request");
            }

            token = token.substring(1);
            System.out.println(token);
            game.loadFromToken(token);

            //String playCol = req.getParameter("playcol");

            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        }
    }

    private void redirectToGameRoot(HttpServletResponse response,
                                    HttpServletRequest request) throws IOException {
        response.sendRedirect(request.getContextPath()
                + request.getServletPath() + "/" + game.getToken());
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        if (request == null) {
            return "";
        }

        System.out.println(request.getRequestURI());

        String token = request.getRequestURI().substring(
                request.getContextPath().length()
                        + request.getServletPath().length());

        return token;


    }
}
