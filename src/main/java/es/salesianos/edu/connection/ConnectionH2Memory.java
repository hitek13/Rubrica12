package es.salesianos.edu.connection;

import org.springframework.stereotype.Component;

@Component
public class ConnectionH2Memory extends AbstractConnectionManager {

	@Override
	protected String getJdbcUrl() {
		return "jdbc:h2:file:./date;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	}

	@Override
	protected String getClassDriver() {
		return "org.h2.Driver";
	}

	@Override
	protected String getUser() {
		return "sa";
	}

	@Override
	protected String getPass() {
		return "";
	}

}