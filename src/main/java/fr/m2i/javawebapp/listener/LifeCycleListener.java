package fr.m2i.javawebapp.listener;

import fr.m2i.javawebapp.session.UserDb;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LifeCycleListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(LifeCycleListener.class.getName());

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Log de demarage
        logger.info("---- App Started ----");
        logger.info(dtf.format(LocalDateTime.now()));
        logger.info("---- App Started ----");

        //on récupère le servlet context
        ServletContext ctx = sce.getServletContext();
        //On recupere les identifiants
        String dbUser = ctx.getInitParameter("dbUser");
        String dbPass = ctx.getInitParameter("dbPass");

        UserDb userDb = UserDb.getInstance(dbUser, dbPass);

        if (userDb == null) {
            logger.severe(("/!\\ Impossible de se connecter à la base de données /!\\ "));
            return;
        }

        ctx.setAttribute("userDb", userDb);

        logger.info("---- init done ----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("---- App Stopped ----");
        logger.info(dtf.format(LocalDateTime.now()));
        logger.info("---- App Stopped ----");
    }
}
