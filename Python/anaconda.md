# Export environment
[Follow this link for more info](https://docs.conda.io/projects/conda/en/latest/user-guide/tasks/manage-environments.html#sharing-an-environment)

1. Activate the environment to export: conda activate myenv
1. Export your active environment to a new file: conda env export > environment.yml
1. Email or copy the exported environment.yml file to the other person.
1. To create environment from .yml file: conda env create -f environment.yml
1. The first line of the yml file sets the new environment's name.