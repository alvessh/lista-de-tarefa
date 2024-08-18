import { Checkbox, IconButton } from '@mui/material';
import React, { useEffect, useState } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';


const Task = (props) => {
	const {emitDeleteTaskItem} = props;
	const [task, setTask] = useState(props.data);
	const [isDirty, setDirty] = useState(false);


	useEffect(() => {
		if (isDirty){
			fetch(`http://localhost:8080/api/task/${task.id}`,{
				method:"PUT",
				headers:{
					"content-type":"application/json"
				},
				body: JSON.stringify(task)
			})
			.then(response => response.json())
			.then(data => {
				setDirty(false);
				setTask(data);
			});
	}},[task, isDirty])

	function updateTask(e){
		setDirty(true);
		setTask({...task, description: e.target.value});
	}

	function deleteTask(){
		fetch(`http://localhost:8080/api/task/${task.id}`,{
			method:"DELETE",
			headers:{
				"content-type":"application/json"
			},
			})
			.then(response => {
				emitDeleteTaskItem(task);
			});
	}

	return (
		<div>
		<Checkbox
			checked={task.isDone}
			onChange={()=> {
			setDirty(true);
			setTask({...task, isDone: !task.isDone})}} />
		
		{
			task.isDone
			? <input type='text' className='done' value={task.description} onChange={updateTask}/>
			: <input type='text' value={task.description} onChange={updateTask}/>
		}
		
		<IconButton aria-label="delete" size="large" onClick={deleteTask}>
			<DeleteIcon fontSize="inherit" color="primary" />
		</IconButton>
		</div>
	);
};

export default Task;