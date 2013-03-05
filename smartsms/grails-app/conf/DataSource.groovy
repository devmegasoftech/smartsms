dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = "smartsms"
	password = "smartsms"
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
			url = "jdbc:mysql://192.168.0.11:3306/smartsms"
		}
	}

	test {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:mysql://192.168.0.11:3306/smartsms"
		}
	}
	
	production {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:mysql://192.168.0.11:3306/smartsms"
		}
	}
}