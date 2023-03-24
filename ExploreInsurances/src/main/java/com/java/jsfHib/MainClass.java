package com.java.jsfHib;

public class MainClass {
	
	public static void main(String[] args) {
		
		PolicyDaoImp daoImp = new PolicyDaoImp();
//		System.out.println(daoImp.getpremIdByPolicyId("I002"));
//		System.out.println(daoImp.getPremiumAbove60("P002"));
		System.out.println(daoImp.getPremiumAbove60("P002"));
		//System.out.println(daoImp.getDiscount18To60("P002"));
		System.out.println(daoImp.getCoverageAbove60("P002"));
		
	}

}
