# Automating NYTimes Book API Endpoints

API automation using Serenity and Cucumber

## 📦 How do I set up

###Pre-requisite:
    These should be installed in your local machine.
    * Java 11
    * Gradle 7

* [Clone](https://docs.gitlab.com/ee/gitlab-basics/start-using-git.html) the project using git into your local directory
git clone https://gitlab.com/sreesl/automation-serenity

* Go to the project's root directory(automation-serenity) and Run

```sh
gradle build -x
```

## ✅ Test
Run the tests using the command as below or use 'Run' function in your IDE on testapi.feature
```sh
gradle test
```
## ✅ Reports

Inorder to generate report, run the command and Report is available in target/site/serenity/ as index.html.
```sh
gradle report
```
## 📦 CI Integration
- The tests are set to run in the [pipeline](https://gitlab.com/sreesl/automation-serenity/-/pipelines) in GitLab for every checkin.
- Add Gitlab config file `.gitlab-ci.yml` 
    - Add task to run your build script
    - Add task to run your test
    - Add task to generate report
- You can trigger the [pipeline](https://gitlab.com/sreesl/automation-serenity/-/pipelines) by clicking on "Run Pipeline" in the UI.
- HTML reports are saved as artifacts in the https://gitlab.com/sreesl/automation-serenity/-/jobs/<job#>/artifacts/browse for each job run of job#/\.
   
     [Sample Report](https://sreesl.gitlab.io/-/automation-serenity/-/jobs/1320766250/artifacts/target/site/serenity/index.html) to refer.
