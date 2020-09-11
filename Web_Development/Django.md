# Django Web Development
## Setup Project
Fist it is better to setup a virtual enviroment for __Django__. For this purpose one choice is to install __VirtualEnvWratter__. Use this link for step by step instruction to install __VirtualEnvWrapper__:
[Setup Virtual Env](../Python/Virtual_Env.md)

```bash
# Make virtual environment with or without project
mkvirtualenv Django
# OR
mkproject Django
# In case of first command, you have to create separate project in the environment created.

# Insall django in the virtual environment
pip install django

# Check the installation
django-admin --version
# NOTE: Django will only be installed in the virtual environment

# Create django project
django-admin startproject django_dash

# Go into project directory
cd django_dash

# Run the server to test project successful creation
python manage.py runserver
# NOTE: If the server gives error for migration, enter following command:
python manage.py migrate
# And test the server on the browser
# If the server is running, initial setup for django is done. Hurray!
```
> Django is very well documented and it is recommended to consult the documentation in case required:
[Django_Official_Documentaion](https://docs.djangoproject.com/en/3.0/)