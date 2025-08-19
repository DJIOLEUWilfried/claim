package com.kozao.models;

public class Resource {
	
		private int idResource;
		private String resourceName;
		private String resourceDescription;
		private Category cat;
		
		
		public Resource() {
			super();
		}

		public Resource(String resource, String resourceDescription, Category category) {
			super();
			this.resourceName = resource;
			this.resourceDescription = resourceDescription;
			this.cat = category;
		}

	

		public int getIdResource() {
			return idResource;
		}

		public void setIdResource(int idResource) {
			this.idResource = idResource;
		}

		public String getResourceName() {
			return resourceName;
		}

		public void setResourceName(String resource) {
			this.resourceName = resource;
		}

		public Category getCat() {
			return cat;
		}

		public void setCat(Category category) {
			this.cat = category;
		}

		public String getResourceDescription() {
			return resourceDescription;
		}

		public void setResourceDescription(String resourceDescription) {
			this.resourceDescription = resourceDescription;
		}
		
		
		
		
		

}
