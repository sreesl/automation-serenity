# Automating NYTimes Books API Validation

API automation using Serenity, Rest Assured and Cucumber for the Books endpoint of New York Times.

## 📦 How do I set up

### Pre-requisite:
    These should be installed in your local machine.
    * Java 11
    * Gradle 7

* [Clone](https://docs.gitlab.com/ee/gitlab-basics/start-using-git.html) the project using git into your local directory
```sh
git clone https://gitlab.com/sreesl/automation-serenity
```

## 🏗 Build
Go to the project's root directory(automation-serenity) and Run
```sh
gradle build -x test
```

## ✅ Test
Run the tests using the command as below or use 'Run' function in your IDE on testapi.feature
```sh
gradle test
```
## 📈 Reports

Inorder to generate report, run the command and respective report will be available in target/site/serenity/ as index.html and serenity-summary.html
```sh
gradle report
```
## 💚 Gitlab Integration

- The tests are set to run in the [pipeline](https://gitlab.com/sreesl/automation-serenity/-/pipelines) in GitLab for every checkin.
- Add Gitlab config file `.gitlab-ci.yml` 
    - Add task to run your build script
    - Add task to run your test
    - Add task to generate report
- You can trigger the [pipeline](https://gitlab.com/sreesl/automation-serenity/-/pipelines) by clicking on "Run Pipeline" in the UI.
- HTML reports are saved as artifacts in the gitlab.com/{username}/automation-serenity/-/jobs/{job_number}/artifacts/browse for each job run.
   
     Refer [Sample INDEX HTML Report](https://sreesl.gitlab.io/-/automation-serenity/-/jobs/1320766250/artifacts/target/site/serenity/index.html). 

     Refer [Sample Single Page HTML Report](https://sreesl.gitlab.io/-/automation-serenity/-/jobs/1320838033/artifacts/target/site/serenity/serenity-summary.html).

## 🥒 Extending Tests

- Add new test scenarios in the feature file [testapi.feature](/src/test/resources/testapi.feature) 
- Add corresponding steps for the new scenarios in the stepDefinitions file [stepDefinition](/src/test/java/stepdefinitions/StepDefinition.java)

Refer further [Cucumber Documentation](https://cucumber.io/docs/guides/10-minute-tutorial/#write-a-scenario)
