# ultimate-cucumber

<div align="center">
<img alt="GitHub top language" src="https://img.shields.io/github/languages/top/benjrozen/ultimate-cucumber?style=flat">
<img alt="GitHub cucumber " src="https://img.shields.io/badge/Cucumber-43B02A?style=for-the-badge&logo=cucumber&logoColor=white">

</div>

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
