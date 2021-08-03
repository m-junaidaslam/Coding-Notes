# Windows Installation

1. Download windows __MySQL__ installer from the [Official Website](https://dev.mysql.com/downloads/mysql/5.7.html).
1. Install follwing two programs:
    * MySQL server
    * MySQL Workbench
1. Add __root password__ to the server and open it in the __work bench__ later on.
1. Add new database to the newly added server using __work bench__.
1. To stop the server at any time, open __Windows Powersheel__ as __admin__ and type:

    ```bash
    net stop <server-service-name>
    ```

1. To start the server at any time, open __Windows Powersheel__ as __admin__ and type:

    ```bash
    net start <server-service-name>
    ```

1. To delete the service:

    ```bash
    sc.exe delete <server-service-name>
    ```
