package Config;

import javax.sql.DataSource;

import Dao.Implementation.*;
import Dao.Interface.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.Interface.AlgoritmoService;
import service.Interface.CorrispondenzaService;
import service.Interface.NonTrovataService;
import service.Interface.StandardService;
import service.implementation.AlgoritmoServiceImpl;
import service.implementation.CorrispondezaImpService;
import service.implementation.NonTrovataServiceImpl;
import service.implementation.StandardServiceImpl;

@Configuration   /*qui ci cono le istanze da creare e gestire con il container di Spring DI-IoC*/
@ComponentScan(basePackages="src")

@EnableTransactionManagement /* Abilita la gestione delle transazioni */

public class Beans {

    @Bean(name="dataSource")
    public DataSource getDataSource () {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("uvagv6gG98");
        ds.setUrl("jdbc:mysql://localhost:3306/myschema");
        return ds;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean  getEntityManager(){



        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        // factory.setValidationMode(ValidationMode.AUTO);

        // JDBC
        factory.setDataSource(getDataSource());

        // imposta il dialogo tra JPA e hibernate
        factory.setJpaVendorAdapter(getJpaVendorAdapter()); // imposta il dialogo tra JPA e hibernate

        // impostare il luogo dove si trovano le entity con il mapping
        factory.setPackagesToScan("Model"); // "com.corso.spring"
        // oppure "com.corso.spring...." al posto di this.getClass().getPackage().getName()
        return factory;
    }
    private HibernateJpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);   // obbligatorio: serve per tradurre le query nel particolare Dialetto

        adapter.setGenerateDdl(true);          //facoltativo, attiva il DDL cio� hibernate creer� le strutture nel DB se non sono gi� essitenti
        adapter.setShowSql(true);              // mostra l'SQL, comodo per i corsi e per il debug ma in produzione solitamente � a false
        return adapter;
    }

    /*** transazioni ***/
    @Bean
    public PlatformTransactionManager getTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        //     transactionManager.setEntityManagerFactory(getEntityManager().getObject());
        //transactionManager.setNestedTransactionAllowed(false);
        return transactionManager;
    }



    @Bean(name="CorrispondenzaDao")
    public CorrispondenzaDao getCorrispondenzaDao (){
        CorrispondenzaDao dao = new CorrispondenzaDaoImpl();
        return dao;
    }

    @Bean(name="NonTrovataDao")
    public NonTrovataDao getNonTrovataDao (){
        NonTrovataDao dao = new NonTrovataDaoImpl();
        return dao;
    }

    @Bean(name="AlgoritmoDao")
    public AlgoritmoDao getAlgoritmoDao (){
        AlgoritmoDao dao = new AlgoritmoDaoImpl();
        return dao;
    }


    @Bean(name="StandardDao")
    public StandardDao standardDao (){
        StandardDao dao = new StandardDaoImpl();
        return dao;
    }

    @Bean(name="BaseDao")
    public BaseDao getBaseDao (){
        BaseDao dao = new BaseDaoImpl();
        return dao;
    }


    @Bean(name="AlgoritmoService")
    public AlgoritmoService getAlgoritmoService (){
        AlgoritmoService service = new AlgoritmoServiceImpl();

        return service;
    }

    @Bean(name="CorrispondenzaService")
    public CorrispondenzaService getCorrispondenzaService (){
        CorrispondenzaService service = new CorrispondezaImpService();
        return service;
    }

    @Bean(name="NonTrovataService")
    public NonTrovataService getNonTrovataService (){
        NonTrovataService service = new NonTrovataServiceImpl();
        return service;
    }

    @Bean(name="StandardService")
    public StandardService getStandardService (){
        StandardService service = new StandardServiceImpl();
        return service;
    }

}
