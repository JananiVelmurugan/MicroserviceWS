# RESTful Web Services

Social Media Application

User -> Posts

- Retrieve all users 	- GET 		/users
- Create a user 		- POST 		/users
- Retrieve a user		- GET		/users/{id} -> /users/1
- Delete a user			- DELETE	/users/{id} -> /users/1

- Retrieve all posts for a user - GET	/users/posts 
- Create a post for a user		- POST	/users/{id}/posts -> /users/1/posts	
- Retrieve details of a post 	- GET	/users/{id}/posts/{post_id} -> /user/1/posts/1 
 