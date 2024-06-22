## Table Of Contents

Pre-requisites
Run Your First Test
Parallel Testing With TestNG
Local Testing With TestNG


## Pre-requisites
Before you can start performing Java automation testing with Selenium, you would need to:


Install the latest **Java development environment** i.e. JDK 1.6 or higher. We recommend using the latest version.


Download the latest Selenium Client and its WebDriver bindings from the official website. Latest versions of Selenium Client and WebDriver are ideal for running your automation script on LambdaTest Selenium cloud grid.


Install Maven which supports JUnit framework out of the box. Maven can be downloaded and installed following the steps from the official website. Maven can also be installed easily on Linux/MacOS using Homebrew package manager.



## Cloning Repo And Installing Dependencies
Step 1: Clone the LambdaTest’s Java-TestNG-Selenium repository and navigate to the code directory as shown below:

git clone https://github.com/LambdaTest/Java-TestNG-Selenium
cd Java-TestNG-Selenium


You can also run the command below to check for outdated dependencies.

mvn versions:display-dependency-updates



Setting Up Your Authentication
Make sure you have your LambdaTest credentials with you to run test automation scripts. You can get these credentials from the LambdaTest Automation Dashboard or by your LambdaTest Profile.
Step 2: Set LambdaTest Username and Access Key in environment variables.


**For Linux/macOS:**

export LT_USERNAME="YOUR_USERNAME" 
export LT_ACCESS_KEY="YOUR ACCESS KEY"



**For Windows:**


set LT_USERNAME="YOUR_USERNAME" 
set LT_ACCESS_KEY="YOUR ACCESS KEY"





**Run Your First Test**

Test Scenario: The sample TestNGTodo1.java tests a sample to-do list app by marking couple items as done, adding a new item to the list and finally displaying the count of pending items as output.


**Configuring Your Test Capabilities**
Step 3: In the test script, you need to update your test capabilities. In this code, we are passing browser, browser version, and operating system information, along with LambdaTest Selenium grid capabilities via capabilities object. The capabilities object in the above code are defined as:

DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");


You can generate capabilities for your test requirements with the help of our inbuilt Desired Capability Generator.

**Executing The Test**
Step 4: The tests can be executed in the terminal using the following command.

mvn test -D suite=single.xml


Your test results would be displayed on the test console (or command-line interface if you are using terminal/cmd) and on LambdaTest automation dashboard.

**Run Parallel Tests Using TestNG**
Here is an example xml file which would help you to run a single test on various browsers at the same time, you would also need to generate a testcase which makes use of TestNG framework parameters (org.testng.annotations.Parameters).

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite thread-count="3" name="LambaTestSuite" parallel="tests">

  <test name="WIN8TEST">
  <parameter name="browser" value="firefox"/>
  <parameter name="version" value="62.0"/>
  <parameter name="platform" value="WIN8"/>
    <classes>
      <class name="LambdaTest.TestNGToDo"/>
    </classes>
  </test> <!-- Test -->

  <test name="WIN10TEST">
  <parameter name="browser" value="chrome"/>
  <parameter name="version" value="79.0"/>
  <parameter name="platform" value="WIN10"/>
    <classes>
      <class name="LambdaTest.TestNGToDo"/>
    </classes>
  </test> <!-- Test -->
  <test name="MACTEST">
  <parameter name="browser" value="safari"/>
  <parameter name="version" value="11.0"/>
  <parameter name="platform" value="macos 10.13"/>
    <classes>
      <class name="LambdaTest.TestNGToDo"/>
    </classes>
  </test> <!-- Test -->

</suite>



**Executing Parallel Tests Using TestNG**
To run parallel tests using TestNG, we would have to execute the below commands in the terminal:

For the above example code

mvn test



For the cloned Java-TestNG-Selenium repo used to run our first sample test

mvn test -D suite=parallel.xml





Testing Locally Hosted Or Privately Hosted Projects
You can test your locally hosted or privately hosted projects with LambdaTest Selenium grid using LambdaTest Tunnel. All you would have to do is set up an SSH tunnel using tunnel and pass toggle tunnel = True via desired capabilities. LambdaTest Tunnel establishes a secure SSH protocol based tunnel that allows you in testing your locally hosted or privately hosted pages, even before they are live.
Refer our LambdaTest Tunnel documentation for more information.
Here’s how you can establish LambdaTest Tunnel.
Download the binary file of:

LambdaTest Tunnel for Windows
LambdaTest Tunnel for macOS
LambdaTest Tunnel for Linux

Open command prompt and navigate to the binary folder.
Run the following command:

LT -user {user’s login email} -key {user’s access key}


So if your user name is lambdatest@example.com and key is 123456, the command would be:

LT -user lambdatest@example.com -key 123456


