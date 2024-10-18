package com.OneToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	 public static void main(String[] args) {
	       
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToMany");
	        EntityManager em = emf.createEntityManager();

	        try {
	         
	            em.getTransaction().begin();

	          
	            Category category = new Category("Electronics");

	          
	            Product product1 = new Product("Laptop");
	            Product product2 = new Product("Smartphone");

	            
	            category.setProducts(Arrays.asList(product1, product2));

	          
	            em.persist(category); 

	         
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	          
	            if (em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	        } finally {
	          
	            em.close();
	            emf.close();
	        }
	    }
	}


