import logo from './logo.svg';
import './App.css';
import React, {useEffect , useState} from "react";
import TaskItem from './components/taskItem';

function App() {
  const[tasks,setTasks] = useState(null);
  useEffect(()=> {
    if(!tasks){
    fetch("http://localhost:8080/task/getTasks")
    .then((response) => response.json())
    .then((data) => {
      
      console.log("tasks: " , data)
      setTasks(data);
    });
  } },[tasks] );
  
 

  function addTask() {
       
    fetch(`http://localhost:8080/task/newTask`,
    {
        method: 'POST',
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify(tasks[(tasks.length) - 1])})
  
    .then((response) => response.json())
    .then((data) => {
      setTasks([...tasks,data]);

    }); }

    function handleDeleteTask(item) {

      addTask();
      const updatedTasks = tasks.filter(a => a.id !== item.id);
      setTasks([...updatedTasks]);
      App();
    }
  
  
    return(
      
      <div className="">
      <div className="wrapper">
        <div className="headpart">
          <div className="col">
           <h1><b>Todo App</b></h1>
         </div>
         <div className="col-6"></div>
      <div className="create-div col">
        <button className="btn btn-secondary" onClick={addTask}>Create New Task</button>
      </div>
      <br/>
      </div>
      <div className="center-div">
        {tasks
          ? tasks.map(item => { 
            return (
              <TaskItem
                key={item.id}
                data={item}
                emitDeleteTask={handleDeleteTask} />
            );
          })
          : "loading data"}
      </div>
      </div>
    </div>
  ); 
}

        
  



export default App;