# TCLib 
The TCLib is a Liberty that expands Java by 
some functions or supplements or simplifies some functions.
The project runs under the [GNU General Public License Version 3](license.md) or higher.
In the [changelog](changelog.md) you can see the changes to the project as well as Liberty.
In the issues area you can report problems or errors so that we can deal with them quickly.
In order to report errors, make suggestions or otherwise, we ask you to use the following languages: 
* German 
* English

other languages are not supported, so these requests cannot be processed.
You can find the documentation for Liberty [here](https://doc.the-cat-tc.de).

## Examples

### Register service permanently in the system.

To save services or devices in a file so that they can be accessed at any time by other programs using TCLib, proceed as follows:

The module.java:
```java
module Test {
    requier de.tc.cat.TClib;
    require java.se;
}
```
The Test.java:

```java
public class Test {
    import de.tc.cat.the.system.*
    public void main(String[] args) {
        Register reg = new Register();
        Service testService = new Service("Test",Status.Aktiviert,
        Option.Run,"This is a test description");
        reg.addService(testService);
    }
}
```
Done, create a class in which a service is permanently integrated. 
Do not send this service has no influence on existing services in the system. 
The services and devices are created purely virtually. 
A connection to other programs is unfortunately not possible.

They create a device in much the same way as a deinst. 
The module.java remains the same. The Test class is expanded as follows:
```java
public class Test {
    import de.tc.cat.the.system.*
    public void main(String[] args) {
        Register reg = new Register();
        Device testDevice = new Device("Test",Status.Aktiviert,Category.Grafik);
        reg.addDevice(testDevice);
    }
}
```

Services and devices are then created. To delete them, simply use the functions
* removeService to delete a service.
* removeDevice to delete a device.