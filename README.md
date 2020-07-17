<h1>Hobby Project</h1>
<hr>
<p>This is a project that was set to me by QA Consulting to access my understanding for the technologies they have been teaching me</p>
<p>With this application you can create your own stamp and a collection of stamps, the stamps can be read back to you and you can update and delete your stamp collection</p>

<p>Bringing stamp collecting into the 21st Century!</p>

<h2>Introduction</h2>
<hr>
<p>The following instructions will allow you to have the application up and running for yourself in no time</p>

<h3>Prerequisites</h3>
<ul>
<li>Spring Tool Suite</li>
<li>Maven</li>
<li>Visual Studio Code (for the frontend)</li>
<li>ChromeDriver (for testing the frontend with Selenium)</li>
<li>MySQL (Optional - I have opted for the H2 Database - more info below)</li>
</ul>

<h3>Installing</h3>

<h4>How to install Spring Tool Suite</h4>
<ol>
<li>Go to this address: https://spring.io/tools</li>
<li>Download for your relevant operating system (i.e Windows)</li>
<li>Go to your downloads folder and double click on the downloaded file</li>
<li>You will then be guided through the set-up process</li>
<li>To run the project you just need to go to Boot (a green hexagon) and press the run button</li>
</ol>

<h3>How to set up Maven</h3>
<ol>
<li>Go to this website: https://maven.apache.org/install.html</li>
<li>This has very good instructions on how to set up your system fully and mentions setting up your path - instructions for that are below</li>
</ol>

<h3>How to set up your path</h3>
<ol>
<li>On your computer you will need to go to your Edit Environment Variables</li>
<li>Click on "Environment Variables..."</li>
<li>Go to system variables and click "new"</li>
<li>Your variable name can be M2_HOME (for Maven)</li>
<li>Your variable value is along the lines of C:\Program Files\apache-maven-3.6.3</li>
<li>Press "OKAY"</li>
<li>Your path is now saved</li>
</ol>

<h2>Dependencies</h2>
<p>Check out my pom.xml for the dependencies that I used</p>

<h2>Testing the server</h2>
<p>Once started try navigating to: http://localhost:8082/swagger-ui.html</p>
<p>This will tell you if the server is up a running, you should be able to view the Swagger Resource Listing</p>

<h2>Testing</h2>

<h3>Integration Testing</h3>
<p>Integration tests are set up for this project and the relevant dependencies for JUnit are in the pom.xml</p>
<p>These tests are set up to check that the CRUD functionality works</p>

<h3>Unit Testing</h3>
<p>Using Mockito to unit test the individual methods</p>

<h3>Selenium Testing</h3>
<p>Selenium tests are set up to test the frontend - make sure you have downloaded the correct remote webdriver. I have 
Google Chrome version 83 so I used ChromeDriver version 83. </p>

<h2>Front-end</h2>
<p>Head over to here to view the front-end code: https://github.com/BeccaStaple/hwa-frontend</p>

<h2>Built With</h2>
<p>Maven</p>

<h2>Authors</h2>
<p>Becca Staple</p>

<h2>Acknowledgements</h2>
<p>Jordan Harrison</p>
<p>Piers Barber</p>


<h2>License</h2>
<p>This project is licensed under the MIT license - see the <a href="https://github.com/BeccaStaple/hwa-backend/blob/master/LICENSE.md" >LICENSE.md</a> file for details</p>

