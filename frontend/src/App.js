import Footer from './components/Footer/Footer';
import "./App.css";
import React, { useEffect, useState } from "react";
import Task from "./components/Task";
import Button from "@mui/material/Button";

function App() {
  const [tasks, setTask] = useState([]);
  //Date
  const current = new Date();
  const weekday = [
    "Domingo",
    "Segunda-feira",
    "Terça-feira",
    "Quarta-feira",
    "Quinta-feira",
    "Sexta-feira",
    "Sábado",
  ];
  let day = weekday[current.getDay()];
  let longMonth = current.toLocaleString("pt-br", { month: "long" });
  let date = `${longMonth} ${current.getDate()}`;

  useEffect(() => {
    console.log("useEffect Loaded.");
    if (!tasks) {
      fetch("http://localhost:8080/api/task")
        .then((response) => response.json())
        .then((data) => {
          console.log("Lista de tarefa:", data);
          setTask(data);
        });
    }
  }, [tasks]);
  function addNewTask() {
    fetch("http://localhost:8080/api/task", {
      headers: {
        "content-type": "application/json",
      },
      method: "POST",
    })
      .then((response) => response.json())
      .then((data) => {
        setTask([...tasks, data]);
        console.log(data);
      });
  }
  function handleDeleteTask(item) {
    const updatedTodoItems = tasks.filter((data) => data.id !== item.id);
    setTask([...updatedTodoItems]);
  }

  return (
    <>
      <div className="main-body">
        <div className="todo-container">
          <div className="above-label">
            <h2 style={{ textTransform: "uppercase" }}>Lista de tarefas!</h2>
          </div>
          <div className="date">
            <h3>
              Data: {day}, {date}
            </h3>
          </div>
          <div className="addbtn">
            <Button variant="contained" onClick={addNewTask}>
              NOVA TAREFA
            </Button>
          </div>
          <div className="task">
            {" "}
            {tasks
              ? tasks.map((task) => {
                return (
                  <Task
                    data={task}
                    key={task.id}
                    emitDeleteTaskItem={handleDeleteTask}
                  />
                );
              })
              : "loading data..."}
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}
export default App