1. docker volume create postgres  
2. run postgress in docker. creates container.
    
    docker run -p 5432:5432 -d \
        --name postgres_0 \
        -e POSTGRES_PASSWORD=postgres \
        -v postgres:/var/lib/postgresql/data \
        postgres:alpine

3. docker exec -it <container_id> bash
4. download pgadmin4 and install (GUI for postgres dbs).
5. create table script
    ```
   CREATE TABLE account(
      user_id serial PRIMARY KEY,
      username VARCHAR (50) UNIQUE NOT NULL,
      password VARCHAR (50) NOT NULL,
      email VARCHAR (355) UNIQUE NOT NULL,
      created_on TIMESTAMP NOT NULL,
      last_login TIMESTAMP
   );```


