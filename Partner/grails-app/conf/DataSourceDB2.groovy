dataSource {
	pooled = false
	driverClassName = "com.ibm.db2.jcc.DB2Driver"
	username = "db2inst1"
	password = "wuffwuff"
}
hibernate {
    cache.use_second_level_cache=false
    cache.use_query_cache=false
	cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:db2://192.168.2.108:50000/part"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:db2://192.168.2.108:50000/part"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:db2://192.168.2.108:50000/part"
		}
	}
}
