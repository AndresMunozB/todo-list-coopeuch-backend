package cl.coopeuch.backend.services;

import cl.coopeuch.backend.dto.TodoDTO;
import cl.coopeuch.backend.mappers.TodoMapper;
import cl.coopeuch.backend.models.Todo;
import cl.coopeuch.backend.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public TodoDTO create(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setDescription(todoDTO.getDescription());
        todo.setDone(Boolean.FALSE);
        todo.setDeleted(Boolean.FALSE);
        todoRepository.save(todo);
        return TodoMapper.toTodoDTO(todo);
    }

    public TodoDTO update(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id).get();
        todo.setDescription(todoDTO.getDescription());
        todoRepository.save(todo);
        return TodoMapper.toTodoDTO(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id); //Soft delete
    }

    public TodoDTO findById(Long id) {
        Todo todo = todoRepository.findById(id).get();
        return TodoMapper.toTodoDTO(todo);
    }

    public List<TodoDTO> getAll() {
        return todoRepository.findAll()
                .stream()
                .map(todo -> TodoMapper.toTodoDTO(todo))
                .collect(Collectors.toList());
    }
}
