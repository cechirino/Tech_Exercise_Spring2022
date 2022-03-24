

const todoInput = document.querySelector(".todo-input");
const todoButton = document.querySelector(".todo-button");
const todolist = document.querySelector(".todo-list");

todoButton.addEventListener("click", addTodo);

todolist.addEventListener('click', remove);

function addTodo(event)
{
	
	event.preventDefault();
	
	if(todoInput.value != null && todoInput.value != "")
	{
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
		
		
		
		var http = new XMLHttpRequest();
    	http.open("POST", "http://localhost:8080/Tech_Exercise_ToDo_List/addItem.jsp", true);
    	http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    	var params = "itemIn=" + todoInput.value; // probably use document.getElementById(...).value
    	http.send(params);
    	http.onload = function() 
		{
        	alert(http.responseText);
    	}

		todoInput.value = "";
		
	}
	
	
}

function remove(e)
{
	const item = e.target;
	
	if(item.classList[0] === "delete-btn")
	{
		const todo = item.parentElement;
		
		todo.classList.add("fall");
		
		todo.addEventListener("transitionend", function(){
			var http = new XMLHttpRequest();
	    	http.open("POST", "http://localhost:8080/Tech_Exercise_ToDo_List/removeitem.jsp", true);
	    	http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    	var params = "itemToRemove=" + item.previousElementSibling.innerText; // probably use document.getElementById(...).value
	    	http.send(params);
	    	http.onload = function() 
			{
	        	alert(http.responseText);
	    	}
			todo.remove();
		});
		

	}
}