Build using `gradlew build`, and then run the application using `java -jar build/libs/bigtable-jdk-issue-all.jar`.
At least Java 17 is required to run the example.

If the firewall is configured to refuse incoming network connections the application takes ~16-17 seconds to run, 
but if the firewall is configured to accept incoming network connections it only takes a couple of seconds.

Notes:
* GCloud authentication using `gcloud auth login` must have been performed.
  * If no valid credentials are registered the application fails immediately with an exception.
* This has been tested on Mac OS Sonoma 14.4
  * Note that system restart is required for firewall settings to be properly applied.
* The configured GCP project, instance and table are completely irrelevant:
  * This simple demo uses values that are not pointing at anything real, but the result is identical with proper values.