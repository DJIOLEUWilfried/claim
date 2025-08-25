package com.kozao.models;

import java.util.List;

public class Resource {
	
		private int idResource;
		private String resourceName;
		private String resourceDescription;
		private List<Claim> claims;
		
		public Resource() {
			super();
		}

		public Resource(String resource, String resourceDescription, List<Claim> claims) {
			super();
			this.resourceName = resource;
			this.resourceDescription = resourceDescription;
			this.claims = claims;
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

		public List<Claim> getClaims() {
			return claims;
		}

		public void setClaims(List<Claim> claims) {
			this.claims = claims;
		}

	


		
		
		
		

}
