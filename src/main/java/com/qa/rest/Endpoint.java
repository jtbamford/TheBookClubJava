package com.qa.rest;

	import javax.inject.Inject;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;

	import com.qa.service.BookService;

	@Path("/Library")
	public class Endpoint {
		
		@Inject
		private BookService service;

		@Path("/getAllBooks")
		@GET
		@Produces({ "application/json" })
		public String getAllBooks() {
			return service.getAllBooks();
		}
		
		@Path("/getAllBookOwnerships")
		@GET
		@Produces({"application/json"})
		public String getAllBookOwnerships() {
			return service.getAllBookOwnerships();
		}
		
		@Path("/getAllBookOwnershipsForUser/{userID}")
		@GET
		@Produces({"application/json"})
		public String getAllBookOwnershipsForUser(@PathParam("userID") Long userID) {
			return service.getAllBookOwnershipsForUser(userID);
		}
		
		@Path("/getAllUsers")
		@GET
		@Produces({"application/json"})
		public String getAllUsers() {
			return service.getAllUsers();
		}
	
		/* need to use ID's as inputs in URL here!	
		
		@Path("/getBookOwnership")
		@GET
		@Produces({"application/json"})
		public String getBookOwnership(String username, String title, String author) {
			return service.getBookOwnership(username, title, author);
		}
		*/
		
		@Path("/getUserByUsername/{username}")
		@GET
		@Produces({"application/json"})
		public String getUser(@PathParam("username") String username) {
			return service.getUserByUsername(username);
		}	
		
		@Path("/getUser/{id}")
		@GET
		@Produces({"application/json"})
		public String getUser(@PathParam("id") Long userID) {
			return service.getUser(userID);
		}
		
		@Path("/getBookOwnership/{id}")
		@GET
		@Produces({"application/json"})
		public String getBookOwnership(@PathParam("id") Long bookownershipID) {
			return service.getBookOwnership(bookownershipID);
		}
		
		@Path("/createBook")
		@POST
		@Produces({"application/json"})
		public String addBook(String book) {
			return service.addBook(book);
		}

		@Path("/createBookForUser")
		@POST
		@Produces({ "application/json" })
		public String addBookForUser(String bookownership) {
			return service.addBookForUser(bookownership);
		}
		
		@Path("/createUser")
		@POST
		@Produces({ "application/json" })
		public String addUser(String username) {
			return service.addUser(username);
		}

		@Path("/deleteUser/{id}")
		@DELETE
		@Produces({ "application/json" })
		public String deleteUser(@PathParam("id") Long userID) {
			return service.deleteUser(userID);
		}
		
		@Path("/deleteBookForUser/{id}")
		@DELETE
		@Produces({ "application/json" })
		public String deleteBookForUser(@PathParam("id") Long bookownershipID) {
			return service.deleteBookForUser(bookownershipID);
		}
		
		@Path("/updateUser/{id}")
		@PUT
		@Produces({ "application/json" })
		public String updateUser(String user,@PathParam("id") Long userID) {
			return service.updateUser(user, userID);
		}
		

		public BookService getService() {
			return service;
		}

		public void setService(BookService service) {
			this.service = service;
		}

}
