package pam.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableJpaRepositories(basePackages = { "pam.repositories"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"pam.metier"})
@EntityScan(basePackages = { "pam.entities"})
@EnableTransactionManagement
public class DomainAndPersistenceConfig {

	// la source de données MySQL
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbpam_hibernate");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	// le provider JPA - n'est pas nécessaire si on est satisfait des valeurs par
	// défaut utilisées par Spring boot
	// ici on le définit pour activer / désactiver les logs SQL
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	// l'EntityManageFactory et le TransactionManager sont définis avec des
	// valeurs par défaut par Spring boot

}