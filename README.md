## Steps to run
1. docker volume create postgres  
2. run postgress in docker. creates container.
    
    docker run -p 5432:5432 -d \
        --name postgres_0 \
        -e POSTGRES_PASSWORD=postgres \
        -v postgres:/var/lib/postgresql/data \
        postgres:alpine

3. docker exec -it <container_id> bash
4. download pgadmin4 and install (GUI for postgres dbs).
5. create table script **db_scripts.sql**
6. Alternatively, if the container already exists, 
    ```
    docker run container_id
   ```


