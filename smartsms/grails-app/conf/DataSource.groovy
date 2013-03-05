dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = "remoto"
	password = "remoto"
}
hibernate {
	cache.use_second_level_cache=true
	cache.use_query_cache=true	
	cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
	hibernate.dialect='org.hibernate.dialect.MySQLInnoDBDialect'
}

environments {
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost:3306/smartsms"
		}
	}

	test {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:mysql://localhost:3306/smartsms"
		}
	}
	
	production {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:mysql://localhost:3306/smartsms"
		}
	}
}