# Git Repository

## Create Git Repository

1. Right click the folder to be added to repository and select git bash here. Then type following commands where **GitTestMarkUp** is the name of the folder in this example.

    ```bash
    git init
    git add .
    git commit -am 'GitTestMarkUp'
    ```

1. Go to **Github** and create a new repository. Copy and execute remote and push commands from the repository page as shown below.

    ```bash
    git remote add origin https://github.com/junaidaslam797/GitMarkUpTest.git

    git push -u origin master
    ```

1. Reload the github page.

## Update remote branch

Following following commands:

```bash
git add .
git commit -m <message>
git push origin <remote-branch>
```

## [Rename Branch](https://linuxize.com/post/how-to-rename-local-and-remote-git-branch/)

## Merge Develop to Master Branch

```bash
git merge master    # on branch develop
# resolve any merge conflicts if there are any

git checkout master
git merge develop # there won't be any conflicts now
```
