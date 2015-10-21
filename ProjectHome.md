# GROOVY2SSH MAVEN PLUGIN #

Maven plugin that allows to execute shell commands via groovy script on remote host through ssh connection.

This is basically only the maven plugin wrapper for [com.googlecode.msidor.groovy2ssh library](https://code.google.com/p/groovy2ssh/) whereas the SSH connection is handled by JSCH library.

**Please visit [our WIKI page](https://code.google.com/p/groovy2ssh-maven-plugin/w/list) for more informations.**

# Dependency #

Check the example of groovy2ssh-maven-plugin configuration in pom.xml

# Maven repository #

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

# Downloads #

To see all available releases downloads visit [OSS SONATYPE repository for groovy2ssh-maven-plugin](https://oss.sonatype.org/content/groups/public/com/googlecode/msidor/maven/plugins/groovy2ssh-maven-plugin/).