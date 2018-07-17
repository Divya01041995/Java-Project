package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase 
{
	@Autowired
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");		
	}
	

	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		
		supplier.setSupplierName("Lenovo");
		supplier.setSupplierAddr("Lenovo Mobiles");
		
		assertTrue("Problem in Adding Supplier",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
    @Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
		supplier.setSupplierName("Samsung");
		supplier.setSupplierAddr("Samsung Smart Mobiles with 4G Feature");
		
		assertTrue("Problem in Updating the Supplier",supplierDAO.updateSupplier(supplier));

	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		assertTrue("Problem in Deleting the Supplier",supplierDAO.deleteSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void listSuppliersTest()
	{
		List<Supplier>listSuppliers=supplierDAO.listSupplier();
		assertTrue("Problem in  Listing Suppliers",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.println(supplier.getSupplierId()+":::");
			System.out.println(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierAddr()+":::");
         }
	}

}
