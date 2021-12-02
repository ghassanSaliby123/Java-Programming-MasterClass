This example is described in the Description text file
It tends to use the Adventure Game example from the Collection examples to implement IO
In order to read and write Objects we need to implement the serializable interface
it dosent contain any method it is just used to warn the JVM that we need to read/write objects
It is recommended to set a serial version field UID to be used with the serialization
it is better to set this field and not let the compiler to do so, because different compilers might
set this field in different way

First we make the Location class implements serializable
Then we set UID field   private  long serialVersionUID = 1L;
Then we use ObjectOutputStream to writeObject
The ObjectInputStream to readObject
