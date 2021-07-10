package cl.coopeuch.backend.mappers;

import cl.coopeuch.backend.dto.TodoDTO;
import cl.coopeuch.backend.models.Todo;
import org.springframework.beans.BeanUtils;

public class TodoMapper {

    public static TodoDTO toTodoDTO(Todo todo) {
        TodoDTO todoDTO = TodoDTO.builder().build();
        BeanUtils.copyProperties(todo, todoDTO);
        return todoDTO;
    }
}
