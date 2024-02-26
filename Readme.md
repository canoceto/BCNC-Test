# BCNC Demo

This is a small project commissioned by BCNC Group to evaluate knowledge, consisting of the development of three of our
services that allow the obtaining of data from an external API, in relation to the aforementioned services we can store
them in a local database, returned immediately and finally the recovery of the data from said local database.

## Deployment

There are several options to deploy this project both on servers and on the cloud, I leave below an article where you
can choose a provider to install in the cloud

https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html

Another option would be on a server like TomCat or Nginx, in that case you can select the packaging based on your needs
and availability either as JAR or WAR.

This requiere Pom.xml edit:

https://www.baeldung.com/spring-boot-war-tomcat-deploy

## Acknowledgements

#### Reference Documentation

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/htmlsingle/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#using.devtools)

#### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## API Reference

#### Load into DB all items from external API

```http
  GET /api/load/all
```

| Parameter | Type | Description              |
|:----------|:-----|:-------------------------|
| `none`    |      | No require any parameter |

#### Get all items without any saving

```http
  GET /api/recover/all
```

| Parameter | Type | Description              |
|:----------|:-----|:-------------------------|
| `none`    |      | No require any parameter |

#### Get all items from our DB

```http
  GET /api/all
```

| Parameter | Type | Description              |
|:----------|:-----|:-------------------------|
| `none`    |      | No require any parameter |

## Running Tests

To run tests, run the following command

```bash
 mvn clean install
```

## Tech Stack

**Client:** Postman

**Server:** Java 17, Spring Boot 3.2.2

**Data Base:** H2

## Run Locally

Clone the project

```bash
  git clone https://github.com/canoceto/BCNC-Test
```

Go to the project directory

```bash
  cd BCNC-Test
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```

## Optimizations

For optimisation we use data structures according to the needs, as is the case of hashmaps for the storage of structures
identifiable by a list ID when we need to iterate over all the elements. Bearing in mind that in this project complete
database inchings and recoveries are carried out, it is not necessary to use lists different from the default ones, in
case we need optimization in insertions and deletions of data from a list of elements, I suggest using a LinkedList
because by the theory on which it is based it is very efficient.

#### Example:

Optimal structure to retrieve a list of photos from the identifier of the album to which they belong

Hashmap<AlbumID, PhotoList> albumsWithPhotos= ...

Use java lib like Collection to handle list, they use optimized methods and structures

## Authors

- [@canoceto](https://www.github.com/canoceto)

## Feedback

If you have any feedback, please reach out to me at carlosg.anoceto@gmail.com

