# ultimate-cucumber
My ideal framework for executing automated testing - selenium &amp; REST API

## Usage:

* clone repo
```
git clone https://github.com/benjrozen/ultimate-cucumber.git
cd ultimate-cucumber
```
* For UI automation, go to https://bookcart.azurewebsites.net/register and register your user, add details to bookcartDemo.properties:

```
USERNAME={{YOUR_USERNAME}}
PASSWORD={{YOUR_PASSWORD}}
```
* To run all tests in 'src/test/resources':
```
cd ultimate-cucumber
./gradlew runCucumber
```
