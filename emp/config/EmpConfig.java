package emp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import emp.dao.EmpDao;
import emp.dao.EmpDaoImpl;


public class EmpConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/advjava");
		ds.setUsername("root");
		ds.setPassword("sql_qwerty");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	@Bean("daoImplementation")
	public EmpDao getEmptDao() {
		EmpDaoImpl dao = new EmpDaoImpl();
		dao.setTemplate(getJdbcTemplate());
		return dao;
		
	}
}
