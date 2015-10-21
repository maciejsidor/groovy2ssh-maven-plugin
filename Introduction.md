# Introduction #

groovy2ssh-maven-plugin maven plugin allows to execute shell commands via groovy script on remote host through ssh connection. You may interact with remote host in your groovy script by the groovy API provided by [com.googlecode.msidor.groovy2ssh library](https://code.google.com/p/groovy2ssh/).

Please check the [project page](https://code.google.com/p/groovy2ssh/) for more information about the API provided.

# Usage #

Bellow code presents the example of groovy2ssh plugin configuration.

In this configuration, groovy2ssh plugin will execute the example.groovy script (see bellow) on remote host. This very simple script will create the folder with project version as the name.

## Maven repository ##

The groovy2ssh-maven-plugin is hosted on OSS SONATYPE repository, thus, in order to use it in your maven project you must add the OSS SONATYPE repository configuration to your pom.xml file.

Add following code to your pom.xml:

```
<repositories>
  <repository>
    <id>sonatype-oss-public</id>
    <url>https://oss.sonatype.org/content/groups/public/</url>
    <releases>
      <enabled>true</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

## Downloads ##

To see all available releases downloads visit [OSS SONATYPE repository for groovy2ssh-maven-plugin](https://oss.sonatype.org/content/groups/public/com/googlecode/msidor/maven/plugins/groovy2ssh-maven-plugin/).