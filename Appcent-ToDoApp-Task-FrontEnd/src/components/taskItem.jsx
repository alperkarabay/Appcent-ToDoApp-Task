import React, { useEffect, useState } from "react";
import DropdownButton from "react-bootstrap/DropdownButton"
import Dropdown from "react-bootstrap/Dropdown"
import 'bootstrap/dist/css/bootstrap.min.css';
const TaskItem = (props) => {
    const { emitDeleteTask } = props;
    const [TaskItem, setTaskItem] = useState(props.data);
    
    const [isModified, setModified] = useState(false);
    useEffect(() => {
        if (isModified) {
            fetch(`http://localhost:8080/task/updateTask/${TaskItem.id}`,
                {
                    method: 'PUT',
                    headers: {
                        "content-type": "application/json"
                    },
                    body: JSON.stringify( TaskItem)
                })
                .then((response) => response.json())
                .then((data) => {
                    setModified(false);
                    setTaskItem(data);

                });

        }

    }, [TaskItem, isModified]); 
    
    function updateTaskStatus(e) {
        setModified(true); 
        setTaskItem({ ...TaskItem, status: e });
       
    }
    function updateTask(e) {
        setModified(true); 
        setTaskItem({ ...TaskItem, taskTitle: e.target.value });
       
    }
   
    function deleteTask() {
        fetch(`http://localhost:8080/task/deleteTask/${TaskItem.id}`,
            {
                method: 'DELETE',
                headers: {
                    "content-type": "application/json"
                },
            })
            .then((response) => response.json())
            .then((data) => {
                emitDeleteTask(TaskItem);

            });
    
    }
    const handleSelect=(e)=>{
        console.log(e);
        updateTaskStatus(e);
      }
    

    return (
        <div>
             {
                TaskItem.status === 'TO_DO' ? 
                    ( <DropdownButton  
                        title={"TO_DO"}
                        key={"down"}
                        id={`dropdown-button-drop-"down"`}
                        drop={"down"}
                     
                        style={{marginTop: "1.5rem",  marginRight: "31rem"}}
                        variant="secondary"
                        value={TaskItem.status} onSelect={handleSelect}
                      
                    >
                        <Dropdown.Item href="TO_DO" active>TO_DO</Dropdown.Item>
                        <Dropdown.Item href="IN_PROGRESS">IN_PROGRESS</Dropdown.Item>
                        <Dropdown.Item href="DONE">DONE</Dropdown.Item>
                    </DropdownButton>) 
                    : TaskItem.status === 'IN_PROGRESS' ?
                    (<DropdownButton title={"IN_PROGRESS"}
                        key={"down"}
                        id={`dropdown-button-drop-"down"`}
                        drop={"down"}
                        
                        style={{marginTop: "1.5rem",  marginRight: "31rem"}}
                        variant="secondary" value={TaskItem.status} onSelect={handleSelect}>
                        <Dropdown.Item href="TO_DO" >TO_DO</Dropdown.Item>
                        <Dropdown.Item href="IN_PROGRESS" active>IN_PROGRESS</Dropdown.Item>
                        <Dropdown.Item href="DONE">DONE</Dropdown.Item>
                        </DropdownButton>) 
                         
                         :(<DropdownButton title={'DONE'}
                            key={"down"}
                            id={`dropdown-button-drop-"down"`}
                            drop={"down"}
                           
                            style={{marginTop: "1.5rem", marginRight: "31rem"}}
                            variant="secondary" value={TaskItem.status}onSelect={handleSelect}>
                            <Dropdown.Item href="TO_DO" >TO_DO</Dropdown.Item>
                            <Dropdown.Item href="IN_PROGRESS" >IN_PROGRESS</Dropdown.Item>
                            <Dropdown.Item href="DONE" active>DONE</Dropdown.Item>
                        </DropdownButton>)
                
            } 

            {
                (TaskItem.status === "DONE") ? 
                    (<input readOnly name ="formargin alert alert-dark" size = "50" style={{textDecoration: 'line-through'}} value={TaskItem.taskTitle}/>) 
                    :
                    (<input  name="formargin alert alert-dark" type="text" size = "50"  value={TaskItem.taskTitle} onChange={updateTask} />)
            }
           
            <span style={{marginLeft: "10rem", cursor: "pointer" }} onClick={deleteTask}>🗑️</span>


        </div>
    );

};

export default TaskItem;