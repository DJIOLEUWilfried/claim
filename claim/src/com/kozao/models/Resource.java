package com.kozao.models;


public class Resource {
	
		private int idResource;
		private String resourceName;
		private String resourceDescription;
		
		public Resource() {
			super();
		}

		public Resource(String resource, String resourceDescription) {
			super();
			this.resourceName = resource;
			this.resourceDescription = resourceDescription;
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

		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}

		public String getResourceDescription() {
			return resourceDescription;
		}

		public void setResourceDescription(String resourceDescription) {
			this.resourceDescription = resourceDescription;
		}
		
		@Override
		public String toString() {
			return String.format("Id= %s  Name= %s  Description= %s ", idResource, resourceName, resourceDescription);
		}


}
