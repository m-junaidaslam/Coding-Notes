# Getting Started with Docker

## Install on Ubuntu
We will use script to download using curl
```bash
$ curl -fsSL https://get.docker.com -o get-docker.sh
$ sudo sh get-docker.sh
```

If you would like to use Docker as a non-root user, you should now consider
adding your user to the "docker" group with something like:
```bash
$ sudo usermod -aG docker your-user
```

Start Docker service if not already started:
```bash
$ sudo service docker start
```


## Working with Containers (Images)

Now run __hello-world__ program to test docker
If the image for __hello-world__ program is present locally, docker will simply run the image in a new container BUT if the image is not present, docker will search *hub.docker.com* for the image and will download and run it.
```bash
$ sudo docker run hello-world
```
Alternatively, image can also be pulled before running from *hub.docker.com*
```bash
$ sudo docker pull <image-name>:<tag>
```
`tag` can be some qualifier for the image e.g. __latest__ or __version__ of that image.

Now list of containers to see __hello-world__ container
```bash
$ sudo docker ps -a
```

List present docker images
```bash
$ sudo docker image ls
```

To start a docker container from suspended state
```bash
$ sudo docker-compose start
```

To stop a running container.
`Options
--time , -t	10	Seconds to wait for stop before killing it`
```bash
$ docker stop [OPTIONS] CONTAINER [CONTAINER...]
```

To remove images, first you have to make sure that there are no containers with that image in running or stopped state:
So first destroy the container
```bash
$ sudo docker rm <container-id>
```
Then remove the image
```bash
$ sudo docker rmi <image-id>
```

Images can also be run directly in the same __bash window__ and can also accept __input__ from the docker run command. We will show this by:

* Pulling docker image for __ubuntu__
* Running a new container with __input__ to start __ubuntu bash__
    ```bash
    $ sudo docker pull ubuntu:latest
    $ sudo docker image ls
    $ sudo docker run -it ubuntu /bin/bash OR
    $ sudo docker run -it <image-name/image-id> <input>
    ```
> On this downloaded image and its container, you will see that you will get very limited number of essential commands. You would not be able to find even very common commands like `htop` or `ping` and that is because this docker image is very minimalistic and should be very small in size.

> All the essentials can later be installed inside the container using __ubuntu__ commands or whichever image it is.

## Start and attach a container
1. To start a container which has already been exited
```bash
$ sudo docker start <container-id>
```
1. You can exit the container using `Ctrl+C` or detach screen by `Ctrl+D`.
1. To connect to the container again, __Start__ the container and attach to it
```bash
$ sudo docker attch <container-id>
```

