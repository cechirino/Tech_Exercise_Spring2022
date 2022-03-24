

const todoInput = document.querySelector(".todo-input");
const todoButton = document.querySelector(".todo-button");
const todolist = document.querySelector(".todo-list");

todoButton.addEventListener("click", addTodo);

todolist.addEventListener('click', remove);

function addTodo(event)
{
	
	event.preventDefault();
	
	const todoDiv = document.createElement('div');
	todoDiv.classList.add("todo");
	
	const newTodo = document.createElement('li');
	newTodo.innerText = todoInput.value;
	newTodo.classList.add("todo-item");
	todoDiv.appendChild(newTodo);
	
	const deletebutton = document.createElement('button');
	deletebutton.innerHTML = '<i class="fas fa-trash"></i>'
	deletebutton.classList.add("delete-btn");
	todoDiv.append(deletebutton);
	
	todolist.appendChild(todoDiv);
	
	todoInput.value = "";
}

function remove(e)
{
	const item = e.target;
	
	if(item.classList[0] === "delete-btn")
	{
		const todo = item.parentElement;
		
		todo.classList.add("fall");
		
		todo.addEventListener("transitionend", function(){
			todo.remove();
		});
	}
}