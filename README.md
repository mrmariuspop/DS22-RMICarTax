# DS22-RMICarTax

The project was done based on the following tutorial: https://www.mkyong.com/java/java-rmi-hello-world-example

RMI stands for Remote Method Invocation and it is the object-oriented equivalent of RPC (Remote Procedure Calls). RMI was designed to make the interaction between applications using the object-oriented model and run on different machines seem like that of stand-alone programs.

# The Remote Interface
The first thing we have to design is the Remote Interface that both Server and Client will implement. The Interface must always be public and extend Remote. All methods described in the Remote interface must list RemoteException in their throws clause.

# The Server
Our Server extends UnicastRemoteObject and implements the Interface we made before. In the main method we bind the server on localhost with the name “MyServer”.

# The Client
Finally, we create the Client. To “find” the Server, the Client uses an RMIInterface Object that “looks” for a reference for the remote object associated with the name we pass as parameter. With that RMIInterface object we can now talk to the Server and receive responses.
