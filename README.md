# **Development Books** project


# Purpose

This Development books kata is developed using Test Driven Development approach using spring boot and written in Java programming language.


# About this Kata and its discount calculation logic

There is a series of books about software development that have been read by a lot of developers who want to improve their development skills. Let’s say an editor, in a gesture of immense generosity to mankind (and to increase sales as well), is willing to set up a pricing model where you can get discounts when you buy these books. The available books are :

Clean Code (Robert Martin, 2008)
The Clean Coder (Robert Martin, 2011)
Clean Architecture (Robert Martin, 2017)
Test Driven Development by Example (Kent Beck, 2003)
Working Effectively With Legacy Code (Michael C. Feathers, 2004)
Rules
The rules are described below :

One copy of the five books costs 50 EUR.

If, however, you buy two different books from the series, you get a 5% discount on those two books.
If you buy 3 different books, you get a 10% discount.
With 4 different books, you get a 20% discount.
If you go for the whole hog, and buy all 5, you get a huge 25% discount.
Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the 4th book still costs 50 EUR.
Developers seeking to deliver quality products are queueing up with shopping baskets overflowing with these books. Your mission is to write a piece of code to calculate the price of any conceivable shopping basket.

```
For example, how much does this basket of books cost?

2 copies of the “Clean Code” book
2 copies of the “Clean Coder” book
2 copies of the “Clean Architecture” book
1 copy of the “Test Driven Development by Example” book
1 copy of the “Working effectively with Legacy Code” book
Answer :

(4 * 50 EUR) - 20% [first book, second book, third book, fourth book]

(4 * 50 EUR) - 20% [first book, second book, third book, fifth book]

= 160 EUR + 160 EUR

= 320 EUR (knowledge is priceless but has a cost)
```
# Getting Started

`git clone https://github.com/2022-DEV1-018/DevelopmentBooks.git `

# Prerequisites
```
To run this program below softwares needs to be installed

Java - Version 1.8 or above
JRE compliance - 1.8 or above
Maven - 3.2 or above
JUnit - Version 4.13.2 (added dependency in pom.xml)
Eclipse - Any IDE which supports Java
```
# Build and Test

## Running the application
```
You can run the application using:

mvn clean install
mvn spring-boot:run
```

## Testing the application
```
Once the application runs, we can test it using postman or the tool of your choice as per the below guidelines.

1) getBooks() Service - 
	This is a GET Service will return all the available books which can be purchased

	HttpMethod : GET
	MediaType : JSON
	EndPoint : http://localhost:8080/books/getBooks

2) calculateBookPrice() Service - 
	This is POST Service where we can send our book request details and the response will be received with the total price and discounted price details for our purchase request

	HttpMethod : POST
	MediaType : JSON
	EndPoint : http://localhost:8080/books/calculateBookPrice

The sample request for this calculateTotalPrice is available under
 `src/main/resources/CalculateTotalPrice.json`, at the root of the project.

```
## Packaging the application
```
The application can be packaged using:

mvn package

It produces the `DevelopmentBooks-1.0.0-SNAPSHOT.jar` file in the `/target` directory.

The application is now runnable using `java -jar target/DevelopmentBooks-1.0.0-SNAPSHOT.jar`.
```

# How to access the code coverage report
```
Jacoco code coverage report can be accessed by the following steps.

Download project as zip file and unzip the same to a folder. 
Open a command prompt and goto the project(extracted) folder and execute below commands:
mvn clean
mvn install
After completion of above steps, the report will be available in below path
<PROJECT_ROOT_FOLDER>\target\site\jacoco\index.html
```

