#EXAMPLE CDI AND STRUTS 2

---
>we develop and example for struts 2 and cdi
>. For `cdi` we use `weld` implementation,and we configure struts 2 with 
> annotation for that we need a ` struts2-convention-plugin`and to integrate
> with cdi we use `sruts2-cdi-plugin`, because we deploy our application 
> in a `tomcat 9 servlet container` we need to register `ManagerObjectFactory` in the JNDI,
> for that we create a file context.xml with the following content 
> ```xml  
> <Context>
>    <Resource name="BeanManager"
>             auth="Container"
>            type="javax.enterprise.inject.spi.BeanManager"
>           factory="org.jboss.weld.resources.ManagerObjectFactory" />
>  </Context> 
> ```
> Finally, for store our data we use a mysql database and for 
> interact with it, we create a connection pool with hikari like this:
> ```java   
>  @ApplicationScoped
>    @Produces
>    public DataSource dataSource() {
>        String hikariPath = this.getClass().getClassLoader().getResource("hikari.properties").getPath();
>        HikariConfig hikariConfig = new HikariConfig(hikariPath);
>        return new HikariDataSource(hikariConfig);
>    }
> ```
> the file `hikari.properties` look like this
> ``` properties
> driverClassName=com.mysql.cj.jdbc.Driver
>jdbcUrl=jdbc:mysql://localhost:3306/distributed
>dataSource.user=root
>dataSource.password=root
>dataSource.databaseName=distributed
>dataSource.portNumber=3306
>dataSource.serverName=localhost
>maximumPoolSize=20
> ```
> for more information visit their page [HikariCP](https://github.com/brettwooldridge/HikariCP/blob/dev/README.md#gear-configuration-knobs-baby)