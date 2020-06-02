package com.stx.entity;

public class RecommendRecipes {
	   private  int  recipesid;
	    private String name;
	    private double calorie;
	    private  String needfood;
	    private  String url;
	    private int count;
	    
	    
		public RecommendRecipes(int recipesid, String name, double calorie, String needfood, String url, int count) {
			this.recipesid = recipesid;
			this.name = name;
			this.calorie = calorie;
			this.needfood = needfood;
			this.url = url;
			this.count = count;
		}
		public int getRecipesid() {
			return recipesid;
		}
		public void setRecipesid(int recipesid) {
			this.recipesid = recipesid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
		public double getCalorie() {
			return calorie;
		}
		public void setCalorie(double calorie) {
			this.calorie = calorie;
		}
		public String getNeedfood() {
			return needfood;
		}
		public void setNeedfood(String needfood) {
			this.needfood = needfood;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	    
	    
}
