package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase
{
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");		
	}
	

	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		
		category.setCategoryName("Lenovo");
		category.setCategoryDesc("Lenovo Mobiles");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
	
	@Ignore
    @Test
	public void editCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryName("Samsung");
		category.setCategoryDesc("Samsung Smart Mobiles with 4G Feature");
		
		assertTrue("Problem in Updating the Category",categoryDAO.editCategory(category));

	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting the Category",categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category>listCategories=categoryDAO.listCategories();
		assertTrue("Problem in  Listing Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println(category.getCategoryId()+":::");
			System.out.println(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc()+":::");
         }
	}
}
