uberjar example service
----------------------
I'm a java service that is deployed a simple uberjar using Maven Shade.

running the example
-------------------

Start the VM

```
$ vagrant up
```

Determine which port the VM is listening on for SSH:

```
$ vagrant ssh-config | grep Port
  Port 2202
```

Modify `mendel.yml`'s `dev` port accordingly:

```
$ patch mendel.yml <<EOP
> 7c7
> <     port: 2200
> ---
> >     port: 2202
> EOP
```

Deploy to the VM:

```
$ mendel dev deploy
[127.0.0.1] Executing task 'deploy'
[localhost] local: mvn clean -U package

...

[INFO] ------------------------------------------------------------------------
[INFO] Building myservice 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------

...

Results :

Tests run: 0, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

...

Successfully installed new release of myservice service

executing upstart:start
myservice start/running, process 13266

Done.
Disconnecting from 127.0.0.1:2200... done.
```

Test it out!

```
$ curl "http://127.0.0.1:8080/hello"
Hello, null!

$ curl "http://127.0.0.1:8080/hello?name=Kevin"
Hello, Kevin!
```