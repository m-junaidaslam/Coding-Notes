# Ubuntu Python3 Virtual Environment
### Use pip to install virtualenv
```bash
sudo pip3 install virtualenv
```

### Launch your Python 3 virtual environment, here the name of my virtual environment will be env3
```bash
virtualenv -p python3 <env-name>
```

### Activate your new Python 3 environment. There are two ways to do this:
```bash 
. <env-name>/bin/activate
```
OR
```bash
source <env-name>/bin/activate
```
which does exactly the same thing.

### Create a requirements.txt of currently installed packages:
```bash
pip freeze > requirements.txt
```

### Delete the misspelled virtualenv:
```bash
rm -r <env-name>/
```



### You can make sure you are now working with Python 3:
```bash
python -- version
```
### This command will show you what is going on; the python executable you are using is now located inside your virtualenv repository:
```bash
which python
```

### Code your stuff

### Done?, leave the virtual environment
```bash
deactivate
```

# Ubuntu Virtual Environment Wrapper
For more functionality, use virtual environment wrapper which also adds copying and renaming of virtual environments.
## Installation
```bash
mkdir ~/.virtualenvs

sudo pip3 install virtualenvwrapper

export WORKON_HOME=~/.virtualenvs

# Mention python version to be used with it:
VIRTUALENVWRAPPER_PYTHON='/usr/bin/python3'

# Also mention the path where projects should be created and saved



# Find the location of __virtualenvwrapper.sh__ and look for address like:
#  /.local/bin/virtualenvwrapper.sh
# using following command:
find / -name virtualenvwrapper.sh

# Then open file .bashrc by:
sudo nano ~/.bashrc

# At the end of the file add the address found:
# /.local/bin/virtualenvwrapper.sh
# Save the file and continue with following commands:
. .bashrc

# And the virtual environment wrapper will be installed
```

## Usage
[Link to Commands of virtualenvwrapper](https://virtualenvwrapper.readthedocs.io/en/latest/command_ref.html)
