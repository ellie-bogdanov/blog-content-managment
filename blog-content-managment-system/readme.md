# blog content managment system
## a quick overview
I built a RESTFUl api that manages your posts with the help of bcms.http (you can also use any other service that provides http requests it is mostly for testing).
you can send json files to PostController so it will make a new post and add it to the database, you can update, delete, and change the number of likes and dislikes on a given post.
the comments are tied to a specific post via having postId so each post will have its own comments

# More in Depth
the repositories I used are extentions of CrudRepository for both comment and post (I also use PostRepository for early testing when I had no sql database).
and in each controller I used the methods provided in CrudRepository, with some added functionality to add likes and dislikes for example.
it is sql injection protected with the help of spring boot and parameterized queries.

# Whats Next?
Ill add likes and dislikes to comment section, I will also integrate user authorization and verification in the future, and some more features when Ill have the time.