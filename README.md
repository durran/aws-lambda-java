# aws-lambda-java

## Steps to deploy

### Clone the repo

```sh
git clone git@github.com:durran/aws-lambda-java.git
```

### Ensure Jenv is installed or have the JDK set to 11.

```sh
brew install jenv
```

### Ensure Gradle is installed.

```sh
brew install gradle
```

### Build the Project

```sh
gradle shadowJar
```

### Create the Lambda Function on AWS.

Use the Java 11 runtime and use an existing execution role.

<img width="1904" alt="Screenshot 2023-01-26 at 20 18 41" src="https://user-images.githubusercontent.com/9030/214932381-4e465f41-c127-445a-afaa-62e1bed6ff24.png">

### Add the handler function to the runtime settings

<img width="1904" alt="Screenshot 2023-01-26 at 20 20 08" src="https://user-images.githubusercontent.com/9030/214932666-8a4442e7-594f-4ff4-b7e5-1338733e9f08.png">
<img width="1904" alt="Screenshot 2023-01-26 at 20 20 49" src="https://user-images.githubusercontent.com/9030/214932706-ca7f59f8-b14e-48d4-8bf8-11a43d65c4dc.png">

### Add MONGODB_URI to the environment variables

<img width="1904" alt="Screenshot 2023-01-26 at 20 19 45" src="https://user-images.githubusercontent.com/9030/214932585-95579157-4153-45e0-99eb-1309d1cd05f8.png">

### Upload the Jar

It's in build/libs/lambda-java-cache-0.0.1-all.jar

<img width="1904" alt="Screenshot 2023-01-26 at 20 21 04" src="https://user-images.githubusercontent.com/9030/214933006-543ea756-c743-4b2d-a05f-d4c0eacaf410.png">
<img width="1904" alt="Screenshot 2023-01-26 at 20 21 17" src="https://user-images.githubusercontent.com/9030/214933054-018a9ab8-ce07-47f4-8168-e23d8c00fecb.png">

### Test

Click on the test tab, then click on the orange test button. Profit.

<img width="1904" alt="Screenshot 2023-01-26 at 20 23 44" src="https://user-images.githubusercontent.com/9030/214933072-454c7a80-b669-4929-b15f-f215fb3b6d7d.png">
