package br.com.fiap.gs.lflTechnology.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory factory;
	
	private EntityManagerFactorySingleton(){
		super();
	}
	
	public static EntityManagerFactory getInstance(){
		if (factory == null){
			factory = Persistence.createEntityManagerFactory("persistence-unit");
		}
		return factory;
	}
}
