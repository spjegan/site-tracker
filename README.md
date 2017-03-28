# site-tracker
An old Assignment

APIs implemented
1. Create Site
2. Add Connection
3. Get Site
4. Get All Sites
5. Update Site name

REST API Details
1. Create Site
URI
POST	http://localhost:8080/sitetracker/rest/site/
Request
```json
{
    "siteName" : "SiteA",
    "connections": [
            {
                "siteName": "Augsburg",
                "distance": 10
            },
            {
                "siteName": "Augsburg",
                "distance": 15
            }            
        ]
}
```
Response
```json
{
    "siteId": "33",
    "siteName": "SiteA",
    "connections": [
        {
            "id": "3",
            "siteName": "Augsburg",
            "distance": 10
        },
        {
            "id": "4",
            "siteName": "Augsburg",
            "distance": 15
        }
    ]
}
```

2. Get Site Details
URI
	GET	http://localhost:8080/sitetracker/rest/site/{siteId}
Response
```json
{
    "siteName": "SiteA",
    "connections": [
        {
            "siteName": "Augsburg",
            "distance": 10
        },
        {
            "siteName": "Augsburg",
            "distance": 15
        }
    ]
}
```

3. Update Site Name
URI
	PUT	http://localhost:8080/sitetracker/rest/site/{siteId}
Request
```json
{
    "siteName": "Edina"
}
```

4. Add Connection to Site
URI
PUT 	http://localhost:8080/sitetracker/rest/site/{siteId}/connection
Request
```json
{
    "siteName": "SiteB",
    "distance": 4
}
```
5. Get All Sites
URI
GET	http://localhost:8080/sitetracker/rest/site/
Response
```json
[
{
"siteId":null,
"siteName":"Akola"
},
{
"siteId":null,
"siteName":"Allegheny"
}
]
```
Things to be implemented
1. Caching. Hibernate Second level cache is not implemented yet
2. Optimistic lock at Object level to avoid concurrency issues.
3. More unit and integration test cases
4. More Logging.
5. Spring AOP for Application Logging
6. More data validations
Schema Creation
Use the below attached SQL file to create the schema. This is for MySql.

