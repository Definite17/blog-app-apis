# Blog Application

Complete Backend Api for a Blog Application in SpringBoot with JWT Authentication, Also Configured with Swagger for Api Documentation.

## Api Enpoints

This projects consists Enpoints for:-

### 1) Login and Registering a User.
#### a) Login
User will need to Log in with his email as username(email) and password and JWTAuthentication token will be generated for him.
```http
  POST /api/v1/auth/login
```

#### b) Registering User
User Will be Registered and "ROLE_NORMAL" would be given to him, where he will be 

```http
  POST /api/v1/auth/register
```
**Required RequestBody** : UserDto
```json
{
  "about": "string",
  "email": "string",
  "id": 0,
  "name": "string",
  "password": "string",
  "roles": [
    {
      "id": 0,
      "name": "string"
    }
  ]
}
```
### 2) User API's
All **CRUD** API's for user.

#### a) createUser
API for adding user.
```html
POST /api/users/create
```
**Required RequestBody** : UserDto
```json
{
  "about": "string",
  "email": "string",
  "id": 0,
  "name": "string",
  "password": "string",
  "roles": [
    {
      "id": 0,
      "name": "string"
    }
  ]
}
```
#### b) updateUser
API for updating user Details.

```html
PUT /api/users/{userId}
```
| Parameter | Type      | Description                                             |
|:----------|:----------|:--------------------------------------------------------|
| `userId`  | `Integer` | **Required**. UserID of the User you want to **UPDATE** |
**Required RequestBody** : UserDto
```json
{
  "about": "string",
  "email": "string",
  "id": 0,
  "name": "string",
  "password": "string",
  "roles": [
    {
      "id": 0,
      "name": "string"
    }
  ]
}
```

#### c) deleteUser
API for deleting existing user.
```html
DELETE /api/users/{userId}
```

| Parameter | Type      | Description                                               |
|:----------|:----------|:----------------------------------------------------------|
| `userId`  | `Integer` | **Required**. UserID of the User you want to _**DELETE**_ |

#### d) getUserById
API for getting user Deatils by userId.
```html
GET /api/users/{userId}
```

| Parameter | Type      | Description                                            |
|:----------|:----------|:-------------------------------------------------------|
| `userId`  | `Integer` | **Required**. UserID of the User you want to _**GET**_ |

#### e) getAllUsers
API for getting All user details.
```html
GET /api/users
```

### 3)Posts API's
API related to all the Post's in the **_BLOG_**
#### a) createPost
API for creating a new Post
```html
POST /api/posts/user/{userId}/category/{categoryId}/create
```


| Parameter    | Type      | Description                              |
|:-------------|:----------|:-----------------------------------------|
| `userId`     | `Integer` | **Required**. UserID of the User.        |
| `categoryId` | `Integer` | **Required**. categoryID of the Category |

**Required RequestBody** : PostDto
```json
{
  "category": {
    "categoryDescription": "string",
    "categoryId": 0,
    "categoryTitle": "string"
  },
  "comments": [
    {
      "content": "string",
      "id": 0
    }
  ],
  "content": "string",
  "createdAt": "2022-10-25T14:14:03.896Z",
  "imgName": "string",
  "postId": 0,
  "title": "string",
  "user": {
    "about": "string",
    "email": "string",
    "id": 0,
    "name": "string",
    "roles": [
      {
        "id": 0,
        "name": "string"
      }
    ]
  }
}
```

#### b) _updatePost_
API for updating the Post
```html
PUT /api/posts/update/{postId}
```

| Parameter | Type      | Description                                               |
|:----------|:----------|:----------------------------------------------------------|
| `postId`  | `Integer` | **Required**. PostID of the User you want to _**UPDATE**_ |

**Required RequestBody** : PostDto
```json
{
  "category": {
    "categoryDescription": "string",
    "categoryId": 0,
    "categoryTitle": "string"
  },
  "comments": [
    {
      "content": "string",
      "id": 0
    }
  ],
  "content": "string",
  "createdAt": "2022-10-25T14:14:03.896Z",
  "imgName": "string",
  "postId": 0,
  "title": "string",
  "user": {
    "about": "string",
    "email": "string",
    "id": 0,
    "name": "string",
    "roles": [
      {
        "id": 0,
        "name": "string"
      }
    ]
  }
}
```

#### c) _deletePost_
API for deleting a Post.
```html
DELETE api/posts/post/{postId}
```

| Parameter | Type      | Description                                               |
|:----------|:----------|:----------------------------------------------------------|
| `postId`  | `Integer` | **Required**. PostID of the User you want to _**DELETE**_ |


#### d) _uploadPostImage_
API for uploading image to the Corresponding Post

```html
POST api/posts/post/image/upload/{postId}
```

| Parameter | Type                  | Description                                               |
|:----------|:----------------------|:----------------------------------------------------------|
| `postId`  | `Integer`             | **Required**. PostID of the User you want to _**DELETE**_ |
| `image`   | `multipart/form-data` | **Required**  Image file you want to upload               |

#### e) _getPostById_
API to get a post with its ID.
```html
GET /api/posts/{postId}
```
**Required Parameter :-** postId

#### f) _getAllPost_
API to get all posts.
```html
GET /api/posts/all
```
**_Optional Parameters_**

| Parameter    | Type      | Description                                                                                       |
|:-------------|:----------|:--------------------------------------------------------------------------------------------------|
| `pageSize`   | `Integer` | Size of the page you want                                                                         |
| `pageNumber` | `Integer` | Page Number you want to look in                                                                   |
| `sortBy`     | `String`  | property with which you want to _**SORT**_, eg: (postId), _**Default value**_: postId             |
| `sortDir`    | `String`  | The Direction in which you want to sort, eg: "DSC" for descending Order. _**Default value**_: asc |

#### g) _getPostByCategory_
API to get Posts of a particular category.
```html
GET /api/posts/category/{categoryId}
```
**_Optional Parameters :-_**  pageSize, pageNumber, sortBy, sortDir

#### h) _downloadImage_
API to View/Download image of a Post.
```html
GET /api/posts/post/image/{imageName}
```
_**Required Parameter**_

| Parameter   | Type     | Description                              |
|:------------|:---------|:-----------------------------------------|
| `imageName` | `String` | **Required**. Name of the Image to want. |

#### i) _searchPostByTitle_
API to search Post By Title
```html
GET /api/posts/search/{keywords}
```
_**Required Parameter**_

| Parameter  | Type     | Description                                          |
|:-----------|:---------|:-----------------------------------------------------|
| `keywords` | `String` | **Required**. Full Title or some words of the title. |

##### j) _getPostByUser_
API to get All posts of a particular user.
```html
GET /api/posts/user/{userId}
```
_**Required Parameter**_ : userId.

_**Optional Parameter**_ : pageSize, pageNumber, sortBy, sortDir
### 4) Category API's


### 5) Comments API's

## - - - - - - - -