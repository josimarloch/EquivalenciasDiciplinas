/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;



import beans.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 *
 * @author josimar
 */
public class HibernateConfiguration {
    public static final String userName = "root";
    public static final String password = "99699939";
    public static final String dataBase = "eqdc";
    
    // configuracões somente uma vez 
    // build  valida somente uma vez
    // Session uma sessão para cada transação ou um conjunto de transações

    private static AnnotationConfiguration cfg = null;
    private static SessionFactory factory = null;

    public static SessionFactory getSessionFactory() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.username", userName);
            cfg.setProperty("hibernate.connection.password", password);
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/"+dataBase);
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.connection.autocommit", "true");
           cfg.addAnnotatedClass(Curso.class); // classes para serem mapeadas
           cfg.addAnnotatedClass(Professor.class); // classes para serem mapeadas
            cfg.addAnnotatedClass(Disciplina.class); // classes para serem mapeadas
            cfg.addAnnotatedClass(Requisicao.class); // classes para serem mapeadas
            cfg.addAnnotatedClass(DocumentoComprobatorio.class); // classes para serem mapeadas
            cfg.addAnnotatedClass(ItemHistorico.class); // classes para serem mapeadas
           // cfg.addAnnotatedClass(Enderec.class); // classes para serem mapeadas

            factory = cfg.buildSessionFactory();// construindo uma fabrica de sessão
        }
        return factory;
    }
    //podemos setar o autocomit como true e nao precisa usar begi tansaction

    public static void createSchema() {
        getSessionFactory().close();
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(cfg);
        schemaEx.create(true, true);
    }
    
    public static void checkAndCreateSchema() {
        try {
          //  new DaoCidade().listar();
        } catch (Exception e) {
            // as tabelas nao existem, tenta criar
            HibernateConfiguration.createSchema();
        }
    }
    
    public static void main(String[] args) {
        HibernateConfiguration.createSchema();
    }
}
