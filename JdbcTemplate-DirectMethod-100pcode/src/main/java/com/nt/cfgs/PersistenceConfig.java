package com.nt.cfgs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
      @Bean
	public DataSource createDS() {
		HikariDataSource hkds=null;
		hkds = new HikariDataSource();
		hkds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkds.setJdbcUrl("jdbc:mysql://localhost:3306/college?serverTimezone=UTC");
		hkds.setUsername("root");
		hkds.setPassword("password");
		hkds.setMaximumPoolSize(10);
		return hkds;
	}
      @Bean
      public JdbcTemplate createJdbcTemplate() {
    	  return new JdbcTemplate(createDS());
      }
}
