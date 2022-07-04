# Appcent-ToDoApp-Task
This is a ToDoApp that is developed for AppCent Tech case study.
****************************UPDATE 04.07.2022****************************
USER-TASK RELATION IS ADDED. FROM NOW ON FOR USING THE SERVICES, FIRSTLY YOU MUST CREATE AN ACCOUNT WITH REGISTER ENDPOINT AND THEN YOU MUST LOGIN WITH LOGIN ENDPOINT
THE APP IS DEPLOYED TO HEROKU
LITTLE BUGS IN THE SERVICES ARE FIXED
HEROKU ENDPOINTS:
           GET - https://appcent-todo-task.herokuapp.com/api/tasks
           POST- https://appcent-todo-task.herokuapp.com/api/tasks
           PUT - https://appcent-todo-task.herokuapp.com/api/tasks/{id}
           DELETE - https://appcent-todo-task.herokuapp.com/api/tasks/{id}
           POST - https://appcent-todo-task.herokuapp.com/api/login
           POST - https://appcent-todo-task.herokuapp.com/api/register
           GET - https://appcent-todo-task.herokuapp.com/api/signOut
           GET - https://appcent-todo-task.herokuapp.com/api/logs
           SWAGGER: GET -http://localhost:8080/v3/api-docs/

************************************************************************


USED TECHNOLOGIES: JAVA 17, SPRING DATA, H2 DATABASE, REACT NATIVE, SPRING BOOT, JUNIT AND MOCKITO FOR UNIT TEST
DATABASE ENTITIES: TASKS, LOGS, USERS, ROLES (ROLES AND USERS ARE DEFINED FOR AUTHENTICATION BUT COULDN'T IMPLEMENT YET)

TO BUILD THE APP: YOU MUST BUILD THE POM XML AND RUN THE BACKEND SIDE FROM THE IDE. ALL THE APIS LINKED TO LOCALHOST:8080
                   AFTER RUNNING THE BACKEND SIDE, YOU SHOULD RUN THE FRONTEND SIDE WITH AN IDE THAT SUPPORTS REACT NATIVE 
                   FRONT END SIDE LINKED TO LOCALHOST:3000


TO RUN THE UNIT TESTS: I ADDED UNIT TESTS FOR SOME OF THE SERVICES YOU CAN RUN THEM FROM THE TESTS FOLDER UNDER THE TEST FOLDER

SWAGGER: http://localhost:8080/v3/api-docs/
ENDPOINTS: http://localhost:8080/api/task/getTasks
           http://localhost:8080/api/task/newTask
           http://localhost:8080/api/task/updateTask/{id}
           http://localhost:8080/api/task/deleteTask/{id}
           http://localhost:8080/api/user/validateUser
           http://localhost:8080/api/user/newUser
           http://localhost:8080/api/log/getLogs
           http://localhost:8080/v3/api-docs/
           
           
IMPORTANT: SINCE I USED H2 DATABASE THAT IS AN IN MEMORY DATABASE, I LET THE DATABASE URL AS MEM:TESTDB IN APPLICATION PROPERTIES. IF YOU DONT LINK IT TO A FILE IN YOUR COMPUTER, IT WILL RESTART THE DATAS AT EVERY RUN






