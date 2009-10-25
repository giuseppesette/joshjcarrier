Josh Carrier
http://javadocs.wordpress.com
10.25.09

Modified product: Sun Jersey 1.0.3.1
Original JAR: jersey-core.jar
Modified JAR: jersey-core-gae.jar 

Modified for compatibility with Google App Engine SDK 1.2.6
This code comes as-is without warranty. Use at your own risk. 

Changes:
Commented out calls to com.sun.jersey.core.reflection.MethodList in the following classes:
com.sun.jersey.core.spi.component.ComponentConstructor
com.sun.jersey.core.spi.component.ComponentInjector
com.sun.jersey.core.spi.component.ComponentDestructor

Reprecussions unknown